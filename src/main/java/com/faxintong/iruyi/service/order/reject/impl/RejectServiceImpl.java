package com.faxintong.iruyi.service.order.reject.impl;

import com.faxintong.iruyi.dao.mybatis.lawyer.LawyerMapper;
import com.faxintong.iruyi.dao.mybatis.order.OrderMapper;
import com.faxintong.iruyi.dao.mybatis.order.ReceiveOrderMapper;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.order.Order;
import com.faxintong.iruyi.model.mybatis.order.OrderExample;
import com.faxintong.iruyi.model.mybatis.order.ReceiveOrder;
import com.faxintong.iruyi.model.mybatis.order.ReceiveOrderExample;
import com.faxintong.iruyi.service.order.reject.RejectService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hehj on 15-1-3.
 */
@Service
public class RejectServiceImpl implements RejectService {
    private OrderMapper orderMapper;
    private ReceiveOrderMapper receiveOrderMapper;
    private LawyerMapper lawyerMapper;

    private final Integer orderConfirmStatus=2;
    private final Integer receiveOrderConfirmStatus=2;
    private final Integer receiveOrderRejectStatus=3;
    @Override
    public List<Order> findRejectOrders(Long lawyerId) throws Exception {
        OrderExample example = new OrderExample();
        example.createCriteria().andLawyerIdEqualTo(lawyerId);
        List<Order> orderList = orderMapper.selectByExample(example);
        return orderList;
    }

    @Override
    public Order findOrderById(Long orderId) throws Exception {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        return order;
    }

    @Override
    public List<Lawyer> findReceiveOrderLawyerByOrderId(Long orderId) throws Exception {
        ReceiveOrderExample example = new ReceiveOrderExample();
        example.createCriteria().andOrderIdEqualTo(orderId);
        List<ReceiveOrder> receiveOrderList = receiveOrderMapper.selectByExample(example);
        List<Lawyer> lawyerList = new ArrayList<Lawyer>();
        for(ReceiveOrder receiveOrder : receiveOrderList){
            Long lawyerID = receiveOrder.getLawyerId();
            Lawyer lawyer = lawyerMapper.selectByPrimaryKey(lawyerID);
            lawyerList.add(lawyer);
        }
        return lawyerList;
    }

    @Override
    public void ChooseOneBestLawyer(Long orderId, Long lawyerId) throws Exception {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        order.setStatus(orderConfirmStatus);
        ReceiveOrderExample example = new ReceiveOrderExample();
        example.createCriteria().andOrderIdEqualTo(orderId);
        List<ReceiveOrder> receiveOrderList = receiveOrderMapper.selectByExample(example);
        for(ReceiveOrder receiveOrder : receiveOrderList){
            if (receiveOrder.getLawyerId()==lawyerId){
                receiveOrder.setStatus(receiveOrderConfirmStatus);
            } else {
                receiveOrder.setStatus(receiveOrderRejectStatus);
            }
        }

    }

    @Override
    public List<Order> findOrdersByStatus(Long lawyerId, Integer status) throws Exception {
        OrderExample example = new OrderExample();
        example.createCriteria().andLawyerIdEqualTo(lawyerId).andStatusEqualTo(status);
        List<Order> orderList = orderMapper.selectByExample(example);
        return orderList;
    }

    @Override
    public  void buildOrder(Long lawyerId, Order order) throws Exception{
        orderMapper.insertSelective(order);
    }

}
