package com.faxintong.iruyi.controller.pay;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.faxintong.iruyi.utils.Constants.*;

/**
 * Created by ron on 2015/1/14.
 */
@RestController(value = "pay")
public class PaymentController {
    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @RequestMapping(value = "record")
    public Map<String, Object> paymentRecords(){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        try {

        }catch (Exception e){

        }
        return result;
    }

    @RequestMapping(value = "find")
    public Map<String, Object> findPayRecordByOrderId(){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        try {

        }catch (Exception e){

        }
        return result;
    }

}
