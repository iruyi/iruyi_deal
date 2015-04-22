package com.faxintong.iruyi.model.mybatis.vo;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by yunaxie on 2015/4/20.
 */
public class VoteVo {
    private Long id;

    private String title;
    private String content;

    private Date createDate;

    private Integer isEnd;

    List<VoteOptionVo> voteOptionVos;

    private Integer voteSum;

    private Map<String,Integer> optionNumMap;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public Map<String, Integer> getOptionNumMap() {
        return optionNumMap;
    }

    public void setOptionNumMap(Map<String, Integer> optionNumMap) {
        this.optionNumMap = optionNumMap;
    }
}
