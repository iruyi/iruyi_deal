package com.faxintong.iruyi.service.article.impl;

import com.faxintong.iruyi.model.mybatis.article.Article;
import com.faxintong.iruyi.service.article.ArticleService;
import com.faxintong.iruyi.utils.Pager;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 15-4-18.
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Override
    public void reportArticle(String content, String url, Long lawyerId) throws Exception {

    }

    @Override
    public List<Article> articleList(Pager pager) throws Exception {
        return null;
    }

    @Override
    public Article articleDetail(Long articleId) throws Exception {
        return null;
    }

    @Override
    public void aticleComment(String articleId, String comment, Long lawyerId) throws Exception {

    }

    @Override
    public void articlePraise(Long articleId, Long lawyerId) throws Exception {

    }
}
