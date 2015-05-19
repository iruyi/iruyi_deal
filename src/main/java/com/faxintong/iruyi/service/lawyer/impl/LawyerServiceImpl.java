package com.faxintong.iruyi.service.lawyer.impl;

import com.faxintong.iruyi.dao.general.*;
import com.faxintong.iruyi.dao.mybatis.active.ActivePraiseMapper;
import com.faxintong.iruyi.dao.mybatis.active.ActiveStoreMapper;
import com.faxintong.iruyi.dao.mybatis.article.ArticleCommentMapper;
import com.faxintong.iruyi.dao.mybatis.article.ArticleStoreMapper;
import com.faxintong.iruyi.model.mybatis.active.Active;
import com.faxintong.iruyi.model.mybatis.active.ActivePraiseExample;
import com.faxintong.iruyi.model.mybatis.active.ActiveStoreExample;
import com.faxintong.iruyi.model.mybatis.article.AppArticle;
import com.faxintong.iruyi.model.mybatis.article.ArticleComment;
import com.faxintong.iruyi.model.mybatis.article.ArticleCommentExample;
import com.faxintong.iruyi.model.mybatis.article.ArticleStoreExample;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.vo.*;
import com.faxintong.iruyi.service.lawyer.LawyerService;
import com.faxintong.iruyi.utils.Pager;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    ActivePraiseMapper activePraiseMapper;

    @Autowired
    private ArticleCommentMapper articleCommentMapper;

    @Autowired
    private ArticleStoreMapper articleStoreMapper;

    @Autowired
    private ActiveStoreMapper activeStoreMapper;

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
    public List<AppArticleVo> getReportArticles(Pager pager, Long lawyerId) throws Exception {
        List<AppArticle> list = articleGeneralMapper.getOwnArticleList(pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()),pager.getPageSize(), lawyerId);
        List<AppArticleVo> articleVoList = new ArrayList<AppArticleVo>();
        for(AppArticle article : list){
            AppArticleVo appArticleVo = new AppArticleVo();
            ArticleCommentExample commentExample1 = new ArticleCommentExample();
            commentExample1.createCriteria().andArticleIdEqualTo(article.getId());
            Integer commentCount = articleCommentMapper.countByExample(commentExample1);//评论数
            appArticleVo.setCommentCount(commentCount);
            ArticleStoreExample storeExample1 = new ArticleStoreExample();
            storeExample1.createCriteria().andArticleIdEqualTo(article.getId());
            Integer storeCount = articleStoreMapper.countByExample(storeExample1);//收藏数
            appArticleVo.setStoreCount(storeCount);
            ArticleStoreExample storeExample2 = new ArticleStoreExample();
            storeExample2.createCriteria().andArticleIdEqualTo(article.getId()).andLawyerIdEqualTo(lawyerId);
            Integer isStore = articleStoreMapper.countByExample(storeExample2);
            if(isStore != null && isStore.intValue() > 0){
                appArticleVo.setIsStore(1);//已收藏
            }else{
                appArticleVo.setIsStore(0);//未收藏
            }
            BeanUtils.copyProperties(article, appArticleVo);
            articleVoList.add(appArticleVo);
        }
        return articleVoList;
    }

    @Override
    public List<AppArticle> getStoreArticles(Pager pager, Long lawyerId) throws Exception {
        return articleGeneralMapper.getStoreArticleList(pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()),pager.getPageSize(), lawyerId);
    }

    @Override
    public List<ArticleComment> praiseArticleComments(Pager pager, Long lawyerId) throws Exception {
        return articleGeneralMapper.getArticleCommentPraiseList(pager.getStartCount(pager.getPageSize(), pager.getCurrentPage()), pager.getPageSize(), lawyerId);
    }

    @Override
    public List<ActiveVo> getStoreActives(Pager pager, Long lawyerId) throws Exception {
        /*List<Active> list = activeGeneralMapper.getStoreActiveList(pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()),pager.getPageSize(), lawyerId);
        List<ActiveVo> activeVoList = new ArrayList<ActiveVo>();
        if(list != null && list.size() > 0){
            for(Active active : list){
                ActivePraiseExample example = new ActivePraiseExample();
                example.createCriteria().andActiveIdEqualTo(active.getId());
                Integer count = activePraiseMapper.countByExample(example);
                ActiveVo activeVo = new ActiveVo();
                activeVo.setPraiseCount(count);
                PropertyUtils.copyProperties(activeVo, active);
                activeVoList.add(activeVo);
            }
        }
        return activeVoList;*/

        List<Active> list = activeGeneralMapper.getStoreActiveList(pager.getStartCount(pager.getPageSize(), pager.getCurrentPage()), pager.getPageSize(), lawyerId);
        List<ActiveVo> activeVoList = new ArrayList<ActiveVo>();
        if(list != null && list.size() > 0){
            for(Active active : list){
                ActivePraiseExample example = new ActivePraiseExample();
                example.createCriteria().andActiveIdEqualTo(active.getId());
                Integer count = activePraiseMapper.countByExample(example);
                ActiveVo activeVo = new ActiveVo();
                activeVo.setPraiseCount(count);

                ActiveStoreExample storeExample = new ActiveStoreExample();
                example.createCriteria().andActiveIdEqualTo(active.getId());
                Integer storeCount = activeStoreMapper.countByExample(storeExample);
                if(storeCount != null && storeCount.intValue() > 0){
                    activeVo.setIsCollect(1);//已关注
                }else{
                    activeVo.setIsCollect(0);//未关注
                }
                PropertyUtils.copyProperties(activeVo, active);
                activeVoList.add(activeVo);
            }
        }
        return activeVoList;
    }

    @Override
    public List<Lawyer> findHotLawyers(Pager pager) throws Exception {
        return lawyerGeneralMapper.selectHotLawyers(pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()),pager.getPageSize());
    }

}
