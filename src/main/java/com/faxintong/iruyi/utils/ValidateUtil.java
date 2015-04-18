package com.faxintong.iruyi.utils;

import com.faxintong.iruyi.model.mybatis.price.RejectOrderPrice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static com.faxintong.iruyi.utils.Constants.ERR_MSG;

/**
 * Created by hehj on 15-2-7.
 */
public class ValidateUtil {

    Logger logger = LoggerFactory.getLogger(ValidateUtil.class);

    public static boolean validateRejectReport(RejectOrderPrice rejectOrderPrice, Map<String, Object> result){
        if(rejectOrderPrice == null){
            result.put(ERR_MSG, "rejectOrderPrice is null");
            return false;
        }else if(rejectOrderPrice.getLawyerId() == null){
            result.put(ERR_MSG, "lawyerId is null");
            return false;
        }else if(rejectOrderPrice.getOrderId() == null){
            result.put(ERR_MSG, "orderId is null");
            return false;
        }else if(rejectOrderPrice.getFixedFigure() == null){
            result.put(ERR_MSG, "fixedFigure is null");
            return false;
        }else{
            return true;
        }
    }
}
