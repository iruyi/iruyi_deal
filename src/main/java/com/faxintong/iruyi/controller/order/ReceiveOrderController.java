package com.faxintong.iruyi.controller.order;

import com.faxintong.iruyi.model.mybatis.order.Order;
import com.faxintong.iruyi.service.order.receive.ReceiveService;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

import static com.faxintong.iruyi.utils.Constants.DATA;
import static com.faxintong.iruyi.utils.Constants.ERR_MSG;
import static com.faxintong.iruyi.utils.Constants.RESULT;

/**
 * Created by hehj on 15-1-15.
 */
@RestController
@RequestMapping("receiveOrder")
public class ReceiveOrderController {

    private Logger logger = LoggerFactory.getLogger(ReceiveOrderController.class);

    @Autowired
    private ReceiveService receiveService;

    @RequestMapping(value = "availReceiveOrders")
    public Map<String, Object> availReceiveOrders(HttpServletRequest request, String lawyerId) {
        logger.info("lawyerId=" + lawyerId);
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        try{
            if(StringUtils.isEmpty(lawyerId)){
                result.put(ERR_MSG, "律师id为空");
                return result;
            }
            List<Order> orderList = receiveService.findAvailReceiveOrders(Long.parseLong(lawyerId));
            result.put(RESULT, true);
            result.put(DATA, orderList);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            result.put(ERR_MSG, "未知异常");
        }
        return result;
    }

    @RequestMapping(value = "receiveOrder")
    public Map<String, Object> receiveOrder(HttpServletRequest request, String orderId, String lawyerId) {
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        try{
            if(StringUtils.isEmpty(orderId)){
                result.put(ERR_MSG, "单子id为空");
                return result;
            }
            if(StringUtils.isEmpty(lawyerId)){
                result.put(ERR_MSG, "律师id为空");
                return result;
            }
            receiveService.receiveOrder(Long.parseLong(orderId), Long.parseLong(lawyerId));
            result.put(RESULT, true);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            result.put(ERR_MSG, "接单出现未知异常");
        }
        return result;
    }

    @RequestMapping(value = "findReceivingOrders")
    public Map<String, Object> findReceivingOrders(HttpServletRequest request, String lawyerId) {
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        try{
            if(StringUtils.isEmpty(lawyerId)){
                result.put(ERR_MSG, "律师id为空");
                return result;
            }
            List<Order> orderList = receiveService.findReceivingOrders(Long.parseLong(lawyerId));
            result.put(RESULT, true);
            result.put(DATA, orderList);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            result.put(ERR_MSG, "未知异常");
        }
        return result;
    }

    @RequestMapping(value = "findOrdersByStatus")
    public Map<String, Object> findOrdersByStatus(HttpServletRequest request, String lawyerId, String status) {
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        try{
            if(StringUtils.isEmpty(lawyerId)){
                result.put(ERR_MSG, "律师id为空");
                return result;
            }
            if(StringUtils.isEmpty(status)){
                result.put(ERR_MSG, "状态为空");
                return result;
            }
            List<Order> orderList = receiveService.findOrdersByStatus(Long.parseLong(lawyerId), Integer.parseInt(status));
            result.put(RESULT, true);
            result.put(DATA, orderList);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            result.put(ERR_MSG, "未知异常");
        }
        return result;
    }

    @RequestMapping(value = "confirmOrder")
    public Map<String, Object> confirmOrder(HttpServletRequest request, String orderId, String lawyerId) {
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        try{
            if(StringUtils.isEmpty(orderId)){
                result.put(ERR_MSG, "单子id为空");
                return result;
            }
            if(StringUtils.isEmpty(lawyerId)){
                result.put(ERR_MSG, "律师id为空");
                return result;
            }
            receiveService.confirmOrder(Long.parseLong(orderId), Long.parseLong(lawyerId));
            result.put(RESULT, true);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            result.put(ERR_MSG, "未知异常");
        }
        return result;
    }

    @RequestMapping(value = "revokeOrder")
    public Map<String, Object> revokeOrder(HttpServletRequest request, String orderId, String lawyerId) {
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        try{
            if(StringUtils.isEmpty(orderId)){
                result.put(ERR_MSG, "单子id为空");
                return result;
            }
            if(StringUtils.isEmpty(lawyerId)){
                result.put(ERR_MSG, "律师id为空");
                return result;
            }
            receiveService.revokeOrder(Long.parseLong(orderId), Long.parseLong(lawyerId));
            result.put(RESULT, true);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            result.put(ERR_MSG, "未知异常");
        }
        return result;
    }

    @RequestMapping(value = "cancelOrder")
    public Map<String, Object> cancelOrder(HttpServletRequest request, String orderId, String lawyerId) {
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        try{
            if(StringUtils.isEmpty(orderId)){
                result.put(ERR_MSG, "单子id为空");
                return result;
            }
            if(StringUtils.isEmpty(lawyerId)){
                result.put(ERR_MSG, "律师id为空");
                return result;
            }
            receiveService.cancelOrder(Long.parseLong(orderId), Long.parseLong(lawyerId));
            result.put(RESULT, true);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            result.put(ERR_MSG, "未知异常");
        }
        return result;
    }
}
