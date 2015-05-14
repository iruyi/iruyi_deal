package com.faxintong.iruyi.dao.general;

import com.faxintong.iruyi.model.mybatis.vo.GroupVo;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by bochenlong on 2015/5/11.
 */
@OperateMyBatis
public interface GroupGeneralMapper {

    int insertLawyerGroup(GroupVo groupVo);

    int insertLawyerGroupMem(@Param("lawyerIds")Long[] lawyerIds,@Param("groupId")String groupId);

    @Delete("delete from lawyer_group_member where group_id = #{groupId} and lawyer_id = #{lawyerId}")
    int delLawyerGroupMem(@Param("lawyerId")Long lawyerId,@Param("groupId")String groupId);

    @Delete("delete from lawyer_group where groupid = #{groupId}")
    int delLaywerGroup(@Param("groupId")String groupId);

    /**修改群聊信息，只支持修改名称、描述、人员上限，其他不支持，因此sql只写这三种属性的动态写法*/
    int updateLawyerGroup(GroupVo groupVo);

    @ResultType(GroupVo.class)
    @Select("select lg.groupid groupId,lg.groupname groupName" +
            " ,lg.affiliations_count affiliationsCount" +
            " ,lg.photo_url photoUrl" +
            " ,(select count(*) from lawyer_group_member lgm" +
            "   where lgm.lawyer_id in (select la.other_lawyer_id from lawyer_attention la where la.lawyer_id = #{lawyerId})) friendNum" +
            " from lawyer_group lg" +
            " where lg.groupid in (select lm.group_id from lawyer_group_member lm where lm.lawyer_id = #{lawyerId})" +
            " order by lg.create_time" +
            " limit #{startCount},#{pageSize}")
    List<GroupVo>  selectLawyerGroup(@Param("startCount")Integer startCount,@Param("pageSize")Integer pageSize,@Param("lawyerId")Long lawyerId);

    @ResultType(GroupVo.class)
    @Select("select lg.id,lg.groupid groupId,lg.groupname groupName,lg.`desc` `desc`,lg.`public` isPublic,lg.approval isApproval" +
            " ,lg.`password` `password`,lg.maxusers maxUsers,lg.affiliations_count affiliationsCount,lg.ownerid ownerId" +
            " ,lg.create_time createTime" +
            " ,lg.photo_url photoUrl" +
            " from lawyer_group lg" +
            " where lg.groupid = #{groupId}")
    GroupVo selectLawyerGroup(@Param("groupId")String groupId);
}
