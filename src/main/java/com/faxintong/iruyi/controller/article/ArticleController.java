package com.faxintong.iruyi.controller.article;

import com.faxintong.iruyi.controller.BaseController;
import com.faxintong.iruyi.dao.mybatis.article.ArticleCommentMapper;
import com.faxintong.iruyi.dao.mybatis.article.ArticlePraiseMapper;
import com.faxintong.iruyi.dao.mybatis.article.ArticleStoreMapper;
import com.faxintong.iruyi.model.mybatis.article.ArticleCommentExample;
import com.faxintong.iruyi.model.mybatis.article.ArticlePraiseExample;
import com.faxintong.iruyi.model.mybatis.article.ArticleStoreExample;
import com.faxintong.iruyi.model.mybatis.vo.AppArticleVo;
import com.faxintong.iruyi.service.article.ArticleService;
import com.faxintong.iruyi.utils.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @Autowired
    private ArticlePraiseMapper articlePraiseMapper;

    @Autowired
    private ArticleCommentMapper articleCommentMapper;

    @Autowired
    private ArticleStoreMapper articleStoreMapper;
    /**
     * 发布文章
     * @param comment
     * @param url
     * @return
     */
    /*@RequestMapping(value = "reportArticle")
    public String reportArticle(HttpServletRequest request, String comment, String url, ModelMap modelMap){
        modelMap.put(ERRCODE, RESULTFAIL);
        try {
            if(comment == null){
                modelMap.put(ERRMESSAGE, "文章评论为null");
            }else if(url == null){
                modelMap.put(ERRMESSAGE, "分享文章url为null");
            }else{
                articleService.reportArticle(comment, url, getLawyerId(request));
                modelMap.put(ERRCODE, RESULTSUCCESS);
                modelMap.put(ERRMESSAGE, "发布文章成功！");
            }
        }catch (Exception e){
            logger.error("发布文章失败:" + e.getMessage());
            modelMap.put(ERRMESSAGE, "发布文章失败!");
        }
        return "lawyer/common";
    }*/

    /**
     * 获取文章列表（分页）
     * @return
     */
    @RequestMapping(value = "articleList")
    public String articleList(HttpServletRequest request, Pager pager, ModelMap modelMap){
        modelMap.put(ERRCODE, RESULTFAIL);
        try {
            if(pager == null || pager.getCurrentPage() == null){
                modelMap.put(ERRMESSAGE, "当前页为null");
            }else{
                List<AppArticleVo> list = articleService.articleList(pager, getLawyerId(request));
                modelMap.put(ERRCODE, RESULTSUCCESS);
                modelMap.put(ERRMESSAGE, "获取文章列表！");
                modelMap.put(DATA, list);
            }
        }catch (Exception e){
            logger.error("获取文章列表失败:" + e.getMessage());
            modelMap.put(ERRMESSAGE, "获取文章列表失败!");
        }
        return "article/articleList";
    }

    /**
     * 获取文章详情
     * @param articleId
     * @return
     */
    @RequestMapping(value = "articleDetail")
    public String articleDetail(HttpServletRequest request, Long articleId, Pager pager, ModelMap modelMap){
        modelMap.put(ERRCODE, RESULTFAIL);
        try {
            if(articleId == null){
                modelMap.put(ERRMESSAGE, "文章id为null");
            }else{
                AppArticleVo appArticle = articleService.articleDetail(articleId, pager, getLawyerId(request));
                modelMap.put(ERRCODE, RESULTSUCCESS);
                modelMap.put(ERRMESSAGE, "获取文章详情成功！");
                modelMap.put(DATA, appArticle);
            }
        }catch (Exception e){
            logger.error("获取文章详情失败:" + e.getMessage());
            modelMap.put(ERRMESSAGE, "获取文章详情失败!");
        }
        return "article/articleDetail";
    }

    /**
     * 评论文章
     * @param articleId
     * @param comment
     * @return
     */
    @RequestMapping(value = "aticleComment")
    public String aticleComment(HttpServletRequest request, Long articleId, String comment, ModelMap modelMap){
        modelMap.put(ERRCODE, RESULTFAIL);
        try {
            if(articleId == null){
                modelMap.put(ERRMESSAGE, "文章id为null");
            }else if(comment == null){
                modelMap.put(ERRMESSAGE, "文章评论为null");
            }else{
                ArticleCommentExample example = new ArticleCommentExample();
                example.createCriteria().andLawyerIdEqualTo(getLawyerId(request)).andArticleIdEqualTo(articleId);
                Integer count = articleCommentMapper.countByExample(example);
                if(count != null && count.intValue() > 0){
                    modelMap.put(ERRMESSAGE, "已评论过文章！");
                }else{
                    articleService.articleComment(articleId, comment, getLawyerId(request));
                    modelMap.put(ERRCODE, RESULTSUCCESS);
                    modelMap.put(ERRMESSAGE, "评论文章成功！");
                }
            }
        }catch (Exception e){
            logger.error("评论文章失败:" + e.getMessage());
            modelMap.put(ERRMESSAGE, "评论文章失败!");
        }
        return "lawyer/common";
    }

    /**
     * 文章点赞
     * @param articleId
     * @return
     */
    @RequestMapping(value = "articlePraise")
    public String articlePraise(HttpServletRequest request, Long articleId, ModelMap modelMap){
        modelMap.put(ERRCODE, RESULTFAIL);
        try {
            if(articleId == null){
                modelMap.put(ERRMESSAGE, "文章id为null");
            }else{
                ArticlePraiseExample example = new ArticlePraiseExample();
                example.createCriteria().andLawyerIdEqualTo(getLawyerId(request)).andArticleIdEqualTo(articleId);
                Integer count = articlePraiseMapper.countByExample(example);
                if(count != null && count.intValue() > 0){
                    modelMap.put(ERRMESSAGE, "已点赞过文章！");
                }else{
                    articleService.articlePraise(articleId, getLawyerId(request));
                    modelMap.put(ERRCODE, RESULTSUCCESS);
                    modelMap.put(ERRMESSAGE, "文章点赞成功！");
                }
            }
        }catch (Exception e){
            logger.error("文章点赞失败:" + e.getMessage());
            modelMap.put(ERRMESSAGE, "文章点赞失败!");
        }
        return "lawyer/common";
    }

    /**
     * 文章存储
     * @param request
     * @param articleId
     * @return
     */
    @RequestMapping(value = "articleStore")
    public String articleStore(HttpServletRequest request, Long articleId, ModelMap modelMap){
        modelMap.put(ERRCODE, RESULTFAIL);
        try {
            if(articleId == null){
                modelMap.put(ERRMESSAGE, "文章id为null");
            }else{
                ArticleStoreExample example = new ArticleStoreExample();
                example.createCriteria().andLawyerIdEqualTo(getLawyerId(request)).andArticleIdEqualTo(articleId);
                Integer count = articleStoreMapper.countByExample(example);
                if(count != null && count.intValue() > 0){
                    modelMap.put(ERRMESSAGE, "已存储过文章！");
                }else{
                    articleService.articleStore(articleId, getLawyerId(request));
                    modelMap.put(ERRCODE, RESULTSUCCESS);
                    modelMap.put(ERRMESSAGE, "文章存储成功！");
                }
            }
        }catch (Exception e){
            logger.error("文章点赞失败:" + e.getMessage());
            modelMap.put(ERRMESSAGE, "文章存储失败!");
        }
        return "lawyer/common";
    }

}
