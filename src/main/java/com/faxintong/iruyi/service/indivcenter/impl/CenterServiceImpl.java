package com.faxintong.iruyi.service.indivcenter.impl;

import com.faxintong.iruyi.dao.mybatis.lawyer.LawyerMapper;
import com.faxintong.iruyi.dao.mybatis.order.OrderMapper;
import com.faxintong.iruyi.dao.mybatis.order.ReceiveOrderMapper;
import com.faxintong.iruyi.dao.mybatis.pay.PaymentRecordMapper;
import com.faxintong.iruyi.model.general.Statistic;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.lawyer.LawyerExample;
import com.faxintong.iruyi.model.mybatis.order.Order;
import com.faxintong.iruyi.model.mybatis.order.OrderExample;
import com.faxintong.iruyi.model.mybatis.order.ReceiveOrder;
import com.faxintong.iruyi.model.mybatis.order.ReceiveOrderExample;
import com.faxintong.iruyi.model.mybatis.pay.PaymentRecord;
import com.faxintong.iruyi.model.mybatis.pay.PaymentRecordExample;
import com.faxintong.iruyi.service.indivcenter.CenterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by hehj on 15-1-3.
 */
@Service
public class CenterServiceImpl implements CenterService {

    private Logger logger = LoggerFactory.getLogger(CenterServiceImpl.class);

    @Autowired
    private LawyerMapper lawyerMapper;

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ReceiveOrderMapper receiveOrderMapper;
    @Autowired
    private PaymentRecordMapper payRecordMapper;

    private Long lawyerID;
    private static final Integer receiveSuccessStatus=4;
    private static final Integer sendSuccessStatus=4;
    private static final Integer receiveDoneStatus=7;
    private static final Integer sendDoneStatus=7;

    @Override
    public Lawyer findLawyerById(Long lawyerId) throws Exception {
        logger.info("律师id为" + lawyerId);
        return lawyerMapper.selectByPrimaryKey(lawyerId);
    }

    @Override
    public Lawyer findLawyerStatistic(Long orderId) throws Exception {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        LawyerExample example = new LawyerExample();
        example.createCriteria().andIdEqualTo(order.getLawyerId());
        List<Lawyer> lawyers = lawyerMapper.selectByExample(example);
        if(lawyers != null && lawyers.size() > 0){
            return lawyers.get(0);
        }
        return null;
    }

    @Override
    public void modifyLawyer(Lawyer lawyer) throws Exception {
        logger.info("修改律师信息为：" + lawyer.toString());
        lawyerMapper.updateByPrimaryKeySelective(lawyer);
    }

    @Override
    public void modifyLawyerVersion(Lawyer lawyer) throws Exception {

    }

    @Override
    public Statistic lawyerStatistic(Long lawyerId) throws Exception {
        this.lawyerID=lawyerId;
        Statistic statistic = new Statistic();
        figureInvalidOrderCount(statistic);
        figureReceiveOrderCount(statistic);
        figureReceiveSuccessConut(statistic);
        figureReceiveSuccessRate(statistic);
        figureRecevieOrderTLECount(statistic);
        figureRecevieDealAmount(statistic);
        figureSendOrderCount(statistic);
        figureSendOrderTLECount(statistic);
        figureSendSuccessCount(statistic);
        figureSendSuccessRate(statistic);
        figureSendDealAmount(statistic);
        return statistic;
    }


    public void figureReceiveOrderCount(Statistic statistic) throws Exception{
        ReceiveOrderExample example= new ReceiveOrderExample();
        example.createCriteria().andLawyerIdEqualTo(lawyerID);
        statistic.setReceiveOrderCount( (long)receiveOrderMapper.countByExample(example) );
        return;
    }

    public void figureSendOrderCount(Statistic statistic) throws Exception{
        OrderExample example = new OrderExample();
        example.createCriteria().andLawyerIdEqualTo(lawyerID);
        statistic.setSendOrderCount( (long)orderMapper.countByExample(example) );
        return;
    }

    public void figureReceiveSuccessConut(Statistic statistic) throws Exception{
        long count=0;
        ReceiveOrderExample receiveOrderExample = new ReceiveOrderExample();
        List<ReceiveOrder> receiveOrderList;
        receiveOrderExample.createCriteria().andLawyerIdEqualTo(lawyerID);
        receiveOrderList=receiveOrderMapper.selectByExample(receiveOrderExample);
        for(ReceiveOrder receiveOrder : receiveOrderList){
            if (receiveOrder.getStatus() == receiveSuccessStatus){
                count++;
            }
        }
        statistic.setReceiveSuccessConut(count);
        return;
    }

    public void figureSendSuccessCount(Statistic statistic) throws Exception{
        long count=0;
        OrderExample orderExample = new OrderExample();
        List<Order> orderList;
        orderExample.createCriteria().andLawyerIdEqualTo(lawyerID);
        orderList = orderMapper.selectByExample(orderExample);
        for(Order order : orderList){
            if(order.getStatus()==sendSuccessStatus){
                count++;
            }
        }
        statistic.setSendSuccessCount(count);
        return;
    }

    public void figureRecevieOrderTLECount(Statistic statistic) throws Exception{

        return;
    }

    public void figureInvalidOrderCount(Statistic statistic) throws Exception{
        Long count = 0L;
        OrderExample orderExample = new OrderExample();
        List<Order> orderList;
        orderExample.createCriteria().andLawyerIdEqualTo(lawyerID);
        orderList = orderMapper.selectByExample(orderExample);
        for(Order order : orderList){
            if(order.getEndFlag()==1){
                count++;
            }
        }
        statistic.setInvalidOrderCount(count);
    }

    public void figureSendOrderTLECount(Statistic statistic) throws  Exception{
        Date now = new Date();
        Long count = 0L;
        OrderExample orderExample = new OrderExample();
        List<Order> orderList;
        orderExample.createCriteria().andLawyerIdEqualTo(lawyerID);
        orderList = orderMapper.selectByExample(orderExample);
        for(Order order : orderList){
            if(now.after(order.getDeadlineDate())){
                count++;
            }
        }
        statistic.setSendOrderTLECount(count);
        return ;
    }

    public void figureRecevieDealAmount(Statistic statistic) throws Exception{
        Double amount=0.0;
        ReceiveOrderExample receiveOrderExample = new ReceiveOrderExample();
        List<ReceiveOrder>  receiveOrderList;
        receiveOrderExample.createCriteria().andLawyerIdEqualTo(lawyerID).andStatusEqualTo(receiveDoneStatus);
        receiveOrderList=receiveOrderMapper.selectByExample(receiveOrderExample);
        for(ReceiveOrder receiveOrder : receiveOrderList){
            long orderID = receiveOrder.getOrderId();
            List<PaymentRecord> payRecordList;
            PaymentRecordExample payRecordExample = new PaymentRecordExample();
            payRecordExample.createCriteria().andOrderIdEqualTo(orderID);
            payRecordList=payRecordMapper.selectByExample(payRecordExample);
            for(PaymentRecord payRecord : payRecordList){
                amount+=payRecord.getFigure();
            }
        }
        statistic.setRecevieDealAmount(amount);
        return;
    }

    public void figureSendDealAmount(Statistic statistic) throws Exception{
        Double amount=0.0;
        OrderExample orderExample = new OrderExample();
        List<Order> orderList;
        orderExample.createCriteria().andLawyerIdEqualTo(lawyerID).andStatusEqualTo(sendDoneStatus);
        orderList=orderMapper.selectByExample(orderExample);
        for(Order order : orderList){
            List<PaymentRecord> payRecordList;
            PaymentRecordExample payRecordExample = new PaymentRecordExample();
            payRecordExample.createCriteria().andOrderIdEqualTo(order.getId());
            payRecordList=payRecordMapper.selectByExample(payRecordExample);
            for(PaymentRecord payRecord : payRecordList){
                amount+=payRecord.getFigure();
            }
        }
        statistic.setSendDealAmount( amount );
        return;
    }

    public void figureReceiveSuccessRate(Statistic statistic) throws Exception{
        statistic.setReceiveSuccessRate( statistic.getReceiveSuccessConut()*1.0/statistic.getReceiveOrderCount() );
        return;
    }

    public void figureSendSuccessRate(Statistic statistic) throws Exception{
        statistic.setSendSuccessRate( statistic.getSendSuccessCount()*1.0/statistic.getSendOrderCount() );
        return;
    }
}
