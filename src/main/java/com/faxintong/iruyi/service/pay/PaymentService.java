package com.faxintong.iruyi.service.pay;

import com.faxintong.iruyi.model.mybatis.pay.PaymentRecord;

import java.util.List;

/**
 * Created by hehj on 15-1-3.
 */
public interface PaymentService {

    /**
     * 创建支付记录接口
     * @param payRecords
     * @throws Exception
     */
    public void paymentRecords(PaymentRecord payRecords) throws Exception;

    /**
     * 查询支付记录
     * @param orderId
     * @return
     * @throws Exception
     */
    public List<PaymentRecord> findPayRecordByOrderId(Long orderId) throws Exception;


}
