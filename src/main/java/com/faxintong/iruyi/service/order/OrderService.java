package com.faxintong.iruyi.service.order;

import com.faxintong.iruyi.model.mybatis.order.Order;
import com.faxintong.iruyi.utils.Pager;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 15-4-18.
 */
public interface OrderService {

    /**
     * 发布商机
     * @param order
     * @return
     */
    public void reportOrder(Order order) throws Exception;

    /**
     * 获取单子列表(未在黑名单里)
     * @param pager
     * @param lawyer
     * @return
     * @throws Exception
     */
    public List<Order> getOrderList(Pager pager, Long lawyer) throws Exception;

    /**
     * 获取单子详情
     * @param orderId
     * @return
     * @throws Exception
     */
    public Order orderDetail(Long orderId) throws Exception;

    /**
     * 单子感兴趣
     * @param orderId
     * @param lawyerId
     * @throws Exception
     */
    public void orderInterest(Long orderId, Long lawyerId) throws  Exception;

    /**
     * 单子留言
     * @param orderId
     * @param content
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public Map<String, Object> orderComment(Long orderId, String content, Long lawyerId) throws Exception;

}
