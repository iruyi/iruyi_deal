package com.faxintong.iruyi.service.lawyer;

import com.faxintong.iruyi.model.mybatis.article.ArticleComment;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.vo.*;
import com.faxintong.iruyi.utils.Pager;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 15-4-18.
 */
@Service
public interface LawyerService {

    /**
     * 获取律师关注列表(黑白名单用)
     * @param pager
     * @return
     */
    public List<LawyerVo> getAttetionList(Pager pager,Long lawyerId) throws Exception;

    /**
     * 获取城市列表
     * @param pager
     * @return
     */
    public List<CityVo> getCityList(Pager pager) throws Exception;


    /**
     * 获取个人信息
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public LawyerVo getLawyerInfo(Long lawyerId) throws Exception;

    /**
     * 获取个人资料
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public LawyerVo getMaterialt(Long lawyerId) throws Exception;

    /**
     * 我发表的商机列表
     * @param pager
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public List<OrderVo> getOrderList(Pager pager, Long lawyerId) throws Exception;

    /**
     * 获取我感兴趣的商机
     * @param pager
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public List<OrderReceiveVo> getReceiveOrders(Pager pager, Long lawyerId) throws Exception;

    /**
     * 我发布的话题列表
     * @param pager
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public List<TopicVo> getReportTopics(Pager pager, Long lawyerId) throws Exception;

    /**
     * 我回应的话题列表
     * @param pager
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public List<ReplyVo> getReplyTopics(Pager pager, Long lawyerId) throws Exception;

    /**
     * 获取我关注的话题列表
     * @param pager
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public List<TopicVo> getAttetionTopics(Pager pager, Long lawyerId) throws Exception;

    /**
     * 赞过话题的回应列表
     * @param pager
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public List<ReplyVo> praiseTopicReplyList(Pager pager, Long lawyerId) throws Exception;

    /**
     * 我发布的文章列表
     * @param pager
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public List<AppArticleVo> getReportArticles(Pager pager, Long lawyerId) throws Exception;

    /**
     * 我收藏的文章列表
     * @param pager
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public List<AppArticleVo> getStoreArticles(Pager pager, Long lawyerId) throws Exception;

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
    public List<ActiveVo> getStoreActives(Pager pager, Long lawyerId) throws Exception;

    /**
     * 获取推荐人列表
     * @param pager
     * @return
     */
    public List<Lawyer> findHotLawyers(Pager pager) throws Exception;

    /**
     * 我的商机中的回应我的接口
     * @param pager
     * @return
     * @throws Exception
     */
    public List<OwnOrderVo> replyOwnOrders(Long lawyerId, Pager pager) throws Exception;

    /**
     * 编辑律师信息
     * @param lawyer
     * @throws Exception
     */
    public boolean editLawyer(Lawyer lawyer) throws Exception;

    /**
     * 批量关注律师
     * @param lawyerId
     * @param attenIds
     * @throws Exception
     */
    public void attenHotLawyers(Long lawyerId,List<Long> attenIds) throws Exception;

    /**
     *
     * @return
     * @throws Exception
     */
    public List<GroupVo> getGroupList() throws Exception;
}
