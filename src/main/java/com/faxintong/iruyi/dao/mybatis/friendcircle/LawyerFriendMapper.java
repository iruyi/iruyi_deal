package com.faxintong.iruyi.dao.mybatis.friendcircle;

import com.faxintong.iruyi.model.mybatis.friendcircle.LawyerFriend;
import com.faxintong.iruyi.model.mybatis.friendcircle.LawyerFriendExample;
import java.util.List;

import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;
@OperateMyBatis
public interface LawyerFriendMapper {
    int countByExample(LawyerFriendExample example);

    int deleteByExample(LawyerFriendExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LawyerFriend record);

    int insertSelective(LawyerFriend record);

    List<LawyerFriend> selectByExample(LawyerFriendExample example);

    LawyerFriend selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LawyerFriend record, @Param("example") LawyerFriendExample example);

    int updateByExample(@Param("record") LawyerFriend record, @Param("example") LawyerFriendExample example);

    int updateByPrimaryKeySelective(LawyerFriend record);

    int updateByPrimaryKey(LawyerFriend record);
}