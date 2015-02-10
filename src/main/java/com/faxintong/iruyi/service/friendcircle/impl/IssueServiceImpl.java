package com.faxintong.iruyi.service.friendcircle.impl;


import com.faxintong.iruyi.dao.mybatis.community.IssueMapper;
import com.faxintong.iruyi.dao.mybatis.community.ReplyMapper;
import com.faxintong.iruyi.model.mybatis.community.Issue;
import com.faxintong.iruyi.model.mybatis.community.IssueExample;
import com.faxintong.iruyi.model.mybatis.community.Reply;
import com.faxintong.iruyi.service.friendcircle.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by admin on 15-1-3.
 */
@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueMapper issueMapper;
    @Autowired
    private ReplyMapper replyMapper;

    @Override
    @Transactional
    public void reportIssue(Issue issue) throws Exception {
        issueMapper.insert(issue);
    }

    @Override
    @Transactional
    public void deleteIssueById(Long issueId) throws Exception {
        issueMapper.deleteByPrimaryKey(issueId);
    }

    @Override
    public List<Issue> findIssueByLawyerIds(List<Long> lawyerIds) throws Exception {
        IssueExample issueExample = new IssueExample();
        issueExample.createCriteria().andLawyerIdIn(lawyerIds);
        return issueMapper.selectByExample(issueExample);
    }

    @Override
    public Issue findIssueById(Long issueId) throws Exception {
        return issueMapper.selectByPrimaryKey(issueId);
    }

    @Override
    @Transactional
    public void reportReply(Long lawyerId, Long issueId, String replyContent) throws Exception {
        Reply reply = new Reply();
        reply.setLawyerId(lawyerId);
        reply.setIssueId(issueId);
        reply.setPraiseCount(0);
        reply.setReplyContent(replyContent);
        reply.setCreateDate(new Date());
        replyMapper.insert(reply);
    }

    @Override
    public List<Reply> findIssueReply(Long IssueId) throws Exception {
        return null;
    }
}
