package com.faxintong.iruyi.model.mybatis.vote.vo;

import com.faxintong.iruyi.model.mybatis.vote.Vote;

import java.util.List;
import java.util.Map;

/**
 * Created by bochenlong on 2015/4/19.
 */
public class VotehVoteOptionVo extends Vote {
    private List<VoteOption> voteOptions;
    private boolean isEnd;
    private int voteNum;
    private Map<Integer,Integer> optionNum;

    public List<VoteOption> getVoteOptions() {
        return voteOptions;
    }

    public void setVoteOptions(List<VoteOption> voteOptions) {
        this.voteOptions = voteOptions;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setIsEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public int getVoteNum() {
        return voteNum;
    }

    public void setVoteNum(int voteNum) {
        this.voteNum = voteNum;
    }

    public Map<Integer, Integer> getOptionNum() {
        return optionNum;
    }

    public void setOptionNum(Map<Integer, Integer> optionNum) {
        this.optionNum = optionNum;
    }
}
