package com.faxintong.iruyi.model.mybatis.price;

import java.util.Date;

public class ReceiveOrderPrice {
    private Long id;

    private Long orderId;

    private Long lawyerId;

    private Float fixedFigure;

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

    public Float getFixedFigure() {
        return fixedFigure;
    }

    public void setFixedFigure(Float fixedFigure) {
        this.fixedFigure = fixedFigure;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}