package com.faxintong.iruyi.service.discovery;

import com.faxintong.iruyi.model.common.Page;
import com.faxintong.iruyi.model.general.article.GeneralArticle;
import com.faxintong.iruyi.model.mybatis.discovery.ArticleComment;
import com.faxintong.iruyi.model.mybatis.discovery.ArticlePraise;

import java.util.List;

/**
 * Created by hehongju on 2015/2/13.
 */
public interface ArticleService {

    /**
     * 获取文章列表
     * @param page
     * @return
     * @throws Exception
     */
    public List<GeneralArticle> findArticles(Page page) throws Exception;

    /**
     * 对文章进行评论
     * @param articleComment
     * @throws Exception
     */
    public void articleComment(ArticleComment articleComment) throws Exception;

    /**
     * 对文章点赞
     * @param articlePraise
     * @throws Exception
     */
    public void articlePraise(ArticlePraise articlePraise) throws Exception;

    /**
     *
     * @param articlePraise
     * @throws Exception
     */
    public boolean isExistPraise(ArticlePraise articlePraise) throws Exception;

}
