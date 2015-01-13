package com.faxintong.iruyi.controller.friendcircle;

import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.service.friendcircle.FriendsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    public List<Lawyer> searchLawyer(String name, String phone, HttpServletResponse response){
        List<Lawyer> lawyerList = null;
        try {
            lawyerList = friendsService.searchLawyer(name, phone);

        }catch (Exception e){
            logger.debug("根据名字电话查找律师失败, 名字:" + name + " 电话:" + phone);
        }
        return lawyerList;
    };

    @RequestMapping(value = "add")
    public void addSearchFriends(Long lawyerId, Long friendId, HttpServletResponse response){
        try {
            friendsService.addSearchFriends(lawyerId, friendId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "confirm")
    public void friendConfirm(Long id){
        try {
            friendsService.friendConfirm(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "find")
    public List<Lawyer> findFriends(Long lawyerId){
        List<Lawyer> lawyerList  = null;
        try {
            if (lawyerId != null)
            lawyerList =  friendsService.findFriends(lawyerId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return lawyerList;
    }
}
