package com.faxintong.iruyi.service.pay.impl;

import com.faxintong.iruyi.dao.mybatis.pay.PaymentRecordMapper;
import com.faxintong.iruyi.model.mybatis.pay.PaymentRecord;
import com.faxintong.iruyi.model.mybatis.pay.PaymentRecordExample;
import com.faxintong.iruyi.service.pay.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 15-1-3.
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRecordMapper paymentRecordMapper;

    @Override
    public void paymentRecords(PaymentRecord payRecords) throws Exception {
        paymentRecordMapper.insertSelective(payRecords);
    }

    @Override
    public List<PaymentRecord> findPayRecordByOrderId(Long orderId) throws Exception {
        PaymentRecordExample paymentRecordExample = new PaymentRecordExample();
        paymentRecordExample.createCriteria().andOrderIdEqualTo(orderId);
        return paymentRecordMapper.selectByExample(paymentRecordExample);
    }
}
