package com.faxintong.iruyi.service.price.impl;

import com.faxintong.iruyi.model.mybatis.price.Price;
import com.faxintong.iruyi.model.mybatis.price.ReceiveOrderPrice;
import com.faxintong.iruyi.model.mybatis.price.RejectOrderPrice;
import com.faxintong.iruyi.service.price.PriceService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 15-1-3.
 */
@Service
public class PriceServiceImpl implements PriceService {
    @Override
    public void rejectReportPrice(List<RejectOrderPrice> reprotPrice) throws Exception {

    }

    @Override
    public void receiveReportPrice(List<ReceiveOrderPrice> reportPrice) throws Exception {

    }

    @Override
    public List<RejectOrderPrice> findRejectReportPrice(Long orderId) throws Exception {
        return null;
    }

    @Override
    public List<ReceiveOrderPrice> findReceiveReportPrice(Long lawyerId, Long orderId) throws Exception {
        return null;
    }

    @Override
    public void calculateRejectPrice(Long lawyerId, Long orderId, Integer lawyerType) throws Exception {

    }

    @Override
    public Price findReportPriceByOrderId(Long orderId) throws Exception {
        return null;
    }
}
