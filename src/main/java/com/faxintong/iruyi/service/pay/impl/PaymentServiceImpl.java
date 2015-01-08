package com.faxintong.iruyi.service.pay.impl;

import com.faxintong.iruyi.model.mybatis.pay.PayRecord;
import com.faxintong.iruyi.service.pay.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 15-1-3.
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public void paymentRecords(PayRecord payRecords) throws Exception {

    }

    @Override
    public List<PayRecord> findPayRecordByOrderId(Long orderId) throws Exception {
        return null;
    }
}
