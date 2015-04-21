package com.faxintong.iruyi.controller.position;

import com.faxintong.iruyi.controller.BaseController;
import com.faxintong.iruyi.model.mybatis.vo.PositionVo;
import com.faxintong.iruyi.service.Position.PositionService;
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
 * 律师招聘
 * Created by hehongju on 2015/4/10.
 */
@RestController
@RequestMapping("position")
public class PositionController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(PositionController.class);
    @Autowired
    private PositionService positionService;

    /**
     * 获取招聘列表
     * @param pager
     * @return
     */
    @RequestMapping(value = "getPositionList")
    public Map<String, Object> getPositionList(Pager pager){
        Map<String, Object> result = Maps.newHashMap();
        result.put(ERRCODE, 0);
        try {
            // 参数校验
            if(pager == null || pager.getCurrentPage() == null) {
                result.put(ERRMESSAGE, "当前页为null");
            }

            List<PositionVo> list = positionService.getPositionList(pager);

            result.put(ERRCODE, 1);
            result.put(ERRMESSAGE, "获取招聘列表成功！");
            result.put(DATA, list);
        }catch (Exception e){
            logger.error("获取招聘列表失败:" + e.getMessage());
            result.put(ERRMESSAGE, "获取招聘列表失败!");
        }
        return result;
    }

    /**
     * 获取招聘详情
     * @return
     */
    @RequestMapping(value = "positionDetail")
    public Map<String, Object> positionDetail(HttpServletRequest request,Long positionId){
        Map<String, Object> result = Maps.newHashMap();
        result.put(ERRCODE, 0);
        try {
            // 参数校验
            if(positionId == null) {
                result.put(ERRMESSAGE, "职位ID为空！");
            }

            PositionVo positionVo = positionService.positionDetail(positionId,getLawyerId(request));

            result.put(ERRCODE, 1);
            result.put(ERRMESSAGE, "获取招聘详情成功！");
            result.put(DATA, positionVo);
        }catch (Exception e){
            logger.error("获取招聘详情失败:" + e.getMessage());
            result.put(ERRMESSAGE, "获取招聘详情失败!");
        }
        return result;
    }

    /**
     * 职位收藏
     * @param positionId
     * @return
     */
    @RequestMapping(value = "positionStore")
    public Map<String, Object> positionStore(HttpServletRequest request,Long positionId){
        Map<String, Object> result = Maps.newHashMap();
        result.put(ERRCODE, 0);
        try {
            // 参数校验
            if(positionId == null) {
                result.put(ERRMESSAGE, "职位ID为空！");
            }

            positionService.positionStore(positionId,getLawyerId(request));

            result.put(ERRCODE, 1);
            result.put(ERRMESSAGE, "职位收藏成功！");
        }catch (Exception e){
            logger.error("职位收藏失败:" + e.getMessage());
            result.put(ERRMESSAGE, "职位收藏失败!");
        }
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
        result.put(ERRCODE, 0);
        try {
            // 参数校验
            if(pager == null || pager.getCurrentPage() == null) {
                result.put(ERRMESSAGE, "当前页为null");
            }

            List<PositionVo> list = positionService.getPositionList(pager);

            result.put(ERRCODE, 1);
            result.put(ERRMESSAGE, "获取招聘列表成功！");
            result.put(DATA, list);
        }catch (Exception e){
            logger.error("获取招聘列表失败:" + e.getMessage());
            result.put(ERRMESSAGE, "获取招聘列表失败!");
        }
        return result;
    }
}
