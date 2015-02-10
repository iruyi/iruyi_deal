package com.faxintong.iruyi.service.friendcircle;

import java.util.List;

/**
 * Created by ron on 2015/2/10.
 */
public interface IssueService {

    /**
     * 提问
     * @param issue
     */
    public void createIssue(Issue issue);

    /**
     * 删除提问
     * @param IssueId
     */
    public void deleteIssue(Long IssueId);

    /**
     *
     * @param IssueId
     * @return
     */
    public Issue findIssue(Long IssueId);

    /**
     * 查找问题
     * @return
     */
    public List<Issue> findIssues(Integer page, Integer pageSize);


    /**
     * 新鲜事
     * @param page
     * @param pageSize
     */
    public void findIssueAndComments(Integer page, Integer pageSize);

    /**
     *
     * @param reply
     */
    public void createReply(Reply reply);

    /**
     *
     * @param replyId
     */
    public void deleteReply(Long replyId);

    /**
     * 删除一个提问的所有回复
     */
    public void deleteIssueReply(Long issueId);

    /**
     * 给回复点赞
     * @param LawyerId
     * @param replyId
     */
    public void praiseReply(Long LawyerId, Long replyId);

}
