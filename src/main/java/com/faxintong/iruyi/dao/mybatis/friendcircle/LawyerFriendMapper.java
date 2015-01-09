package com.faxintong.iruyi.dao.mybatis.friendcircle;

import com.faxintong.iruyi.model.mybatis.friendcircle.LayerFriend;
import com.faxintong.iruyi.model.mybatis.friendcircle.LayerFriendExample;
import java.util.List;

import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;
@OperateMyBatis
public interface LawyerFriendMapper {
    int countByExample(LayerFriendExample example);

    int deleteByExample(LayerFriendExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LayerFriend record);

    int insertSelective(LayerFriend record);

    List<LayerFriend> selectByExample(LayerFriendExample example);

    LayerFriend selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LayerFriend record, @Param("example") LayerFriendExample example);

    int updateByExample(@Param("record") LayerFriend record, @Param("example") LayerFriendExample example);

    int updateByPrimaryKeySelective(LayerFriend record);

    int updateByPrimaryKey(LayerFriend record);
}