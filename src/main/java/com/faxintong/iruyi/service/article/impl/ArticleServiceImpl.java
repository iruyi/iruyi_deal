package com.faxintong.iruyi.service.article.impl;

import com.faxintong.iruyi.dao.general.ArticleGeneralMapper;
import com.faxintong.iruyi.dao.mybatis.article.AppArticleMapper;
import com.faxintong.iruyi.dao.mybatis.article.ArticleCommentMapper;
import com.faxintong.iruyi.dao.mybatis.article.ArticlePraiseMapper;
import com.faxintong.iruyi.dao.mybatis.article.ArticleStoreMapper;
import com.faxintong.iruyi.model.mybatis.article.AppArticle;
import com.faxintong.iruyi.model.mybatis.article.ArticleComment;
import com.faxintong.iruyi.model.mybatis.article.ArticlePraise;
import com.faxintong.iruyi.model.mybatis.article.ArticleStore;
import com.faxintong.iruyi.service.article.ArticleService;
import com.faxintong.iruyi.utils.Pager;
import com.faxintong.iruyi.utils.PaperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public void reportArticle(String comment, String url, Long lawyerId) throws Exception {
        AppArticle appArticle = new AppArticle();
        appArticle.setLawyerId(lawyerId);
        appArticle.setComment(comment);
        appArticle.setUrl(url);
        appArticle.setCreateDate(new Date());
        appArticle.setAcro(PaperUtil.getPaperAcro(url));
        appArticleMapper.insertSelective(appArticle);
    }

    @Override
    public List<AppArticle> articleList(Pager pager) throws Exception {
        List<AppArticle> list = articleGeneralMapper.getAppArticleList(pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()), pager.getPageSize());
        /*if(list != null && list.size() > 0){
            for (AppArticle appArticle : list){
                appArticle.setAcro(PaperUtil.getPaperAcro(appArticle.getUrl()));
            }
        }*/
        return list;
    }

    @Override
    public AppArticle articleDetail(Long articleId) throws Exception {
        return appArticleMapper.selectByPrimaryKey(articleId);
    }

    @Override
    public void articleComment(Long articleId, String comment, Long lawyerId) throws Exception {
        ArticleComment articleComment = new ArticleComment();
        articleComment.setArticleId(articleId);
        articleComment.setComment(comment);
        articleComment.setLawyerId(lawyerId);
        articleComment.setCreateTime(new Date());
        articleCommentMapper.insert(articleComment);
    }

    @Override
    public void articlePraise(Long articleId, Long lawyerId) throws Exception {
        ArticlePraise articlePraise = new ArticlePraise();
        articlePraise.setLawyerId(lawyerId);
        articlePraise.setArticleId(articleId);
        articlePraiseMapper.insert(articlePraise);
    }

    @Override
    public void articleStore(Long articleId, Long lawyerId) throws Exception {
        ArticleStore articleStore = new ArticleStore();
        articleStore.setArticleId(articleId);
        articleStore.setLawyerId(lawyerId);
        articleStoreMapper.insertSelective(articleStore);
    }

}