package com.faxintong.iruyi.controller.discuss;

import com.faxintong.iruyi.controller.BaseController;
import com.faxintong.iruyi.model.mybatis.vo.TopicAllVo;
import com.faxintong.iruyi.service.discuss.DiscussService;
import com.faxintong.iruyi.utils.Pager;
import com.faxintong.iruyi.utils.Result;
import com.faxintong.iruyi.utils.ServletUtils;
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
@RequestMapping("discuss")
public class DiscussController extends BaseController{
    private Logger logger = LoggerFactory.getLogger(DiscussController.class);
    @Autowired
    private DiscussService discussService;

    /**
     * 获取讨论列表
     * @param pager
     * @return
     */
    @RequestMapping(value = "getDiscussList")
    public String getDiscussList(Pager pager,HttpServletResponse response,ModelMap modelMap,HttpServletRequest request){
        try {
            // 参数校验
            if(pager == null || pager.getCurrentPage() == null) {
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "当前页为null"));
                return null;
            }

            List<TopicAllVo> topicAllVoList = discussService.getDiscussList(pager,getLawyerId(request), null, null);

            modelMap.put(DATA, topicAllVoList);
            resultModelMap(RESULTSUCCESS,"获取讨论列表成功！",modelMap);

            return "topic/getDiscussList";
        }catch (Exception e){
            logger.error("获取讨论列表失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "获取讨论列表失败!"));
        }
        return null;
    }

    /**
     * 获取讨论列表
     * @param pager
     * @return
     */
    @RequestMapping(value = "searchDiscuss")
    public String searchDiscuss(Pager pager, String title, String content, HttpServletResponse response,ModelMap modelMap,HttpServletRequest request){
        try {
            // 参数校验
            if(pager == null || pager.getCurrentPage() == null) {
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "当前页为null"));
                return null;
            }
            List<TopicAllVo> topicAllVoList = discussService.getDiscussList(pager,getLawyerId(request), title, content);
            modelMap.put(DATA, topicAllVoList);
            resultModelMap(RESULTSUCCESS,"搜索讨论列表成功！",modelMap);

            return "topic/getDiscussList";
        }catch (Exception e){
            logger.error("搜索讨论列表失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "搜索讨论列表失败!"));
        }
        return null;
    }

}
