package com.faxintong.iruyi.controller.order;

import com.faxintong.iruyi.controller.BaseController;
import com.faxintong.iruyi.model.general.order.GeneralOrder;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.order.Order;
import com.faxintong.iruyi.service.indivcenter.CenterService;
import com.faxintong.iruyi.service.order.receive.ReceiveService;
import com.faxintong.iruyi.service.order.reject.RejectService;
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

import static com.faxintong.iruyi.utils.Constants.*;

/**
 * Created by hehj on 15-1-15.
 */
@RestController
@RequestMapping("receiveOrder")
public class ReceiveOrderController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(ReceiveOrderController.class);

    @Autowired
    private ReceiveService receiveService;
    @Autowired
    private RejectService rejectService;
    @Autowired
    private CenterService centerService;

    @RequestMapping(value = "availReceiveOrders")
    public Map<String, Object> availReceiveOrders(HttpServletRequest request) {
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        try{
            Long lawyerId = getLawyerId(request);
            List<GeneralOrder> orderList = receiveService.findAvailReceiveOrders(lawyerId);
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

    @RequestMapping(value = "findOrdersDetail")
    public Map<String, Object> findOrdersDetail(HttpServletRequest request, String orderId) {
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        try{
            if(StringUtils.isEmpty(orderId)){
                result.put(ERR_MSG, "单子id为空");
                return result;
            }
            //获取单子信息
            List<GeneralOrder> generalOrders = rejectService.findOrderById(Long.parseLong(orderId.toString()));
            //获取律师信息
            Lawyer lawyer = centerService.findLawyerStatistic(Long.parseLong(orderId.toString()));
            result.put(RESULT, true);
            result.put("order", generalOrders);
            result.put("lawyer", lawyer);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            result.put(ERR_MSG, "未知异常");
        }
        return result;
    }

    /**
     * 所有参与的接单（无论接单成功还是失败的）
     * @param request
     * @param lawyerId
     * @return
     */
    @RequestMapping(value = "findReceivedOrders")
    public Map<String, Object> findReceivedOrders(HttpServletRequest request, String lawyerId, String status) {
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        try{
            if(StringUtils.isEmpty(lawyerId)){
                result.put(ERR_MSG, "律师id为空");
                return result;
            }
            List<GeneralOrder> generalOrders = null;
            if(StringUtils.isEmpty(status)){
                generalOrders = receiveService.findReceivedOrders(Long.parseLong(lawyerId));
            }else{
                generalOrders = receiveService.findOrdersByStatus(Long.parseLong(lawyerId), Integer.parseInt(status));
            }
            result.put(RESULT, true);
            result.put(DATA, generalOrders);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            result.put(ERR_MSG, "未知异常");
        }
        return result;
    }

    /**
     * 待定
     * @param request
     * @param lawyerId
     * @return
     */
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

    /**
     * 目前暂时不用
     * @param request
     * @param lawyerId
     * @param status
     * @return
     */
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
            List<GeneralOrder> generalOrders = receiveService.findOrdersByStatus(Long.parseLong(lawyerId), Integer.parseInt(status));
            result.put(RESULT, true);
            result.put(DATA, generalOrders);
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
