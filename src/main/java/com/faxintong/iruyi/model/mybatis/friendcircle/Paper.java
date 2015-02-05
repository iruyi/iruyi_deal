package com.faxintong.iruyi.model.mybatis.friendcircle;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Null;
import java.util.Date;

public class Paper {
    @Null
    private Long id;

    @NotBlank
    private Long lawyerId;

    @NotBlank
    private String title;

    private Date createTime;

    @NotBlank
    private String paperContent;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPaperContent() {
        return paperContent;
    }

    public void setPaperContent(String paperContent) {
        this.paperContent = paperContent;
    }


    @Override
    public String toString() {
        return "Paper{" +
                "id=" + id +
                ", lawyerId=" + lawyerId +
                ", title='" + title + '\'' +
                ", createTime=" + createTime +
                ", paperContent='" + paperContent + '\'' +
                '}';
    }
}