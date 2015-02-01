package com.faxintong.iruyi.filter;

import com.faxintong.iruyi.utils.ServletUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by hehj on 15-1-23.
 */
public class SqlInjectFilter implements Filter {

    private static List<String> invalidsql = new ArrayList<String>();
    private static String error = "/WEB-INF/views/error/error.jsp";
    private static boolean debug = false;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String sql = filterConfig.getInitParameter("invalidsql");
        String errorpage = filterConfig.getInitParameter("error");
        String de = filterConfig.getInitParameter("debug");
        if(errorpage != null){
            error = errorpage;
        }
        if(sql != null){
            invalidsql = Arrays.asList(sql.split(" "));
        }
        if(de != null && Boolean.parseBoolean(de)){
            debug = true;
            System.out.println("PreventSQLInject Filter staring...");
            System.out.println("print filter details");
            System.out.println("invalid words as fllows (split with blank):");
            for(String s : invalidsql){
                System.out.print(s+" ");
            }
            System.out.println();
            System.out.println("error page as fllows");
            System.out.println(error);
            System.out.println();
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(debug){
            System.out.println("prevent sql inject filter works");
        }
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        Map<String, String[]> params = request.getParameterMap();
        Set<String> keys = params.keySet();
        for(String key : keys){
            String value = request.getParameter(key);
            if(debug){
                System.out.println("process params <key, value>: <"+key+", "+value+">");
            }
            for(String word : invalidsql){
                if(word.equalsIgnoreCase(value) || value.contains(word)){
                    if(value.contains("<")){
                        value = value.replace("<", "<");
                    }
                    if(value.contains(">")){
                        value = value.replace(">", ">");
                    }
                    //request.getSession().setAttribute("sqlInjectError", "the request parameter \""+value+"\" contains keyword: \""+word+"\"");
                    //response.sendRedirect(request.getContextPath()+error);
                    //return;
                    ServletUtils.sqlInject(response);
                }
            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
