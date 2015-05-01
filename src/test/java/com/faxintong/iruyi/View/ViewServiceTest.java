package com.faxintong.iruyi.View;

import com.faxintong.iruyi.base.BaseTest;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.vo.ViewDiscussVo;
import com.faxintong.iruyi.model.mybatis.vo.ViewVo;
import com.faxintong.iruyi.service.lawyer.UserService;
import com.faxintong.iruyi.service.microview.ViewService;
import com.faxintong.iruyi.utils.Pager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by bochenlong on 2015/4/20.
 */
public class ViewServiceTest extends BaseTest {
    @Autowired
    private ViewService viewService;
    @Autowired
    private UserService userService;

    static Pager pager;
    {
        pager = new Pager();
        pager.setCurrentPage(1);
        pager.setPageSize(2);
    }

    @Test
    public void testViewDetail() {
        try {
            ViewVo viewVo = viewService.viewDetail(1L,28L,pager);
            System.out.println("律师简介：" + viewVo.getIntroduction() + ",粉丝数" + viewVo.getFansCount());
            for(ViewDiscussVo viewDiscussVo : viewVo.getViewDiscussVoList()) {
                System.out.println(viewDiscussVo.getContent()+","+viewDiscussVo.getPraiseCount());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetViewList() {
        try {
            List<ViewVo> viewList = viewService.getViewList(pager,1L);
            for(ViewVo v : viewList) {
                System.out.println("微访谈：" + v.getTitle() +"||" +v.getContent());
                System.out.println("作者：" + v.getLawyerName() + "是否结束" + v.getIsLive());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testViewAttention() {
        try {
            viewService.viewAttention(1L,28L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testViewDiscuss() {
        try {
            Lawyer lawyer = userService.getLawyerByPrimaryKey(28L);
            viewService.viewDiscuss(lawyer,1L,"hello bochenlong",1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDiscussPraise() {
        try {
            viewService.discussPraise(1L,1L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
