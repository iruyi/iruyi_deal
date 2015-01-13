package com.faxintong.iruyi.model.mybatis.pay;

import java.util.Date;

public class PaymentMode {
    private Long id;

    private Long priceId;

    private Integer periodNum;

    private Float figure;

    private Date payDate;

    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPriceId() {
        return priceId;
    }

    public void setPriceId(Long priceId) {
        this.priceId = priceId;
    }

    public Integer getPeriodNum() {
        return periodNum;
    }

    public void setPeriodNum(Integer periodNum) {
        this.periodNum = periodNum;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}