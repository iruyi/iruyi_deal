package com.faxintong.iruyi.controller.topic;

import com.faxintong.iruyi.utils.Pager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 话题
 * Created by hehongju on 2015/3/27.
 */
@RestController
@RequestMapping("topic")
public class TopicController {

    /**
     * 发表话题
     * @return
     */
    @RequestMapping(value = "reportTopic")
    public Map<String, Object> reportTopic(Long groupId, String content){

        return null;
    }

    /**
     * 获取话题列表
     * @return
     */
    @RequestMapping(value = "getGroupList")
    public Map<String, Object> getGroupList(Pager pager){

        return null;
    }

    /**
     * 获取话题组详情
     * @return
     */
    @RequestMapping(value = "getGroupDetail")
    public Map<String, Object> getGroupDetail(Long groupId, Pager pager){

        return null;
    }

    /**
     * 获取话题详情
     * @param topicId
     * @return
     */
    @RequestMapping(value = "getTopicDetail")
    public Map<String, Object> getTopicDetail(Long topicId){

        return null;
    }

    /**
     * 关注话题组
     * @return
     */
    @RequestMapping(value = "attentionGroup")
    public Map<String, Object> attentionGroup(Long groupId){

        return null;
    }

    /**
     * 回应话题
     * @param topicId
     * @param content
     * @return
     */
    @RequestMapping(value = "topicReply")
    public Map<String, Object> topicReply(Long topicId, String content){

        return null;
    }

    /**
     * 关注话题
     * @param topicId
     * @return
     */
    @RequestMapping(value = "attentionTopic")
    public Map<String, Object> attentionTopic(Long topicId){

        return null;
    }

    /**
     * 话题回应点赞
     * @param replyId
     * @return
     */
    public Map<String, Object> topicReplyPraise(Long replyId){

        return null;
    }

}
