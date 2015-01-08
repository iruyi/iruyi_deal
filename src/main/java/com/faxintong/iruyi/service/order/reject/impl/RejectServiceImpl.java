package com.faxintong.iruyi.service.order.reject.impl;

import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.order.Order;
import com.faxintong.iruyi.service.order.reject.RejectService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hehj on 15-1-3.
 */
@Service
public class RejectServiceImpl implements RejectService {
    @Override
    public List<Order> findRejectOrders(Long lawyerId) throws Exception {
        return null;
    }

    @Override
    public Order findOrderById(Long orderId) throws Exception {
        return null;
    }

    @Override
    public List<Lawyer> findReceiveOrderLawyerByOrderId(Long orderId) throws Exception {
        return null;
    }

    @Override
    public void ChooseOneBestLawyer(Long orderId, Long lawyerId) throws Exception {

    }

    @Override
    public List<Order> findOrdersByStatus(Long lawyerId, Integer status) throws Exception {
        return null;
    }

}
