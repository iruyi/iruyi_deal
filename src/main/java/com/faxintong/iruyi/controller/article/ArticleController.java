package com.faxintong.iruyi.controller.article;

import com.faxintong.iruyi.controller.BaseController;
import com.faxintong.iruyi.model.mybatis.article.AppArticle;
import com.faxintong.iruyi.service.article.ArticleService;
import com.faxintong.iruyi.utils.Pager;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

import static com.faxintong.iruyi.utils.Constants.*;

/**
 * Created by hehongju on 15-4-14.
 */
@RestController
@RequestMapping("article")
public class ArticleController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    /**
     * 发布文章
     * @param comment
     * @param url
     * @return
     */
    @RequestMapping(value = "reportArticle")
    public Map<String, Object> reportArticle(HttpServletRequest request, String comment, String url){
        Map<String, Object> result = Maps.newHashMap();
        result.put(ERRCODE, 0);
        try {
            if(comment == null){
                result.put(ERRMESSAGE, "文章评论为null");
            }else if(url == null){
                result.put(ERRMESSAGE, "分享文章url为null");
            }else{
                articleService.reportArticle(comment, url, getLawyerId(request));
                result.put(ERRCODE, 1);
                result.put(ERRMESSAGE, "发布文章成功！");
            }
        }catch (Exception e){
            logger.error("发布文章失败:" + e.getMessage());
            result.put(ERRMESSAGE, "发布文章失败!");
        }
        return result;
    }

    /**
     * 获取文章列表（分页）
     * @return
     */
    @RequestMapping(value = "articleList")
    public Map<String, Object> articleList(Pager pager){
        Map<String, Object> result = Maps.newHashMap();
        result.put(ERRCODE, 0);
        try {
            if(pager == null || pager.getCurrentPage() == null){
                result.put(ERRMESSAGE, "当前页为null");
            }else{
                List<AppArticle> list = articleService.articleList(pager);
                result.put(ERRCODE, 1);
                result.put(ERRMESSAGE, "获取文章列表！");
                result.put(DATA, list);
            }
        }catch (Exception e){
            logger.error("获取文章列表失败:" + e.getMessage());
            result.put(ERRMESSAGE, "获取文章列表失败!");
        }
        return result;
    }

    /**
     * 获取文章详情
     * @param articleId
     * @return
     */
    @RequestMapping(value = "articleDetail")
    public Map<String, Object> articleDetail(Long articleId){
        Map<String, Object> result = Maps.newHashMap();
        result.put(ERRCODE, 0);
        try {
            if(articleId == null){
                result.put(ERRMESSAGE, "文章id为null");
            }else{
                AppArticle appArticle = articleService.articleDetail(articleId);
                result.put(ERRCODE, 1);
                result.put(ERRMESSAGE, "获取文章详情成功！");
                result.put(DATA, appArticle);
            }
        }catch (Exception e){
            logger.error("获取文章详情失败:" + e.getMessage());
            result.put(ERRMESSAGE, "获取文章详情失败!");
        }
        return result;
    }

    /**
     * 评论文章
     * @param articleId
     * @param comment
     * @return
     */
    @RequestMapping(value = "aticleComment")
    public Map<String, Object> aticleComment(HttpServletRequest request, Long articleId, String comment){
        Map<String, Object> result = Maps.newHashMap();
        result.put(ERRCODE, 0);
        try {
            if(articleId == null){
                result.put(ERRMESSAGE, "文章id为null");
            }else if(comment == null){
                result.put(ERRMESSAGE, "文章评论为null");
            }else{
                articleService.articleComment(articleId, comment, getLawyerId(request));
                result.put(ERRCODE, 1);
                result.put(ERRMESSAGE, "评论文章成功！");
            }
        }catch (Exception e){
            logger.error("评论文章失败:" + e.getMessage());
            result.put(ERRMESSAGE, "评论文章失败!");
        }
        return result;
    }

    /**
     * 文章点赞
     * @param articleId
     * @return
     */
    @RequestMapping(value = "articlePraise")
    public Map<String, Object> articlePraise(HttpServletRequest request, Long articleId){
        Map<String, Object> result = Maps.newHashMap();
        result.put(ERRCODE, 0);
        try {
            if(articleId == null){
                result.put(ERRMESSAGE, "文章id为null");
            }else{
                articleService.articlePraise(articleId, getLawyerId(request));
                result.put(ERRCODE, 1);
                result.put(ERRMESSAGE, "文章点赞成功！");
            }
        }catch (Exception e){
            logger.error("文章点赞失败:" + e.getMessage());
            result.put(ERRMESSAGE, "文章点赞失败!");
        }
        return result;
    }

    /**
     * 文章存储
     * @param request
     * @param articleId
     * @return
     */
    @RequestMapping(value = "articleStore")
    public Map<String, Object> articleStore(HttpServletRequest request, Long articleId){
        Map<String, Object> result = Maps.newHashMap();
        result.put(ERRCODE, 0);
        try {
            if(articleId == null){
                result.put(ERRMESSAGE, "文章id为null");
            }else{
                articleService.articleStore(articleId, getLawyerId(request));
                result.put(ERRCODE, 1);
                result.put(ERRMESSAGE, "文章存储成功！");
            }
        }catch (Exception e){
            logger.error("文章点赞失败:" + e.getMessage());
            result.put(ERRMESSAGE, "文章存储失败!");
        }
        return result;
    }

}
