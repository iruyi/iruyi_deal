package com.faxintong.iruyi.controller.comment;

import com.faxintong.iruyi.model.mybatis.comment.Comment;
import com.faxintong.iruyi.service.comment.CommentService;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;

import static com.faxintong.iruyi.utils.Constants.*;
/**
 * Created by ron on 2015/1/14.
 */
public class CommentController {

    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
    @Autowired
    private CommentService commentService;

    public Map<String, Object> reportComment(@Valid Comment comment,
                                             HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        try {
            commentService.commentOrder(comment);
            result.put(RESULT, true);
        } catch (Exception e) {
            logger.debug("律师对订单发表评论失败");
            e.printStackTrace();
        }
        return result;
    }

    public Map<String, Object> findOrderComment(Long orderId,HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        try {
            result.put("comment", commentService.findOrderComment(orderId));
            result.put(RESULT, true);
        } catch (Exception e) {
            logger.debug("获取订单评论失败");
            e.printStackTrace();
        }
        return result;
    }
}
