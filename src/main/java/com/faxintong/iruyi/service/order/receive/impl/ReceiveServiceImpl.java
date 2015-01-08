package com.faxintong.iruyi.service.order.receive.impl;

import com.faxintong.iruyi.model.mybatis.order.Order;
import com.faxintong.iruyi.service.order.receive.ReceiveService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 15-1-3.
 */
@Service
public class ReceiveServiceImpl implements ReceiveService {
    @Override
    public List<Order> findAvailableOrders(Long lawyerId) throws Exception {
        return null;
    }

    @Override
    public List<Order> findReceivingOrders(Long lawyerId) throws Exception {
        return null;
    }

    @Override
    public List<Order> findFinalOrders(Long lawyerId) throws Exception {
        return null;
    }

    @Override
    public void receiveOrder(Long lawyerId, Long orderId) throws Exception {

    }

    @Override
    public void confirmOrder(Long lawyerId, Long orderId) throws Exception {

    }

    @Override
    public void revokeOrder(Long lawyerId, Long orderId) throws Exception {

    }

    @Override
    public void invalidOrder(Long lawyerId, Long orderId) throws Exception {

    }

}
