package com.faxintong.iruyi.controller.discuss;

import com.faxintong.iruyi.utils.Pager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by admin on 15-4-18.
 */
@RestController
@RequestMapping("discuss")
public class DiscussController {

    /**
     * 获取讨论列表
     * @param pager
     * @return
     */
    @RequestMapping(value = "getDiscussList")
    public Map<String, Object> getDiscussList(Pager pager){

        return null;
    }

}
