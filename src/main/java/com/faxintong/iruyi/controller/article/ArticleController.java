package com.faxintong.iruyi.controller.article;

import com.faxintong.iruyi.model.mybatis.article.Article;
import com.faxintong.iruyi.model.mybatis.article.ArticleComment;
import com.faxintong.iruyi.model.mybatis.article.ArticlePraise;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by hehongju on 15-4-14.
 */
@RestController
@RequestMapping("article")
public class ArticleController {

    /**
     * 发布文章
     * @param article
     * @return
     */
    @RequestMapping(value = "reportArticle")
    public Map<String, Object> reportArticle(Article article){

        return null;
    }

    /**
     * 获取文章详情通过文章id
     * @param articleId
     * @return
     */
    @RequestMapping(value = "articleDetail")
    public Map<String, Object> articleDetail(Long articleId){

        return null;
    }

    /**
     * 获取文章列表（分页）
     * @return
     */
    @RequestMapping(value = "articleList")
    public Map<String, Object> articleList(){

        return null;
    }

    /**
     * 评论文章
     * @return
     */
    @RequestMapping(value = "aticleComment")
    public Map<String, Object> aticleComment(ArticleComment articleComment){

        return null;
    }

    /**
     * 文章点赞
     * @param articlePraise
     * @return
     */
    @RequestMapping(value = "articlePraise")
    public Map<String, Object> articlePraise(ArticlePraise articlePraise){

        return null;
    }
}
