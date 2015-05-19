package com.faxintong.iruyi.dao.mybatis.topic;

import com.faxintong.iruyi.model.mybatis.topic.TopicGroupTitle;
import com.faxintong.iruyi.model.mybatis.topic.TopicGroupTitleExample;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@OperateMyBatis
public interface TopicGroupTitleMapper {
    int countByExample(TopicGroupTitleExample example);

    int deleteByExample(TopicGroupTitleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TopicGroupTitle record);

    int insertSelective(TopicGroupTitle record);

    List<TopicGroupTitle> selectByExample(TopicGroupTitleExample example);

    TopicGroupTitle selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TopicGroupTitle record, @Param("example") TopicGroupTitleExample example);

    int updateByExample(@Param("record") TopicGroupTitle record, @Param("example") TopicGroupTitleExample example);

    int updateByPrimaryKeySelective(TopicGroupTitle record);

    int updateByPrimaryKey(TopicGroupTitle record);
}