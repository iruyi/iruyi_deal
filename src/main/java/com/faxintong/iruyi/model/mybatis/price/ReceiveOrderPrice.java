package com.faxintong.iruyi.model.mybatis.price;

import java.util.Date;

public class ReceiveOrderPrice {
    private Long id;

    private Long orderId;

    private Float startPrice;

    private Float endPrice;

    private Float percentFigure;

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

    public Float getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Float startPrice) {
        this.startPrice = startPrice;
    }

    public Float getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(Float endPrice) {
        this.endPrice = endPrice;
    }

    public Float getPercentFigure() {
        return percentFigure;
    }

    public void setPercentFigure(Float percentFigure) {
        this.percentFigure = percentFigure;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}