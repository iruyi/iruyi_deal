package com.faxintong.iruyi.service.discovery.impl;

import com.faxintong.iruyi.dao.general.discovery.ArticleGeneralMapper;
import com.faxintong.iruyi.dao.mybatis.article.ArticleCommentMapper;
import com.faxintong.iruyi.dao.mybatis.article.ArticlePraiseMapper;
import com.faxintong.iruyi.model.common.Page;
import com.faxintong.iruyi.model.general.article.GeneralArticle;
import com.faxintong.iruyi.model.mybatis.article.ArticleComment;
import com.faxintong.iruyi.model.mybatis.article.ArticleCommentExample;
import com.faxintong.iruyi.model.mybatis.article.ArticlePraise;
import com.faxintong.iruyi.model.mybatis.article.ArticlePraiseExample;
import com.faxintong.iruyi.service.discovery.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.faxintong.iruyi.utils.Constants.PAPER;

/**
 * Created by hehongju on 2015/2/13.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    private Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Autowired
    private ArticleGeneralMapper articleGeneralMapper;
    @Autowired
    private ArticleCommentMapper articleCommentMapper;
    @Autowired
    private ArticlePraiseMapper articlePraiseMapper;

    @Override
    public List<GeneralArticle> findArticles(Page page) throws Exception {
        logger.info("pageSize=" + page.getPageSize() + " currentSize=" +page.getCurrentSize());
        List<GeneralArticle> articles =  articleGeneralMapper.findArticles(page.getPageSize(), page.getCurrentSize(), PAPER);
        if(articles != null && articles.size() > 0){
            for(GeneralArticle article : articles){
                ArticleCommentExample commentExampl = new ArticleCommentExample();
                ArticlePraiseExample praiseExample = new ArticlePraiseExample();
                commentExampl.createCriteria().andArticleIdEqualTo(article.getId());
                Integer commentCount = articleCommentMapper.countByExample(commentExampl);
                article.setCommentCount(commentCount);
                praiseExample.createCriteria().andArticleIdEqualTo(article.getId());
                Integer praiseCount = articlePraiseMapper.countByExample(praiseExample);
                article.setPraiseCount(praiseCount);
            }
        }
        return articles;
    }

    @Override
    public void articleComment(ArticleComment articleComment) throws Exception {
        articleCommentMapper.insertSelective(articleComment);
    }

    @Override
    public void articlePraise(ArticlePraise articlePraise) throws Exception {
        articlePraiseMapper.insertSelective(articlePraise);
    }

    @Override
    public boolean isExistPraise(ArticlePraise articlePraise) throws Exception {
        ArticlePraiseExample example = new ArticlePraiseExample();
        example.createCriteria().andArticleIdEqualTo(articlePraise.getArticleId()).andLawyerIdEqualTo(articlePraise.getLawyerId());
        Integer count = articlePraiseMapper.countByExample(example);
        if(count != null && count.intValue() > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public GeneralArticle findArticleById(Long id) throws Exception {
        return null;
    }

}
