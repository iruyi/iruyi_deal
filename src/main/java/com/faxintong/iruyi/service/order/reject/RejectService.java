package com.faxintong.iruyi.service.order.reject;

import com.faxintong.iruyi.model.general.order.GeneralOrder;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.order.Order;

import java.util.List;

/**
 * Created by hehj on 15-1-3.
 */
public interface RejectService {

    /**
     * 查询律师甩出去单子列表
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public List<Order> findRejectOrders(Long lawyerId) throws Exception;

    /**
     * 查询单子详情
     * @param orderId
     * @return
     * @throws Exception
     */
    public Order findOrderById(Long orderId) throws Exception;

    /**
     * 查询甩出单子的接单人列表
     * @param orderId
     * @return
     * @throws Exception
     */
    public List<Lawyer> findReceiveOrderLawyerByOrderId(Long orderId) throws Exception;

    /**
     * 甩单人选择一位合适的接单人
     * @param orderId
     * @param lawyerId
     * @throws Exception
     */
    public void ChooseOneBestLawyer(Long orderId,Long lawyerId) throws Exception;

    /**
     * 根据状态获取单子
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public List<Order> findOrdersByStatus(Long lawyerId, Integer status) throws Exception;

    /**
     * 甩单
     * @param generalOrder
     * @throws Exception
     */
    public  void buildOrder(GeneralOrder generalOrder) throws Exception;
}
