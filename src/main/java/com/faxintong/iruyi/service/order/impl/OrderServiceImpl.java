package com.faxintong.iruyi.service.order.impl;

import com.faxintong.iruyi.model.mybatis.order.Order;
import com.faxintong.iruyi.service.order.OrderService;
import com.faxintong.iruyi.utils.Pager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 15-4-18.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public void reportOrder(Order order) throws Exception {

    }

    @Override
    public List<Order> getOrderList(Pager pager, Long lawyer) throws Exception {
        return null;
    }

    @Override
    public Order orderDetail(Long orderId) throws Exception {
        return null;
    }

    @Override
    public void orderInterest(Long orderId, Long lawyerId) throws Exception {

    }

    @Override
    public Map<String, Object> orderComment(Long orderId, String content, Long lawyerId) throws Exception {
        return null;
    }
}
