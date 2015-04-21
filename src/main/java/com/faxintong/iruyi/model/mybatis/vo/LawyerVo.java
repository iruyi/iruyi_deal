package com.faxintong.iruyi.model.mybatis.vo;

import java.util.List;

/**
 * Created by yunaxie on 2015/4/21.
 * 既用于查看别人主页个人信息
 *  又用于查看自己个人主页个人信息
 */
public class LawyerVo {
    private Long id;
    private String name;
    private String cityName;
    private String photoUrl;
    private String lawOffice;

    private Integer attentionCount;
    private Integer fansCount;

    private List<TopicVo> topicVoList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getLawOffice() {
        return lawOffice;
    }

    public void setLawOffice(String lawOffice) {
        this.lawOffice = lawOffice;
    }

    public Integer getAttentionCount() {
        return attentionCount;
    }

    public void setAttentionCount(Integer attentionCount) {
        this.attentionCount = attentionCount;
    }

    public Integer getFansCount() {
        return fansCount;
    }

    public void setFansCount(Integer fansCount) {
        this.fansCount = fansCount;
    }
}
