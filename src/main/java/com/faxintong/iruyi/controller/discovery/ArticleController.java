package com.faxintong.iruyi.controller.discovery;

import com.faxintong.iruyi.controller.BaseController;
import com.faxintong.iruyi.model.common.Page;
import com.faxintong.iruyi.model.general.article.GeneralArticle;
import com.faxintong.iruyi.model.mybatis.article.ArticleComment;
import com.faxintong.iruyi.model.mybatis.article.ArticlePraise;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.service.discovery.ArticleService;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.faxintong.iruyi.utils.Constants.*;

/**
 * Created by hehongju on 2015/2/15.
 */
@RestController
@RequestMapping("article")
public class ArticleController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "findArticles")
    public Map<String, Object> findArticles(Page page, BindingResult bindingResult,
                                           HttpServletRequest request, HttpServletResponse response){
        Map<String , Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        if(bindingResult.hasErrors()){
            result.put(ERR_MSG, bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        try {
            List<GeneralArticle> articles = articleService.findArticles(page);
            result.put(RESULT, true);
            result.put(DATA, articles);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取文章失败:" + e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "articleDetail")
    public Map<String, Object> articleDetail(String id, HttpServletRequest request, HttpServletResponse response){
        Map<String , Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        if(StringUtils.isEmpty(id)){
            result.put(ERR_MSG, "article id is null");
            return result;
        }
        try {
            GeneralArticle article = articleService.findArticleById(Long.parseLong(id));
            result.put(RESULT, true);
            result.put(DATA, article);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取文章失败:" + e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "articleComment")
    public Map<String, Object> articleComment(HttpServletRequest request, ArticleComment articleComment, BindingResult bindingResult){
        Map<String , Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        if(bindingResult.hasErrors()){
            result.put(ERR_MSG, bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        try {
            Lawyer lawyer = getLawyer(request);
            articleComment.setLawyerId(lawyer.getId());
            articleComment.setLawyerName(lawyer.getName());
            articleComment.setCreateTime(new Date());
            articleService.articleComment(articleComment);
            result.put(RESULT, true);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取文章失败:" + e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "articlePraise")
    public Map<String, Object> articlePraise(HttpServletRequest request, String articleId){
        Map<String , Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        if(StringUtils.isEmpty(articleId)){
            result.put(ERR_MSG, "articleId is null");
            return result;
        }
        try {
            Lawyer lawyer = getLawyer(request);
            ArticlePraise articlePraise = new ArticlePraise();
            articlePraise.setArticleId(Long.parseLong(articleId.toString()));
            articlePraise.setLawyerId(lawyer.getId());
            //articlePraise.setLawyerName(lawyer.getName());
            //articlePraise.setCreateTime(new Date());
            if(articleService.isExistPraise(articlePraise)){
                result.put(ERR_MSG, "律师" + lawyer.getName() + "已点过赞了");
                return result;
            }else{
                articleService.articlePraise(articlePraise);
                result.put(RESULT, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取文章失败:" + e.getMessage());
        }
        return result;
    }
}
