package com.faxintong.iruyi.dao.general;

import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.topic.TopicGroup;
import com.faxintong.iruyi.model.mybatis.vo.ReplyVo;
import com.faxintong.iruyi.model.mybatis.vo.TopicGroupVo;
import com.faxintong.iruyi.model.mybatis.vo.TopicVo;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by yunaxie on 2015/4/20.
 */
@OperateMyBatis
public interface TopicGeneralMapper {
    String TOPICGROUPVIEW = "id,group_name as groupName,access_count as readerCount";

    @Insert("insert into topic (group_id,lawyer_id,lawyer_name,content,create_date) values (#{groupId},#{lawyer.id},#{lawyer.name},#{content},now())")
    int insertTopic(@Param("groupId")Long groupId, @Param("content")String content, @Param("lawyer")Lawyer lawyer);

    @Select("select " + TOPICGROUPVIEW +" from topic_group order by access_count limit #{startCount},#{pageSize}")
    List<TopicGroupVo> selectTopicGroup(@Param("startCount")Integer startCount, @Param("pageSize")Integer pageSize);

    @Select("select count(id) from topic where group_id = #{groupId}")
    int countTopicNumByGroupId(@Param("groupId")Long groupId);
    @Select("select access_count from topic_group where id = #{groupId}")
    int countReaderNumByGroupId(@Param("groupId")Long groupId);
    @Select("select count(id) from topic_group_atten where category_id = #{groupId}")
    int countFansNumByGroupId(@Param("groupId")Long groupId);

    List<TopicVo> selectTopicVo(@Param("groupId")Long groupId,@Param("startCount")Integer startCount, @Param("pageSize")Integer pageSize, @Param("lawyerId")Long lawyerId);

    List<ReplyVo> selectReplyVo(@Param("topicId")Long topicId, @Param("lawyerId")Long lawyerId);

    @Insert("insert into topic_group_atten (category_id,lawyer_id) values(#{groupId},#{lawyerId})")
    int insertTopicGropuAtten(@Param("groupId")Long groupId, @Param("lawyerId")Long lawyerId);

    @Insert("insert into topic_reply (topic_id,lawyer_id,lawyer_name,content,create_date) values(#{topicId},#{lawyer.id},#{lawyer.name},#{content},now())")
    int insertTopicReply(@Param("topicId")Long topicId, @Param("content")String content, @Param("lawyer")Lawyer lawyer);

    @Insert("insert into topic_store (topic_id,lawyer_id) values (#{topicId},#{lawyerId})")
    int insertTopicStore(@Param("topicId")Long topicId, @Param("lawyerId")Long lawyerId);

    @Insert("insert into topic_praise (topic_id,lawyer_id) values (#{topicId},#{lawyerId})")
    int insertTopicPraise(@Param("topicId")Long topicId, @Param("lawyerId")Long lawyerId);
}
