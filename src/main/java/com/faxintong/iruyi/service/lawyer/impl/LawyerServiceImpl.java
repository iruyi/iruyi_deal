package com.faxintong.iruyi.service.lawyer.impl;

import com.faxintong.iruyi.dao.general.LawyerGeneralMapper;
import com.faxintong.iruyi.dao.general.TopicGeneralMapper;
import com.faxintong.iruyi.model.mybatis.active.Active;
import com.faxintong.iruyi.model.mybatis.article.Article;
import com.faxintong.iruyi.model.mybatis.article.ArticleComment;
import com.faxintong.iruyi.model.mybatis.lawyer.City;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.order.Order;
import com.faxintong.iruyi.model.mybatis.topic.Topic;
import com.faxintong.iruyi.model.mybatis.topic.TopicReply;
import com.faxintong.iruyi.model.mybatis.vo.CityVo;
import com.faxintong.iruyi.model.mybatis.vo.LawyerVo;
import com.faxintong.iruyi.model.mybatis.vo.TopicVo;
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
    public List<Order> getOrderList(Pager pager, Long lawyerId) throws Exception {
        return null;
    }

    @Override
    public List<Order> getReceiveOrders(Pager pager, Long lawyerId) throws Exception {
        return null;
    }

    @Override
    public List<TopicVo> getReportTopics(Pager pager, Long lawyerId) throws Exception {
        return topicGeneralMapper.selectTopicVo(null,pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()),pager.getPageSize(),lawyerId,1);
    }

    @Override
    public List<Topic> getReplyTopics(Pager pager, Long lawyerId) throws Exception {
        return null;
    }

    @Override
    public List<TopicVo> getAttetionTopics(Pager pager, Long lawyerId) throws Exception {
        return topicGeneralMapper.selectTopicVo(null,pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()),pager.getPageSize(),lawyerId,0);
    }

    @Override
    public List<TopicReply> praiseTopicReplyList(Pager pager, Long lawyerId) throws Exception {
        return null;
    }

    @Override
    public List<Article> getReportArticles(Pager pager, Long lawyerId) throws Exception {
        return null;
    }

    @Override
    public List<Article> getStoreArticles(Pager pager, Long lawyerId) throws Exception {
        return null;
    }

    @Override
    public List<ArticleComment> praiseArticleComments(Pager pager, Long lawyerId) throws Exception {
        return null;
    }

    @Override
    public List<Active> getStoreActives(Pager pager, Long lawyerId) throws Exception {
        return null;
    }

}
