package com.faxintong.iruyi.controller.position;

import com.faxintong.iruyi.utils.Pager;
import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 律师招聘
 * Created by hehongju on 2015/4/10.
 */
@RestController
@RequestMapping("position")
public class PositionController {

    /**
     * 获取招聘列表
     * @param pager
     * @return
     */
    @RequestMapping(value = "getPositionList")
    public Map<String, Object> getPositionList(Pager pager){
        Map<String, Object> result = Maps.newHashMap();

        return result;
    }

    /**
     * 获取招聘详情
     * @return
     */
    @RequestMapping(value = "positionDetail")
    public Map<String, Object> positionDetail(Long positionId){
        Map<String, Object> result = Maps.newHashMap();

        return result;
    }

    /**
     * 职位收藏
     * @param positionId
     * @return
     */
    @RequestMapping(value = "positionStore")
    public Map<String, Object> positionStore(Long positionId){
        Map<String, Object> result = Maps.newHashMap();

        return result;
    }

    /**
     * 获取职位收藏列表
     * @param pager
     * @return
     */
    @RequestMapping(value = "getStoreList")
    public Map<String, Object> getStoreList(Pager pager){
        Map<String, Object> result = Maps.newHashMap();

        return result;
    }
}
