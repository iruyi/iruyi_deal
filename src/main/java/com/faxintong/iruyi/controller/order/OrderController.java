package com.faxintong.iruyi.controller.order;

import com.faxintong.iruyi.model.mybatis.order.Order;
import com.faxintong.iruyi.utils.Pager;
import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by hehongju on 2015/2/11.
 */
@RestController
@RequestMapping("order")
public class OrderController {

    /**
     * 发布商机
     * @param order
     * @return
     */
    @RequestMapping(value = "reportOrder")
    public Map<String, Object> reportOrder(Order order) {
        Map<String, Object> result = Maps.newHashMap();

        return result;
    }

    /**
     * 获取单子列表
     * @param pager
     * @return
     */
    @RequestMapping(value = "getOrderList")
    public Map<String, Object> getOrderList(Pager pager) {
        Map<String, Object> result = Maps.newHashMap();

        return result;
    }

    /**
     *
     * @param orderId
     * @return
     */
    @RequestMapping(value = "orderDetail")
    public Map<String, Object> orderDetail(Long orderId) {
        Map<String, Object> result = Maps.newHashMap();

        return result;
    }

    /**
     * 单子感兴趣
     * @param orderId
     * @return
     */
    @RequestMapping(value = "orderInterest")
    public Map<String, Object> orderInterest(Long orderId) {
        Map<String, Object> result = Maps.newHashMap();

        return result;
    }

    /**
     * 单子留言
     * @param orderId
     * @param content
     * @return
     */
    @RequestMapping(value = "orderComment")
    public Map<String, Object> orderComment(Long orderId, String content) {
        Map<String, Object> result = Maps.newHashMap();

        return result;
    }


}
