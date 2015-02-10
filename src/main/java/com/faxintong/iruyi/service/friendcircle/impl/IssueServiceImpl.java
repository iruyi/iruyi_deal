package com.faxintong.iruyi.service.friendcircle.impl;

import com.faxintong.iruyi.dao.mybatis.community.IssueMapper;
import com.faxintong.iruyi.dao.mybatis.community.ReplyMapper;
import com.faxintong.iruyi.model.mybatis.community.Issue;
import com.faxintong.iruyi.model.mybatis.community.IssueExample;
import com.faxintong.iruyi.model.mybatis.community.Reply;
import com.faxintong.iruyi.model.mybatis.community.ReplyExample;
import com.faxintong.iruyi.service.friendcircle.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ron on 2015/2/10.
 */
@Service
public class IssueServiceImpl implements IssueService{

    @Autowired
    private IssueMapper issueMapper;
    @Autowired
    private ReplyMapper replyMapper;

    @Override
    public void createIssue(Issue issue) {
        issueMapper.insert(issue);
    }

    @Override
    public void deleteIssue(Long IssueId) {
        issueMapper.deleteByPrimaryKey(IssueId);
    }

    @Override
    public Issue findIssue(Long issueId) {
        return issueMapper.selectByPrimaryKey(issueId);
    }

    @Override
    public List<Issue> findIssues(Integer page, Integer pageSize) {
        IssueExample issueExample = new IssueExample();
        return issueMapper.selectByExample(issueExample);
    }


    @Override
    public void findIssueAndComments(Integer page, Integer pageSize) {

    }

    @Override
    public void createReply(Reply reply) {
        replyMapper.insert(reply);
    }

    @Override
    public void deleteReply(Long replyId) {
        replyMapper.deleteByPrimaryKey(replyId);
    }

    @Override
    public void deleteIssueReply(Long issueId) {
        ReplyExample replyExample = new ReplyExample();
        replyExample.createCriteria().andIssueIdEqualTo(issueId);
        replyMapper.deleteByExample(replyExample);
    }

    @Override
    public void praiseReply(Long LawyerId, Long replyId) {

    }
}
