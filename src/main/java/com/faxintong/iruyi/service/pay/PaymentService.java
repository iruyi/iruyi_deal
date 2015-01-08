package com.faxintong.iruyi.service.pay;

import com.faxintong.iruyi.model.mybatis.pay.PayRecord;

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
    public void paymentRecords(PayRecord payRecords) throws Exception;

    /**
     * 查询支付记录
     * @param orderId
     * @return
     * @throws Exception
     */
    public List<PayRecord> findPayRecordByOrderId(Long orderId) throws Exception;


}
