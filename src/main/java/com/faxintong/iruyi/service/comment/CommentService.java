package com.faxintong.iruyi.service.comment;

import com.faxintong.iruyi.model.mybatis.comment.Comment;

import java.util.List;

/**
 * Created by hehj on 15-1-3.
 */
public interface CommentService {

    /**
     * 律师针对单子互评
     * @param comment
     * @throws Exception
     */
    public void commentOrder(Comment comment) throws Exception;

    /**
     * 查询单子互评
     * @param orderId
     * @return
     * @throws Exception
     */
    public List<Comment> findOrderComment(Long orderId) throws Exception;

}
