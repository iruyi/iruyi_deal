package com.faxintong.iruyi.model.mybatis.community;

import java.util.Date;

/**
 * Created by ron on 2015/2/10.
 */
public class CommunityNews {

    private Long issueId;

    private Long LawyerId;

    private Long replyId;

    private Integer type;

    private String issueLawyerName;

    private String replyLawyerName;

    private String issueTitle;

    private String issueContent;

    private String replyContent;

    private Integer praiseCount;

    private Date issueCreateDate;

    private Date replyCreateDate;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIssueLawyerName() {
        return issueLawyerName;
    }

    public void setIssueLawyerName(String issueLawyerName) {
        this.issueLawyerName = issueLawyerName;
    }

    public String getReplyLawyerName() {
        return replyLawyerName;
    }

    public void setReplyLawyerName(String replyLawyerName) {
        this.replyLawyerName = replyLawyerName;
    }

    public String getIssueTitle() {
        return issueTitle;
    }

    public void setIssueTitle(String issueTitle) {
        this.issueTitle = issueTitle;
    }

    public String getIssueContent() {
        return issueContent;
    }

    public void setIssueContent(String issueContent) {
        this.issueContent = issueContent;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Integer getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Integer praiseCount) {
        this.praiseCount = praiseCount;
    }


    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

    public Long getLawyerId() {
        return LawyerId;
    }

    public void setLawyerId(Long lawyerId) {
        LawyerId = lawyerId;
    }

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    public Date getIssueCreateDate() {
        return issueCreateDate;
    }

    public void setIssueCreateDate(Date issueCreateDate) {
        this.issueCreateDate = issueCreateDate;
    }

    public Date getReplyCreateDate() {
        return replyCreateDate;
    }

    public void setReplyCreateDate(Date replyCreateDate) {
        this.replyCreateDate = replyCreateDate;
    }
}
