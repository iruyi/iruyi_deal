package com.faxintong.iruyi.model.mybatis.vo;

import java.util.Date;

/**
 * Created by yunaxie on 2015/4/21.
 */
public class OrderVo {
    private Long id;
    private Integer type;
    private String title;
    private String content;
    private String cityName;
    private Integer interestCount;
    private Date deadDate;
    private String keyWords;
    private Double price;
    private Integer isInterest;


    private Integer fansCount;
    private Integer issueCount;
    private Integer interestCountMy;

    private String blackList;
    private String whiteList;
    private Long lawyerId;
    private String lawyerName;
    private String lawyerPhotoUrl;
    private Long cityId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDeadDate() {
        return deadDate;
    }

    public void setDeadDate(Date deadDate) {
        this.deadDate = deadDate;
    }

    public Integer getInterestCount() {
        return interestCount;
    }

    public void setInterestCount(Integer interestCount) {
        this.interestCount = interestCount;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getIsInterest() {
        return isInterest;
    }

    public void setIsInterest(Integer isInterest) {
        this.isInterest = isInterest;
    }

    public Integer getFansCount() {
        return fansCount;
    }

    public void setFansCount(Integer fansCount) {
        this.fansCount = fansCount;
    }

    public Integer getIssueCount() {
        return issueCount;
    }

    public void setIssueCount(Integer issueCount) {
        this.issueCount = issueCount;
    }

    public Integer getInterestCountMy() {
        return interestCountMy;
    }

    public void setInterestCountMy(Integer interestCountMy) {
        this.interestCountMy = interestCountMy;
    }

    public String getBlackList() {
        return blackList;
    }

    public void setBlackList(String blackList) {
        this.blackList = blackList;
    }

    public String getWhiteList() {
        return whiteList;
    }

    public void setWhiteList(String whiteList) {
        this.whiteList = whiteList;
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

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getLawyerPhotoUrl() {
        return lawyerPhotoUrl;
    }

    public void setLawyerPhotoUrl(String lawyerPhotoUrl) {
        this.lawyerPhotoUrl = lawyerPhotoUrl;
    }
}
