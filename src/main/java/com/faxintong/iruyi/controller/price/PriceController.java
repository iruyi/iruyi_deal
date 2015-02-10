package com.faxintong.iruyi.controller.price;

import com.faxintong.iruyi.controller.BaseController;
import com.faxintong.iruyi.model.mybatis.price.ReceiveOrderPrice;
import com.faxintong.iruyi.model.mybatis.price.RejectOrderPrice;
import com.faxintong.iruyi.service.price.PriceService;
import com.google.common.collect.Maps;
import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

import static com.faxintong.iruyi.utils.Constants.ERR_MSG;
import static com.faxintong.iruyi.utils.Constants.RESULT;

/**
 * Created by ron on 2015/1/14.
 */
@RestController
@RequestMapping("price")
public class PriceController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(PriceController.class);

    @Autowired
    private PriceService priceService;

    @RequestMapping(value = "reject/report")
    public Map<String, Object> rejectReportPrice(List<RejectOrderPrice> reportPrice,
                                                 HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        try {
            Long lawyerId = getLawyerId(request);
            priceService.rejectReportPrice(lawyerId, reportPrice);
            result.put(RESULT, true);
            result.put(ERR_MSG, "甩单律师创建报价规则成功");
        }catch (Exception e){
            e.printStackTrace();
            result.put(ERR_MSG, "甩单律师创建报价规则失败");
            logger.error("甩单律师创建报价规则失败" + e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "receive/report")
    public Map<String, Object> receiveReportPrice(List<ReceiveOrderPrice> reportPrice,
                                                  HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        try {
            priceService.receiveReportPrice(reportPrice);
            result.put(RESULT, true);
            result.put(ERR_MSG, "接单律师创建报价规则成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("接单律师创建报价规则失败" + e.getMessage());
            result.put(ERR_MSG, "接单律师创建报价规则失败");
        }
        return result;
    }

    @RequestMapping(value = "find/reject")
    public Map<String, Object> findRejectReportPrice(Long orderId,
                                                     HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);

        if(orderId == null){
            result.put(ERR_MSG, "订单ID不能为空");
            return result;
        }

        try {
            priceService.findRejectReportPrice(orderId);
            result.put(RESULT, true);
            result.put(ERR_MSG, "查询甩单律师报价规则成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("查询甩单律师报价规则失败:" + e.getMessage());
            result.put(ERR_MSG, "查询甩单律师报价规则失败");
        }
        return result;
    }

    @RequestMapping(value = "find/receive")
    public Map<String, Object> findReceiveReportPrice(Long orderId,
                                                      HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);

        if(orderId == null){
            result.put(ERR_MSG, "订单ID不能为空");
            return result;
        }

        try {
            priceService.findRejectReportPrice(orderId);
            result.put(ERR_MSG, "查询接单律师报价规则成功");
            result.put(RESULT, true);
        }catch (Exception e){
            e.printStackTrace();
            result.put(ERR_MSG, "查询接单律师报价规则失败");
            logger.error("查询接单律师报价规则:" + e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "calculate/reject")
    public Map<String, Object> calculateRejectPrice(Long lawyerId, Long orderId, Integer lawyerType,
                                                    HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);

        if(lawyerId == null){
            result.put(ERR_MSG, "律师id不能为空");
            return result;
        }

        if(orderId == null){
            result.put(ERR_MSG, "订单ID不能为空");
            return result;
        }

        if(lawyerType == null){
            result.put(ERR_MSG, "类型不能为空");
            return result;
        }

        try {

        }catch (Exception e){
            e.printStackTrace();
            result.put(ERR_MSG, "计算报价出错");
            logger.error("计算报价出错：" + e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "find/byId")
    public Map<String, Object> findReportPriceByOrderId(Long orderId,
                                                        HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);

        try {

        }catch (Exception e){

        }
        return result;
    }
}
