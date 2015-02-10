package com.faxintong.iruyi.model.mybatis.community;

/**
 * Created by ron on 2015/2/10.
 */
public class CommunityNews {
    private Long id;

    private Long issueId;

    private Long LawyerId;

    private Integer type;

    private String lawyerName;

    private String title;

    private String content;

    private Integer praiseCount;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getLawyerName() {
        return lawyerName;
    }

    public void setLawyerName(String lawyerName) {
        this.lawyerName = lawyerName;
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

    public Integer getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Integer praiseCount) {
        this.praiseCount = praiseCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
