package com.faxintong.iruyi.controller.lawyer;

import com.faxintong.iruyi.utils.Pager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by admin on 15-4-18.
 */
@RestController
@RequestMapping("lawyer")
public class LawyerController {

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
    public Map<String, Object> getAttetionList(Pager pager){

        return null;
    }

    /**
     * 获取城市
     * @param pager
     * @return
     */
    @RequestMapping(value = "getCityList")
    public Map<String, Object> getCityList(Pager pager){

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
    public Map<String, Object> getReplyTopics(Pager pager){

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
    public Map<String, Object> praiseTopicReplyList(Pager pager){

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
