package com.faxintong.iruyi.interceptor;

import com.faxintong.iruyi.utils.Constants;
import com.faxintong.iruyi.utils.RedisUtils;
import com.faxintong.iruyi.utils.ServletUtils;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import static com.faxintong.iruyi.utils.Constants.ERR_MSG;
import static com.faxintong.iruyi.utils.Constants.RESULT;
import static com.faxintong.iruyi.utils.Constants.SESSION_PREFIX;

/**
 * Created by hehj on 15-1-2.
 */
public class LoginInterceptor implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String userId = null;
        final String appSessionId = request.getParameter("sessionId");
        if(!StringUtils.isEmpty(appSessionId)){
            userId = RedisUtils.get(SESSION_PREFIX + appSessionId);
            request.setAttribute("currentUserId", userId);
            return ServletUtils.isValidUser(response, userId);
        }

        final Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("sessionId")) {
                    final String sessionId = cookie.getValue();
                    userId = RedisUtils.get(SESSION_PREFIX + sessionId);
                    request.setAttribute("currentUserId", userId);
                    return ServletUtils.isValidUser(response, userId);
                }
            }
        }
        logger.info("validate user legality -> userId = " + userId);
        return ServletUtils.isValidUser(response, userId);
    }



    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {

    }
}
