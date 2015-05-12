package com.faxintong.iruyi.service.im.impl;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.faxintong.iruyi.service.im.HxService;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.faxintong.iruyi.utils.Constants;
import com.faxintong.iruyi.utils.HxUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URL;

/**
 * Created by bochenlong on 2015/5/10.
 */
@Service
public class HxServiceImpl implements HxService {
    private static final Logger logger = LoggerFactory.getLogger(HxServiceImpl.class);

    @Override
    public void registerHxUser(String username, String password) throws Exception {
        ObjectNode dataNode = JsonNodeFactory.instance.objectNode();
        dataNode.put("username", username);
        dataNode.put("password", password);

        ObjectNode objectNode ;

        try {
            objectNode = HxUtils.sendHTTPRequest(Constants.USERS_URL, dataNode,
                    "POST");
        } catch (Exception e) {
            logger.error("注册环信用户失败：" + e.getMessage());
            throw new RuntimeException("注册环信用户失败！");
        }

        if(objectNode == null || (objectNode.has("statusCode") && !objectNode.get("statusCode").toString().equals("200"))) {
            throw new RuntimeException("注册环信用户失败！");
        }
    }

    @Override
    public void makeHxFriend(String ownerUsername,String friendUsername) {
        ObjectNode objectNode ;
        try {
            URL addFriendSingleUrl = HxUtils.getURL(Constants.APPKEY.replace("#", "/") + "/users/"
                    + ownerUsername + "/contacts/users/" + friendUsername);

            ObjectNode body = HxUtils.factory.objectNode();
            objectNode = HxUtils.sendHTTPRequest(addFriendSingleUrl, body, "POST");

        } catch (Exception e) {
            logger.error("添加环信好友失败：" + e.getMessage());
            throw new RuntimeException("添加环信好友失败！");
        }

        if(objectNode == null || (objectNode.has("statusCode") && !objectNode.get("statusCode").toString().equals("200"))) {
            throw new RuntimeException("添加环信好友失败！");
        }
    }

    @Override
    public void delHxFriend(String ownerUsername, String friendUsername) throws Exception {
        ObjectNode objectNode ;
        try {
            URL addFriendSingleUrl = HxUtils.getURL(Constants.APPKEY.replace("#", "/") + "/users/"
                    + ownerUsername + "/contacts/users/" + friendUsername);

            ObjectNode body = HxUtils.factory.objectNode();
            objectNode = HxUtils.sendHTTPRequest(addFriendSingleUrl, body, "DELETE");

        } catch (Exception e) {
            logger.error("删除环信好友失败：" + e.getMessage());
            throw new RuntimeException("删除环信好友失败！");
        }

        if(objectNode == null || (objectNode.has("statusCode") && !objectNode.get("statusCode").toString().equals("200"))) {
            throw new RuntimeException("删除环信好友失败！");
        }

    }

    @Override
    public String createHxGroup(String groupName, String desc, boolean isPublic,
                              Integer maxUsers, boolean approval, String ownerId) throws Exception {
        ObjectNode dataObjectNode = JsonNodeFactory.instance.objectNode();
        dataObjectNode.put("groupname", groupName);
        dataObjectNode.put("desc", desc);
        dataObjectNode.put("approval", approval);
        dataObjectNode.put("public", isPublic);
        dataObjectNode.put("maxusers", maxUsers);
        dataObjectNode.put("owner", ownerId);

        ObjectNode objectNode ;
        try {
            objectNode = HxUtils.sendHTTPRequest(Constants.CHATGROUPS_URL, dataObjectNode,
                    "POST");
        } catch (Exception e) {
            logger.error("创建环信群聊失败：" + e.getMessage());
            throw new RuntimeException("创建环信群聊失败！");
        }

        if(objectNode == null || (objectNode.has("statusCode") && !objectNode.get("statusCode").toString().equals("200"))) {
            throw new RuntimeException("创建环信群聊失败！");
        }

        return objectNode.findValue("groupid").toString().replace("\"","");
    }

    @Override
    public void delHxGroup(String groupId) throws Exception {
        ObjectNode objectNode ;
        try {
            URL deleteChatGroupsUrl = HxUtils.getURL(Constants.APPKEY.replace("#", "/") + "/chatgroups/"
                    + groupId);
            objectNode = HxUtils.sendHTTPRequest(deleteChatGroupsUrl, null,
                    "DELETE");
        } catch (Exception e) {
            logger.error("删除环信群聊失败：" + e.getMessage());
            throw new RuntimeException("删除环信群聊失败！");
        }

        if(objectNode == null || (objectNode.has("statusCode") && !objectNode.get("statusCode").toString().equals("200"))) {
            throw new RuntimeException("删除环信群聊失败！");
        }
    }

    @Override
    public void addHxMe2Group(String[] usernames, String groupId) throws Exception {
        ArrayNode usernameArrayNode = JsonNodeFactory.instance.arrayNode();
        for(int i=0;i<usernames.length;i++) {
            usernameArrayNode.add(usernames[i]);
        }
        ObjectNode usernamesNode = JsonNodeFactory.instance.objectNode();
        usernamesNode.put("usernames", usernameArrayNode);

        ObjectNode objectNode ;
        try {
            URL getJoinedChatgroupsForIMUserUrl = HxUtils.getURL(Constants.APPKEY.replace("#", "/")
                    + "/chatgroups/" + groupId + "/users");
            objectNode = HxUtils.sendHTTPRequest(getJoinedChatgroupsForIMUserUrl, usernamesNode,
                    "POST");
        } catch (Exception e) {
            logger.error("环信群聊添加成员失败：" + e.getMessage());
            throw new RuntimeException("环信群聊添加成员失败！");
        }

        if(objectNode == null || (objectNode.has("statusCode") && !objectNode.get("statusCode").toString().equals("200"))) {
            throw new RuntimeException("环信群聊添加成员失败！");
        }
    }

    @Override
    public void delHxMefGroup(String username, String groupId) throws Exception {
        ObjectNode objectNode ;
        try {
            URL allMemberssByGroupIdUrl = HxUtils.getURL(Constants.APPKEY.replace("#", "/") + "/chatgroups/"
                    + groupId + "/users/" + username);
            objectNode = HxUtils.sendHTTPRequest(allMemberssByGroupIdUrl, null,
                    "DELETE");
        } catch (Exception e) {
            logger.error("环信群聊删除成员失败：" + e.getMessage());
            throw new RuntimeException("环信群聊删除成员失败！");
        }

        if(objectNode == null || (objectNode.has("statusCode") && !objectNode.get("statusCode").toString().equals("200"))) {
            throw new RuntimeException("环信群聊删除成员失败！");
        }
    }


}
