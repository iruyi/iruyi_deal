package com.faxintong.iruyi.model.mybatis.vo;

import com.faxintong.iruyi.model.mybatis.article.AppArticle;

import java.util.List;

/**
 * Created by hehongju on 2015/5/14.
 */
public class AppArticleVo extends AppArticle {

    private Integer commentCount;//评论数
    private Integer praiseCount;//点赞数
    private Integer isPraise;//是否点赞
    private Integer isComment;//是否评论
    private Integer storeCount;//收藏数
    private Integer isStore;//是否收藏

    private List<ArticleCommentVo> articleCommentVos;

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Integer praiseCount) {
        this.praiseCount = praiseCount;
    }

    public Integer getIsPraise() {
        return isPraise;
    }

    public void setIsPraise(Integer isPraise) {
        this.isPraise = isPraise;
    }

    public Integer getIsComment() {
        return isComment;
    }

    public void setIsComment(Integer isComment) {
        this.isComment = isComment;
    }

    public Integer getStoreCount() {
        return storeCount;
    }

    public void setStoreCount(Integer storeCount) {
        this.storeCount = storeCount;
    }

    public Integer getIsStore() {
        return isStore;
    }

    public void setIsStore(Integer isStore) {
        this.isStore = isStore;
    }

    public List<ArticleCommentVo> getArticleCommentVos() {
        return articleCommentVos;
    }

    public void setArticleCommentVos(List<ArticleCommentVo> articleCommentVos) {
        this.articleCommentVos = articleCommentVos;
    }
}