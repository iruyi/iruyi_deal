package com.faxintong.iruyi.model.mybatis.vo;

import java.util.Date;

/**
 * Created by yunaxie on 2015/4/21.
 */
public class PositionVo {
    private Long id;
    private String officeName;
    private String cityName;
    private String salary;
    private Date createDate;
    //TODO 律所头像没有表里
    private String title;
    private String content;
    private Integer type;
    private String education;
    private String experience;
    private String keywords;
    private Integer isCollection;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Integer getIsCollection() {
        return isCollection;
    }

    public void setIsCollection(Integer isCollection) {
        this.isCollection = isCollection;
    }
}
