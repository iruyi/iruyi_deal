package com.faxintong.iruyi.controller.topic;

import com.faxintong.iruyi.controller.BaseController;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.topic.TopicGroup;
import com.faxintong.iruyi.model.mybatis.vo.TopicGroupVo;
import com.faxintong.iruyi.model.mybatis.vo.TopicVo;
import com.faxintong.iruyi.service.topic.TopicService;
import com.faxintong.iruyi.utils.Pager;
import com.faxintong.iruyi.utils.RedisUtils;
import com.faxintong.iruyi.utils.Result;
import com.faxintong.iruyi.utils.ServletUtils;
import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

import static com.faxintong.iruyi.utils.Constants.*;
/**
 * 话题
 * Created by hehongju on 2015/3/27.
 */
@RestController
@RequestMapping("topic")
public class TopicController extends BaseController{
    private Logger logger = LoggerFactory.getLogger(TopicController.class);
    @Autowired
    private TopicService topicService;
    /**
     * 发表话题
     * @return
     *
     * @note
     *  发表话题
     *   必须登录
     *
     */
    @RequestMapping(value = "reportTopic")
    public Map<String, Object> reportTopic(HttpServletRequest request, Long groupId, String content, ModelMap modelMap,HttpServletResponse response){
        try {
            // 用户信息获取
            Lawyer lawyer = getLawyer(request);

            // 参数校验
            if(groupId == null || StringUtils.isEmpty(content)){
                ServletUtils.responseJson(response, new Result(0, "话题所属组和话题为空！"));
                return null;
            }

            topicService.reportTopic(groupId,content,lawyer);

            ServletUtils.responseJson(response, new Result(1, "发表话题成功！"));
        }catch (Exception e){
            logger.error("发表话题失败:" + e.getMessage());
            resultModelMap(0, "发表话题失败!", modelMap);
        }
        return null;
    }

    /**
     * 获取话题组列表
     * @return
     *
     * @note
     *  获取话题组列表
     *   无需登录
     *
     */
    @RequestMapping(value = "getGroupList")
    public String getGroupList(Pager pager,ModelMap modelMap,HttpServletResponse response){
        try {
            // 参数校验
            if(pager == null || pager.getCurrentPage() == null) {
                ServletUtils.responseJson(response, new Result(0, "当前页为null！"));
                return null;
            }

            List<TopicGroupVo> list = topicService.getGroupList(pager);
            resultModelMap(1,"获取话题组列表成功！",modelMap);
            modelMap.put(DATA,list);

            return "topic/getGroupList";
        }catch (Exception e){
            logger.error("获取话题列表失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(0, "获取话题列表失败！"));
        }
        return null;
    }

    /**
     * 获取话题组详情
     * @return
     *
     * @note
     *  获取话题组详情
     *  无需登录
     *  如果登录的话 会返回是否关注字段，以及是否点赞字段；否则默认为没有
     */
    @RequestMapping(value = "getGroupDetail")
    public String getGroupDetail(HttpServletRequest request, HttpServletResponse response, Long groupId, Pager pager,ModelMap modelMap){
        try {
            // 参数校验
            if(pager == null || pager.getCurrentPage() == null) {
                ServletUtils.responseJson(response,new Result(0,"当前页为null"));
                return null;
            }

            TopicGroupVo topicGroupVo = topicService.getGroupDetail(groupId,pager,getLawyerId(request));

            modelMap.put(DATA, topicGroupVo);
            resultModelMap(1,"获取话题组详情成功！",modelMap);

            return "topic/getGroupDetail";
        }catch (Exception e){
            logger.error("获取话题组详情失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(0, "获取话题组详情失败!"));
        }
        return null;
    }

    /**
     * 获取话题详情
     * @param topicId
     * @return
     */
    @RequestMapping(value = "getTopicDetail")
    public String getTopicDetail(HttpServletRequest request,HttpServletResponse response,Long topicId,ModelMap modelMap){
        try {
            // 参数校验
            if(topicId == null) {
                ServletUtils.responseJson(response,new Result(0,"话题ID为空！"));
                return null;
            }

            TopicVo topicVo = topicService.getTopicDetail(topicId,getLawyerId(request));

            modelMap.put(DATA,topicVo);
            resultModelMap(1, "获取话题详情成功！", modelMap);

            return "topic/getTopicDetail";
        }catch (Exception e){
            logger.error("获取话题详情失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(0, "获取话题详情失败！"));
        }
        return null;
    }

    /**
     * 关注话题组
     * @return
     *
     * @note
     *  关注话题组
     *  必须登录
     */
    @RequestMapping(value = "attentionGroup")
    public String attentionGroup(HttpServletRequest request,Long groupId,HttpServletResponse response){
        try {
            // 参数校验
            if(groupId == null) {
                ServletUtils.responseJson(response,new Result(0,"话题ID为空！"));
                return null;
            }

            topicService.attentionGroup(groupId, getLawyerId(request));

            ServletUtils.responseJson(response, new Result(1, "关注话题组成功！"));
        }catch (Exception e){
            logger.error("关注话题组失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(0, "关注话题组失败！"));
        }
        return null;
    }

    /**
     * 回应话题
     * @param topicId
     * @param content
     * @return
     */
    @RequestMapping(value = "topicReply")
    public String topicReply(HttpServletRequest request,Long topicId, String content, HttpServletResponse response){
        try {
            // 参数校验
            if(topicId == null || StringUtils.isEmpty(content)) {
                ServletUtils.responseJson(response,new Result(0,"话题ID或者回复内容为空！"));
                return null;
            }

            topicService.topicReply(topicId, content, getLawyer(request));

            ServletUtils.responseJson(response, new Result(1, "回应话题成功！"));
        }catch (Exception e){
            logger.error("回应话题失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(1, "回应话题失败！"));
        }
        return null;
    }

    /**
     * 关注话题
     * @param topicId
     * @return
     *
     * @note
     * 关注话题  收藏话题
     */
    @RequestMapping(value = "attentionTopic")
    public String attentionTopic(Long topicId, HttpServletRequest request,HttpServletResponse response){
        try {
            // 参数校验
            if(topicId == null) {
                ServletUtils.responseJson(response,new Result(0,"话题ID为空！"));
                return null;
            }

            topicService.attentionTopic(topicId, getLawyerId(request));

            ServletUtils.responseJson(response, new Result(1, "关注话题成功！"));
        }catch (Exception e){
            logger.error("关注话题失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(0, "关注话题失败！"));
        }
        return null;
    }

    @RequestMapping(value = "topicReplyPraise")
    public String topicPraise(HttpServletRequest request,Long topicId,HttpServletResponse response){
        try {
            // 参数校验
            if(topicId == null) {
                ServletUtils.responseJson(response,new Result(0,"话题ID为空！"));
                return null;
            }

            topicService.topicPraise(topicId, getLawyerId(request));

            ServletUtils.responseJson(response, new Result(1, "话题点赞成功！"));
        }catch (Exception e){
            logger.error("话题点赞失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(0, "话题点赞失败！"));
        }
        return null;
    }

    /**
     * 话题回应点赞
     * @param replyId
     * @return
     */
    @RequestMapping(value = "topicReplyPraise")
    public String topicReplyPraise(HttpServletRequest request,Long replyId,HttpServletResponse response){
        try {
            // 参数校验
            if(replyId == null) {
                ServletUtils.responseJson(response,new Result(0,"回复ID为空！"));
                return null;
            }

            topicService.topicReplyPraise(replyId, getLawyerId(request));

            ServletUtils.responseJson(response, new Result(1, "话题回应点赞成功！"));
        }catch (Exception e){
            logger.error("话题回应点赞失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(0, "话题回应点赞成功！"));
        }
        return null;
    }

}
