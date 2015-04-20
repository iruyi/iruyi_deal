package com.faxintong.iruyi.model.mybatis.vo;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by yunaxie on 2015/4/20.
 */
public class VoteVo {
    private Long id;

    private String content;

    private Integer isEnd;

    List<VoteOptionVo> voteOptionVos;

    private Integer voteSum;

    private Map<Integer,Integer> optionNumMap;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIsEnd() {
        return isEnd;
    }

    public void setIsEnd(Integer isEnd) {
        this.isEnd = isEnd;
    }

    public List<VoteOptionVo> getVoteOptionVos() {
        return voteOptionVos;
    }

    public void setVoteOptionVos(List<VoteOptionVo> voteOptionVos) {
        this.voteOptionVos = voteOptionVos;
    }

    public Integer getVoteSum() {
        return voteSum;
    }

    public void setVoteSum(Integer voteSum) {
        this.voteSum = voteSum;
    }

    public Map<Integer, Integer> getOptionNumMap() {
        return optionNumMap;
    }

    public void setOptionNumMap(Map<Integer, Integer> optionNumMap) {
        this.optionNumMap = optionNumMap;
    }
}
