package com.faxintong.iruyi.model.general.lawyer;

import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;

import java.io.Serializable;

/**
 * Created by hehongju on 2015/2/10.
 */
public class ReceiveLawyer implements Serializable{

    private Long orderId;
    private Long lawyerId;
    private Integer status;
    private String name;
    private Integer sex;
    private Long cityId;
    private String cityName;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
