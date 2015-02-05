package com.faxintong.iruyi.utils;

import com.google.common.collect.Maps;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Map;

import static com.faxintong.iruyi.utils.Constants.ERR_MSG;
import static com.faxintong.iruyi.utils.Constants.RESULT;

/**
 * Created by hehj on 15-1-16.
 */
public class ServletUtils {

    public static void responseJson(ServletResponse response, Object object) {
        response.setContentType("text/json;charset=utf-8");
        PrintWriter writer = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            SerializationConfig cfg = mapper.getSerializationConfig()
                    .withDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
            mapper.setSerializationConfig(cfg);
            writer = response.getWriter();
            mapper.writeValue(writer, object);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }
    }

    public static boolean isValidUser(HttpServletResponse response, String userId){
        if(userId == null){
            Map<String, Object> result = Maps.newHashMap();
            result.put(ERR_MSG, "请登录后再操作");
            result.put(RESULT, false);
            responseJson(response, result);
            return false;
        }
        return true;
    }

    public static void sqlInject(HttpServletResponse response){
            Map<String, Object> result = Maps.newHashMap();
            result.put(ERR_MSG, "非法操作");
            result.put(RESULT, false);
            responseJson(response, result);
            return;
    }
}
