package com.faxintong.iruyi.service.friend.impl;

import com.faxintong.iruyi.dao.general.GroupGeneralMapper;
import com.faxintong.iruyi.dao.general.LawyerGeneralMapper;
import com.faxintong.iruyi.dao.mybatis.lawyer.LawyerMapper;
import com.faxintong.iruyi.model.mybatis.vo.GroupVo;
import com.faxintong.iruyi.model.mybatis.vo.LawyerVo;
import com.faxintong.iruyi.service.friend.GroupService;
import com.faxintong.iruyi.service.im.HxService;
import com.faxintong.iruyi.utils.Constants;
import com.faxintong.iruyi.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bochenlong on 2015/5/11.
 */
@Service
public class GroupServiceImpl implements GroupService{
    @Autowired
    private HxService hxService;
    @Autowired
    private GroupGeneralMapper groupGeneralMapper;
    @Autowired
    private LawyerGeneralMapper lawyerGeneralMapper;


    @Override
    public List<GroupVo> getLaywerGroups(Pager pager,Long lawyerId) throws Exception {

        return groupGeneralMapper.selectLawyerGroup(pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()),pager.getPageSize(),lawyerId);
    }

    @Override
    public List<LawyerVo> getGroupLawyer(Pager pager,String groupId) throws Exception {
        return lawyerGeneralMapper.selectGroupLaywer(pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()),pager.getPageSize(),groupId);
    }

    @Override
    public GroupVo getLawyerGroup(String groupId) throws Exception {
        return groupGeneralMapper.selectLawyerGroup(groupId);
    }

    @Override
    @Transactional
    public void createGroup(GroupVo groupVo) throws Exception {
        // 创建环信群聊 得到环信群聊id
        String groupId = hxService.createHxGroup(groupVo.getGroupName(),groupVo.getDesc(),
                groupVo.getIsPublic()>=1?true:false,
                Constants.GROUP_MAXUSERS,
                groupVo.getIsApproval()>=1?true:false,groupVo.getOwnerId().toString());
        groupVo.setGroupId(groupId);
        groupGeneralMapper.insertLawyerGroup(groupVo);
        groupGeneralMapper.insertLawyerGroupMem(new Long[]{groupVo.getOwnerId()},groupId);
    }

    @Override
    @Transactional
    public void addMe2Group(String[] lawyerIds, String groupId) throws Exception {
        Long[] lawyerIdLongs = new Long[lawyerIds.length];
        for(int i=0;i<lawyerIds.length;i++) {
            lawyerIdLongs[i] = Long.valueOf(lawyerIds[i]);
        }
        groupGeneralMapper.insertLawyerGroupMem(lawyerIdLongs,groupId);
        // 环信群聊添加人员
        hxService.addHxMe2Group(lawyerIds,groupId);
    }

    @Override
    @Transactional
    public void delMefGroup(Long lawyerId, String groupId) throws Exception {
        groupGeneralMapper.delLawyerGroupMem(lawyerId,groupId);
        // 环信群聊删除人员
        hxService.delHxMefGroup(lawyerId.toString(),groupId);
    }

    @Override
    @Transactional
    public void delGroup(String groupId) throws Exception {
        groupGeneralMapper.delLaywerGroup(groupId);
        // 删除环信群聊
        hxService.delHxGroup(groupId);
    }

    @Override
    @Transactional
    public void updateGroup(GroupVo groupVo) throws Exception {
        groupGeneralMapper.updateLawyerGroup(groupVo);
        // 修改环信群聊
        hxService.updateHxGroup(groupVo.getGroupId(),groupVo.getGroupName(),groupVo.getDesc(),groupVo.getMaxUsers());
    }


}
