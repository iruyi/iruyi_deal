package com.faxintong.iruyi.dao.mybatis.topic;

import com.faxintong.iruyi.model.mybatis.topic.TopicGroup;
import com.faxintong.iruyi.model.mybatis.topic.TopicGroupExample;
import com.faxintong.iruyi.operate.OperateMyBatis;
import com.faxintong.iruyi.utils.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@OperateMyBatis
public interface TopicGroupMapper {
    /**查询话题组列表，根据热度进行排序*/
    List<TopicGroup> selectTopicGroup(Pager pager);
    /**根据ID查询话题组信息*/
    int countfans(Long id);
    int countRead(Long id);
    /**关注讨论组*/
    void insertTopicGropuAtten(Long groupId, Long LawyerId);

    int countByExample(TopicGroupExample example);

    int deleteByExample(TopicGroupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TopicGroup record);

    int insertSelective(TopicGroup record);

    List<TopicGroup> selectByExample(TopicGroupExample example);

    TopicGroup selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TopicGroup record, @Param("example") TopicGroupExample example);

    int updateByExample(@Param("record") TopicGroup record, @Param("example") TopicGroupExample example);

    int updateByPrimaryKeySelective(TopicGroup record);

    int updateByPrimaryKey(TopicGroup record);
}