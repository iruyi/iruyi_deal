package com.faxintong.iruyi.service.order.impl;

import com.faxintong.iruyi.dao.general.LawyerGeneralMapper;
import com.faxintong.iruyi.dao.general.OrderGeneralMapper;
import com.faxintong.iruyi.dao.mybatis.order.OrderMapper;
import com.faxintong.iruyi.model.mybatis.order.Order;
import com.faxintong.iruyi.model.mybatis.vo.OrderVo;
import com.faxintong.iruyi.service.order.OrderService;
import com.faxintong.iruyi.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 15-4-18.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderGeneralMapper orderGeneralMapper;
    @Autowired
    LawyerGeneralMapper lawyerGeneralMapper;
    @Override
    @Transactional
    public void reportOrder(Order order) throws Exception {
        orderGeneralMapper.insertOrder(order);
    }

    @Override
    public List<OrderVo> getOrderList(Pager pager,Long lawyerId) throws Exception {
        return orderGeneralMapper.selectOrderVo(pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()),pager.getPageSize(),lawyerId);
    }

    @Override
    public OrderVo orderDetail(Long orderId,Long lawyerId) throws Exception {
        OrderVo vo = new OrderVo();
        int fansNum =lawyerGeneralMapper.countFansByLawyerId(lawyerId);
        int issueNum =orderGeneralMapper.countIssueByLawyerId(lawyerId);
        int interestCount = orderGeneralMapper.countIssueOfmyInterest(lawyerId);
        vo.setFansCount(fansNum);
        vo.setIssueCount(issueNum);
        vo.setInterestCount(interestCount);
        return vo;
    }

    @Override
    public void orderInterest(Long orderId, Long lawyerId) throws Exception {
        orderGeneralMapper.insertOrderReceive(orderId,lawyerId);
    }

    @Override
    @Transactional
    public void orderComment(Long orderId, String content, Long lawyerId) throws Exception {
        orderGeneralMapper.updateOrderReceive(orderId,content,lawyerId);
    }
}
