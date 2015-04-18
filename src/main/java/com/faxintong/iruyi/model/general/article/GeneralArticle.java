package com.faxintong.iruyi.model.general.article;

import com.faxintong.iruyi.model.mybatis.article.Article;

import java.io.Serializable;

/**
 * Created by hehongju on 2015/2/13.
 */
public class GeneralArticle extends Article implements Serializable {

    private Integer praiseCount;//赞美数
    private Integer commentCount;//评论数

    public Integer getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Integer praiseCount) {
        this.praiseCount = praiseCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }
}
