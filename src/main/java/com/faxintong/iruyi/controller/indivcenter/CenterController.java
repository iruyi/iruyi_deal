package com.faxintong.iruyi.controller.indivcenter;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public Map<String, Object> getLawyerInfo(HttpServletRequest request, String lawyerId) throws Exception{
        Map<String, Object> result = Maps.newHashMap();
        String currentUserId = (String) request.getAttribute("currentUserId");

        return result;
    }
}
