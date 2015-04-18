package com.faxintong.iruyi.service.topic;

import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.topic.Topic;
import com.faxintong.iruyi.model.mybatis.topic.TopicGroup;
import com.faxintong.iruyi.model.mybatis.topic.vo.TopicDetail;
import com.faxintong.iruyi.model.mybatis.topic.vo.TopicGroupDetail;
import com.faxintong.iruyi.utils.Pager;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 15-4-18.
 */
public interface TopicService {

    /**
     * 发表话题
     */
    public void reportTopic(Long groupId, String content, Lawyer lawyer) throws Exception;

    /**
     * 获取话题组列表
     * 根据热度进行排序 热度 高->低
     */
    public List<TopicGroup> getGroupList(Pager pager) throws Exception;

    /**
     * 获取话题组详情
     *  此处需要获取的元素包含 粉丝数、阅读量、话题数、话题与赞数与是否点赞
     */
    public TopicGroupDetail getGroupDetail(Long groupId, Pager pager,Long lawyerId) throws Exception;

    /**
     * 获取话题详情
     * @param topicId
     * @return
     */
    public TopicDetail getTopicDetail(Long topicId, Long LawyerId) throws Exception;

    /**
     * 关注话题组
     */
    public void attentionGroup(Long groupId, Long LawyerId) throws Exception;

    /**
     * 回应话题
     */
    public void topicReply(Long topicId, String content, Lawyer lawyer) throws Exception;

    /**
     * 关注话题 ,其实就是点赞功能
     */
    public void attentionTopic(Long topicId, Long lawyerId) throws Exception;

    /**
     * 话题回应点赞
     * 对话题的回复进行点赞
     */
    public void topicReplyPraise(Long replyId, Long lawyerId) throws Exception;

}
