package com.faxintong.iruyi.controller.indivcenter;

import com.faxintong.iruyi.dao.mybatis.lawyer.LawyerMapper;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.service.indivcenter.CenterService;
import com.faxintong.iruyi.utils.Constants;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping(value = "lawyerInfo")
    public Map<String, Object> getLawyerInfo(HttpServletRequest request, String lawyerId) throws Exception{
        Map<String, Object> result = Maps.newHashMap();
        result.put(Constants.RESULT, false);
        String currentUserId = (String) request.getAttribute("currentUserId");
        try{
            if (StringUtils.isEmpty(currentUserId)) {
                result.put(Constants.ERR_MSG, "请登录后再操作");
                return  result;
            }
            if(StringUtils.isEmpty(lawyerId)){
                result.put(Constants.ERR_MSG, "律师id为空");
                return result;
            }
            Lawyer lawyer = centerService.findLawyerById(Long.getLong(lawyerId));
            result.put(Constants.RESULT, true);
            result.put(Constants.DATA, lawyer);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            result.put(Constants.ERR_MSG, "未知异常");
        }
        return result;
    }
}
