package com.faxintong.iruyi.service.vote.impl;

import com.faxintong.iruyi.model.mybatis.vote.Vote;
import com.faxintong.iruyi.service.vote.VoteService;
import com.faxintong.iruyi.utils.Pager;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 15-4-18.
 */
@Service
public class VoteServiceImpl implements VoteService {
    @Override
    public List<Vote> getVoteList(Pager pager) throws Exception {
        return null;
    }

    @Override
    public Vote voteDetail(Long voteId) throws Exception {
        return null;
    }

    @Override
    public void voteChoise(Long voteId, Long optionId, Long lawyerId) throws Exception {

    }
}
