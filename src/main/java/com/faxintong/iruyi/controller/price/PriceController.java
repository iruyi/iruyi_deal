package com.faxintong.iruyi.controller.price;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.faxintong.iruyi.utils.Constants.RESULT;

/**
 * Created by ron on 2015/1/14.
 */
@RestController
@RequestMapping("price")
public class PriceController {
    private static final Logger logger = LoggerFactory.getLogger(PriceController.class);

    @RequestMapping(value = "reject/report")
    public Map<String, Object> rejectReportPrice(){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        try {

        }catch (Exception e){

        }
        return result;
    }

    @RequestMapping(value = "receive/report")
    public Map<String, Object> receiveReportPrice(){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        try {

        }catch (Exception e){

        }
        return result;
    }

    @RequestMapping(value = "find/reject")
    public Map<String, Object> findRejectReportPrice(){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        try {

        }catch (Exception e){

        }
        return result;
    }

    @RequestMapping(value = "find/receive")
    public Map<String, Object> findReceiveReportPrice(Long lawyerId,Long orderId){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        try {

        }catch (Exception e){

        }
        return result;
    }

    @RequestMapping(value = "calculate/reject")
    public Map<String, Object> calculateRejectPrice(Long lawyerId,Long orderId,Integer lawyerType){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        try {

        }catch (Exception e){

        }
        return result;
    }

    @RequestMapping(value = "find/byId")
    public Map<String, Object> findReportPriceByOrderId(Long orderId){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        try {

        }catch (Exception e){

        }
        return result;
    }
}
