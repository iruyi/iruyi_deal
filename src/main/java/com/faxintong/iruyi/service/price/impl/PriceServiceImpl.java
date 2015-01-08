package com.faxintong.iruyi.service.price.impl;

import com.faxintong.iruyi.model.mybatis.price.ReceivePriceRule;
import com.faxintong.iruyi.model.mybatis.price.RejectPriceRule;
import com.faxintong.iruyi.model.mybatis.price.ReportPrice;
import com.faxintong.iruyi.service.price.PriceService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 15-1-3.
 */
@Service
public class PriceServiceImpl implements PriceService {
    @Override
    public void rejectReportPrice(List<RejectPriceRule> reprotPrice) throws Exception {

    }

    @Override
    public void receiveReportPrice(List<ReceivePriceRule> reportPrice) throws Exception {

    }

    @Override
    public List<RejectPriceRule> findRejectReportPrice(Long orderId) throws Exception {
        return null;
    }

    @Override
    public List<ReceivePriceRule> findReceiveReportPrice(Long lawyerId, Long orderId) throws Exception {
        return null;
    }

    @Override
    public void calculateRejectPrice(Long lawyerId, Long orderId, Integer lawyerType) throws Exception {

    }

    @Override
    public ReportPrice findReportPriceByOrderId(Long orderId) throws Exception {
        return null;
    }
}
