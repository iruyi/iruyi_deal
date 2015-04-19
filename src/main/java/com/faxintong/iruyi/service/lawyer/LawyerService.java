package com.faxintong.iruyi.service.lawyer;

import com.faxintong.iruyi.model.mybatis.active.Active;
import com.faxintong.iruyi.model.mybatis.article.Article;
import com.faxintong.iruyi.model.mybatis.article.ArticleComment;
import com.faxintong.iruyi.model.mybatis.lawyer.City;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.order.Order;
import com.faxintong.iruyi.model.mybatis.topic.Topic;
import com.faxintong.iruyi.model.mybatis.topic.TopicReply;
import com.faxintong.iruyi.utils.Pager;

import java.util.List;

/**
 * Created by admin on 15-4-18.
 */
public interface LawyerService {

    /**
     * 获取指定律师关注的律师列表
     */
    public List<Lawyer> getAttetionList(Pager pager,Long lawyerId) throws Exception;

    /**
     * 获取城市列表
     */
    public List<City> getCityList(Pager pager);


    /**
     * 获取个人信息
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public Lawyer getLawyerInfo(Long lawyerId) throws Exception;

    /**
     * 获取个人资料
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public Lawyer getMaterialt(Long lawyerId) throws Exception;

    /**
     * 我发表的商机列表
     * @param pager
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public List<Order> getOrderList(Pager pager, Long lawyerId) throws Exception;

    /**
     * 获取我感兴趣的商机
     * @param pager
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public List<Order> getReceiveOrders(Pager pager, Long lawyerId) throws Exception;

    /**
     * 我发布的话题列表
     * @param pager
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public List<Topic> getReportTopics(Pager pager, Long lawyerId) throws Exception;

    /**
     * 我回应的话题列表
     * @param pager
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public List<Topic> getReplyTopics(Pager pager, Long lawyerId) throws Exception;

    /**
     * 获取我关注的话题列表
     * @param pager
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public List<Topic> getAttetionTopics(Pager pager, Long lawyerId) throws Exception;

    /**
     * 赞过话题的回应列表
     * @param pager
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public List<TopicReply> praiseTopicReplyList(Pager pager, Long lawyerId) throws Exception;

    /**
     * 我发布的文章列表
     * @param pager
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public List<Article> getReportArticles(Pager pager, Long lawyerId) throws Exception;

    /**
     * 我收藏的文章列表
     * @param pager
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public List<Article> getStoreArticles(Pager pager, Long lawyerId) throws Exception;

    /**
     * 获取赞过的文章评论列表(缺文章评论点攒表)
     * @param pager
     * @return
     */
    public List<ArticleComment> praiseArticleComments(Pager pager, Long lawyerId) throws Exception;

    /**
     * 获取我收藏的活动列表
     * @param pager
     * @return
     */
    public List<Active> getStoreActives(Pager pager, Long lawyerId) throws Exception;
}
