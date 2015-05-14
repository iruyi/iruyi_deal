package com.faxintong.iruyi.article;

import com.faxintong.iruyi.base.BaseTest;
import com.faxintong.iruyi.model.mybatis.article.AppArticle;
import com.faxintong.iruyi.model.mybatis.vo.AppArticleVo;
import com.faxintong.iruyi.service.article.ArticleService;
import com.faxintong.iruyi.service.lawyer.LawyerService;
import com.faxintong.iruyi.utils.Pager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by admin on 15-4-26.
 */
public class ArticleServiceTest extends BaseTest {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private LawyerService lawyerService;

    @Test
    public void testReportArticle(){
        try {
            articleService.reportArticle("comment", "http://asialee.iteye.com/blog/2101915", 1l);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testArticleList(){
        try {
            Pager pager = new Pager();
            pager.setCurrentPage(1);
            List<AppArticleVo> list = articleService.articleList(pager, 44l);
            for(AppArticleVo appArticle : list){
                System.out.print("=========" + appArticle.getUrl());
                System.out.print("=========" + appArticle.getCommentCount());
                System.out.print("=========" + appArticle.getIsPraise());
                System.out.println("=========" + appArticle.getPraiseCount());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testArticleDetail(){
        try {
            AppArticle appArticle = articleService.articleDetail(1l);
            System.out.println(appArticle.getUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAticleComment(){
        try {
            articleService.articleComment(1l, "comment", 1l);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testArticlePraise(){
        try {
            articleService.articlePraise(3l, 3l);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testArticleStore(){
        try {
            articleService.articleStore(1l, 1l);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetArticleStores(){
        try {
            Pager pager = new Pager();
            pager.setCurrentPage(1);
            List<AppArticle> list = lawyerService.getStoreArticles(pager, 1l);
            System.out.println("===============" + list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetReportArticles(){
        try {
            Pager pager = new Pager();
            pager.setCurrentPage(1);
            List<AppArticle> list = lawyerService.getReportArticles(pager, 1l);
            for(AppArticle appArticle : list){
                System.out.println("=========" + appArticle.getUrl());
                System.out.println("=========" + appArticle.getAcro());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getStoreArticles(){
        try {
            Pager pager = new Pager();
            pager.setCurrentPage(1);
            List<AppArticle> list = lawyerService.getStoreArticles(pager, 1l);
            for(AppArticle appArticle : list){
                System.out.println("=========" + appArticle.getUrl());
                System.out.println("=========" + appArticle.getAcro());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
