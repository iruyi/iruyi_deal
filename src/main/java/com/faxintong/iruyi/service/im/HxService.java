package com.faxintong.iruyi.service.im;

/**
 * Created by bochenlong on 2015/5/10.
 */
public interface HxService {
    void registerHxUser(String username,String password) throws Exception;
    void makeHxFriend(String ownerUsername,String friendUsername) throws Exception;
    void delHxFriend(String ownerUsername,String friendUsername) throws Exception;

    String createHxGroup(String groupName, String desc, boolean isPublic,
                       Integer maxUsers, boolean approval, String ownerId) throws Exception;
    void delHxGroup(String groupId) throws Exception;
    void addHxMe2Group(String[] usernames,String groupId) throws Exception;
    void delHxMefGroup(String username,String groupId) throws Exception;
}
