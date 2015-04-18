package com.faxintong.iruyi.controller.order;

import com.faxintong.iruyi.model.general.order.GeneralOrder;
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
 * Created by hehongju on 2015/2/11.
 */
@RestController
@RequestMapping("order")
public class OrderController {

    private Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private RejectService rejectService;

    @RequestMapping(value = "orderDetail")
    public Map<String, Object> orderInfo(HttpServletRequest request, String orderId) {
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        if(StringUtils.isEmpty(orderId)){
            result.put(ERR_MSG, "单子id为空");
            return result;
        }
        try {
            List<GeneralOrder> generalOrders = rejectService.findOrderById(Long.parseLong(orderId.toString()));
            result.put(RESULT, true);
            result.put(DATA, generalOrders);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.put(ERR_MSG, "未知错误");
        }
        return result;
    }

    /**
     * 发单
     * @param request
     * @param orderId
     * @return
     */
    @RequestMapping(value = "buildOrder")
    public Map<String, Object> buildOrder(HttpServletRequest request, String orderId) {
        Map<String, Object> result = Maps.newHashMap();

        return result;
    }

    /**
     * 获取单子详情
     * @param request
     * @param orderId
     * @return
     */
    @RequestMapping(value = "orderDetail")
    public Map<String, Object> orderDetail(HttpServletRequest request, String orderId) {
        Map<String, Object> result = Maps.newHashMap();

        return result;
    }
}
