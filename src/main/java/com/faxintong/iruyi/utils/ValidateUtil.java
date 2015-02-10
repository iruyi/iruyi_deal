package com.faxintong.iruyi.utils;

import com.faxintong.iruyi.model.general.order.GeneralOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static com.faxintong.iruyi.utils.Constants.ERR_MSG;

/**
 * Created by hehj on 15-2-7.
 */
public class ValidateUtil {

    Logger logger = LoggerFactory.getLogger(ValidateUtil.class);

    public static boolean validateGeneralOrder(GeneralOrder generalOrder, Map<String, Object> result){
        if(generalOrder == null){
            result.put(ERR_MSG, "generalOrder is null");
            return false;
        }else if(generalOrder.getType() == null){
            result.put(ERR_MSG, "type is null");
            return false;
        }else if(generalOrder.getCategoryId() == null){
            result.put(ERR_MSG, "category is null");
            return false;
        }else if(generalOrder.getCityId() == null){
            result.put(ERR_MSG, "city is null");
            return false;
        }else if(generalOrder.getTitle() == null){
            result.put(ERR_MSG, "title is null");
            return false;
        }else if(generalOrder.getDescription() == null){
            result.put(ERR_MSG, "desc is null");
            return false;
        }else if(generalOrder.getRosterType() == null){
            result.put(ERR_MSG, "roster is null");
            return false;
        }else {
            return true;
        }
    }
}