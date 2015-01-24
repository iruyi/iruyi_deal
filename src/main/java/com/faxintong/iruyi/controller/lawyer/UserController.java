package com.faxintong.iruyi.controller.lawyer;

import com.faxintong.iruyi.controller.BaseController;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.utils.Config;
import com.faxintong.iruyi.utils.RedisUtils;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import static com.faxintong.iruyi.utils.Constants.*;

/**
 * Created by hehj on 15-1-3.
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    /**
     * 注册
     * @param lawyer
     * @param bindingResult
     * @param validCode
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "reg")
    public Map<String, Object> register(@Valid Lawyer lawyer, BindingResult bindingResult, String validCode,
                                        HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        try {
            if(bindingResult.hasErrors()){
                result.put(ERR_MSG, bindingResult.getFieldError().getDefaultMessage());
            }else{
                String code = request.getParameter("code");
                if (!code.equals(validCode)) {
                    result.put(ERR_MSG, "验证码填写错误");
                }
                else if (userService.containsPhone(lawyer.getPhone())) {
                    result.put(ERR_MSG, "该手机号已经注册");
                }else if (!userService.regisValidate(lawyer.getPhone())){
                    result.put(ERR_MSG, "该手机号格式错误");
                }
                else {
                    Date date = new Date();
                    lawyer.setCreateDate(date);
                    lawyer.setUpdateDate(date);
                    userService.registerLawyer(lawyer);
                    result.put(RESULT, true);
                    result.put(ERR_MSG, "注册成功");
                }
            }
        }catch (Exception e){
            logger.error("注册失败:" + e.getMessage());
            result.put(ERR_MSG, "注册出错!");
        }
        return result;
    }


    /**
     * 登录
     * @param phone
     * @param password
     * @param response
     * @return
     */
    @RequestMapping(value = "login")
    public Map<String, Object> login(String phone, String password, HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        String sessionId = request.getSession().getId();
        if (RedisUtils.exists(SESSION_PREFIX + sessionId)){
                result.put(RESULT, true);
                return result;
        }
        if(StringUtils.isEmpty(phone)) {
            result.put(ERR_MSG, "帐号不能为空");
        }else if(StringUtils.isEmpty(password)){
            result.put(ERR_MSG, "密码不能为空");
        }else {
            try {
                if (!userService.loginValidate(phone, password))
                    result.put(ERR_MSG, "帐号密码不匹配");
                else {
                    Lawyer lawyer = userService.getLawyer(phone);
                    RedisUtils.set(SESSION_PREFIX + sessionId, "" + lawyer.getId());
                    result.put(RESULT, true);
                }
            } catch (Exception e) {
                result.put(ERR_MSG, "登录出错");
                logger.error("登录出错" + e.getMessage());
            }
        }
        return result;
    }

    /**
     * 退出登录
     * @param request
     * @param response
     */
    @RequestMapping(value = "logout")
    public void logOut(HttpServletRequest request, HttpServletResponse response){
        String sessionId = request.getSession().getId();
        RedisUtils.del(SESSION_PREFIX + sessionId);
        request.getSession().invalidate();
    }

    /**
     * 上传头像
     * @param request
     * @param response
     */
    @RequestMapping(value = "head/upload")
    public Map<String, Object> headImageUpload(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        String sessionId = request.getSession().getId();
        String lawyerId = RedisUtils.get(SESSION_PREFIX + sessionId);
        if(lawyerId != null){
            try {
                String fileName = uploadFile(request, Config.HEAD_DIR + sessionId);
                Lawyer lawyer = getLawyer(request);
                lawyer.setPhoto(fileName);
                userService.updateLawyerInfo(lawyer);
                result.put(RESULT, true);
            } catch (IOException e) {
                result.put(ERR_MSG, "上传头像错误");
                logger.error(lawyerId + ":上传头像失败:" + e.getMessage());
            }
        }
        return  result;
    }

    /**
     * 上传执照信息
     * @param request
     * @param response
     */
    @RequestMapping(value = "certificate/upload")
    public void jobInfoUpload(HttpServletRequest request, HttpServletResponse response){
        String sessionId = request.getSession().getId();
        String lawyerId = RedisUtils.get(SESSION_PREFIX+sessionId);
        if(lawyerId != null){
            try {
                String fileName =  uploadFile(request, Config.CERTIFICATE_INFO + sessionId);
                Lawyer lawyer = getLawyer(request);
                lawyer.setBusinessLicense(fileName);
                userService.updateLawyerInfo(lawyer);
            } catch (IOException e) {
                logger.error(lawyerId + ":上传执照信息失败:" + e.getMessage());
            }
        }
    }
}
