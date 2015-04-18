package com.faxintong.iruyi.dao.mybatis.vote;

import com.faxintong.iruyi.model.mybatis.vote.Vote;
import com.faxintong.iruyi.model.mybatis.vote.VoteExample;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@OperateMyBatis
public interface VoteMapper {
    int countByExample(VoteExample example);

    int deleteByExample(VoteExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Vote record);

    int insertSelective(Vote record);

    List<Vote> selectByExample(VoteExample example);

    Vote selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Vote record, @Param("example") VoteExample example);

    int updateByExample(@Param("record") Vote record, @Param("example") VoteExample example);

    int updateByPrimaryKeySelective(Vote record);

    int updateByPrimaryKey(Vote record);
}