package com.faxintong.iruyi.service.topic;

import com.faxintong.iruyi.model.mybatis.topic.Topic;
import com.faxintong.iruyi.model.mybatis.topic.TopicGroup;
import com.faxintong.iruyi.utils.Pager;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 15-4-18.
 */
public interface TopicService {

    /**
     * 发表话题
     * @param groupId
     * @param content
     * @param lawyerId
     * @throws Exception
     */
    public void reportTopic(Long groupId, String content, Long lawyerId) throws Exception;

    /**
     * 获取话题组列表
     * @param pager
     * @return
     * @throws Exception
     */
    public List<TopicGroup> getGroupList(Pager pager) throws Exception;

    /**
     * 获取话题组详情
     * @param groupId
     * @param pager
     * @return
     * @throws Exception
     */
    public List<Topic> getGroupDetail(Long groupId, Pager pager) throws Exception;

    /**
     * 获取话题详情
     * @param topicId
     * @return
     */
    public Topic getTopicDetail(Long topicId) throws Exception;

    /**
     * 关注话题组
     * @param groupId
     * @param LawyerId
     * @throws Exception
     */
    public void attentionGroup(Long groupId, Long LawyerId) throws Exception;

    /**
     * 回应话题
     * @param topicId
     * @param content
     * @param lawyerId
     * @throws Exception
     */
    public void topicReply(Long topicId, String content, Long lawyerId) throws Exception;

    /**
     * 关注话题
     * @param topicId
     * @param lawyerId
     * @throws Exception
     */
    public void attentionTopic(Long topicId, Long lawyerId) throws Exception;

    /**
     * 话题回应点赞
     * @param replyId
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public Map<String, Object> topicReplyPraise(Long replyId, Long lawyerId) throws Exception;

}
