package com.faxintong.iruyi.service.friendcircle;


import com.faxintong.iruyi.model.mybatis.community.CommunityNews;
import com.faxintong.iruyi.model.mybatis.community.Issue;
import com.faxintong.iruyi.model.mybatis.community.Reply;

import java.util.List;

/**
 * Created by ron on 15-2-10.
 */
public interface IssueService {

    /**
     * 律师发表文章
     * @param issue
     * @throws Exception
     */
    public void reportIssue(Issue issue) throws Exception;

    /**
     * 删除文章
     * @param issueId
     * @throws Exception
     */
    public void deleteIssueById(Long issueId) throws Exception;

    /**
     * 获取文章列表
     * @param lawyerIds
     * @return
     * @throws Exception
     */
    public List<Issue> findIssueByLawyerIds(List<Long> lawyerIds) throws Exception;

    /**
     * 获取文章详情
     * @param issueId
     * @return
     * @throws Exception
     */
    public Issue findIssueById(Long issueId) throws Exception;

    /**
     * 对文章发表评论
     * @param lawyerId
     * @param issueId
     * @param reply
     * @throws Exception
     */
    public void reportReply(Long lawyerId,Long issueId,String reply) throws Exception;



    /**
     * 获取文章评论列表
     * @param issueId
     * @return
     * @throws Exception
     */
    public List<Reply> findIssueReply(Long issueId) throws Exception;

    /**
     * 获取社区首页问题
     * @param page
     * @param pageSize
     * @return
     */
    public List<CommunityNews> getCommunityNews(Integer page, Integer pageSize) throws Exception;
}
