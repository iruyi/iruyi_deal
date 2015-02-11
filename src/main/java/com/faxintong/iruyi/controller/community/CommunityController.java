package com.faxintong.iruyi.controller.community;

import com.faxintong.iruyi.model.mybatis.community.Issue;
import com.faxintong.iruyi.service.friendcircle.IssueService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import static com.faxintong.iruyi.utils.Constants.*;

/**
 * Created by ron on 2015/2/10.
 */
@RestController
@RequestMapping("community")
public class CommunityController {

    @Autowired
    private IssueService issueService;

    @RequestMapping("news")
    public Map<String, Object> getCommunityNews(){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        try {
            result.put("news", issueService.getCommunityNews(1, 10));
            result.put(RESULT, true);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
