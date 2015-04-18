package com.faxintong.iruyi.service.discuss.impl;

import com.faxintong.iruyi.model.mybatis.topic.Topic;
import com.faxintong.iruyi.service.discuss.DiscussService;
import com.faxintong.iruyi.utils.Pager;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 15-4-18.
 */
@Service
public class DiscussServiceImpl implements DiscussService {

    @Override
    public List<Topic> getDiscussList(Pager pager, Long lawyerId) throws Exception {
        return null;
    }

}
