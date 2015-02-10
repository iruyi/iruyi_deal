package com.faxintong.iruyi.service.price;

import com.faxintong.iruyi.model.mybatis.price.Price;
import com.faxintong.iruyi.model.mybatis.price.ReceiveOrderPrice;
import com.faxintong.iruyi.model.mybatis.price.RejectOrderPrice;

import java.util.List;

/**
 * Created by hehj on 15-1-3.
 */
public interface PriceService {

    /**
     * 甩单律师创建报价规则
     * @param lawyerId
     * @param reportPrice
     * @throws Exception
     */
    public void rejectReportPrice(Long lawyerId, List<RejectOrderPrice> reportPrice) throws Exception;

    /**
     * 接单律师创建报价规则
     * @param lawyerId
     * @param reportPrice
     * @throws Exception
     */
    public void receiveReportPrice(Long lawyerId, List<ReceiveOrderPrice> reportPrice) throws Exception;

    /**
     * 甩单律师查询报价规则
     * @param orderId
     * @return
     * @throws Exception
     */
    public List<RejectOrderPrice> findRejectReportPrice(Long orderId) throws Exception;

    /**
     * 接单律师查询报价规则
     * @param lawyerId
     * @param orderId
     * @return
     * @throws Exception
     */
    public List<ReceiveOrderPrice> findReceiveReportPrice(Long lawyerId,Long orderId)throws Exception;

    /**
     * 计算甩/接单律师报价金额
     * @param lawyerId
     * @param orderId
     * @param lawyerType
     * @throws Exception
     */
    public float calculateRejectPrice(Long lawyerId,Long orderId,Integer lawyerType) throws Exception;

    /**
     * 查询报价金额
     * @param orderId
     * @return
     * @throws Exception
     */
    public Price findReportPriceByOrderId(Long orderId) throws Exception;
}
