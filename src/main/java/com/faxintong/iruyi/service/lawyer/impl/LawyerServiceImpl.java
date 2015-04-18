package com.faxintong.iruyi.service.lawyer.impl;

import com.faxintong.iruyi.model.mybatis.active.Active;
import com.faxintong.iruyi.model.mybatis.article.Article;
import com.faxintong.iruyi.model.mybatis.article.ArticleComment;
import com.faxintong.iruyi.model.mybatis.lawyer.City;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.order.Order;
import com.faxintong.iruyi.model.mybatis.topic.Topic;
import com.faxintong.iruyi.model.mybatis.topic.TopicReply;
import com.faxintong.iruyi.service.lawyer.LawyerService;
import com.faxintong.iruyi.utils.Pager;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 15-4-18.
 */
@Service
public class LawyerServiceImpl implements LawyerService {

    @Override
    public List<Lawyer> getAttetionList(Pager pager) throws Exception {
        return null;
    }

    @Override
    public List<City> getCityList(Pager pager) {
        return null;
    }

    @Override
    public Lawyer getLawyerInfo(Long lawyerId) throws Exception {
        return null;
    }

    @Override
    public Lawyer getMaterialt(Long lawyerId) throws Exception {
        return null;
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
    public List<Topic> getReportTopics(Pager pager, Long lawyerId) throws Exception {
        return null;
    }

    @Override
    public List<Topic> getReplyTopics(Pager pager, Long lawyerId) throws Exception {
        return null;
    }

    @Override
    public List<Topic> getAttetionTopics(Pager pager, Long lawyerId) throws Exception {
        return null;
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
