package com.faxintong.iruyi.service.comment.impl;

import com.faxintong.iruyi.dao.mybatis.comment.CommentMapper;
import com.faxintong.iruyi.model.mybatis.comment.Comment;
import com.faxintong.iruyi.model.mybatis.comment.CommentExample;
import com.faxintong.iruyi.service.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hehj on 15-1-3.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void commentOrder(Comment comment) throws Exception {
        commentMapper.insert(comment);
    }

    @Override
    public List<Comment> findOrderComment(Long orderId) throws Exception {
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andOrderIdEqualTo(orderId);
        return commentMapper.selectByExample(commentExample);
    }
}
