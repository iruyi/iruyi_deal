package com.faxintong.iruyi.controller.lawyer;

import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.service.lawyer.UserService;
import com.faxintong.iruyi.utils.RedisUtils;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.*;

import static com.faxintong.iruyi.utils.Constants.*;

/**
 * Created by hehj on 15-1-3.
 */
@RestController
@RequestMapping("user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

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
    public Map<String, Object> registor(@Valid Lawyer lawyer, BindingResult bindingResult, String validCode,
                                        HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        try {
            if(bindingResult.hasErrors()){
                logger.info(bindingResult.getFieldError().getDefaultMessage());
                result.put(ERR_MSG, bindingResult.getFieldError().getDefaultMessage());
            }else{
                String code = request.getParameter("code");
                if (!code.equals(validCode))
                    result.put(ERR_MSG, "验证码填写错误");
                else if (userService.containsPhone(lawyer.getPhone()))
                    result.put(ERR_MSG ,"该手机号已经注册");
                else {
                    Date date = new Date();
                    lawyer.setCreateDate(date);
                    lawyer.setUpdateDate(date);
                    userService.registerLawyer(lawyer);
                    result.put(RESULT, true);
                }
            }
        }catch (Exception e){
            logger.error("注册失败");
            logger.error(e.getMessage());
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
    @RequestMapping("login")
    public Map<String, Object> login(String phone, String password, HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        String sessionId = request.getSession().getId();
            if (RedisUtils.getJedis().exists(sessionId)){
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
                    RedisUtils.setSerializable(sessionId, lawyer);
                    result.put(RESULT, true);
                }
            } catch (Exception e) {
                logger.error("登陆出错");
                logger.error(e.getMessage());
            }
        }
        return result;
    }

    /**
     * 退出登录
     * @param request
     * @param response
     */
    @RequestMapping("logout")
    public void logOut(HttpServletRequest request, HttpServletResponse response){
        String sessionId = request.getSession().getId();
        RedisUtils.getJedis().del(sessionId);
        request.getSession().invalidate();
    }
}
