package com.faxintong.iruyi.service.friendcircle.impl;

import com.faxintong.iruyi.dao.mybatis.friendcircle.LawyerFriendMapper;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.service.friendcircle.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 15-1-3.
 */
@Service("friendsService")
public class FriendsServiceImpl implements FriendsService {

    @Autowired
    private LawyerFriendMapper lawyerFriendMapper;

    @Override
    public Lawyer searchLawyer(String name, String phone) throws Exception {
        return null;
    }

    @Override
    public void addSearchFriends(Long layerId) throws Exception {

    }

    @Override
    public void friendConfirm(Long layerId) throws Exception {

    }

    @Override
    public List<Lawyer> findFriends(Long lawyerId) throws Exception {
        return null;
    }
}
