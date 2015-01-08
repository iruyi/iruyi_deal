package com.faxintong.iruyi.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Created by hehj on 15-1-2.
 */
public class TimeInterceptor implements HandlerInterceptor {

    private Log log = LogFactory.getLog(TimeInterceptor.class);

    public boolean preHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Long controllerStartTime = System.currentTimeMillis();
        request.setAttribute("controllerStartTime", controllerStartTime);
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        Long controllerEndTime = System.currentTimeMillis();
        Long controllerStartTime = Long.parseLong(request.getAttribute("controllerStartTime").toString());
        if(o instanceof  HandlerMethod){
            log.info("执行"+((HandlerMethod)o).getBean().getClass().getName()+"方法"+((HandlerMethod)o).getMethod().getName()+"所用时间为:"+(controllerEndTime-controllerStartTime)+"ms");
        }
    }

}
