package com.faxintong.iruyi.dao.mybatis.topic;

import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.topic.Topic;
import com.faxintong.iruyi.model.mybatis.topic.TopicExample;
import com.faxintong.iruyi.model.mybatis.topic.vo.ReplyWithParis;
import com.faxintong.iruyi.model.mybatis.topic.vo.TopicDetail;
import com.faxintong.iruyi.model.mybatis.topic.vo.TopicWithPraise;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@OperateMyBatis
public interface TopicMapper {
    /**新增话题*/
    int insert(Topic record);
    /**获取话题组下的话题数*/
    int countTopicByGroup(Long groupId);
    /**获取话题组下的话题,其中包含话题律师、头像、点赞数、是否点赞等信息*/
    List<TopicWithPraise> selectTopicByGroup(Long groupId,Long lawyerId);
    /**回复话题*/
    void insertTopicReply(Long topicId, String content, Lawyer lawyer);
    /**赞（关注话题）*/
    void insertTopicParise(Long topicId,Long lawyerId);
    /**赞 回复*/
    void insertReplyParise(Long replyId,Long lawyerId);
    /**根据ID查询话题*/
    TopicDetail selectById(Long topicId);
    /**根据话题ID查询回复内容*/
    List<ReplyWithParis> selectReplyByTopicId(Long topicId,Long LawyerId);

    int countByExample(TopicExample example);

    int deleteByExample(TopicExample example);

    int deleteByPrimaryKey(Long id);

    int insertSelective(Topic record);

    List<Topic> selectByExample(TopicExample example);

    Topic selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Topic record, @Param("example") TopicExample example);

    int updateByExample(@Param("record") Topic record, @Param("example") TopicExample example);

    int updateByPrimaryKeySelective(Topic record);

    int updateByPrimaryKey(Topic record);
}