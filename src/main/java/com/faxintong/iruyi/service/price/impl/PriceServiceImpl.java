package com.faxintong.iruyi.service.price.impl;

import com.faxintong.iruyi.dao.mybatis.price.ReceiveOrderPriceMapper;
import com.faxintong.iruyi.dao.mybatis.price.RejectOrderPriceMapper;
import com.faxintong.iruyi.model.mybatis.order.ReceiveOrderExample;
import com.faxintong.iruyi.model.mybatis.price.*;
import com.faxintong.iruyi.service.price.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 15-1-3.
 */
@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private RejectOrderPriceMapper rejectOrderPriceMapper;
    @Autowired
    private ReceiveOrderPriceMapper receiveOrderPriceMapper;

    @Override
    public void rejectReportPrice(List<RejectOrderPrice> reportPrice) throws Exception {
        for(RejectOrderPrice r: reportPrice){
            rejectOrderPriceMapper.insertSelective(r);
        }
    }

    @Override
    public void receiveReportPrice(List<ReceiveOrderPrice> reportPrice) throws Exception {
        for(ReceiveOrderPrice r: reportPrice){
            receiveOrderPriceMapper.insertSelective(r);
        }
    }

    @Override
    public List<RejectOrderPrice> findRejectReportPrice(Long orderId) throws Exception {
        RejectOrderPriceExample rejectOrderPriceExample = new RejectOrderPriceExample();
        rejectOrderPriceExample.createCriteria().andIdEqualTo(orderId);
        return rejectOrderPriceMapper.selectByExample(rejectOrderPriceExample);
    }

    @Override
    public List<ReceiveOrderPrice> findReceiveReportPrice(Long lawyerId, Long orderId) throws Exception {
        ReceiveOrderPriceExample receiveOrderPriceExample = new ReceiveOrderPriceExample();
        receiveOrderPriceExample.createCriteria().andLawyerIdEqualTo(lawyerId).andOrderIdEqualTo(orderId);
        return receiveOrderPriceMapper.selectByExample(receiveOrderPriceExample);
    }

    @Override
    public void calculateRejectPrice(Long lawyerId, Long orderId, Integer lawyerType) throws Exception {

    }

    @Override
    public Price findReportPriceByOrderId(Long orderId) throws Exception {
        return null;
    }
}
