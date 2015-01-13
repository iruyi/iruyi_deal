package com.faxintong.iruyi.service.pay.impl;

import com.faxintong.iruyi.model.mybatis.pay.PaymentRecord;
import com.faxintong.iruyi.service.pay.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 15-1-3.
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public void paymentRecords(PaymentRecord payRecords) throws Exception {

    }

    @Override
    public List<PaymentRecord> findPayRecordByOrderId(Long orderId) throws Exception {
        return null;
    }
}
