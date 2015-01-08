package com.faxintong.iruyi.model.mybatis.pay;

import java.util.Date;

public class PayRecord {
    private Long id;

    private Long orderId;

    private Long payLayerId;

    private Long receiveLayerId;

    private Float figure;

    private Integer status;

    private Integer layerType;

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

    public Long getPayLayerId() {
        return payLayerId;
    }

    public void setPayLayerId(Long payLayerId) {
        this.payLayerId = payLayerId;
    }

    public Long getReceiveLayerId() {
        return receiveLayerId;
    }

    public void setReceiveLayerId(Long receiveLayerId) {
        this.receiveLayerId = receiveLayerId;
    }

    public Float getFigure() {
        return figure;
    }

    public void setFigure(Float figure) {
        this.figure = figure;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLayerType() {
        return layerType;
    }

    public void setLayerType(Integer layerType) {
        this.layerType = layerType;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }
}