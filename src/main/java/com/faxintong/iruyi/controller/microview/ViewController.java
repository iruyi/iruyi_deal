package com.faxintong.iruyi.controller.microview;

import com.faxintong.iruyi.controller.BaseController;
import com.faxintong.iruyi.model.mybatis.vo.ViewVo;
import com.faxintong.iruyi.service.microview.ViewService;
import com.faxintong.iruyi.utils.Pager;
import com.faxintong.iruyi.utils.Result;
import com.faxintong.iruyi.utils.ServletUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.faxintong.iruyi.utils.Constants.*;

/**
 * Created by admin on 15-4-18.
 */
@RestController
@RequestMapping("microview")
public class ViewController extends BaseController{
    private Logger logger = LoggerFactory.getLogger(ViewController.class);
    @Autowired
    private ViewService viewService;
    /**
     * 获取微访谈话题列表
     * @param pager
     * @return
     *
     * @note
     *  获取微访谈列表
     *
     *  备注：缺少访谈结束时间，无法判断访谈是否在进行中，这里为了不影响程序写死了1
     *
     */
    @RequestMapping(value = "getViewList")
    public String getViewList(Pager pager,ModelMap modelMap,HttpServletRequest request,HttpServletResponse response){
        try {
            // 参数校验
            if(pager == null || pager.getCurrentPage() == null) {
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "当前页为空！"));
                return null;
            }

            List<ViewVo> viewList = viewService.getViewList(pager,getLawyerId(request));
            if(viewList != null && viewList.size() > 0){
                for (ViewVo viewVo : viewList){
                    if(viewVo.getIsAtten() > 0){
                        viewVo.setIsAtten(1);
                    }
                }
            }

            modelMap.put(DATA,viewList);
            resultModelMap(RESULTSUCCESS,"获取微访谈列表成功！",modelMap);

            return "view/getViewList";
        }catch (Exception e){
            logger.error("获取微访谈列表失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "获取微访谈列表失败！"));
        }
        return null;
    }

    /**
     * 查看微访谈详情
     * @param microViewId
     * @return
     */
    @RequestMapping(value = "viewDetail")
    public String viewDetail(Long microViewId,Pager pager,ModelMap modelMap,HttpServletRequest request,HttpServletResponse response){
        try {
            // 参数校验
            if(microViewId == null || pager == null) {
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "当前页或微访谈ID为空！"));
                return null;
            }

            ViewVo viewVo = viewService.viewDetail(microViewId, getLawyerId(request),pager);

            modelMap.put(DATA, viewVo);
            resultModelMap(RESULTSUCCESS, "查看微访谈详情成功！", modelMap);

            return "view/viewDetail";
        }catch (Exception e){
            e.printStackTrace();
            logger.error("查看微访谈详情失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "查看微访谈详情失败！"));
        }
        return null;
    }

    /**
     * 关注微访谈
     * @param microViewId
     * @return
     */
    @RequestMapping(value = "attentionView")
    public String viewAttention(HttpServletRequest request,Long microViewId,HttpServletResponse response){
        try {
            // 参数校验
            if(microViewId == null) {
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "微访谈ID为空！"));
                return null;
            }

            viewService.viewAttention(microViewId,getLawyerId(request));

            ServletUtils.responseJson(response, new Result(RESULTSUCCESS, "关注微访谈成功！"));

        }catch (Exception e){
            logger.error("关注微访谈失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "关注微访谈失败！"));
        }
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
    public String viewDiscuss(HttpServletRequest request,Long microViewId, Integer type, String content, HttpServletResponse response){
        try {
            // 参数校验
            if(microViewId == null || StringUtils.isEmpty(content) ) {
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "微访谈ID或者讨论内容为空！"));
                return null;
            }

            if(type == null) {
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "微访谈提问回答类型为空！"));
                return null;
            }

            viewService.viewDiscuss(getLawyer(request), microViewId, content, type);
            ServletUtils.responseJson(response, new Result(RESULTSUCCESS, "微访谈讨论成功！"));
        }catch (Exception e){
            logger.error("微访谈讨论失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "微访谈讨论失败！"));
        }
        return null;
    }

    /**
     * 访谈讨论点赞
     * @param discussId
     * @return
     */
    @RequestMapping(value = "discussPraise")
    public String discussPraise(HttpServletRequest request,Long discussId,HttpServletResponse response){
        try {
            // 参数校验
            if(discussId == null) {
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "讨论ID为空！"));
                return null;
            }

            viewService.discussPraise(discussId,getLawyerId(request));

            ServletUtils.responseJson(response, new Result(RESULTSUCCESS, "访谈讨论点赞成功！"));
        }catch (Exception e){
            logger.error("访谈讨论点赞失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "访谈讨论点赞失败！"));
        }
        return null;
    }
}
