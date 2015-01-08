package com.faxintong.iruyi.service.comment.impl;

import com.faxintong.iruyi.model.mybatis.comment.Comment;
import com.faxintong.iruyi.service.comment.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hehj on 15-1-3.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Override
    public void commentOrder(Comment comment) throws Exception {

    }

    @Override
    public List<Comment> findOrderComment(Long orderId) throws Exception {
        return null;
    }
}
