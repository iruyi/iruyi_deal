package com.faxintong.iruyi.model.mybatis.price;

public class ReceivePriceRule {
    private Long id;

    private Long lawyerId;

    private Long orderId;

    private Integer type;

    private Float startPrice;

    private Float endPrice;

    private Float fixedPercentFigure;

    private String description;

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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Float getFixedPercentFigure() {
        return fixedPercentFigure;
    }

    public void setFixedPercentFigure(Float fixedPercentFigure) {
        this.fixedPercentFigure = fixedPercentFigure;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}