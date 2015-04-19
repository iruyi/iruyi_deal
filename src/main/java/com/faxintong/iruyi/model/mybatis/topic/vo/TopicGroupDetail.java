package com.faxintong.iruyi.model.mybatis.topic.vo;

import java.util.List;

/**
 * Created by bochenlong on 2015/4/18.
 */
public class TopicGroupDetail {
    private List<TopicWithPraise> data;
    private int fansCount;
    private int readCount;
    private int toppicCount;
    private String imageUrl;

    public List<TopicWithPraise> getData() {
        return data;
    }

    public void setData(List<TopicWithPraise> data) {
        this.data = data;
    }

    public int getFansCount() {
        return fansCount;
    }

    public void setFansCount(int fansCount) {
        this.fansCount = fansCount;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public int getToppicCount() {
        return toppicCount;
    }

    public void setToppicCount(int toppicCount) {
        this.toppicCount = toppicCount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
