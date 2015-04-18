package com.faxintong.iruyi.model.mybatis.topic.vo;

/**
 * Created by bochenlong on 2015/4/18.
 */
public class ReplyWithParis {
    private int praiseCount;
    private boolean isPraise;
    private String content;
    private String photoUrl;
    private String lawyerName;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLawyerName() {
        return lawyerName;
    }

    public void setLawyerName(String lawyerName) {
        this.lawyerName = lawyerName;
    }
}
