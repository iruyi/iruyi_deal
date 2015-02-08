package com.faxintong.iruyi.controller;

import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.service.lawyer.UserService;
import com.faxintong.iruyi.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import static com.faxintong.iruyi.utils.Constants.*;
/**
 * Created by ron on 2015/1/13.
 */
public class BaseController {

    @Autowired
    protected UserService userService;
    /**
     * 上传文件
     * @param request
     * @param filePath 需要.以前的绝对路径
     * @throws IOException
     */
    protected String uploadFile(HttpServletRequest request, String filePath) throws IOException {
        String fileName = null;
        CommonsMultipartResolver cmr =  new CommonsMultipartResolver(request.getSession().getServletContext());

        if(cmr.isMultipart(request)){
            MultipartHttpServletRequest mhr = (MultipartHttpServletRequest)request;

            Iterator<String> iterator = mhr.getFileNames();
            while(iterator.hasNext()){
                MultipartFile mf = mhr.getFile(iterator.next());
                if(mf != null){
                    fileName = mhr.getLocalName();
                    String ext = fileName.substring(fileName.lastIndexOf("."));
                    File file = new File(filePath + fileName);
                    mf.transferTo(file);
                }
            }
        }
        return filePath + fileName;
    }

    /**
     * 获得律师Id
     * @param request
     * @return
     */
    protected Long getLawyerId(HttpServletRequest request){
        return Long.valueOf((String) request.getAttribute("currentUserId"));
    }

    /**
     * 获得律师
     * @param request
     * @return
     */
    protected Lawyer getLawyer(HttpServletRequest request){
        /*String sessionId = (String) request.getAttribute("sessionId");
        String id = RedisUtils.get(SESSION_PREFIX + sessionId);
        return userService.getLawyerByPrimaryKey(Long.parseLong(id));*/
        return userService.getLawyerByPrimaryKey(getLawyerId(request));
    }
}
