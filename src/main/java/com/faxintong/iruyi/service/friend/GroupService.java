package com.faxintong.iruyi.service.friend;

import com.faxintong.iruyi.model.mybatis.vo.GroupVo;

/**
 * Created by bochenlong on 2015/5/11.
 */
public interface GroupService {
    void createGroup(GroupVo groupVo) throws Exception;
    void addMe2Group(String[] lawyerIds,String groupId) throws Exception;
}
