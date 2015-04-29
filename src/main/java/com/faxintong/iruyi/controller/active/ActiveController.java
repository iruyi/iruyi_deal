package com.faxintong.iruyi.controller.active;

import com.faxintong.iruyi.controller.BaseController;
import com.faxintong.iruyi.dao.mybatis.active.ActiveStoreMapper;
import com.faxintong.iruyi.model.mybatis.active.ActiveStoreExample;
import com.faxintong.iruyi.model.mybatis.vo.ActiveVo;
import com.faxintong.iruyi.service.active.ActiveService;
import com.faxintong.iruyi.utils.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @Autowired
    private ActiveStoreMapper activeStoreMapper;

    /**
     * 获取活动列表
     * @param pager
     * @return
     */
    @RequestMapping(value = "getActiveList")
    public String getActiveList(Pager pager, ModelMap modelMap){
        modelMap.put(ERRCODE, RESULTFAIL);
        try {
            if(pager == null || pager.getCurrentPage() == null){
                modelMap.put(ERRMESSAGE, "当前页为null");
            }else{
                List<ActiveVo> list = activeService.getActiveList(pager);
                modelMap.put(ERRCODE, RESULTSUCCESS);
                modelMap.put(ERRMESSAGE, "获取活动列表成功！");
                modelMap.put(DATA, list);
            }
        }catch (Exception e){
            logger.error("获取活动列表失败:" + e.getMessage());
            modelMap.put(ERRMESSAGE, "获取活动列表失败!");
        }
        return "active/getActiveList";
    }

    /**
     * 获取活动详情
     * @param activeId
     * @return
     */
    @RequestMapping(value = "getActiveDetail")
    public String getActiveDetail(Long activeId, ModelMap modelMap){
        modelMap.put(ERRCODE, RESULTFAIL);
        try {
            if(activeId == null){
                modelMap.put(ERRMESSAGE, "活动id为null");
            }else{
                ActiveVo activeDetail = activeService.getActiveDetail(activeId);
                modelMap.put(ERRCODE, RESULTSUCCESS);
                modelMap.put(ERRMESSAGE, "获取活动详情成功！");
                modelMap.put(DATA, activeDetail);
            }
        }catch (Exception e){
            logger.error("获取活动详情失败:" + e.getMessage());
            modelMap.put(ERRMESSAGE, "获取活动详情失败!");
        }
        return "active/getActiveDetail";
    }

    /**
     * 活动收藏
     * @param activeId
     * @return
     */
    @RequestMapping(value = "activeStore")
    public String activeStore(HttpServletRequest request, Long activeId, ModelMap modelMap){
        modelMap.put(ERRCODE, RESULTFAIL);
        try {
            if(activeId == null){
                modelMap.put(ERRMESSAGE, "活动id为null");
            }else{
                ActiveStoreExample example = new ActiveStoreExample();
                example.createCriteria().andActiveIdEqualTo(activeId).andLawyerIdEqualTo(getLawyerId(request));
                Integer count = activeStoreMapper.countByExample(example);
                if(count != null && count.intValue() > 0){
                    modelMap.put(ERRMESSAGE, "此活动已收藏！");
                }else {
                    activeService.activeStore(activeId, getLawyerId(request));
                    modelMap.put(ERRCODE, RESULTSUCCESS);
                    modelMap.put(ERRMESSAGE, "活动收藏成功！");
                }
            }
        }catch (Exception e){
            logger.error("活动收藏失败:" + e.getMessage());
            modelMap.put(ERRMESSAGE, "活动收藏失败!");
        }
        return "lawyer/common";
    }
}
