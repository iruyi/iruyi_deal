package com.faxintong.iruyi.lawyer;

import com.faxintong.iruyi.base.BaseTest;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.vo.CityVo;
import com.faxintong.iruyi.model.mybatis.vo.LawyerVo;
import com.faxintong.iruyi.model.mybatis.vo.TopicVo;
import com.faxintong.iruyi.service.lawyer.LawyerService;
import com.faxintong.iruyi.service.lawyer.UserService;
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
            List<LawyerVo> lawyerVoList = lawyerService.getAttetionList(pager,1L);
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
            List<TopicVo> topicVoList = lawyerService.getAttetionTopics(pager,28L);
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
            List<TopicVo> topicVoList = lawyerService.getReportTopics(pager,1L);
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

}
