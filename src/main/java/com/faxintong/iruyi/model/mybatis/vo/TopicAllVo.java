package com.faxintong.iruyi.model.mybatis.vo;

/**
 * Created by bochenlong on 2015/4/26.
 */
public class TopicAllVo {
    private Long lawyerId2;// 谁
    private String lawyerName2;// 谁
    private Integer type;// 怎么 收藏、发表、回复

    private Long id ;//话题ID
    private String title;//话题标题
    private String content;//话题内容

    private Long lawyerId;//话题作者
    private String lawyerName;//作者名称
    private String photoUrl;//作者头像

    private Long id2;//回复或者收藏ID
    private String content2;// 回复内容
    private String photoUrl2;

    private String createDate;// 收藏、发表、或回复时间

    private Integer praiseCount;//话题或回复点赞总数，
    private Integer isPraise;//话题或回复是否点赞

    public Long getLawyerId2() {
        return lawyerId2;
    }

    public void setLawyerId2(Long lawyerId2) {
        this.lawyerId2 = lawyerId2;
    }

    public String getLawyerName2() {
        return lawyerName2;
    }

    public void setLawyerName2(String lawyerName2) {
        this.lawyerName2 = lawyerName2;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getId2() {
        return id2;
    }

    public void setId2(Long id2) {
        this.id2 = id2;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    public String getPhotoUrl2() {
        return photoUrl2;
    }

    public void setPhotoUrl2(String photoUrl2) {
        this.photoUrl2 = photoUrl2;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Integer praiseCount) {
        this.praiseCount = praiseCount;
    }

    public Integer getIsPraise() {
        return isPraise;
    }

    public void setIsPraise(Integer isPraise) {
        this.isPraise = isPraise;
    }
}
