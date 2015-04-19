package com.faxintong.iruyi.service.vote.impl;

import com.faxintong.iruyi.dao.mybatis.vote.VoteMapper;
import com.faxintong.iruyi.model.mybatis.vote.Vote;
import com.faxintong.iruyi.model.mybatis.vote.vo.VotehVoteOptionVo;
import com.faxintong.iruyi.service.vote.VoteService;
import com.faxintong.iruyi.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 15-4-18.
 */
@Service
public class VoteServiceImpl implements VoteService {
    @Autowired
    private VoteMapper voteMapper;

    @Override
    public List<VotehVoteOptionVo> getVoteList(Pager pager) throws Exception {
        return voteMapper.selectVotehVoteOption(pager);
    }

    @Override
    public Vote voteDetail(Long voteId) throws Exception {
        VotehVoteOptionVo votehVoteOptionVo = voteMapper.selectVotehVoteOption(null).get(0);
        votehVoteOptionVo.setVoteNum(voteMapper.countVoteOption(voteId));
        votehVoteOptionVo.setOptionNum(voteMapper.countVoteOptionGroupByOption(voteId));
        return votehVoteOptionVo;
    }

    @Override
    public void voteChoise(Long voteId, Long optionId, Long lawyerId) throws Exception {
        voteMapper.insertVoteResult(voteId,optionId,lawyerId);
    }
}
