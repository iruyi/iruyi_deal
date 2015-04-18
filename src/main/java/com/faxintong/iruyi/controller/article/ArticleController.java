package com.faxintong.iruyi.controller.article;

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
     * @param content
     * @param url
     * @return
     */
    @RequestMapping(value = "reportArticle")
    public Map<String, Object> reportArticle(String content, String url){

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
     * 获取文章详情
     * @param articleId
     * @return
     */
    @RequestMapping(value = "articleDetail")
    public Map<String, Object> articleDetail(Long articleId){

        return null;
    }

    /**
     * 评论文章
     * @param articleId
     * @param comment
     * @return
     */
    @RequestMapping(value = "aticleComment")
    public Map<String, Object> aticleComment(String articleId, String comment){

        return null;
    }

    /**
     * 文章点赞
     * @param articleId
     * @return
     */
    @RequestMapping(value = "articlePraise")
    public Map<String, Object> articlePraise(Long articleId){

        return null;
    }
}
