package com.faxintong.iruyi.controller.lawyer;

import com.faxintong.iruyi.controller.BaseController;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.utils.*;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String register(@Valid Lawyer lawyer, BindingResult bindingResult, String validCode, ModelMap modelMap,
                                        HttpServletRequest request, HttpServletResponse response){
        //Map<String, Object> result = Maps.newHashMap();
        modelMap.put(ERRCODE, RESULTFAIL);
        try {
            if(bindingResult.hasErrors()){
                modelMap.put(ERR_MSG, bindingResult.getFieldError().getDefaultMessage());
            }else{
                String code = "123";//(String) request.getSession().getAttribute("code");
                /*if(code == null) {
                    result.put(ERR_MSG, "请先填写验证码");
                }else if (!code.equals(validCode)) {
                    result.put(ERR_MSG, "验证码填写错误");
                }
                else*/ if (userService.containsPhone(lawyer.getPhone())) {
                    modelMap.put(ERRMESSAGE, "该手机号已经注册");
                }else if (!userService.regisValidate(lawyer.getPhone())){
                    modelMap.put(ERRMESSAGE, "该手机号格式错误");
                }
                else {
                    lawyer.setPassword(MD5.newinstance().getMD5ofStr(lawyer.getPassword()));
                    Date date = new Date();
                    lawyer.setCreateDate(date);
                    lawyer.setUpdateDate(date);
                    userService.registerLawyer(lawyer);
                    modelMap.put(ERRCODE, RESULTSUCCESS);
                    modelMap.put(ERRMESSAGE, "注册成功");
                }
            }
        }catch (Exception e){
            logger.error("注册失败:" + e.getMessage());
            modelMap.put(ERRMESSAGE, "注册出错!");
        }
        //return result;
        //ServletUtils.responseJson(response, result);
        return "lawyer/common";
    }


    /**
     * 登录
     * @param phone
     * @param password
     * @param response
     * @return
     */
    @RequestMapping(value = "login")
    public String login(String phone, String password, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
        modelMap.put(ERRCODE, RESULTFAIL);
        if(StringUtils.isEmpty(phone)) {
            modelMap.put(ERRMESSAGE, "帐号不能为空");
            modelMap.put("sessionId", "");
        }else if(StringUtils.isEmpty(password)){
            modelMap.put(ERRMESSAGE, "密码不能为空");
            modelMap.put("sessionId", "");
        }else {
            try {
                password = MD5.newinstance().getMD5ofStr(password);
                if (!userService.loginValidate(phone, password)){
                    modelMap.put(ERRMESSAGE, "帐号密码不匹配");
                    modelMap.put("sessionId", "");
                } else {
                    String sessionId = SessionUtil.getSessionId();
                    modelMap.put("sessionId", sessionId);
                    Lawyer lawyer = userService.getLawyer(phone);
                    RedisUtils.set(SESSION_PREFIX + sessionId, "" + lawyer.getId());
                    modelMap.put(ERRCODE, RESULTSUCCESS);
                    modelMap.put(ERRMESSAGE, "登录成功");
                }
            } catch (Exception e) {
                modelMap.put(ERRMESSAGE, "登录出错");
                modelMap.put("sessionId", "");
                logger.error("登录出错:" + e.getMessage());
            }
        }
        return "lawyer/login";
    }

    /**
     * 退出登录
     * @param request
     * @param response
     */
    @RequestMapping(value = "logout")
    public String logOut(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = Maps.newHashMap();
        result.put(ERRCODE, RESULTFAIL);
        try {
            String sessionId = request.getParameter("sessionId");
            RedisUtils.del(SESSION_PREFIX + sessionId);
            result.put(ERRCODE, RESULTSUCCESS);
            result.put(ERRMESSAGE, "登出成功");
        }catch (Exception e){
            e.printStackTrace();
            result.put(ERRMESSAGE, "登出出错");
        }
        return "lawyer/common";
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
                //lawyer.setPhoto(fileName);
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
                //lawyer.setBusinessLicense(fileName);
                userService.updateLawyerInfo(lawyer);
            } catch (IOException e) {
                logger.error(lawyerId + ":上传执照信息失败:" + e.getMessage());
            }
        }
    }
}
