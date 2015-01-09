package com.faxintong.iruyi.service.order.receive;

import com.faxintong.iruyi.model.mybatis.order.Order;

import java.util.List;

/**
 * Created by hehj on 15-1-3.
 */
public interface ReceiveService {

    /**
     * 查询可接单子
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public List<Order> findAvailableOrders(Long lawyerId) throws Exception;

    /**
     * 查询已接但还未审核单子
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public List<Order> findReceivingOrders(Long lawyerId) throws Exception;

    /**
     * 查询接单成功/失败的单子列表
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public List<Order> findFinalOrders(Long lawyerId) throws Exception;

    /**
     * 律师接单
     * @param lawyerId
     * @param orderId
     * @throws Exception
     */
    public void receiveOrder(Long lawyerId,Long orderId) throws Exception;

    /**
     * 接单人确认接单
     * @param lawyerId
     * @param orderId
     * @throws Exception
     */
    public void confirmOrder(Long lawyerId,Long orderId) throws Exception;

    /**
     * 接单人再确认单子时撤销单子
     * @param lawyerId
     * @param orderId
     * @throws Exception
     */
    public void revokeOrder(Long lawyerId,Long orderId) throws Exception;

    /**
     * 接单人接单成功后作废单子
     * @param lawyerId
     * @param orderId
     * @throws Exception
     */
    public void invalidOrder(Long lawyerId,Long orderId) throws Exception;


}