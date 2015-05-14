package com.faxintong.iruyi.model.mybatis.vo;

import com.faxintong.iruyi.model.mybatis.article.AppArticle;

/**
 * Created by hehongju on 2015/5/14.
 */
public class AppArticleVo extends AppArticle {

    private Integer commentCount;//评论数
    private Integer praiseCount;//点赞数
    private Integer isPraise;//是否点赞

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
}