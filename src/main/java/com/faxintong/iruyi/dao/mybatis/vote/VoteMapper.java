package com.faxintong.iruyi.dao.mybatis.vote;

import com.faxintong.iruyi.model.mybatis.vote.Vote;
import com.faxintong.iruyi.model.mybatis.vote.VoteExample;
import com.faxintong.iruyi.model.mybatis.vote.vo.VotehVoteOptionVo;
import com.faxintong.iruyi.operate.OperateMyBatis;
import com.faxintong.iruyi.utils.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@OperateMyBatis
public interface VoteMapper {
    /**投票操作*/
    int insertVoteResult(Long voteId, Long optionId, Long lawyerId);
    /**获取调查列表*/
    List<VotehVoteOptionVo> selectVotehVoteOption(Pager pager);
    /**获取投票总数*/
    int countVoteOption(Long voteId);
    /**获取各个项投票总数*/
    Map<Integer,Integer> countVoteOptionGroupByOption(Long voteId);



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