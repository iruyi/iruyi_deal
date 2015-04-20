package com.faxintong.iruyi.controller.microview;

import com.faxintong.iruyi.utils.Pager;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.faxintong.iruyi.utils.Constants.ERRCODE;
import static com.faxintong.iruyi.utils.Constants.ERRMESSAGE;

/**
 * Created by admin on 15-4-18.
 */
@RestController
@RequestMapping("microview")
public class ViewController {
    private Logger logger = LoggerFactory.getLogger(ViewController.class);
    /**
     * 获取微访谈话题列表
     * @param pager
     * @return
     */
    @RequestMapping(value = "getViewList")
    public Map<String, Object> getViewList(Pager pager){

        return null;
    }

    /**
     * 查看微访谈详情
     * @param microViewId
     * @return
     */
    @RequestMapping(value = "microViewId")
    public Map<String, Object> viewDetail(Long microViewId){

        return null;
    }

    /**
     * 关注微访谈
     * @param microViewId
     * @return
     */
    @RequestMapping(value = "attentionView")
    public Map<String, Object> viewAttention(Long microViewId){

        return null;
    }

    /**
     * 微访谈讨论内容
     * @param microViewId
     * @param content
     * @param type
     * @return
     */
    @RequestMapping(value = "viewDiscuss")
    public Map<String, Object> viewDiscuss(Long microViewId, String content, Integer type){

        return null;
    }

    /**
     * 访谈讨论点赞
     * @param discussId
     * @return
     */
    @RequestMapping(value = "discussPraise")
    public Map<String, Object> discussPraise(Long discussId){
        Map<String, Object> result = Maps.newHashMap();
        result.put(ERRCODE, 0);
        try {
            // 参数校验
            if(discussId == null) {
                result.put(ERRMESSAGE, "讨论ID为空！");
            }



            result.put(ERRCODE, 1);
            result.put(ERRMESSAGE, "访谈讨论点赞成功！");
        }catch (Exception e){
            logger.error("访谈讨论点赞失败:" + e.getMessage());
            result.put(ERRMESSAGE, "访谈讨论点赞失败!");
        }
        return result;
    }
}
