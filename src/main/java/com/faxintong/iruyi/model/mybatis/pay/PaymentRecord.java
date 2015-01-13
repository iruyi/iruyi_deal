package com.faxintong.iruyi.model.mybatis.pay;

import java.util.Date;

public class PaymentRecord {
    private Long id;

    private Long orderId;

    private Long payLawyerId;

    private Long receiveLawyerId;

    private Float figure;

    private Date payDate;

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

    public Long getPayLawyerId() {
        return payLawyerId;
    }

    public void setPayLawyerId(Long payLawyerId) {
        this.payLawyerId = payLawyerId;
    }

    public Long getReceiveLawyerId() {
        return receiveLawyerId;
    }

    public void setReceiveLawyerId(Long receiveLawyerId) {
        this.receiveLawyerId = receiveLawyerId;
    }

    public Float getFigure() {
        return figure;
    }

    public void setFigure(Float figure) {
        this.figure = figure;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }
}