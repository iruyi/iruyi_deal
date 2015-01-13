package com.faxintong.iruyi.controller.indivcenter;

import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.service.indivcenter.CenterService;
import static com.faxintong.iruyi.utils.Constants.*;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by hehj on 15-1-8.
 */
@RestController
@RequestMapping("center")
public class CenterController {

    private Logger logger = LoggerFactory.getLogger(CenterController.class);

    @Autowired
    private CenterService centerService;

/*
    private String getSessionId() {
        return DigestUtils.md5Hex(System.currentTimeMillis() + RandomStringUtils.randomNumeric(6));
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public Map<String, Object> login(HttpServletRequest request, String currentUserId) {
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        try{
            result.put(RESULT, true);
            String sessionId = getSessionId();
            RedisUtils.set(SESSION_PREFIX + sessionId, currentUserId);
            logger.info("sessionId=" + sessionId);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            result.put(ERR_MSG, "未知异常");
        }
        return result;
    }
*/

    @RequestMapping(value = "lawyerInfo", method = RequestMethod.GET)
    public Map<String, Object> getLawyerInfo(HttpServletRequest request, String lawyerId) {
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        String currentUserId = (String) request.getAttribute("currentUserId");
        try{
            if (StringUtils.isEmpty(currentUserId)) {
                result.put(ERR_MSG, "请登录后再操作");
                return  result;
            }
            if(StringUtils.isEmpty(lawyerId)){
                result.put(ERR_MSG, "律师id为空");
                return result;
            }
            Lawyer lawyer = centerService.findLawyerById(Long.parseLong(lawyerId));
            result.put(RESULT, true);
            result.put(DATA, lawyer);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            result.put(ERR_MSG, "未知异常");
        }
        return result;
    }

    @RequestMapping(value = "modifyLawyer", method = RequestMethod.POST)
    public Map<String, Object> modifyLawyer(HttpServletRequest request, Lawyer lawyer){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        String currentUserId = (String) request.getAttribute("currentUserId");
        try{
            if (StringUtils.isEmpty(currentUserId)) {
                result.put(ERR_MSG, "请登录后再操作");
                return  result;
            }
            if(lawyer == null){
                result.put(ERR_MSG, "律师为空");
                return result;
            }
            centerService.modifyLawyer(lawyer);
            result.put(RESULT, true);
            result.put(ERR_MSG, "律师更新成功");
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            result.put(ERR_MSG, "未知异常");
        }
        return result;
    }

}
