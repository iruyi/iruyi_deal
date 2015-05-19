package com.faxintong.iruyi.controller.lawyer;

import com.faxintong.iruyi.controller.BaseController;
import com.faxintong.iruyi.model.mybatis.article.AppArticle;
import com.faxintong.iruyi.model.mybatis.article.ArticleComment;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.vo.*;
import com.faxintong.iruyi.service.lawyer.LawyerService;
import com.faxintong.iruyi.service.topic.TopicService;
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
@RequestMapping("lawyer")
public class LawyerController extends BaseController{
    private Logger logger = LoggerFactory.getLogger(LawyerController.class);
    @Autowired
    private LawyerService lawyerService;
    @Autowired
    private TopicService topicService;

    /**
     * 获取个人信息
     * @return
     */
    @RequestMapping(value = "getLawyerInfo")
    public String getLawyerInfo(Long lawyerId,Pager pager,ModelMap modelMap,HttpServletRequest request,HttpServletResponse response){
        try {
            if(lawyerId == null){
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "律师ID不能为空！"));
                return null;
            }

            if(pager == null || pager.getCurrentPage() == null){
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "当前页为null！"));
                return null;
            }

            if(pager.getCurrentPage() == 1 ){
                LawyerVo lawyerVo = lawyerService.getMaterialt(lawyerId);
                modelMap.put("lawyerInfo", lawyerVo);
            }

            List<TopicAllVo> topicAllVoList = topicService.topicAll(pager, lawyerId, getLawyerId(request),null);
            modelMap.put(DATA,topicAllVoList);
            resultModelMap(RESULTSUCCESS,"获取律师信息成功！",modelMap);

            return "lawyer/getLawyerInfo";
        } catch (Exception e) {
            logger.error("获取律师信息失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "获取律师信息失败！"));
        }
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
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "当前页为null！"));
                return null;
            }

            List<LawyerVo> lawyerVoList = lawyerService.getAttetionList(pager, getLawyerId(request));
            modelMap.put(DATA,lawyerVoList);
            resultModelMap(RESULTSUCCESS,"获取我关注的律师列表成功！",modelMap);

            return "lawyer/getAttetionList";
        } catch (Exception e) {
            logger.error("获取我关注的律师列表失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "获取我关注的律师列表失败！"));
        }
        return null;
    }

    /**
     * 获取城市
     * @param pager
     * @return
     */
    @RequestMapping(value = "getCityList")
    public String getCityList(Pager pager,ModelMap modelMap,HttpServletResponse response){
        try {
            if(pager == null || pager.getCurrentPage() == null){
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "当前页为null！"));
                return null;
            }

            List<CityVo> cityVoList = lawyerService.getCityList(pager);
            modelMap.put(DATA,cityVoList);
            resultModelMap(RESULTSUCCESS,"获取城市列表成功！",modelMap);

            return "city/getCityList";
        } catch (Exception e) {
            logger.error("获取城市列表失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "获取城市列表失败！"));
        }
        return null;
    }

    /**
     * 获取个人资料
     * @return
     * 个人主页的个人信息
     */
    @RequestMapping(value = "getMaterialt")
    public String getMaterialt(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response){
        try {

            LawyerVo lawyerVo = lawyerService.getMaterialt(getLawyerId(request));
            modelMap.put(DATA, lawyerVo);
            resultModelMap(RESULTSUCCESS,"获取个人资料成功！",modelMap);
            return "lawyer/getMaterialt";
        } catch (Exception e) {
            logger.error("获取个人资料失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "获取个人资料失败！"));
        }
        return null;
    }

    /**
     * 我发表的商机列表
     * @param pager
     * @return
     */
    @RequestMapping(value = "getOrderList")
    public String getOrderList(Pager pager,ModelMap modelMap,HttpServletRequest request,HttpServletResponse response){
        try {
            if(pager == null || pager.getCurrentPage() == null){
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "当前页为null！"));
                return null;
            }

            List<OrderVo> orderList = lawyerService.getOrderList(pager, getLawyerId(request));
            modelMap.put(DATA,orderList);
            resultModelMap(RESULTSUCCESS,"获取我发表的商机列表成功！",modelMap);

            return "order/getOrderList";
        } catch (Exception e) {
            logger.error("获取城市列表失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "获取城市列表失败！"));
        }
        return null;
    }

    /**
     * 获取我感兴趣的商机
     * @param pager
     * @return
     */
    @RequestMapping(value = "getReceiveOrders")
    public String getReceiveOrders(Pager pager,ModelMap modelMap,HttpServletRequest request,HttpServletResponse response){
        try {
            if(pager == null || pager.getCurrentPage() == null){
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "当前页为null！"));
                return null;
            }

            List<OrderReceiveVo> orderReceiveVoList = lawyerService.getReceiveOrders(pager, getLawyerId(request));
            modelMap.put(DATA,orderReceiveVoList);
            resultModelMap(RESULTSUCCESS,"获取我感兴趣的商机列表成功！",modelMap);

            return "lawyer/getReceiveOrders";
        } catch (Exception e) {
            logger.error("获取我感兴趣的商机列表失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "获取我感兴趣的商机列表失败！"));
        }
        return null;
    }

    /**
     * 我发布的话题列表
     * @param pager
     * @return
     */
    @RequestMapping(value = "getReportTopics")
    public String getReportTopics(Pager pager,ModelMap modelMap,HttpServletRequest request,HttpServletResponse response){
        try {
            if(pager == null || pager.getCurrentPage() == null){
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "当前页为null！"));
                return null;
            }

            List<TopicVo> topicVoList = lawyerService.getReportTopics(pager, getLawyerId(request));
            modelMap.put(DATA,topicVoList);
            resultModelMap(RESULTSUCCESS,"获取我发布的话题列表成功！",modelMap);

            return "lawyer/getReportTopics";

        } catch (Exception e) {
            logger.error("获取我发布的话题列表成功:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "获取我发布的话题列表成功！"));
        }
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
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "当前页为null！"));
                return null;
            }

            Lawyer lawyer = getLawyer(request);
            List<ReplyVo> replyVoList = lawyerService.getReplyTopics(pager,lawyer.getId());
            modelMap.put(DATA,replyVoList);
            modelMap.put("lawyer",lawyer);
            resultModelMap(RESULTSUCCESS,"获取我回应的话题列表成功！",modelMap);

            return "lawyer/getReplyTopics";
        } catch (Exception e) {
            logger.error("获取我回应的话题列表失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "获取我回应的话题列表失败！"));
        }
        return null;
    }

    /**
     * 获取我关注的话题列表
     * @param pager
     * @return
     */
    @RequestMapping(value = "getAttetionTopics")
    public String getAttetionTopics(Pager pager,ModelMap modelMap,HttpServletRequest request,HttpServletResponse response){
        try {
            if(pager == null || pager.getCurrentPage() == null){
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "当前页为null！"));
                return null;
            }

            Lawyer lawyer = getLawyer(request);
            List<TopicVo> topicVoList = lawyerService.getAttetionTopics(pager, lawyer.getId());
            modelMap.put(DATA,topicVoList);
            resultModelMap(RESULTSUCCESS,"获取我关注的话题列表成功！",modelMap);

            return "lawyer/getReportTopics";
        } catch (Exception e) {
            logger.error("获取我关注的话题列表失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "获取我关注的话题列表失败！"));
        }
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
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "当前页为null！"));
                return null;
            }

            Lawyer lawyer = getLawyer(request);
            List<ReplyVo> replyVoList = lawyerService.praiseTopicReplyList(pager, lawyer.getId());
            modelMap.put(DATA,replyVoList);
            modelMap.put("lawyer",lawyer);
            resultModelMap(RESULTSUCCESS,"获取我赞过的话题回应列表成功！",modelMap);

            return "lawyer/praiseTopicReplyList";
        } catch (Exception e) {
            logger.error("获取我赞过的话题回应列表失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "获取我赞过的话题回应列表失败！"));
        }
        return null;
    }

    /**
     * 我发布的文章列表
     * @param pager
     * @return
     */
    @RequestMapping(value = "getReportArticles")
    public String getReportArticles(HttpServletRequest request, Pager pager, ModelMap modelMap){
        modelMap.put(ERRCODE, RESULTFAIL);
        try {
            if(pager == null || pager.getCurrentPage() == null){
                modelMap.put(ERRMESSAGE, "当前页为null");
            }else{
                List<AppArticleVo> list = lawyerService.getReportArticles(pager, getLawyerId(request));
                modelMap.put(ERRCODE, RESULTSUCCESS);
                modelMap.put(ERRMESSAGE, "获取文章列表成功！");
                modelMap.put(DATA, list);
            }
        }catch (Exception e){
            logger.error("获取文章列表失败:" + e.getMessage());
            modelMap.put(ERRMESSAGE, "获取文章列表失败!");
        }
        return "article/articleList";
    }

    /**
     * 我收藏的文章列表
     * @param pager
     * @return
     */
    @RequestMapping(value = "getStoreArticles")
    public String getStoreArticles(HttpServletRequest request, Pager pager, ModelMap modelMap){
        modelMap.put(ERRCODE, RESULTFAIL);
        try {
            if(pager == null || pager.getCurrentPage() == null){
                modelMap.put(ERRMESSAGE, "当前页为null");
            }else{
                List<AppArticle> list = lawyerService.getStoreArticles(pager, getLawyerId(request));
                modelMap.put(ERRCODE, RESULTSUCCESS);
                modelMap.put(ERRMESSAGE, "获取收藏文章列表成功！");
                modelMap.put(DATA, list);
            }
        }catch (Exception e){
            logger.error("获取收藏文章列表失败:" + e.getMessage());
            modelMap.put(ERRMESSAGE, "获取收藏文章列表失败!");
        }
        return "article/articleList";
    }

    /**
     * 获取赞过的文章评论列表
     * @param pager
     * @return
     */
    @RequestMapping(value = "praiseArticleComments")
    public String praiseArticleComments(HttpServletRequest request, Pager pager, ModelMap modelMap){
        modelMap.put(ERRCODE, RESULTFAIL);
        try {
            if(pager == null || pager.getCurrentPage() == null){
                modelMap.put(ERRMESSAGE, "当前页为null");
            }else{
                List<ArticleComment> list = lawyerService.praiseArticleComments(pager, getLawyerId(request));
                modelMap.put(ERRCODE, RESULTSUCCESS);
                modelMap.put(ERRMESSAGE, "获取赞过的文章评论列表成功！");
                modelMap.put(DATA, list);
            }
        }catch (Exception e){
            logger.error("获取赞过的文章评论列表失败:" + e.getMessage());
            modelMap.put(ERRMESSAGE, "获取赞过的文章评论列表失败!");
        }
        return "";
    }

    /**
     * 获取我收藏的活动
     * @param pager
     * @return
     */
    @RequestMapping(value = "getStoreActives")
    public String getStoreActives(HttpServletRequest request, Pager pager, ModelMap modelMap){
        modelMap.put(ERRCODE, RESULTFAIL);
        try {
            if(pager == null || pager.getCurrentPage() == null){
                modelMap.put(ERRMESSAGE, "当前页为null");
            }else{
                List<ActiveVo> list = lawyerService.getStoreActives(pager, getLawyerId(request));
                modelMap.put(ERRCODE, RESULTSUCCESS);
                modelMap.put(ERRMESSAGE, "获取收藏活动列表成功！");
                modelMap.put(DATA, list);
            }
        }catch (Exception e){
            logger.error("获取收藏活动列表失败:" + e.getMessage());
            modelMap.put(ERRMESSAGE, "获取收藏活动列表失败!");
        }
        return "active/getActiveList";
    }

    /**
     * 获取推荐人列表
     * @param request
     * @param pager
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "findHotLawyers")
    public String findHotLawyers(HttpServletRequest request, Pager pager, ModelMap modelMap){
        modelMap.put(ERRCODE, RESULTFAIL);
        try {
            if(pager == null || pager.getCurrentPage() == null){
                modelMap.put(ERRMESSAGE, "当前页为null");
            }else{
                List<Lawyer> list = lawyerService.findHotLawyers(pager);
                modelMap.put(ERRCODE, RESULTSUCCESS);
                modelMap.put(ERRMESSAGE, "获取推荐人列表成功！");
                modelMap.put(DATA, list);
            }
        }catch (Exception e){
            logger.error("获取推荐人列表失败:" + e.getMessage());
            modelMap.put(ERRMESSAGE, "获取推荐人列表失败!");
        }
        return "lawyer/getHotLawyers";
    }
}
