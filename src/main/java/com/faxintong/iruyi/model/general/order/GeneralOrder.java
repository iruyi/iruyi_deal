package com.faxintong.iruyi.model.general.order;

import com.faxintong.iruyi.model.mybatis.order.Order;

/**
 * Created by hehongju on 2015/2/5.
 */
public class GeneralOrder extends Order {

    private String cityName;


    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
