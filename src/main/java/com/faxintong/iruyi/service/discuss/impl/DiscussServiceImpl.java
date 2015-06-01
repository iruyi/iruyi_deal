package com.faxintong.iruyi.service.discuss.impl;

import com.faxintong.iruyi.dao.general.TopicGeneralMapper;
import com.faxintong.iruyi.model.mybatis.vo.TopicAllVo;
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
    public List<TopicAllVo> getDiscussList(Pager pager,Long lawyerId,String title,String content) throws Exception {
        return topicGeneralMapper.selectTopicAllVo(pager.getStartCount(pager.getPageSize(), pager.getCurrentPage()), pager.getPageSize(), null, lawyerId, null, title, content);
    }

}
