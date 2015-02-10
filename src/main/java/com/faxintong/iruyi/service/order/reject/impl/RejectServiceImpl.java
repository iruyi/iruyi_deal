package com.faxintong.iruyi.service.order.reject.impl;

import com.faxintong.iruyi.dao.general.order.ReceiveGeneralMapper;
import com.faxintong.iruyi.dao.mybatis.lawyer.LawyerMapper;
import com.faxintong.iruyi.dao.mybatis.order.*;
import com.faxintong.iruyi.model.general.lawyer.ReceiveLawyer;
import com.faxintong.iruyi.model.general.order.GeneralOrder;
import com.faxintong.iruyi.model.mybatis.order.*;
import com.faxintong.iruyi.service.order.reject.RejectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.faxintong.iruyi.utils.Constants.*;

/**
 * Created by hehj on 15-1-3.
 */
@Service
public class RejectServiceImpl implements RejectService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ReceiveOrderMapper receiveOrderMapper;
    @Autowired
    private LawyerMapper lawyerMapper;
    @Autowired
    private OrderRuleMapper orderRuleMapper;
    @Autowired
    private WhitelistMapper whitelistMapper;
    @Autowired
    private BlacklistMapper blacklistMapper;
    @Autowired
    private ReceiveGeneralMapper receiveGeneralMapper;

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
    public List<ReceiveLawyer> findReceiveOrderLawyers(Long orderId) throws Exception {
        return receiveGeneralMapper.findReceiveOrderLawyers(orderId);
    }

    @Transactional
    public void chooseBestLawyer(Long orderId, Long lawyerId) throws Exception {
        receiveGeneralMapper.chooseBestLawyer(orderId, lawyerId, RECEIVED);
    }

    @Override
    public List<Order> findOrdersByStatus(Long lawyerId, Integer status) throws Exception {
        OrderExample example = new OrderExample();
        example.createCriteria().andLawyerIdEqualTo(lawyerId).andStatusEqualTo(status);
        List<Order> orderList = orderMapper.selectByExample(example);
        return orderList;
    }

    @Transactional
    public Integer buildOrder(GeneralOrder generalOrder) throws Exception{
        Integer ruleId = 0;//默认情况下没有规则（商务单）
        if(generalOrder.getType() != null && generalOrder.getType().intValue() != SHANGWU){
            OrderRuleExample orderRuleExample = new OrderRuleExample();
            orderRuleExample.createCriteria().andCategoryIdEqualTo(generalOrder.getCategoryId()).andCityIdEqualTo(generalOrder.getCityId());
            List<OrderRule> orderRuleList = orderRuleMapper.selectByExample(orderRuleExample);
            if(orderRuleList != null && orderRuleList.size() > 0){
                ruleId = Integer.parseInt(orderRuleList.get(0).getId().toString());
            }else{
                OrderRule orderRule = new OrderRule();
                orderRule.setRuleName(generalOrder.getTitle());
                orderRule.setCategoryId(generalOrder.getCategoryId());
                orderRule.setCityId(generalOrder.getCityId());
                orderRule.setCreateDate(new Date());
                orderRule.setDescription(generalOrder.getTitle());
                ruleId = orderRuleMapper.insertSelective(orderRule);
            }
        }

        if(ruleId == null){
            throw new Exception("ruleId is null");
        }

        Order order = new Order();
        order.setLawyerId(generalOrder.getLawyerId());
        order.setTitle(generalOrder.getTitle());
        order.setStatus(RECEIVING);
        order.setIsDelay(NO_DELAY);
        order.setRuleId(Long.parseLong(ruleId.toString()));
        order.setRosterType(generalOrder.getRosterType());
        order.setType(generalOrder.getType());
        order.setDescription(generalOrder.getDescription());
        order.setCreateDate(new Date());
        Integer orderId = orderMapper.insertSelective(order);

        if(generalOrder.getRosterType().intValue() == WHITE_LIST){
            if(orderId == null){
                throw new Exception("orderId is null");
            }
            if(generalOrder.getLawyerIds() != null && generalOrder.getLawyerIds().length > 0){
                List<Whitelist> list = new ArrayList<Whitelist>();
                for(Long lawyerId : generalOrder.getLawyerIds()){
                    Whitelist whitelist = new Whitelist();
                    whitelist.setLawyerId(lawyerId);
                    whitelist.setOrderId(Long.parseLong(orderId.toString()));
                    whitelistMapper.insertSelective(whitelist);
                }
            }
        }else if(generalOrder.getRosterType().intValue() == BLACK_LIST){
            if(orderId == null){
                throw new Exception("orderId is null");
            }
            if(generalOrder.getLawyerIds() != null && generalOrder.getLawyerIds().length > 0){
                List<Blacklist> list = new ArrayList<Blacklist>();
                for(Long lawyerId : generalOrder.getLawyerIds()){
                    Blacklist blacklist = new Blacklist();
                    blacklist.setLawyerId(lawyerId);
                    blacklist.setOrderId(Long.parseLong(orderId.toString()));
                    blacklistMapper.insertSelective(blacklist);
                }
            }
        }
        return orderId;
    }

}
