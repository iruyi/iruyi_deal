package com.faxintong.iruyi.model.mybatis.lawyer;

import java.util.Date;

public class LawyerAttention {
    private Long id;

    private Long lawyerId;

    private Long otherLawyerId;

    private Date createTime;

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

    public Long getOtherLawyerId() {
        return otherLawyerId;
    }

    public void setOtherLawyerId(Long otherLawyerId) {
        this.otherLawyerId = otherLawyerId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}