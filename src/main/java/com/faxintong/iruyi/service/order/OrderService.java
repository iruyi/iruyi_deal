package com.faxintong.iruyi.service.order;

import com.faxintong.iruyi.model.mybatis.vo.OrderVo;
import com.faxintong.iruyi.utils.Pager;

import java.util.List;

/**
 * Created by admin on 15-4-18.
 */
public interface OrderService {
    /**
     * 发布商机
     * @param order
     * @return
     */
    public void reportOrder(OrderVo order) throws Exception;

    /**
     * 获取单子列表(未在黑名单里)
     * @param pager
     * @return
     * @throws Exception
     */
    public List<OrderVo> getOrderList(Pager pager,Long lawyerId) throws Exception;

    /**
     * 搜索商机
     * @param pager
     * @param title
     * @param content
     * @return
     * @throws Exception
     */
    public List<OrderVo> searchOrders(Pager pager,Long lawyerId, String title, String content) throws Exception;


    /**
     * 获取单子详情
     * @param orderId
     * @return
     * @throws Exception
     */
    public OrderVo orderDetail(Long orderId,Long lawyerId) throws Exception;

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
    public void orderComment(Long orderId, String content, Long lawyerId) throws Exception;

}
