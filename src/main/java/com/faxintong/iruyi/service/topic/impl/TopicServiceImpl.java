package com.faxintong.iruyi.service.topic.impl;

import com.faxintong.iruyi.model.mybatis.topic.Topic;
import com.faxintong.iruyi.model.mybatis.topic.TopicGroup;
import com.faxintong.iruyi.service.topic.TopicService;
import com.faxintong.iruyi.utils.Pager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 15-4-18.
 */
@Service
public class TopicServiceImpl implements TopicService {
    @Override
    public void reportTopic(Long groupId, String content, Long lawyerId) throws Exception {

    }

    @Override
    public List<TopicGroup> getGroupList(Pager pager) throws Exception {
        return null;
    }

    @Override
    public List<Topic> getGroupDetail(Long groupId, Pager pager) throws Exception {
        return null;
    }

    @Override
    public Topic getTopicDetail(Long topicId) throws Exception {
        return null;
    }

    @Override
    public void attentionGroup(Long groupId, Long LawyerId) throws Exception {

    }

    @Override
    public void topicReply(Long topicId, String content, Long lawyerId) throws Exception {

    }

    @Override
    public void attentionTopic(Long topicId, Long lawyerId) throws Exception {

    }

    @Override
    public Map<String, Object> topicReplyPraise(Long replyId, Long lawyerId) throws Exception {
        return null;
    }
}
