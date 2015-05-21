package com.faxintong.iruyi.controller.position;

import com.faxintong.iruyi.controller.BaseController;
import com.faxintong.iruyi.model.mybatis.vo.PositionVo;
import com.faxintong.iruyi.service.position.PositionService;
import com.faxintong.iruyi.utils.Pager;
import com.faxintong.iruyi.utils.Result;
import com.faxintong.iruyi.utils.ServletUtils;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public String getPositionList(Pager pager,ModelMap modelMap,HttpServletResponse response){
        try {
            // 参数校验
            if(pager == null || pager.getCurrentPage() == null) {
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "当前页为null！"));
                return null;
            }

            List<PositionVo> list = positionService.getPositionList(pager);

            modelMap.put(DATA, list);
            resultModelMap(RESULTSUCCESS,"获取招聘列表成功！",modelMap);

            return "position/getPositionList";
        }catch (Exception e){
            logger.error("获取招聘列表失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "获取招聘列表失败！"));
        }
        return null;
    }

    /**
     * 获取招聘详情
     * @return
     */
    @RequestMapping(value = "positionDetail")
    public String positionDetail(HttpServletRequest request,Long positionId,ModelMap modelMap,HttpServletResponse response){
        try {
            // 参数校验
            if(positionId == null) {
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "职位ID为空！"));
                return null;
            }

            PositionVo positionVo = positionService.positionDetail(positionId,getLawyerId(request));

            modelMap.put(DATA, positionVo);
            resultModelMap(RESULTSUCCESS,"获取招聘详情成功！",modelMap);

            return "position/positionDetail";
        }catch (Exception e){
            logger.error("获取招聘详情失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "获取招聘详情失败！"));
        }
        return null;
    }

    /**
     * 职位收藏
     * @param positionId
     * @return
     */
    @RequestMapping(value = "positionStore")
    public String positionStore(HttpServletRequest request,Long positionId,HttpServletResponse response){
        Map<String, Object> result = Maps.newHashMap();
        result.put(ERRCODE, 0);
        try {
            // 参数校验
            if(positionId == null) {
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "职位ID为空！"));
                return null;
            }

            positionService.positionStore(positionId, getLawyerId(request));

            ServletUtils.responseJson(response, new Result(RESULTSUCCESS, "职位收藏成功！"));
        }catch (Exception e){
            logger.error("职位收藏失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "职位收藏失败！"));
        }
        return null;
    }

    /**
     * 获取职位收藏列表
     * @param pager
     * @return
     */
    @RequestMapping(value = "getStoreList")
    public String getStoreList(Pager pager,ModelMap modelMap,HttpServletResponse response){
        try {
            // 参数校验
            if(pager == null || pager.getCurrentPage() == null) {
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "当前页为null！"));
                return null;
            }

            List<PositionVo> list = positionService.getPositionList(pager);
            modelMap.put(DATA, list);
            resultModelMap(RESULTSUCCESS,"获取职位收藏列表成功！",modelMap);

            return "position/getStoreList";
        }catch (Exception e){
            logger.error("获取招聘列表失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "获取招聘列表失败！"));
        }
        return null;
    }
}
