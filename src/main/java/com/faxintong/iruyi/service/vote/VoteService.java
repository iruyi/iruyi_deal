package com.faxintong.iruyi.service.vote;

import com.faxintong.iruyi.model.mybatis.vote.Vote;
import com.faxintong.iruyi.utils.Pager;

import java.util.List;

/**
 * Created by admin on 15-4-18.
 */
public interface VoteService {

    /**
     * 获取投票列表
     * @param pager
     * @return
     */
    public List<Vote> getVoteList(Pager pager) throws Exception;

    /**
     * 获取投票详情
     * @param voteId
     * @return
     */
    public Vote voteDetail(Long voteId) throws Exception;

    /**
     * 投票选择
     * @param voteId
     * @param optionId
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public void voteChoise(Long voteId, Long optionId, Long lawyerId) throws Exception;
}
