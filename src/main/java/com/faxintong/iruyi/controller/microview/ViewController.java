package com.faxintong.iruyi.controller.microview;

import com.faxintong.iruyi.controller.BaseController;
import com.faxintong.iruyi.model.mybatis.vo.ViewVo;
import com.faxintong.iruyi.service.microview.ViewService;
import com.faxintong.iruyi.utils.Pager;
import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

import static com.faxintong.iruyi.utils.Constants.DATA;
import static com.faxintong.iruyi.utils.Constants.ERRCODE;
import static com.faxintong.iruyi.utils.Constants.ERRMESSAGE;

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
     */
    @RequestMapping(value = "getViewList")
    public Map<String, Object> getViewList(Pager pager){
        Map<String, Object> result = Maps.newHashMap();
        result.put(ERRCODE, 0);
        try {
            // 参数校验
            if(pager == null || pager.getCurrentPage() == null) {
                result.put(ERRMESSAGE, "微访谈ID为空！");
            }

            List<ViewVo> viewList = viewService.getViewList(pager);

            result.put(ERRCODE, 1);
            result.put(ERRMESSAGE, "获取微访谈话题列表成功！");
            result.put(DATA, viewList);
        }catch (Exception e){
            logger.error("获取微访谈话题列表失败:" + e.getMessage());
            result.put(ERRMESSAGE, "获取微访谈话题列表失败!");
        }
        return result;
    }

    /**
     * 查看微访谈详情
     * @param microViewId
     * @return
     */
    @RequestMapping(value = "microViewId")
    public Map<String, Object> viewDetail(Long microViewId,HttpServletRequest request){
        Map<String, Object> result = Maps.newHashMap();
        result.put(ERRCODE, 0);
        try {
            // 参数校验
            if(microViewId == null) {
                result.put(ERRMESSAGE, "微访谈ID为空！");
            }

            ViewVo viewVo = viewService.viewDetail(microViewId, getLawyerId(request));

            result.put(ERRCODE, 1);
            result.put(ERRMESSAGE, "查看微访谈详情成功！");
            result.put(DATA, viewVo);
        }catch (Exception e){
            logger.error("查看微访谈详情失败:" + e.getMessage());
            result.put(ERRMESSAGE, "查看微访谈详情失败!");
        }
        return result;
    }

    /**
     * 关注微访谈
     * @param microViewId
     * @return
     */
    @RequestMapping(value = "attentionView")
    public Map<String, Object> viewAttention(HttpServletRequest request,Long microViewId){
        Map<String, Object> result = Maps.newHashMap();
        result.put(ERRCODE, 0);
        try {
            // 参数校验
            if(microViewId == null) {
                result.put(ERRMESSAGE, "微访谈ID为空！");
            }

            viewService.viewAttention(microViewId,getLawyerId(request));

            result.put(ERRCODE, 1);
            result.put(ERRMESSAGE, "关注微访谈成功！");
        }catch (Exception e){
            logger.error("关注微访谈失败:" + e.getMessage());
            result.put(ERRMESSAGE, "关注微访谈失败!");
        }
        return result;
    }

    /**
     * 微访谈讨论内容
     * @param microViewId
     * @param content
     * @param type
     * @return
     */
    @RequestMapping(value = "viewDiscuss")
    public Map<String, Object> viewDiscuss(HttpServletRequest request,Long microViewId, String content, Integer type){
        Map<String, Object> result = Maps.newHashMap();
        result.put(ERRCODE, 0);
        try {
            // 参数校验
            if(microViewId == null || StringUtils.isEmpty(content) || type == null) {
                result.put(ERRMESSAGE, "微访谈ID或者讨论内容、类型为空！");
            }

            viewService.viewDiscuss(getLawyer(request),microViewId,content,type);

            result.put(ERRCODE, 1);
            result.put(ERRMESSAGE, "微访谈讨论成功！");
        }catch (Exception e){
            logger.error("微访谈讨论失败:" + e.getMessage());
            result.put(ERRMESSAGE, "微访谈讨论失败!");
        }
        return result;
    }

    /**
     * 访谈讨论点赞
     * @param discussId
     * @return
     */
    @RequestMapping(value = "discussPraise")
    public Map<String, Object> discussPraise(HttpServletRequest request,Long discussId){
        Map<String, Object> result = Maps.newHashMap();
        result.put(ERRCODE, 0);
        try {
            // 参数校验
            if(discussId == null) {
                result.put(ERRMESSAGE, "讨论ID为空！");
            }

            viewService.discussPraise(discussId,getLawyerId(request));

            result.put(ERRCODE, 1);
            result.put(ERRMESSAGE, "访谈讨论点赞成功！");
        }catch (Exception e){
            logger.error("访谈讨论点赞失败:" + e.getMessage());
            result.put(ERRMESSAGE, "访谈讨论点赞失败!");
        }
        return result;
    }
}
