package com.faxintong.iruyi.model.mybatis.contract;

import java.util.Date;

public class Contract {
    private Long id;

    private String name;

    private Long orderId;

    private Long rejectLawyerId;

    private Long receiveLawyerId;

    private Float contractFigure;

    private Integer status;

    private String contractUrl;

    private Date createDate;

    private Date updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getRejectLawyerId() {
        return rejectLawyerId;
    }

    public void setRejectLawyerId(Long rejectLawyerId) {
        this.rejectLawyerId = rejectLawyerId;
    }

    public Long getReceiveLawyerId() {
        return receiveLawyerId;
    }

    public void setReceiveLawyerId(Long receiveLawyerId) {
        this.receiveLawyerId = receiveLawyerId;
    }

    public Float getContractFigure() {
        return contractFigure;
    }

    public void setContractFigure(Float contractFigure) {
        this.contractFigure = contractFigure;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContractUrl() {
        return contractUrl;
    }

    public void setContractUrl(String contractUrl) {
        this.contractUrl = contractUrl;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}