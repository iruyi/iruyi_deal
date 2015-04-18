package com.faxintong.iruyi.service.discuss;

import com.faxintong.iruyi.model.mybatis.topic.Topic;
import com.faxintong.iruyi.utils.Pager;

import java.util.List;

/**
 * Created by admin on 15-4-18.
 */
public interface DiscussService {

    /**
     * 获取讨论列表(自己关注过的话题)
     * @param pager
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public List<Topic> getDiscussList(Pager pager, Long lawyerId) throws Exception;

}
