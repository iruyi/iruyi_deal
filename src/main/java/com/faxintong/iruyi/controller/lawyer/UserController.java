package com.faxintong.iruyi.controller.lawyer;

import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.service.lawyer.UserService;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

/**
 * Created by hehj on 15-1-3.
 */
@RestController
@RequestMapping("user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "reg")
    public Map<String, Object> registor(@Valid Lawyer lawyer, BindingResult bindingResult, String validCode,
                                        HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = Maps.newHashMap();
        result.put("hello", "helloworld");
//        if(bindingResult.hasErrors()){
//            result.put(ERR_MSG, bindingResult.getFieldError().getDefaultMessage());
//        }else{
//            String code = request.getParameter("code");
//            if (!code.equals(validCode))
//                result.put(ERR_MSG, "验证码填写错误");
//            else if (true)
//                result.put(ERR_MSG ,"该手机号已经注册");
//            else {
//                Date date = new Date();
//                lawyer.setCreateDate(date);
//                lawyer.setUpdateDate(date);
//                try {
//                    userService.registerLawyer(lawyer);
//                } catch (Exception e) {
//                    logger.error(e.getMessage());
//                    result.put(ERR_MSG, "注册出错!");
//                }
//            }
//        }
        return result;
    }

//    @RequestMapping("login")
//    public Map<String, Object> login(String loginName, String password, HttpServletResponse response){
//        Map<String, Object> result = Maps.newHashMap();
//        result.put(RESULT, false);
//        try {
//            if (!userService.loginValidate(loginName, password))
//                result.put(ERR_MSG, "帐号密码不匹配");
//        } catch (Exception e) {
//            logger.error("登陆出错");
//            logger.error(e.getMessage());
//        }
//        return result;
//    }

    private final int height = 30;

    private final int width = 100;

    private final int codeCount = 4;

    private int fontHeight = 1;

    private final char[] codeSequence = {'1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C',
            'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z'};

    private int codeX = 4;

    private int codeY = 4;

    @RequestMapping(value = "code")
    public void validCode(HttpServletRequest request, HttpServletResponse response){
        // 定义图像buffer
        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D gd = buffImg.createGraphics();
        // 创建一个随机数生成器类
        Random random = new Random();
        // 将图像填充为白色
        gd.setColor(Color.LIGHT_GRAY);
        gd.fillRect(0, 0, width, height);
        // 创建字体，字体的大小应该根据图片的高度来定。
        Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);
        // 设置字体。
        gd.setFont(font);
        // 画边框。
        gd.setColor(Color.BLACK);
        gd.drawRect(0, 0, width - 1, height - 1);
        // 随机产生160条干扰线，使图象中的认证码不易被其它程序探测到。
        gd.setColor(Color.gray);
        for (int i = 0; i < 16; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            gd.drawLine(x, y, x + xl, y + yl);
        }
        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
        StringBuffer randomCode = new StringBuffer();
        int red = 0, green = 0, blue = 0;
        // 随机产生codeCount数字的验证码。
        for (int i = 0; i < codeCount; i++) {
            // 得到随机产生的验证码数字。
            String strRand = String.valueOf(codeSequence[random.nextInt(36)]);
            // 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
            // 用随机产生的颜色将验证码绘制到图像中。
            gd.setColor(new Color(red,green,blue));
            gd.drawString(strRand, (i + 1) * codeX, codeY);
            // 将产生的四个随机数组合在一起。
            randomCode.append(strRand);
        }
        // 将四位数字的验证码保存到Session中。
        HttpSession session = request.getSession();
        session.setAttribute("validateCode", randomCode.toString());
        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        response.setContentType("image/jpeg");
        // 将图像输出到Servlet输出流中。
        ServletOutputStream sos = null;
        try {
            sos = response.getOutputStream();
            ImageIO.write(buffImg, "jpeg", sos);
            sos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
