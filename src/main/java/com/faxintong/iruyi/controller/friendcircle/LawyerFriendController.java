package com.faxintong.iruyi.controller.friendcircle;

import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.service.friendcircle.FriendsService;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

import static com.faxintong.iruyi.utils.Constants.*;

/**
 * Created by ron on 2015/1/12.
 */
@RestController
@RequestMapping(value = "friend")
public class LawyerFriendController {

    private static final Logger logger = LoggerFactory.getLogger(LawyerFriendController.class);
    @Autowired
    private FriendsService friendsService;

    @RequestMapping(value = "search")
    public Map<String, Object> searchLawyer(String name, String phone, HttpServletResponse response){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        List<Lawyer> lawyerList = null;
        try {
            lawyerList = friendsService.searchLawyer(name, phone);
            result.put("lawyerList", lawyerList);
        }catch (Exception e){
            logger.debug("根据名字电话查找律师失败, 名字:" + name + " 电话:" + phone);
        }
        return result;
    };

    @RequestMapping(value = "add")
    public Map<String, Object> addSearchFriends(Long lawyerId, Long friendId,
                                                HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        try {
            friendsService.addSearchFriends(lawyerId, friendId);
            result.put(RESULT, true);
        } catch (Exception e) {
            logger.debug("添加好友失败:" + e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "confirm")
    public Map<String, Object> friendConfirm(Long id){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        if (id != null){
            try {
                friendsService.friendConfirm(id);
                result.put(RESULT, true);
            }catch (Exception e){
                logger.debug("确认朋友关系失败:" + e.getMessage());
            }
        }
        return result;
    }

    @RequestMapping(value = "find")
    public Map<String, Object> findFriends(Long lawyerId){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        List<Lawyer> lawyerList  = null;
        try {
            if (lawyerId != null) {
                lawyerList = friendsService.findFriends(lawyerId);
                result.put("lawyerList", lawyerList);
                result.put(RESULT, true);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
