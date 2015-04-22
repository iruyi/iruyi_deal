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

            ServletUtils.responseJson(response, new Result(1, "投票成功！"));
        }catch (Exception e){
            logger.error("发表话题失败:" + e.getMessage());
            resultModelMap(0, "发表话题失败!", modelMap);
        }
        return null;
    }

    /**
     * 获取话题列表
     * @return
     *
     * @note
     *  获取话题列表
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
     */
    @RequestMapping(value = "getGroupDetail")
    public Map<String, Object> getGroupDetail(HttpServletRequest request, Long groupId, Pager pager){
        Map<String, Object> result = Maps.newHashMap();
        result.put(ERRCODE, 0);
        try {
            // 参数校验
            if(pager == null || pager.getCurrentPage() == null) {
                result.put(ERRMESSAGE, "当前页为null");
            }

            TopicGroupVo topicGroupVo = topicService.getGroupDetail(groupId,pager,getLawyerId(request).longValue());

            result.put(ERRCODE, 1);
            result.put(ERRMESSAGE, "获取话题组详情成功！");
            result.put(DATA,topicGroupVo);
        }catch (Exception e){
            logger.error("获取话题组详情失败:" + e.getMessage());
            result.put(ERRMESSAGE, "获取话题组详情失败!");
        }
        return result;
    }

    /**
     * 获取话题详情
     * @param topicId
     * @return
     */
    @RequestMapping(value = "getTopicDetail")
    public Map<String, Object> getTopicDetail(HttpServletRequest request,Long topicId){
        Map<String, Object> result = Maps.newHashMap();
        result.put(ERRCODE, 0);
        try {
            // 参数校验
            if(topicId == null) {
                result.put(ERRMESSAGE, "话题ID为空！");
            }

            TopicVo topicVo = topicService.getTopicDetail(topicId,getLawyerId(request));

            result.put(ERRCODE, 1);
            result.put(ERRMESSAGE, "获取话题详情成功！");
            result.put(DATA,topicVo);
        }catch (Exception e){
            logger.error("获取话题组详情失败:" + e.getMessage());
            result.put(ERRMESSAGE, "获取话题详情失败!");
        }
        return result;
    }

    /**
     * 关注话题组
     * @return
     */
    @RequestMapping(value = "attentionGroup")
    public Map<String, Object> attentionGroup(HttpServletRequest request,Long groupId){
        Map<String, Object> result = Maps.newHashMap();
        result.put(ERRCODE, 0);
        try {
            // 参数校验
            if(groupId == null) {
                result.put(ERRMESSAGE, "话题ID为空！");
            }

            topicService.attentionGroup(groupId,getLawyerId(request));

            result.put(ERRCODE, 1);
            result.put(ERRMESSAGE, "关注话题组成功！");
        }catch (Exception e){
            logger.error("关注话题组失败:" + e.getMessage());
            result.put(ERRMESSAGE, "关注话题组失败!");
        }
        return result;
    }

    /**
     * 回应话题
     * @param topicId
     * @param content
     * @return
     */
    @RequestMapping(value = "topicReply")
    public Map<String, Object> topicReply(HttpServletRequest request,Long topicId, String content){
        Map<String, Object> result = Maps.newHashMap();
        result.put(ERRCODE, 0);
        try {
            // 参数校验
            if(topicId == null || StringUtils.isEmpty(content)) {
                result.put(ERRMESSAGE, "话题ID或者回复内容为空！");
            }

            topicService.topicReply(topicId,content,getLawyer(request));

            result.put(ERRCODE, 1);
            result.put(ERRMESSAGE, "关注话题组成功！");
        }catch (Exception e){
            logger.error("关注话题组失败:" + e.getMessage());
            result.put(ERRMESSAGE, "关注话题组失败!");
        }
        return result;
    }

    /**
     * 关注话题
     * @param topicId
     * @return
     */
    @RequestMapping(value = "attentionTopic")
    public Map<String, Object> attentionTopic(Long topicId, HttpServletRequest request){
        Map<String, Object> result = Maps.newHashMap();
        result.put(ERRCODE, 0);
        try {
            // 参数校验
            if(topicId == null) {
                result.put(ERRMESSAGE, "话题ID为空！");
            }

            topicService.attentionTopic(topicId,getLawyerId(request));

            result.put(ERRCODE, 1);
            result.put(ERRMESSAGE, "关注话题组成功！");
        }catch (Exception e){
            logger.error("关注话题组失败:" + e.getMessage());
            result.put(ERRMESSAGE, "关注话题组失败!");
        }
        return result;
    }

    /**
     * 话题回应点赞
     * @param replyId
     * @return
     */
    public Map<String, Object> topicReplyPraise(HttpServletRequest request,Long replyId){
        Map<String, Object> result = Maps.newHashMap();
        result.put(ERRCODE, 0);
        try {
            // 参数校验
            if(replyId == null) {
                result.put(ERRMESSAGE, "回复ID为空！");
            }

            topicService.topicReplyPraise(replyId,getLawyerId(request));

            result.put(ERRCODE, 1);
            result.put(ERRMESSAGE, "关注话题组成功！");
        }catch (Exception e){
            logger.error("关注话题组失败:" + e.getMessage());
            result.put(ERRMESSAGE, "关注话题组失败!");
        }
        return result;
    }

}
