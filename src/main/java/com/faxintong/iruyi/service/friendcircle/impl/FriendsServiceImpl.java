package com.faxintong.iruyi.service.friendcircle.impl;

import com.faxintong.iruyi.dao.mybatis.friendcircle.LawyerFriendMapper;
import com.faxintong.iruyi.dao.mybatis.lawyer.LawyerMapper;
import com.faxintong.iruyi.model.mybatis.friendcircle.LawyerFriend;
import com.faxintong.iruyi.model.mybatis.friendcircle.LawyerFriendExample;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.lawyer.LawyerExample;
import com.faxintong.iruyi.service.friendcircle.FriendsService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;

import static com.faxintong.iruyi.utils.Constants.*;

/**
 * Created by admin on 15-1-3.
 */
@Service("friendsService")
public class FriendsServiceImpl implements FriendsService {

    private final static Logger logger = LoggerFactory.getLogger(FriendsServiceImpl.class);

    @Autowired
    private LawyerFriendMapper lawyerFriendMapper;
    @Autowired
    private LawyerMapper lawyerMapper;

    @Override
    public List<Lawyer> searchLawyer(String name, String phone) throws Exception {
        LawyerExample lawyerExample = new LawyerExample();
        if(!StringUtils.isEmpty(name))
            lawyerExample.createCriteria().andNameEqualTo(name);
        if(!StringUtils.isEmpty(phone))
            lawyerExample.createCriteria().andPhoneEqualTo(phone);
        return lawyerMapper.selectByExample(lawyerExample);
    }

    @Override
    public void addSearchFriends(Long lawyerId, Long friendId) throws Exception {
        LawyerFriendExample lawyerFriendExample = new LawyerFriendExample();
        lawyerFriendExample.createCriteria().andLayerIdEqualTo(lawyerId).andFriendIdEqualTo(friendId);

        if(lawyerFriendMapper.countByExample(lawyerFriendExample) != 0) {
            logger.info(lawyerId + "" + friendId + "添加失败, 重复添加");
            return;
        }
        LawyerFriend lawyerFriend = new LawyerFriend();
        lawyerFriend.setLayerId(lawyerId);
        lawyerFriend.setFriendId(friendId);
        lawyerFriend.setAddTime(new Date());
        lawyerFriend.setStatus(UNCONFIRMED_FRIEND);
        lawyerFriendMapper.insert(lawyerFriend);
    }

    @Override
    public void friendConfirm(Long id) throws Exception {
        LawyerFriend lawyerFriend = lawyerFriendMapper.selectByPrimaryKey(id);
        lawyerFriend.setStatus(FRIEND);
        lawyerFriendMapper.updateByPrimaryKey(lawyerFriend);
    }

    @Override
    public List<Lawyer> findFriends(Long lawyerId) throws Exception {
        LawyerFriendExample lawyerFriendExample = new LawyerFriendExample();
        lawyerFriendExample.createCriteria().andLayerIdEqualTo(lawyerId);
        List<LawyerFriend> lawyerFriends = lawyerFriendMapper.selectByExample(lawyerFriendExample);
        List<Long> lawyerIds = new ArrayList<Long>();
        for(int i = 0; i != lawyerFriends.size(); i++)
            lawyerIds.add(lawyerFriends.get(i).getLayerId());
        LawyerExample lawyerExample = new LawyerExample();
        lawyerExample.createCriteria().andIdIn(lawyerIds);
        return lawyerMapper.selectByExample(lawyerExample);
    }
}
