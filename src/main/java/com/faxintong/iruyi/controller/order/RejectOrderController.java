package com.faxintong.iruyi.controller.order;

import com.faxintong.iruyi.controller.BaseController;
import com.faxintong.iruyi.model.general.order.GeneralOrder;
import com.faxintong.iruyi.model.mybatis.order.Order;
import com.faxintong.iruyi.service.order.reject.RejectService;
import com.faxintong.iruyi.utils.ValidateUtil;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static com.faxintong.iruyi.utils.Constants.DATA;
import static com.faxintong.iruyi.utils.Constants.ERR_MSG;
import static com.faxintong.iruyi.utils.Constants.RESULT;

/**
 * Created by hehj on 15-2-7.
 */
@RestController
@RequestMapping("rejectOrder")
public class RejectOrderController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(RejectOrderController.class);

    @Autowired
    private RejectService rejectService;

    @RequestMapping(value = "buildOrder")
    public Map<String, Object> buildOrder(HttpServletRequest request, GeneralOrder generalOrder) {
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        if(ValidateUtil.validateGeneralOrder(generalOrder, result)){
            generalOrder.setLawyerId(getLawyerId(request));
            try {
                rejectService.buildOrder(generalOrder);
                result.put(RESULT, true);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                result.put(ERR_MSG, "未知错误");
            }
        }
        return result;
    }

    @RequestMapping(value = "orderInfo")
    public Map<String, Object> orderInfo(HttpServletRequest request, String orderId) {
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        if(StringUtils.isEmpty(orderId)){
            result.put(ERR_MSG, "单子id为空");
            return result;
        }
        try {
            Order order = rejectService.findOrderById(Long.parseLong(orderId.toString()));
            result.put(RESULT, true);
            result.put(DATA, order);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.put(ERR_MSG, "未知错误");
        }
        return result;
    }
}
