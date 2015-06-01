package com.faxintong.iruyi.service.topic.impl;

import com.faxintong.iruyi.dao.general.TopicGeneralMapper;
import com.faxintong.iruyi.dao.mybatis.topic.TopicGroupTitleMapper;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.topic.AdColumn;
import com.faxintong.iruyi.model.mybatis.topic.Topic;
import com.faxintong.iruyi.model.mybatis.topic.TopicGroupTitle;
import com.faxintong.iruyi.model.mybatis.vo.ReplyVo;
import com.faxintong.iruyi.model.mybatis.vo.TopicAllVo;
import com.faxintong.iruyi.model.mybatis.vo.TopicGroupVo;
import com.faxintong.iruyi.model.mybatis.vo.TopicVo;
import com.faxintong.iruyi.service.topic.TopicService;
import com.faxintong.iruyi.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by admin on 15-4-18.
 */
@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicGeneralMapper topicGeneralMapper;

    @Autowired
    private TopicGroupTitleMapper topicGroupTitleMapper;

    @Override
    public void reportTopic(Long groupId, String content, Lawyer lawyer) throws Exception {
        topicGeneralMapper.insertTopic(groupId,content,lawyer);
    }

    @Override
    public List<TopicGroupVo> getGroupList(Pager pager) throws Exception {
        return topicGeneralMapper.selectTopicGroup(pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()), pager.getPageSize());
    }

    @Override
    public TopicGroupVo getGroupDetail(Long groupId, Pager pager ,Long lawyerId) throws Exception {
        TopicGroupVo topicGroupVo = topicGeneralMapper.getTopicGroupById(groupId);
        // 只有第一页的时候才获取话题组相关统计数据
        if (pager.getCurrentPage() == 1) {
            int topicNum = topicGeneralMapper.countTopicNumByGroupId(groupId);
            int readerNum = topicGeneralMapper.countReaderNumByGroupId(groupId);
            int fansNum = topicGeneralMapper.countFansNumByGroupId(groupId);
            int isAttenNum = topicGeneralMapper.countFansNumByGroupIdMy(groupId,lawyerId);
            topicGroupVo.setTopicCount(topicNum);
            topicGroupVo.setReaderCount(readerNum);
            topicGroupVo.setFansCount(fansNum);
            topicGroupVo.setIsAtten(isAttenNum);
        }

        List<TopicAllVo> topicAllVoList = topicGeneralMapper.selectTopicAllVo(pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()), pager.getPageSize(),null,lawyerId,groupId, null, null);
        topicGroupVo.setTopicAllVoList(topicAllVoList);
        return topicGroupVo;
    }

    @Override
    public TopicVo getTopicDetail(Long topicId ,Long lawyerId) throws Exception {
        TopicVo topicVo = new TopicVo();
        List<ReplyVo> replyVoList = topicGeneralMapper.selectReplyVo(topicId,lawyerId);
        topicVo.setReplyVoList(replyVoList);
        return topicVo;
    }

    @Override
    @Transactional
    public void attentionGroup(Long groupId, Long LawyerId) throws Exception {
        topicGeneralMapper.insertTopicGropuAtten(groupId,LawyerId);
    }

    @Override
    @Transactional
    public void topicReply(Long topicId, String content, Lawyer lawyer) throws Exception {
        topicGeneralMapper.insertTopicReply(topicId,content,lawyer);
    }

    @Override
    @Transactional
    public void attentionTopic(Long topicId, Long lawyerId) throws Exception {
        topicGeneralMapper.insertTopicStore(topicId,lawyerId);
    }

    @Override
    public void attenHotTopics(List<Long> topicIds, Long lawyerId) throws Exception {
        if(topicIds != null && topicIds.size() > 0){
            for(Long topicId : topicIds){
                topicGeneralMapper.insertTopicStore(topicId,lawyerId);
            }
        }
    }

    @Override
    @Transactional
    public void topicPraise(Long topicId, Long lawyerId) throws Exception {
        topicGeneralMapper.insertTopicPraise(topicId,lawyerId);
    }

    @Override
    @Transactional
    public void topicReplyPraise(Long replyId, Long lawyerId) throws Exception {
        topicGeneralMapper.insertReplyPraise(replyId,lawyerId);
    }

    @Override
    public List<TopicAllVo> topicAll(Pager pager,Long targetLawyerId, Long lawyerId, Long groupId) {
        return topicGeneralMapper.selectTopicAllVo(pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()),pager.getPageSize(),targetLawyerId,lawyerId,groupId, null, null);
    }

    @Override
    public List<Topic> findHotTopics(Pager pager) {
        return topicGeneralMapper.selectHotTopics(pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()),pager.getPageSize());
    }

    @Override
    public List<TopicGroupTitle> findHotTopicGroup() {
        return topicGeneralMapper.selectHotTopicGroup();
    }

    @Override
    public List<AdColumn> findAdColumn() {
        return topicGeneralMapper.selectAdColumn();
    }
}
