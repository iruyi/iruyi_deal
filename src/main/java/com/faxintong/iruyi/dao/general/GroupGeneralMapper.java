package com.faxintong.iruyi.dao.general;

import com.faxintong.iruyi.model.mybatis.vo.GroupVo;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;

/**
 * Created by bochenlong on 2015/5/11.
 */
@OperateMyBatis
public interface GroupGeneralMapper {

    int insertLawyerGroup(GroupVo groupVo);

    int insertLawyerGroupMem(@Param("lawyerIds")Long[] lawyerIds,@Param("groupId")String groupId);
}
