package com.faxintong.iruyi.lawyer;

import com.faxintong.iruyi.base.BaseTest;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.order.OrderReceive;
import com.faxintong.iruyi.model.mybatis.vo.*;
import com.faxintong.iruyi.service.lawyer.LawyerService;
import com.faxintong.iruyi.service.lawyer.UserService;
import com.faxintong.iruyi.service.order.OrderService;
import com.faxintong.iruyi.utils.MD5;
import com.faxintong.iruyi.utils.Pager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ron on 2015/1/29.
 */
public class LawyerServiceTest extends BaseTest {

    @Autowired
    private LawyerService lawyerService;


    static Pager pager;
    {
        pager = new Pager();
        pager.setCurrentPage(1);
        pager.setPageSize(10);
    }

    @Test
    public void testGetLawyerInfo() {
        try {
            LawyerVo lawyerVo =lawyerService.getLawyerInfo(1L);
            System.out.println(lawyerVo.getName()+",地点：" + lawyerVo.getCityName() + ",粉丝数:" + lawyerVo.getFansCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetAttetionList() {
        try {
            List<LawyerVo> lawyerVoList = lawyerService.getAttetionList(pager, 1L);
            for(LawyerVo v: lawyerVoList) {
                System.out.println("1 关注了" + v.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetCityList() {
        try {
            List<CityVo> cityVoList = lawyerService.getCityList(pager);
            for(CityVo cityVo:cityVoList) {
                System.out.println(cityVo.getId() + "||||" + cityVo.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetAttetionTopics() {
        try {
            List<TopicVo> topicVoList = lawyerService.getAttetionTopics(pager, 28L);
            for(TopicVo v: topicVoList) {
                System.out.println("28 律师关注的话题：");
                System.out.println(v.getContent() + "\n" +
                                "是否点赞：" + v.getIsPraise() + "\n" +
                                "点赞总数: " + v.getPraiseCount() + "\n" +
                                "话题作者：" + v.getLawyerName()
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetReportTopics() {
        try {
            List<TopicVo> topicVoList = lawyerService.getReportTopics(pager, 1L);
            for(TopicVo v: topicVoList) {
                System.out.println("1L 律师发布的话题：");
                System.out.println(v.getContent() + "\n" +
                                "是否点赞：" + v.getIsPraise() + "\n" +
                                "点赞总数: " + v.getPraiseCount() + "\n" +
                                "话题作者：" + v.getLawyerName()
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetOrderList() {
        try {
            List<OrderVo> vs = lawyerService.getOrderList(pager, 28L);
            for(OrderVo v : vs) {
                System.out.println("商机title：" + v.getTitle() + "\n" +
                                "商机content：" + v.getContent() + "\n" +
                                "感兴趣的数量：" + v.getInterestCount() + "\n"
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetReceiveOrders() {
        try {
            List<OrderReceiveVo> vs = lawyerService.getReceiveOrders(pager,11L);
            for(OrderReceiveVo v : vs) {
                System.out.println("律师：" + v.getLawyerName() + " 留言：" + v.getContent() + "\n" +
                        "商机title：" + v.getOrderVo().getTitle() + "\n" +
                                "商机content：" + v.getOrderVo().getContent() + "\n"
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetReplyTopics() {
        try{
            List<ReplyVo> vs = lawyerService.getReplyTopics(pager, 1L);
            for(ReplyVo v : vs) {
                System.out.println("回复内容：" + v.getContent() + " \n 话题内容：" + v.getTopicVo().getContent() + "\n" +
                                "回复时间：" + v.getCreateDate() + "\n"
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
