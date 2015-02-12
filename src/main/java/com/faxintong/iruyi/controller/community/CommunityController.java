package com.faxintong.iruyi.controller.community;

import com.faxintong.iruyi.controller.BaseController;
import com.faxintong.iruyi.controller.comment.CommentController;
import com.faxintong.iruyi.model.mybatis.community.Community;
import com.faxintong.iruyi.model.mybatis.community.Issue;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.service.community.CommunityService;
import com.faxintong.iruyi.service.friendcircle.IssueService;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;
import java.util.Map;
import static com.faxintong.iruyi.utils.Constants.*;

/**
 * Created by ron on 2015/2/10.
 */
@RestController
@RequestMapping("community")
public class CommunityController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private CommunityService communityService;

    @RequestMapping("issue/create")
    public Map<String, Object> createIssue(@Valid Community community, BindingResult bindingResult,
                                           HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);

        if (bindingResult.hasErrors()){
            result.put(ERR_MSG, bindingResult.getFieldError().getDefaultMessage());
            return result;
        }

        try {
            Lawyer lawyer = getLawyer(request);
            community.setLawyerId(lawyer.getId());
            community.setLawyerName(lawyer.getName());
            community.setType(COMMUNITY_ISSUE);
            community.setCreateDate(new Date());
            community.setPraiseCount(0);
            communityService.createCommunity(community);
            result.put(ERR_MSG, "提问成功");
            result.put(RESULT, true);
        }catch (Exception e){
            result.put(RESULT, false);
            result.put(ERR_MSG, "提问出错");
            e.printStackTrace();
            logger.error("提问出错");
        }
        return result;
    }

    @RequestMapping("reply/create")
    public Map<String, Object> createReply(@Valid Community community, BindingResult bindingResult,
                                           HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);

        if (bindingResult.hasErrors()){
            result.put(ERR_MSG, bindingResult.getFieldError().getDefaultMessage());
            return result;
        }

        if(!communityService.issueIsExists(community.getIssueId())){
            result.put(ERR_MSG, "问题不存在");
            return result;
        }

        try {
            Lawyer lawyer = getLawyer(request);
            community.setLawyerId(lawyer.getId());
            community.setLawyerName(lawyer.getName());
            community.setType(COMMUNITY_REPLY);
            community.setCreateDate(new Date());
            community.setPraiseCount(0);
            communityService.createCommunity(community);
            result.put(ERR_MSG, "回复成功");
            result.put(RESULT, true);
        }catch (Exception e){
            result.put(RESULT, false);
            result.put(ERR_MSG, "回复出错");
            e.printStackTrace();
            logger.error("回复出错");
        }
        return result;
    }

    /**
     *
     * @param page
     * @param pageSize
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("news")
    public Map<String, Object> getCommunityNews(Integer page, Integer pageSize,
                                                HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);

        if(page == null || pageSize == null){
            result.put(ERR_MSG, "页数以及页码都不能空");
            return result;
        }

        try{
            Long lawyerId = getLawyerId(request);
            result.put("communityNews", communityService.getCommunityNews(lawyerId, page, pageSize));
            result.put(RESULT, true);
            result.put(ERR_MSG, "获取社区新鲜事成功");
        }catch (Exception e){
            e.printStackTrace();
            result.put(ERR_MSG, "获取社区新鲜事出错");
            logger.error("获取社区新鲜事出错");
        }
        return result;
    }

    @RequestMapping("praise/reply")
    public Map<String, Object> praiseReply(Long replyId,
                                           HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);

        if(!communityService.replyIsExists(replyId)){
            result.put(ERR_MSG, "该回复不存在");
            return result;
        }

        Long lawyerId = getLawyerId(request);

        if(communityService.hasPraised(lawyerId, replyId)){
            result.put(ERR_MSG, "不能重复点赞");
            return result;
        }

        try{
            communityService.createCommunityPraise(lawyerId, replyId);
            result.put(RESULT, true);
            result.put(ERR_MSG, "点赞成功");
        }catch (Exception e){
            e.printStackTrace();
            result.put(ERR_MSG, "点赞失败");
            logger.error("点赞失败:" + e.getMessage());
        }
        return result;
    }


}
