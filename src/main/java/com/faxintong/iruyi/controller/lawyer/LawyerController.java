package com.faxintong.iruyi.controller.lawyer;

import com.faxintong.iruyi.controller.BaseController;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.vo.CityVo;
import com.faxintong.iruyi.model.mybatis.vo.LawyerVo;
import com.faxintong.iruyi.model.mybatis.vo.ReplyVo;
import com.faxintong.iruyi.service.lawyer.LawyerService;
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
import java.util.Map;

import static com.faxintong.iruyi.utils.Constants.DATA;

/**
 * Created by admin on 15-4-18.
 */
@RestController
@RequestMapping("lawyer")
public class LawyerController extends BaseController{
    private Logger logger = LoggerFactory.getLogger(LawyerController.class);
    @Autowired
    private LawyerService lawyerService;

    /**
     * 获取个人信息
     * @return
     */
    @RequestMapping(value = "getLawyerInfo")
    public Map<String, Object> getLawyerInfo(){

        return null;
    }

    /**
     * 获取关注律师列表(黑白名单用)
     * @return
     */
    @RequestMapping(value = "getAttetionList")
    public String getAttetionList(Pager pager,ModelMap modelMap,HttpServletRequest request,HttpServletResponse response){
        try {
            if(pager == null || pager.getCurrentPage() == null){
                ServletUtils.responseJson(response, new Result(0, "当前页为null！"));
                return null;
            }

            List<LawyerVo> lawyerVoList = lawyerService.getAttetionList(pager,getLawyerId(request));
            modelMap.put(DATA,lawyerVoList);
            resultModelMap(1,"获取我关注的律师列表成功！",modelMap);

            return "lawyer/getAttetionList";
        } catch (Exception e) {
            logger.error("获取我关注的律师列表失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(0, "获取我关注的律师列表失败！"));
        }
        return null;
    }

    /**
     * 获取城市
     * @param pager
     * @return
     */
    @RequestMapping(value = "getCityList")
    public String getCityList(Pager pager,ModelMap modelMap,HttpServletRequest request,HttpServletResponse response){
        try {
            if(pager == null || pager.getCurrentPage() == null){
                ServletUtils.responseJson(response, new Result(0, "当前页为null！"));
                return null;
            }

            List<CityVo> cityVoList = lawyerService.getCityList(pager);
            modelMap.put(DATA,cityVoList);
            resultModelMap(1,"获取城市列表成功！",modelMap);

            return "city/getCityList";
        } catch (Exception e) {
            logger.error("获取城市列表失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(0, "获取城市列表失败！"));
        }
        return null;
    }

    /**
     * 获取个人资料
     * @return
     * 个人主页的个人信息
     */
    @RequestMapping(value = "getMaterialt")
    public Map<String, Object> getMaterialt(){

        return null;
    }

    /**
     * 我发表的商机列表
     * @param pager
     * @return
     */
    @RequestMapping(value = "getOrderList")
    public Map<String, Object> getOrderList(Pager pager){

        return null;
    }

    /**
     * 获取我感兴趣的商机
     * @param pager
     * @return
     */
    @RequestMapping(value = "getReceiveOrders")
    public Map<String, Object> getReceiveOrders(Pager pager){

        return null;
    }

    /**
     * 我发布的话题列表
     * @param pager
     * @return
     */
    @RequestMapping(value = "getReportTopics")
    public Map<String, Object> getReportTopics(Pager pager){

        return null;
    }

    /**
     * 我回应的话题列表
     * @param pager
     * @return
     */
    @RequestMapping(value = "getReplyTopics")
    public String getReplyTopics(Pager pager,ModelMap modelMap,HttpServletRequest request,HttpServletResponse response){
        try {
            if(pager == null || pager.getCurrentPage() == null){
                ServletUtils.responseJson(response, new Result(0, "当前页为null！"));
                return null;
            }

            Lawyer lawyer = getLawyer(request);
            List<ReplyVo> replyVoList = lawyerService.getReplyTopics(pager,lawyer.getId());
            modelMap.put(DATA,replyVoList);
            modelMap.put("lawyer",lawyer);
            resultModelMap(1,"获取我回应的话题列表成功！",modelMap);

            return "lawyer/getReplyTopics";
        } catch (Exception e) {
            logger.error("获取我回应的话题列表失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(0, "获取我回应的话题列表失败！"));
        }
        return null;
    }

    /**
     * 获取我关注的话题列表
     * @param pager
     * @return
     */
    @RequestMapping(value = "getAttetionTopics")
    public Map<String, Object> getAttetionTopics(Pager pager){

        return null;
    }

    /**
     * 赞过的话题回应列表
     * @param pager
     * @return
     */
    @RequestMapping(value = "praiseTopicReplyList")
    public String praiseTopicReplyList(Pager pager,ModelMap modelMap,HttpServletRequest request,HttpServletResponse response){
        try {
            if(pager == null || pager.getCurrentPage() == null){
                ServletUtils.responseJson(response, new Result(0, "当前页为null！"));
                return null;
            }

            Lawyer lawyer = getLawyer(request);
            List<ReplyVo> replyVoList = lawyerService.praiseTopicReplyList(pager, lawyer.getId());
            modelMap.put(DATA,replyVoList);
            modelMap.put("lawyer",lawyer);
            resultModelMap(1,"获取我赞过的话题回应列表成功！",modelMap);

            return "lawyer/praiseTopicReplyList";
        } catch (Exception e) {
            logger.error("获取我赞过的话题回应列表失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(0, "获取我赞过的话题回应列表失败！"));
        }
        return null;
    }

    /**
     * 我发布的文章列表
     * @param pager
     * @return
     */
    @RequestMapping(value = "getReportArticles")
    public Map<String, Object> getReportArticles(Pager pager){

        return null;
    }

    /**
     * 我收藏的文章列表
     * @param pager
     * @return
     */
    @RequestMapping(value = "getStoreArticles")
    public Map<String, Object> getStoreArticles(Pager pager){

        return null;
    }

    /**
     * 获取赞过的文章评论列表
     * @param pager
     * @return
     */
    @RequestMapping(value = "praiseArticleComments")
    public Map<String, Object> praiseArticleComments(Pager pager){

        return null;
    }

    /**
     * 获取我收藏的获取
     * @param pager
     * @return
     */
    @RequestMapping(value = "getStoreActives")
    public Map<String, Object> getStoreActives(Pager pager){

        return null;
    }
}
