package com.faxintong.iruyi.controller.pay;

import com.faxintong.iruyi.model.mybatis.pay.PaymentRecord;
import com.faxintong.iruyi.service.pay.PaymentService;
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
import javax.validation.Valid;
import java.util.Map;

import static com.faxintong.iruyi.utils.Constants.*;

/**
 * Created by ron on 2015/1/14.
 */
@RestController
@RequestMapping("pay")
public class PaymentController {
    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = "record")
    public Map<String, Object> paymentRecords(@Valid PaymentRecord paymentRecord, BindingResult bindingResult,
                                              HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        if(bindingResult.hasErrors()){
            result.put(ERR_MSG, bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        try {
            paymentService.paymentRecords(paymentRecord);
            result.put(RESULT, true);
            result.put(ERR_MSG, "创建支付记录接口成功");
        }catch (Exception e){
            result.put(ERR_MSG, "创建支付记录接口失败");
            logger.error("创建支付记录接口失败:" + e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "find")
    public Map<String, Object> findPayRecordByOrderId(@NotBlank Long orderId, BindingResult bindingResult,
                                                      HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        if (bindingResult.hasErrors()){
            result.put(ERR_MSG, bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        try {
            paymentService.findPayRecordByOrderId(orderId);
            result.put(RESULT, true);
            result.put(ERR_MSG, "查询支付记录成功");
        }catch (Exception e){
            result.put(ERR_MSG, "查询支付记录失败");
            logger.error("查询支付记录失败:" + e.getMessage());
        }
        return result;
    }

}
