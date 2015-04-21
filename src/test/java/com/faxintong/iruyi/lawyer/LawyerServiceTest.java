package com.faxintong.iruyi.lawyer;

import com.faxintong.iruyi.base.BaseTest;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.vo.CityVo;
import com.faxintong.iruyi.model.mybatis.vo.LawyerVo;
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
        pager.setPageSize(2);
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

}
