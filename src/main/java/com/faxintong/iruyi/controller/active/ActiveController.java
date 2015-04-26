package com.faxintong.iruyi.controller.active;

import com.faxintong.iruyi.controller.BaseController;
import com.faxintong.iruyi.model.mybatis.vo.ActiveVo;
import com.faxintong.iruyi.service.active.ActiveService;
import com.faxintong.iruyi.utils.Pager;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

import static com.faxintong.iruyi.utils.Constants.*;

/**
 * Created by admin on 15-4-18.
 */
@RestController
@RequestMapping("active")
public class ActiveController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ActiveController.class);

    @Autowired
    private ActiveService activeService;

    /**
     * 获取活动列表
     * @param pager
     * @return
     */
    @RequestMapping(value = "getActiveList")
    public Map<String, Object> getActiveList(Pager pager){
        Map<String, Object> result = Maps.newHashMap();
        result.put(ERRCODE, 0);
        try {
            if(pager == null || pager.getCurrentPage() == null){
                result.put(ERRMESSAGE, "当前页为null");
            }else{
                List<ActiveVo> list = activeService.getActiveList(pager);
                result.put(ERRCODE, 1);
                result.put(ERRMESSAGE, "获取活动列表成功！");
                result.put(DATA, list);
            }
        }catch (Exception e){
            logger.error("获取活动列表失败:" + e.getMessage());
            result.put(ERRMESSAGE, "获取活动列表失败!");
        }
        return result;
    }

    /**
     * 获取活动详情
     * @param activeId
     * @return
     */
    @RequestMapping(value = "getActiveDetail")
    public Map<String, Object> getActiveDetail(Long activeId){
        Map<String, Object> result = Maps.newHashMap();
        result.put(ERRCODE, 0);
        try {
            if(activeId == null){
                result.put(ERRMESSAGE, "活动id为null");
            }else{
                ActiveVo activeDetail = activeService.getActiveDetail(activeId);
                result.put(ERRCODE, 1);
                result.put(ERRMESSAGE, "获取活动详情成功！");
                result.put(DATA, activeDetail);
            }
        }catch (Exception e){
            logger.error("获取活动详情失败:" + e.getMessage());
            result.put(ERRMESSAGE, "获取活动详情失败!");
        }
        return result;
    }

    /**
     * 活动收藏
     * @param activeId
     * @return
     */
    @RequestMapping(value = "activeStore")
    public Map<String, Object> activeStore(HttpServletRequest request, Long activeId){
        Map<String, Object> result = Maps.newHashMap();
        result.put(ERRCODE, 0);
        try {
            if(activeId == null){
                result.put(ERRMESSAGE, "活动id为null");
            }else{
                activeService.activeStore(activeId, getLawyerId(request));
                result.put(ERRCODE, 1);
                result.put(ERRMESSAGE, "活动收藏成功！");
            }
        }catch (Exception e){
            logger.error("活动收藏失败:" + e.getMessage());
            result.put(ERRMESSAGE, "活动收藏失败!");
        }
        return result;
    }
}
