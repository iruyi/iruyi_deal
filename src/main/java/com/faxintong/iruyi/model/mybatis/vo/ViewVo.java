package com.faxintong.iruyi.model.mybatis.vo;

import java.util.Date;
import java.util.List;

/**
 * Created by bochenlong on 2015/4/20.
 */
public class ViewVo {
    private Long id;

    private String title;

    private String content;

    private Long lawyerId;

    private String lawyerName;

    private String  photoUrl;

    private Date viewTime;

    private Date endTime;

    private Date createDate;

    private Integer isLive;

    private String introduction;

    // 没有大图
    private String imgUrl;

    private Integer fansCount;

    private Integer isAtten;

    private List<ViewDiscussVo> viewDiscussVoList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getLawyerId() {
        return lawyerId;
    }

    public void setLawyerId(Long lawyerId) {
        this.lawyerId = lawyerId;
    }

    public String getLawyerName() {
        return lawyerName;
    }

    public void setLawyerName(String lawyerName) {
        this.lawyerName = lawyerName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Date getViewTime() {
        return viewTime;
    }

    public void setViewTime(Date viewTime) {
        this.viewTime = viewTime;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getIsLive() {
        return isLive;
    }

    public void setIsLive(Integer isLive) {
        this.isLive = isLive;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getFansCount() {
        return fansCount;
    }

    public void setFansCount(Integer fansCount) {
        this.fansCount = fansCount;
    }

    public List<ViewDiscussVo> getViewDiscussVoList() {
        return viewDiscussVoList;
    }

    public void setViewDiscussVoList(List<ViewDiscussVo> viewDiscussVoList) {
        this.viewDiscussVoList = viewDiscussVoList;
    }

    public Integer getIsAtten() {
        return isAtten;
    }

    public void setIsAtten(Integer isAtten) {
        this.isAtten = isAtten;
    }


    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
