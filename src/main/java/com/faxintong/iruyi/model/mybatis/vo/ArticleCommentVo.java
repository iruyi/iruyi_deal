package com.faxintong.iruyi.model.mybatis.vo;

import com.faxintong.iruyi.model.mybatis.article.ArticleComment;

/**
 * Created by admin on 15-5-17.
 */
public class ArticleCommentVo extends ArticleComment {

    private Integer isPraise;//是否点赞
    private Integer praiseCount;//点赞数


    public Integer getIsPraise() {
        return isPraise;
    }

    public void setIsPraise(Integer isPraise) {
        this.isPraise = isPraise;
    }

    public Integer getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Integer praiseCount) {
        this.praiseCount = praiseCount;
    }
}
