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

    @Insert("insert into topic (group_id,lawyer_id,lawyer_name,content,create_date) values (#{groupId},#{lawyer.id},#{lawyer.name},#{content},now())")
    int insertTopic(@Param("groupId")Long groupId, @Param("content")String content, @Param("lawyer")Lawyer lawyer);

    @Select("select id,group_name as groupName from topic_group order by access_count limit #{startCount},#{pageSize}")
    List<TopicGroupVo> selectTopicGroup(@Param("startCount")Integer startCount, @Param("pageSize")Integer pageSize);

    @Select("select count(id) from topic where group_id = #{groupId}")
    int countTopicNumByGroupId(@Param("groupId")Long groupId);
    @Select("select access_count from topic_group where id = #{groupId}")
    int countReaderNumByGroupId(@Param("groupId")Long groupId);
    @Select("select count(id) from topic_group_atten where category_id = #{groupId}")
    int countFansNumByGroupId(@Param("groupId")Long groupId);

    @Select("select count(id) from topic_group_atten where category_id = #{groupId} and lawyer_id = #{lawyerId}")
    int countFansNumByGroupIdMy(@Param("groupId")Long groupId,@Param("lawyerId")Long lawyerId);

    /**
     * groupId 不为空的时候，根据groupId查询话题
     * 否则根据mo值
     * 1 查询关注的律师发的话题
     * 2 查询自己发的话题
     *
     * 否则都为空时 查询全部分页时间倒叙
     * */
    List<TopicVo> selectTopicVo(@Param("groupId")Long groupId,@Param("startCount")Integer startCount, @Param("pageSize")Integer pageSize, @Param("lawyerId")Long lawyerId,@Param("mo")Integer mo);

    List<ReplyVo> selectReplyVo(@Param("topicId")Long topicId, @Param("lawyerId")Long lawyerId);

    @Insert("insert into topic_group_atten (category_id,lawyer_id) values(#{groupId},#{lawyerId})")
    int insertTopicGropuAtten(@Param("groupId")Long groupId, @Param("lawyerId")Long lawyerId);

    @Insert("insert into topic_reply (topic_id,lawyer_id,lawyer_name,content,create_date) values(#{topicId},#{lawyer.id},#{lawyer.name},#{content},now())")
    int insertTopicReply(@Param("topicId")Long topicId, @Param("content")String content, @Param("lawyer")Lawyer lawyer);

    @Insert("insert into topic_store (topic_id,lawyer_id) values (#{topicId},#{lawyerId})")
    int insertTopicStore(@Param("topicId")Long topicId, @Param("lawyerId")Long lawyerId);

    @Insert("insert into topic_praise (topic_id,lawyer_id) values (#{topicId},#{lawyerId})")
    int insertTopicPraise(@Param("topicId")Long topicId, @Param("lawyerId")Long lawyerId);

    List<ReplyVo> selectMyReplyVo(@Param("startCount")Integer startCount, @Param("pageSize")Integer pageSize, @Param("lawyerId")Long lawyerId);
}
