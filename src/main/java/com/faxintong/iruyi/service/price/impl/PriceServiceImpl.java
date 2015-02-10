package com.faxintong.iruyi.service.price.impl;

import com.faxintong.iruyi.dao.mybatis.price.PriceMapper;
import com.faxintong.iruyi.dao.mybatis.price.ReceiveOrderPriceMapper;
import com.faxintong.iruyi.dao.mybatis.price.RejectOrderPriceMapper;
import com.faxintong.iruyi.dao.mybatis.price.RejecterPriceMapper;
import com.faxintong.iruyi.model.mybatis.price.*;
import com.faxintong.iruyi.service.price.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.faxintong.iruyi.utils.Constants.*;

/**
 * Created by admin on 15-1-3.
 */
@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private RejectOrderPriceMapper rejectOrderPriceMapper;
    @Autowired
    private ReceiveOrderPriceMapper receiveOrderPriceMapper;
    @Autowired
    private PriceMapper priceMapper;
    @Autowired
    private RejecterPriceMapper rejecterPriceMapper;

    @Override
    public void rejectReportPrice(RejectOrderPrice reportPrice) throws Exception {
        /*Date date = new Date();
        for(RejectOrderPrice r: reportPrice){
            r.setCreateDate(date);
            r.setLawyerId(lawyerId);
            rejectOrderPriceMapper.insertSelective(r);
        }*/
        rejectOrderPriceMapper.insertSelective(reportPrice);
    }

    @Override
    public List<RejecterPrice> findRejecterPrice(Long lawyerId) throws Exception {
        RejecterPriceExample example = new RejecterPriceExample();
        example.createCriteria().andLawyerIdEqualTo(lawyerId);
        return rejecterPriceMapper.selectByExample(example);
    }


    @Override
    public void receiveReportPrice(List<ReceiveOrderPrice> reportPrice) throws Exception {
        Date date = new Date();
        for(ReceiveOrderPrice r: reportPrice){
            r.setCreateDate(date);
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
    public List<ReceiveOrderPrice> findReceiveReportPrice(Long orderId) throws Exception {
        ReceiveOrderPriceExample receiveOrderPriceExample = new ReceiveOrderPriceExample();
        receiveOrderPriceExample.createCriteria().andOrderIdEqualTo(orderId);
        return receiveOrderPriceMapper.selectByExample(receiveOrderPriceExample);
    }

    @Override
    public float calculateRejectPrice(Long lawyerId, Long orderId, Integer lawyerType) throws Exception {
        PriceExample priceExample = new PriceExample();
        priceExample.createCriteria().andLawyerIdEqualTo(lawyerId).andOrderIdEqualTo(orderId).andLawyerTypeEqualTo(lawyerType);
        List<Price> priceList = priceMapper.selectByExample(priceExample);
        if (priceList.size() != 1)
            return -1;
        Price price = priceList.get(0);

        if(lawyerType == ORDER_COOPERATIVE){
            return price.getPrice();
        }else if (lawyerType == ORDER_CASE){
            return price.getPrice();
        }
        return -1;
    }

    @Override
    public Price findReportPriceByOrderId(Long orderId) throws Exception {

        return null;
    }
}
