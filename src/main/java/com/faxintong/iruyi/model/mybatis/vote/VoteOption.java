package com.faxintong.iruyi.model.mybatis.vote;

/**
 * Created by bochenlong on 2015/4/19.
 *  投票选择项Entity
 */
public class VoteOption {
    private Long id;
    private Long voteId;
    private Long content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContent() {
        return content;
    }

    public void setContent(Long content) {
        this.content = content;
    }

    public Long getVoteId() {
        return voteId;
    }

    public void setVoteId(Long voteId) {
        this.voteId = voteId;
    }
}
