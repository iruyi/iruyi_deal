package com.faxintong.iruyi.model.mybatis.price;

import java.util.Date;

public class ReportPrice {
    private Long id;

    private Long orderId;

    private Long lawyerId;

    private Integer lawyerType;

    private Float price;

    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getLawyerId() {
        return lawyerId;
    }

    public void setLawyerId(Long lawyerId) {
        this.lawyerId = lawyerId;
    }

    public Integer getLawyerType() {
        return lawyerType;
    }

    public void setLawyerType(Integer lawyerType) {
        this.lawyerType = lawyerType;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}