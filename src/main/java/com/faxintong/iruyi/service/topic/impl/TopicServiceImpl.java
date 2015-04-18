package com.faxintong.iruyi.service.topic.impl;

import com.faxintong.iruyi.dao.mybatis.topic.TopicGroupMapper;
import com.faxintong.iruyi.dao.mybatis.topic.TopicMapper;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.topic.Topic;
import com.faxintong.iruyi.model.mybatis.topic.TopicGroup;
import com.faxintong.iruyi.model.mybatis.topic.vo.ReplyWithParis;
import com.faxintong.iruyi.model.mybatis.topic.vo.TopicDetail;
import com.faxintong.iruyi.model.mybatis.topic.vo.TopicGroupDetail;
import com.faxintong.iruyi.model.mybatis.topic.vo.TopicWithPraise;
import com.faxintong.iruyi.service.topic.TopicService;
import com.faxintong.iruyi.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 15-4-18.
 */
@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicMapper topicMapper;
    @Autowired
    private TopicGroupMapper topicGroupMapper;

    @Override
    @Transactional
    public void reportTopic(Long groupId, String content, Lawyer lawyer) throws Exception {
        Topic topic = new Topic();
        topic.setGroupId(groupId);
        topic.setContent(content);
        topic.setLawyerId(lawyer.getId());
        topic.setLawyerName(lawyer.getName());

        Date current = new Date();
        topic.setCreateDate(current);
        topic.setUpdateDate(current);
        topic.setTitle("");
        topicMapper.insert(topic);
    }

    @Override
    public List<TopicGroup> getGroupList(Pager pager) throws Exception {
        return topicGroupMapper.selectTopicGroup(pager);
    }

    @Override
    public TopicGroupDetail getGroupDetail(Long groupId, Pager pager,Long lawyerId) throws Exception {
        int topicNum = topicMapper.countTopicByGroup(groupId);
        int fansNum = topicGroupMapper.countfans(groupId);
        int readNum = topicGroupMapper.countRead(groupId);
        List<TopicWithPraise> topicWithPraiseList = topicMapper.selectTopicByGroup(groupId,lawyerId);
        TopicGroupDetail topicGroupDetail = new TopicGroupDetail();
        topicGroupDetail.setFansCount(fansNum);
        topicGroupDetail.setReadCount(readNum);
        topicGroupDetail.setToppicCount(topicNum);
        topicGroupDetail.setData(topicWithPraiseList);
        return topicGroupDetail;
    }

    @Override
    public TopicDetail getTopicDetail(Long topicId, Long LawyerId) throws Exception {
        TopicDetail topicDetail = topicMapper.selectById(topicId);
        List<ReplyWithParis> replyWithParisList =topicMapper.selectReplyByTopicId(topicId,LawyerId);
        topicDetail.setData(replyWithParisList);
        return topicDetail;
    }

    @Override
    @Transactional
    public void attentionGroup(Long groupId, Long LawyerId) throws Exception {
        topicGroupMapper.insertTopicGropuAtten(groupId,LawyerId);
    }

    @Override
    @Transactional
    public void topicReply(Long topicId, String content, Lawyer lawyer) throws Exception {
        topicMapper.insertTopicReply(topicId, content, lawyer);
    }

    @Override
    @Transactional
    public void attentionTopic(Long topicId, Long lawyerId) throws Exception {
        topicMapper.insertTopicParise(topicId,lawyerId);
    }

    @Override
    @Transactional
    public void topicReplyPraise(Long replyId, Long lawyerId) throws Exception {
        topicMapper.insertReplyParise(replyId,lawyerId);
    }
}
