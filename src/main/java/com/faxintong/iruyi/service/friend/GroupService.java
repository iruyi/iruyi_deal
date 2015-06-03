package com.faxintong.iruyi.service.friend;

import com.faxintong.iruyi.model.mybatis.vo.GroupVo;
import com.faxintong.iruyi.model.mybatis.vo.LawyerVo;
import com.faxintong.iruyi.utils.Pager;

import java.util.List;

/**
 * Created by bochenlong on 2015/5/11.
 */
public interface GroupService {
    List<GroupVo> getLaywerGroups(Pager pager,Long lawyerId) throws Exception;
    List<LawyerVo> getGroupLawyer(Pager pager,String groupId) throws Exception;
    GroupVo getLawyerGroup(String groupId) throws Exception;

    void createGroup(GroupVo groupVo) throws Exception;
    void addMe2Group(String[] lawyerIds,String groupId) throws Exception;
    void delMefGroup(Long lawyerId,String groupId) throws Exception;
    void delGroup(String groupId) throws Exception;

    void updateGroup(GroupVo groupVo) throws Exception;

    Integer countGroupByName(String name) throws Exception;
}
