package com.faxintong.iruyi.controller.friendcircle;

import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.service.friendcircle.FriendsService;
import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

import static com.faxintong.iruyi.utils.Constants.*;

/**
 * Created by ron on 2015/1/12.
 */
@RestController
@RequestMapping("friend")
public class LawyerFriendController {

    private static final Logger logger = LoggerFactory.getLogger(LawyerFriendController.class);
    @Autowired
    private FriendsService friendsService;

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public Map<String, Object> searchLawyer(String name, String phone, HttpServletResponse response){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        List<Lawyer> lawyerList = null;
        try {
            if(!StringUtils.isEmpty(name) || !StringUtils.isEmpty(phone))
                lawyerList = friendsService.searchLawyer(name, phone);
            result.put("lawyerList", lawyerList);
            result.put(RESULT, true);
        }catch (Exception e){
            logger.error("根据名字电话查找律师失败, 名字:" + name + " 电话:" + phone);
        }
        return result;
    };

    @RequestMapping(value = "add")
    public Map<String, Object> addSearchFriends(@NotNull Long lawyerId,@NotNull Long friendId, BindingResult bindingResult,
                                                HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        if (bindingResult.hasErrors()) {
            result.put(ERR_MSG, bindingResult.getFieldError());
            return result;
        }
        try {
            friendsService.addSearchFriends(lawyerId, friendId);
            result.put(RESULT, true);
        } catch (Exception e) {
            logger.error("添加好友失败:" + e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "confirm")
    public Map<String, Object> friendConfirm(@NotNull Long id, BindingResult bindingResult,
                                             HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        if(bindingResult.hasErrors()){
            result.put(ERR_MSG, bindingResult.getFieldError());
            return result;
        }
        try {
            friendsService.friendConfirm(id);
            result.put(RESULT, true);
        }catch (Exception e){
            logger.error("确认朋友关系失败:" + e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "find")
    public Map<String, Object> findFriends(@NotNull Long lawyerId,BindingResult bindingResult,
                                           HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        List<Lawyer> lawyerList  = null;
        if (bindingResult.hasErrors()){
            result.put(ERR_MSG, bindingResult.getFieldError());
            return result;
        }
        try {
            lawyerList = friendsService.findFriends(lawyerId);
            result.put("lawyerList", lawyerList);
            result.put(RESULT, true);
        }catch (Exception e){
            logger.error("查找朋友失败:" + e.getMessage());
        }
        return result;
    }
}
