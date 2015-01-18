package com.faxintong.iruyi.service.friendcircle;

import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;

import java.util.List;

/**
 * Created by admin on 15-1-3.
 */
public interface FriendsService {

    /**
     * 搜索好友
     * @param name
     * @param phone
     * @return
     * @throws Exception
     */
    public List<Lawyer> searchLawyer(String name, String phone) throws Exception;

    /**
     * 添加搜索出的好友
     * 1. 黑名单为你
     * 2. 重复添加问题
     * @param lawyerId
     * @throws Exception
     */
    public void addSearchFriends(Long lawyerId, Long friendId) throws Exception;

    /**
     * 添加好友确认
     * @param id
     * @throws Exception
     */
    public void friendConfirm(Long id) throws Exception;

    /**
     * 获取好友列表
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public List<Lawyer> findFriends(Long lawyerId) throws Exception;
}
