package com.faxintong.iruyi.service.discuss.impl;

import com.faxintong.iruyi.dao.general.TopicGeneralMapper;
import com.faxintong.iruyi.model.mybatis.topic.Topic;
import com.faxintong.iruyi.model.mybatis.vo.TopicVo;
import com.faxintong.iruyi.service.discuss.DiscussService;
import com.faxintong.iruyi.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 15-4-18.
 */
@Service
public class DiscussServiceImpl implements DiscussService {
    @Autowired
    TopicGeneralMapper topicGeneralMapper;
    @Override
    public List<TopicVo> getDiscussList(Pager pager,Long lawyerId) throws Exception {
        return topicGeneralMapper.selectTopicVo(null,pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()), pager.getPageSize(),lawyerId,null);
    }

}
