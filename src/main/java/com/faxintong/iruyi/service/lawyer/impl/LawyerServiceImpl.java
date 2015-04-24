package com.faxintong.iruyi.service.lawyer.impl;

import com.faxintong.iruyi.dao.general.*;
import com.faxintong.iruyi.model.mybatis.active.Active;
import com.faxintong.iruyi.model.mybatis.article.AppArticle;
import com.faxintong.iruyi.model.mybatis.article.ArticleComment;
import com.faxintong.iruyi.model.mybatis.vo.*;
import com.faxintong.iruyi.service.lawyer.LawyerService;
import com.faxintong.iruyi.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 15-4-18.
 */
@Service
public class LawyerServiceImpl implements LawyerService {
    @Autowired
    LawyerGeneralMapper lawyerGeneralMapper;
    @Autowired
    TopicGeneralMapper topicGeneralMapper;
    @Autowired
    OrderGeneralMapper orderGeneralMapper;

    @Autowired
    ArticleGeneralMapper articleGeneralMapper;

    @Autowired
    ActiveGeneralMapper activeGeneralMapper;

    @Override
    public List<LawyerVo> getAttetionList(Pager pager,Long lawyerId) throws Exception {
        return lawyerGeneralMapper.selectLawyerVo(pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()),pager.getPageSize(),lawyerId);
    }

    @Override
    public List<CityVo> getCityList(Pager pager) {
        return lawyerGeneralMapper.selectCityVo(pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()),pager.getPageSize());
    }

    @Override
    public LawyerVo getLawyerInfo(Long lawyerId) throws Exception {
        return null;
    }

    @Override
    public LawyerVo getMaterialt(Long lawyerId) throws Exception {
        return lawyerGeneralMapper.selectLawyerVoOne(lawyerId);
    }

    @Override
    public List<OrderVo> getOrderList(Pager pager, Long lawyerId) throws Exception {
        return orderGeneralMapper.selectMyOrderVo(pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()),pager.getPageSize(),lawyerId);
    }

    @Override
    public List<OrderReceiveVo> getReceiveOrders(Pager pager, Long lawyerId) throws Exception {
        return orderGeneralMapper.selectMyOrderReceiveVo(pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()),pager.getPageSize(),lawyerId);
    }

    @Override
    public List<TopicVo> getReportTopics(Pager pager, Long lawyerId) throws Exception {
        return topicGeneralMapper.selectTopicVo(null,pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()),pager.getPageSize(),lawyerId,1);
    }

    @Override
    public List<ReplyVo> getReplyTopics(Pager pager, Long lawyerId) throws Exception {
        return topicGeneralMapper.selectMyReplyVo(pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()),pager.getPageSize(),lawyerId,0);
    }

    @Override
    public List<TopicVo> getAttetionTopics(Pager pager, Long lawyerId) throws Exception {
        return topicGeneralMapper.selectTopicVo(null,pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()),pager.getPageSize(),lawyerId,0);
    }

    @Override
    public List<ReplyVo> praiseTopicReplyList(Pager pager, Long lawyerId) throws Exception {
        return topicGeneralMapper.selectMyReplyVo(pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()),pager.getPageSize(),lawyerId,1);
    }

    @Override
    public List<AppArticle> getReportArticles(Pager pager, Long lawyerId) throws Exception {
        return articleGeneralMapper.getOwnArticleList(pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()),pager.getPageSize(), lawyerId);
    }

    @Override
    public List<AppArticle> getStoreArticles(Pager pager, Long lawyerId) throws Exception {
        return articleGeneralMapper.getStoreArticleList(pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()),pager.getPageSize(), lawyerId);
    }

    @Override
    public List<ArticleComment> praiseArticleComments(Pager pager, Long lawyerId) throws Exception {
        return articleGeneralMapper.getArticleCommentList(pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()),pager.getPageSize(), lawyerId);
    }

    @Override
    public List<Active> getStoreActives(Pager pager, Long lawyerId) throws Exception {
        return activeGeneralMapper.getStoreActiveList(pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()),pager.getPageSize(), lawyerId);
    }

}
