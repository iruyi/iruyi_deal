package com.faxintong.iruyi.controller.active;

import com.faxintong.iruyi.utils.Pager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by admin on 15-4-18.
 */
@RestController
@RequestMapping("active")
public class ActiveController {

    /**
     * 获取活动列表
     * @param pager
     * @return
     */
    @RequestMapping(value = "getActiveList")
    public Map<String, Object> getActiveList(Pager pager){

        return null;
    }

    /**
     *
     * @param activeId
     * @return
     */
    @RequestMapping(value = "getActiveDetail")
    public Map<String, Object> getActiveDetail(Long activeId){

        return null;
    }

    /**
     * 活动收藏
     * @param activeId
     * @return
     */
    @RequestMapping(value = "activeStore")
    public Map<String, Object> activeStore(Long activeId){

        return null;
    }
}
