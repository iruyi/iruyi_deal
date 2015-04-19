package com.faxintong.iruyi.model.mybatis.topic.vo;

import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.topic.Topic;

/**
 * Created by bochenlong on 2015/4/18.
 */
public class TopicWithPraise extends Topic{
    private int praiseCount;
    private boolean isPraise;
    private String photoUrl;

    public int getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(int praiseCount) {
        this.praiseCount = praiseCount;
    }

    public boolean isPraise() {
        return isPraise;
    }

    public void setIsPraise(boolean isPraise) {
        this.isPraise = isPraise;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
