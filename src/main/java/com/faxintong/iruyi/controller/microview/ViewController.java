package com.faxintong.iruyi.controller.microview;

import com.faxintong.iruyi.utils.Pager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by admin on 15-4-18.
 */
@RestController
@RequestMapping("microview")
public class ViewController {

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
    public Map<String, Object> attentionView(Long microViewId){

        return null;
    }

}
