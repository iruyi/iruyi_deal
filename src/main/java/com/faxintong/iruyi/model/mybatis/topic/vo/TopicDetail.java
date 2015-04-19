package com.faxintong.iruyi.model.mybatis.topic.vo;

import java.util.Date;
import java.util.List;

/**
 * Created by bochenlong on 2015/4/18.
 */
public class TopicDetail {
    private List<ReplyWithParis> data;
    private String content;
    private String photoUrl;
    private Date createDate;

    public List<ReplyWithParis> getData() {
        return data;
    }

    public void setData(List<ReplyWithParis> data) {
        this.data = data;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
