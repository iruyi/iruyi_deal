package com.faxintong.iruyi.service.vote;

import com.faxintong.iruyi.model.mybatis.vo.VoteVo;
import com.faxintong.iruyi.model.mybatis.vote.Vote;
import com.faxintong.iruyi.utils.Pager;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 15-4-18.
 */
public interface VoteService {

    /**
     * 获取投票列表
     * @param pager
     * @return
     */
    public List<VoteVo> getVoteList(Pager pager) throws Exception;

    /**
     * 获取投票详情
     * @param voteId
     * @return
     *
     * @note by bochenlong
     * 因为获取投票列表时已经把投票相关信息返回，因此获取详情时只返回统计部分的字段
     *
     */
    public VoteVo voteDetail(Long voteId) throws Exception;

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
