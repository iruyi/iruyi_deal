package com.faxintong.iruyi.controller.lawyer;

import com.faxintong.iruyi.utils.SMSUtils;
import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.regex.Pattern;

import static com.faxintong.iruyi.utils.Constants.*;

/**
 * Created by ron on 2015/1/9.
 */
@RestController
@RequestMapping("code")
public class CodeController {

    @Autowired
    private VelocityEngine velocityEngine;

    private int width = 100;
    private int height = 50;
    private int codeLength = 4;
    private int codeX = (width - 4) / (codeLength + 1);
    private int codeY = height - 5;
    private String[] fonts = {"Georgia", "Verdana", "Arial", "Tahoma", "Time News Roman", "Courier New", "Arial Black", "Quantzite"};

    /**
     * @param request  上下文request
     * @param response 上下文response
     */
    @RequestMapping("code")
    public void getCode(Integer widthParam, Integer heightParam, HttpServletRequest request, HttpServletResponse response) {
        if(widthParam != null)
            width = widthParam;
        if(heightParam != null)
            height = heightParam;
        String randomCode = RandomStringUtils.randomNumeric(codeLength);
        request.getSession().setAttribute("code", randomCode);
        char codes[] = randomCode.toCharArray();
        Random ran = new Random();
        // 定义图像buffer
        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D gd = buffImg.createGraphics();
        // 将图像填充为白色
        gd.setColor(Color.WHITE);
        gd.fillRect(0, 0, width, height);

        // 画边框。
        gd.setColor(new Color(221, 221, 221));
        gd.drawRect(0, 0, width - 1, height - 1);
        for (int i = 0; i < codeLength; i++) {
            gd.setColor(Color.BLUE);
            // 设置字体

            int fontIndex = ran.nextInt(fonts.length - 1);
            int fontSize = ran.nextInt(height - 16) + 16;
            gd.setFont(new Font(fonts[fontIndex], Font.PLAIN, fontSize));
            AffineTransform at = new AffineTransform();
            int number = ran.nextInt(3) - 1;
            double role = number * ran.nextDouble() * (Math.PI / 4);
            at.setToRotation(role, (i + 1) * codeX, codeY - ran.nextInt(5)); //role:旋转角度,后面两个参数是设置围绕坐标点旋转
            gd.setTransform(at);
            gd.drawString(String.valueOf(codes[i]), (i + 1) * codeX, codeY - ran.nextInt(5));

        }
        for (int i = 0; i < (ran.nextInt(7) + 8); i++) {
            gd.setColor(new Color(ran.nextInt(255) + 1, ran.nextInt(255) + 1, ran.nextInt(255) + 1));
            gd.drawLine(ran.nextInt(width), ran.nextInt(height), ran.nextInt(width), ran.nextInt(height));
        }

        // 将四位数字的验证码保存到redis中。

        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        response.setContentType("image/jpeg");
        // 将图像输出到Servlet输出流中。
        ServletOutputStream sos;
        try {
            sos = response.getOutputStream();
            ImageIO.write(buffImg, "jpeg", sos);
            sos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("captcha")
    /**
     * bizType:业务类型【0-注册，1-找回密码】
     */
    public String captcha(String mobile, Integer bizType, ModelMap modelMap) {
        modelMap.put(ERRCODE, RESULTFAIL);
        Pattern pattern = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        if (StringUtils.isEmpty(mobile) || !pattern.matcher(mobile).matches()) {
            modelMap.put(ERRMESSAGE, "请填写正确的手机号码");
            modelMap.put("code", "");
        }

        final String i = RandomStringUtils.randomNumeric(6);
        String content = null;
        switch (bizType) {
            case 0:
                content = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "template/captcha.vm", ENCODING,
                        ImmutableMap.<String, Object>of("captcha", i));
                break;
            case 1:
                content = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "template/findPass.vm", ENCODING,
                        ImmutableMap.<String, Object>of("captcha", i));
                break;
            default:
                break;
        }
        if (StringUtils.isNotEmpty(content)) {
            SMSUtils.sendMandao(mobile, content);
            modelMap.put(ERRCODE, RESULTSUCCESS);
            modelMap.put(ERRMESSAGE, "发送验证码成功！");
            modelMap.put("code", i);
        }else{
            modelMap.put(ERRMESSAGE, "发送验证码失败！");
            modelMap.put("code", "");
        }
        return "lawyer/code";
    }

}
