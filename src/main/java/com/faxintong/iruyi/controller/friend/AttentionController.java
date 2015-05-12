package com.faxintong.iruyi.controller.friend;

import com.faxintong.iruyi.controller.BaseController;
import com.faxintong.iruyi.service.friend.AttentionService;
import com.faxintong.iruyi.utils.Result;
import com.faxintong.iruyi.utils.ServletUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.faxintong.iruyi.utils.Constants.*;

/**
 * Created by bochenlong on 2015/5/10.
 */
@RestController
@RequestMapping("atten")
public class AttentionController extends BaseController{
    private Logger logger = LoggerFactory.getLogger(AttentionController.class);

    @Autowired
    private AttentionService attentionService;

    /**
     * 添加好友
     * @param attenId
     * @return
     */
    @RequestMapping(value = "makeatten")
    public String makeFriend(Long attenId,HttpServletResponse response,HttpServletRequest request){
        try {
            // 参数校验
            if(attenId == null) {
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "关注ID不能为空！"));
                return null;
            }

            attentionService.makeAtten(getLawyerId(request),attenId);

            ServletUtils.responseJson(response,new Result(RESULTSUCCESS,"关注成功！"));
        }catch (Exception e){
            logger.error("关注失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "关注失败!"));
        }
        return null;
    }

    /**
     * 删除好友
     * @param attenId
     * @return
     */
    @RequestMapping(value = "delatten")
    public String delFriend(Long attenId,HttpServletResponse response,HttpServletRequest request){
        try {
            // 参数校验
            if(attenId == null) {
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "关注ID不能为空！"));
                return null;
            }

            attentionService.delAtten(getLawyerId(request), attenId);

            ServletUtils.responseJson(response,new Result(RESULTSUCCESS,"关注成功！"));
        }catch (Exception e){
            logger.error("关注失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "关注失败!"));
        }
        return null;
    }
}
