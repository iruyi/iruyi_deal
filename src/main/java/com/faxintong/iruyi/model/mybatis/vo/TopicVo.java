package com.faxintong.iruyi.model.mybatis.vo;

import java.util.Date;
import java.util.List;

/**
 * Created by yunaxie on 2015/4/20.
 */
public class TopicVo {
    private Long id;

    private Long lawyerId;

    private String lawyerName;

    private String photoUrl;

    private String content;

    private Date createDate;

    private Integer praiseCount;

    private Integer isPraise;

    private List<ReplyVo> replyVoList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
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

    public List<ReplyVo> getReplyVoList() {
        return replyVoList;
    }

    public void setReplyVoList(List<ReplyVo> replyVoList) {
        this.replyVoList = replyVoList;
    }


}
