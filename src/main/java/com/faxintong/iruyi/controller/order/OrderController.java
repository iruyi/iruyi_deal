package com.faxintong.iruyi.controller.order;

import com.faxintong.iruyi.model.mybatis.order.Order;
import com.faxintong.iruyi.service.order.OrderService;
import com.faxintong.iruyi.utils.Pager;
import com.faxintong.iruyi.utils.Result;
import com.faxintong.iruyi.utils.ServletUtils;
import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by hehongju on 2015/2/11.
 */
@RestController
@RequestMapping("order")
public class OrderController {
    private Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private OrderService orderService;

    /**
     * 发布商机
     * @param order
     * @return
     *
     * @note
     *  发布商机
     *   必须登录
     *    需要参数 类型、标题、内容、城市、
     *
     *    //TODO 没有黑白名单表
     *       order 表 缺少city相关字段 已加
     *
     *       这个黑白名单的设计  跟商机列表怎么处理
     *       是不是没登陆的话 就能查看全部的 不含黑白名单的商机列表
     *        如果登录的话，不仅能查看全部的不含黑白名单的商机列表，而且能查看被指定的白名单列表
     *
     */
    @RequestMapping(value = "reportOrder")
    public String  reportOrder(Order order,HttpServletResponse response) {
        try {


            ServletUtils.responseJson(response, new Result(1, "发布商机成功！"));
            orderService.reportOrder(order);


        }catch (Exception e){
            logger.error("发布商机失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(0, "发布商机失败！"));
        }
        return null;
    }

    /**
     * 获取单子列表
     * @param pager
     * @return
     */
    @RequestMapping(value = "getOrderList")
    public Map<String, Object> getOrderList(Pager pager) {
        Map<String, Object> result = Maps.newHashMap();

        return result;
    }

    /**
     * 单子详情
     * @param orderId
     * @return
     */
    @RequestMapping(value = "orderDetail")
    public Map<String, Object> orderDetail(Long orderId) {
        Map<String, Object> result = Maps.newHashMap();

        return result;
    }

    /**
     * 单子感兴趣
     * @param orderId
     * @return
     */
    @RequestMapping(value = "orderInterest")
    public Map<String, Object> orderInterest(Long orderId) {
        Map<String, Object> result = Maps.newHashMap();

        return result;
    }

    /**
     * 单子留言
     * @param orderId
     * @param content
     * @return
     */
    @RequestMapping(value = "orderComment")
    public Map<String, Object> orderComment(Long orderId, String content) {
        Map<String, Object> result = Maps.newHashMap();

        return result;
    }


}
