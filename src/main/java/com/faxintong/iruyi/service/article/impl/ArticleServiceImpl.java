package com.faxintong.iruyi.service.article.impl;

import com.faxintong.iruyi.dao.general.ArticleGeneralMapper;
import com.faxintong.iruyi.dao.mybatis.article.*;
import com.faxintong.iruyi.model.mybatis.article.*;
import com.faxintong.iruyi.model.mybatis.vo.AppArticleVo;
import com.faxintong.iruyi.model.mybatis.vo.ArticleCommentVo;
import com.faxintong.iruyi.service.article.ArticleService;
import com.faxintong.iruyi.utils.Pager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 15-4-18.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private AppArticleMapper appArticleMapper;

    @Autowired
    private ArticleGeneralMapper articleGeneralMapper;

    @Autowired
    private ArticleCommentMapper articleCommentMapper;

    @Autowired
    private ArticlePraiseMapper articlePraiseMapper;

    @Autowired
    private ArticleStoreMapper articleStoreMapper;

    @Autowired
    private ArcCommentPraiseMapper arcCommentPraiseMapper;


    /*@Transactional
    public void reportArticle(String comment, String url, Long lawyerId) throws Exception {
        AppArticle appArticle = new AppArticle();
        appArticle.setLawyerId(lawyerId);
        appArticle.setComment(comment);
        appArticle.setUrl(url);
        appArticle.setCreateDate(new Date());
        appArticle.setAcro(PaperUtil.getPaperAcro(url));
        appArticleMapper.insertSelective(appArticle);
    }*/

    @Override
    public List<AppArticleVo> articleList(Pager pager, Long lawyerId) throws Exception {
        List<AppArticle> list = articleGeneralMapper.getAppArticleList(pager.getStartCount(pager.getPageSize(), pager.getCurrentPage()), pager.getPageSize());
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
    public List<AppArticleVo> searchArticle(Pager pager, Long lawyerId, String title, String content) throws Exception {
        List<AppArticle> list = null;
        if(!StringUtils.isEmpty(title) && !StringUtils.isEmpty(content)){
            list = articleGeneralMapper.allAppArticle(pager.getStartCount(pager.getPageSize(), pager.getCurrentPage()), pager.getPageSize(), title, content);
        }else if(!StringUtils.isEmpty(title) && StringUtils.isEmpty(content)){
            list = articleGeneralMapper.titleAppArticle(pager.getStartCount(pager.getPageSize(), pager.getCurrentPage()), pager.getPageSize(), title);
        }else if(StringUtils.isEmpty(title) && !StringUtils.isEmpty(content)){
            list = articleGeneralMapper.contentAppArticle(pager.getStartCount(pager.getPageSize(), pager.getCurrentPage()), pager.getPageSize(), content);
        }else{
            list = articleGeneralMapper.getAppArticleList(pager.getStartCount(pager.getPageSize(), pager.getCurrentPage()), pager.getPageSize());
        }
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
    public AppArticleVo articleDetail(Long articleId, Pager pager, Long lawyerId) throws Exception {
        AppArticle appArticle = appArticleMapper.selectByPrimaryKey(articleId);
        AppArticleVo appArticleVo = new AppArticleVo();
        BeanUtils.copyProperties(appArticle, appArticleVo);
        List<ArticleComment> articleCommentList = articleGeneralMapper.getCommentList(pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()), pager.getPageSize(), articleId);
        List<ArticleCommentVo> articleCommentVos = new ArrayList<ArticleCommentVo>();
        if(articleCommentList != null && articleCommentList.size() > 0){
            for(ArticleComment articleComment : articleCommentList){
                ArticleCommentVo articleCommentVo = new ArticleCommentVo();
                BeanUtils.copyProperties(articleComment, articleCommentVo);
                ArcCommentPraiseExample example1 = new ArcCommentPraiseExample();
                example1.createCriteria().andCommentIdEqualTo(articleComment.getId());
                Integer commentCount = arcCommentPraiseMapper.countByExample(example1);
                articleCommentVo.setPraiseCount(commentCount);
                ArcCommentPraiseExample example2 = new ArcCommentPraiseExample();
                example2.createCriteria().andCommentIdEqualTo(articleComment.getId()).andLawyerIdEqualTo(lawyerId);
                Integer isPraise = arcCommentPraiseMapper.countByExample(example2);
                articleCommentVo.setIsPraise(isPraise);
                articleCommentVos.add(articleCommentVo);
            }
        }
        appArticleVo.setArticleCommentVos(articleCommentVos);
        return appArticleVo;
    }

    @Transactional
    public void articleComment(Long articleId, String comment, Long lawyerId) throws Exception {
        ArticleComment articleComment = new ArticleComment();
        articleComment.setArticleId(articleId);
        articleComment.setComment(comment);
        articleComment.setLawyerId(lawyerId);
        articleComment.setCreateTime(new Date());
        articleCommentMapper.insert(articleComment);
    }

    @Transactional
    public void articlePraise(Long articleId, Long lawyerId) throws Exception {
        ArticlePraise articlePraise = new ArticlePraise();
        articlePraise.setLawyerId(lawyerId);
        articlePraise.setArticleId(articleId);
        articlePraiseMapper.insert(articlePraise);
    }

    @Transactional
    public void articleStore(Long articleId, Long lawyerId) throws Exception {
        ArticleStore articleStore = new ArticleStore();
        articleStore.setArticleId(articleId);
        articleStore.setLawyerId(lawyerId);
        articleStoreMapper.insertSelective(articleStore);
    }

}
