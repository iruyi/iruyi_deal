package com.faxintong.iruyi.service.topic;

import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.topic.Topic;
import com.faxintong.iruyi.model.mybatis.topic.TopicGroup;
import com.faxintong.iruyi.model.mybatis.vo.TopicAllVo;
import com.faxintong.iruyi.model.mybatis.vo.TopicGroupVo;
import com.faxintong.iruyi.model.mybatis.vo.TopicVo;
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
     * @param lawyer
     * @throws Exception
     */
    public void reportTopic(Long groupId, String content, Lawyer lawyer) throws Exception;

    /**
     * 获取话题组列表
     * @param pager
     * @return
     * @throws Exception
     */
    public List<TopicGroupVo> getGroupList(Pager pager) throws Exception;

    /**
     * 获取话题组详情
     * @param groupId
     * @param pager
     * @return
     * @throws Exception
     */
    public TopicGroupVo getGroupDetail(Long groupId, Pager pager, Long lawyerId) throws Exception;

    /**
     * 获取话题详情
     * @param topicId
     * @return
     * //TODO 话题组详情已经获取了话题的相关信息，这里只封装了回复详细信息
     */
    public TopicVo getTopicDetail(Long topicId, Long lawyerId) throws Exception;

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
     * @param lawyer
     * @throws Exception
     */
    public void topicReply(Long topicId, String content, Lawyer lawyer) throws Exception;

    /**
     * 关注话题
     * @param topicId
     * @param lawyerId
     * @throws Exception
     */
    public void attentionTopic(Long topicId, Long lawyerId) throws Exception;

    void topicPraise(Long topicId,Long lawyerId) throws Exception;

    /**
     * 话题回应点赞
     * @param replyId
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public void topicReplyPraise(Long replyId,Long lawyerId) throws Exception;


    /**
     * 获取话题的动态
     */
    List<TopicAllVo> topicAll(Pager pager,Long targetLawyerId,Long lawyerId,Long groupId);
}
