package com.faxintong.iruyi.service.article;

import com.faxintong.iruyi.model.mybatis.article.AppArticle;
import com.faxintong.iruyi.model.mybatis.vo.AppArticleVo;
import com.faxintong.iruyi.utils.Pager;

import java.util.List;

/**
 * Created by admin on 15-4-18.
 */
public interface ArticleService {

    /**
     * 发布文章
     * @param comment
     * @param url
     * @param lawyerId
     * @throws Exception
     */
    public void reportArticle(String comment, String url, Long lawyerId) throws Exception;

    /**
     * 获取文章列表（分页）
     * @param pager
     * @return
     * @throws Exception
     */
    public List<AppArticleVo> articleList(Pager pager, Long lawyerId) throws Exception;

    /**
     * 获取文章详情
     * @param articleId
     * @return
     * @throws Exception
     */
    public AppArticle articleDetail(Long articleId) throws Exception;

    /**
     * 评论文章
     * @param articleId
     * @param comment
     * @param lawyerId
     * @return
     */
    public void articleComment(Long articleId, String comment, Long lawyerId) throws Exception;

    /**
     * 文章点赞
     * @param articleId
     * @param lawyerId
     * @return
     */
    public void articlePraise(Long articleId ,Long lawyerId) throws Exception;

    /**
     * 文章收藏
     * @param articleId
     * @param lawyerId
     * @throws Exception
     */
    public void articleStore(Long articleId ,Long lawyerId) throws  Exception;

}
