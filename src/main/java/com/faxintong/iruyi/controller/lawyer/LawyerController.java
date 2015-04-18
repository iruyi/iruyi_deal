package com.faxintong.iruyi.controller.lawyer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by admin on 15-4-18.
 */
@RestController
@RequestMapping("lawyer")
public class LawyerController {

    /**
     * 获取关注律师列表
     * @return
     */
    @RequestMapping(value = "getAttetionList")
    public Map<String, Object> getAttetionList(){

        return null;
    }
}
