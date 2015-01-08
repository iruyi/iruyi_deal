package com.faxintong.iruyi.service.price;

import com.faxintong.iruyi.model.mybatis.price.ReceivePriceRule;
import com.faxintong.iruyi.model.mybatis.price.RejectPriceRule;
import com.faxintong.iruyi.model.mybatis.price.ReportPrice;

import java.util.List;

/**
 * Created by hehj on 15-1-3.
 */
public interface PriceService {

    /**
     * 甩单律师创建报价规则
     * @param reprotPrice
     * @throws Exception
     */
    public void rejectReportPrice(List<RejectPriceRule> reprotPrice) throws Exception;

    /**
     * 接单律师创建报价规则
     * @param reportPrice
     * @throws Exception
     */
    public void receiveReportPrice(List<ReceivePriceRule> reportPrice) throws Exception;

    /**
     * 甩单律师查询报价规则
     * @param orderId
     * @return
     * @throws Exception
     */
    public List<RejectPriceRule> findRejectReportPrice(Long orderId) throws Exception;

    /**
     * 接单律师查询报价规则
     * @param lawyerId
     * @param orderId
     * @return
     * @throws Exception
     */
    public List<ReceivePriceRule> findReceiveReportPrice(Long lawyerId,Long orderId)throws Exception;

    /**
     * 计算甩/接单律师报价金额
     * @param lawyerId
     * @param orderId
     * @param lawyerType
     * @throws Exception
     */
    public void calculateRejectPrice(Long lawyerId,Long orderId,Integer lawyerType) throws Exception;

    /**
     * 查询报价金额
     * @param orderId
     * @return
     * @throws Exception
     */
    public ReportPrice findReportPriceByOrderId(Long orderId) throws Exception;
}
