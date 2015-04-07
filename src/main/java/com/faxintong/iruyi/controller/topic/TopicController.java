package com.faxintong.iruyi.controller.topic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by hehongju on 2015/3/27.
 */
@RestController
@RequestMapping("topic")
public class TopicController {

    /**
     * 发表话题
     * @return
     */
    @RequestMapping(value = "reportTopic")
    public Map<String, Object> reportTopic(){

        return null;
    }

    /**
     * 获取话题列表
     * @param categoryId
     * @return
     */
    @RequestMapping(value = "getTopicList")
    public Map<String, Object> getTopicList(Long categoryId){

        return null;
    }

    /**
     * 获取话题详情
     * @param topicId
     * @return
     */
    @RequestMapping(value = "getTopicDetail")
    public Map<String, Object> getTopicDetail(Long topicId){

        return null;
    }

    /**
     * 关注话题
     * @return
     */
    @RequestMapping(value = "attentionTopic")
    public Map<String, Object> attentionTopic(){

        return null;
    }

    /**
     * 获取微访谈话题列表
     * @return
     */
    @RequestMapping(value = "microViewList")
    public Map<String, Object> microViewList(){

        return null;
    }

    /**
     * 查看微访谈详情
     * @param microViewId
     * @return
     */
    @RequestMapping(value = "microViewDetail")
    public Map<String, Object> microViewDetail(Long microViewId){

        return null;
    }

    /**
     * 关注微访谈
     * @return
     */
    @RequestMapping(value = "attentionView")
    public Map<String, Object> attentionView(){

        return null;
    }
}
