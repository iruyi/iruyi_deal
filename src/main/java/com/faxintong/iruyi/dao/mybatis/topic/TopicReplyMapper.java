package com.faxintong.iruyi.dao.mybatis.topic;

import com.faxintong.iruyi.model.mybatis.topic.TopicReply;
import com.faxintong.iruyi.model.mybatis.topic.TopicReplyExample;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@OperateMyBatis
public interface TopicReplyMapper {
    int countByExample(TopicReplyExample example);

    int deleteByExample(TopicReplyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TopicReply record);

    int insertSelective(TopicReply record);

    List<TopicReply> selectByExample(TopicReplyExample example);

    TopicReply selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TopicReply record, @Param("example") TopicReplyExample example);

    int updateByExample(@Param("record") TopicReply record, @Param("example") TopicReplyExample example);

    int updateByPrimaryKeySelective(TopicReply record);

    int updateByPrimaryKey(TopicReply record);
}