package com.faxintong.iruyi.model.general.order;

import com.faxintong.iruyi.model.mybatis.order.Order;

import java.io.Serializable;

/**
 * Created by hehongju on 2015/2/5.
 */
public class GeneralOrder extends Order implements Serializable{

    private String cityName;

    private Long categoryId;
    private String category;
    private Long cityId;
    private Long[] lawyerIds;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long[] getLawyerIds() {
        return lawyerIds;
    }

    public void setLawyerIds(Long[] lawyerIds) {
        this.lawyerIds = lawyerIds;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
