package com.faxintong.iruyi.active;

import com.faxintong.iruyi.base.BaseTest;
import com.faxintong.iruyi.model.mybatis.article.AppArticle;
import com.faxintong.iruyi.model.mybatis.vo.ActiveVo;
import com.faxintong.iruyi.service.active.ActiveService;
import com.faxintong.iruyi.service.lawyer.LawyerService;
import com.faxintong.iruyi.utils.Pager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by admin on 15-4-19.
 */
public class ActiveServiceTest extends BaseTest {

    @Autowired
    private ActiveService activeService;

    @Autowired
    private LawyerService lawyerService;

    @Test
    public void testGetActiveList(){
        Pager pager = new Pager();
        pager.setCurrentPage(1);
        try {
            List<ActiveVo> list = activeService.getActiveList(pager);
            System.out.println("========================list size="+list.size());
            System.out.println("========================第"+pager.getCurrentPage()+"页");
            //点赞数
            for(ActiveVo active : list){
                System.out.println(active.getId()+"===" +active.getPhotoUrl()+"===" + active.getPraiseCount());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetActiveDetail(){
        Pager pager = new Pager();
        pager.setCurrentPage(2);
        try {
            ActiveVo active = activeService.getActiveDetail(1l);
            System.out.println(active.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testActiveStore(){
        try {
            activeService.activeStore(1l, 1l);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetReportArticles(){
        try {
            Pager pager = new Pager();
            pager.setCurrentPage(1);
            List<AppArticle> list = lawyerService.getReportArticles(pager, 1l);
            System.out.println("=======list size=" + list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getStoreActives(){
        Pager pager = new Pager();
        pager.setCurrentPage(1);
        try {
            List<ActiveVo> list = lawyerService.getStoreActives(pager, 1l);
            System.out.println("========================list size="+list.size());
            System.out.println("========================第"+pager.getCurrentPage()+"页");
            //点赞数
            for(ActiveVo active : list){
                System.out.println(active.getId()+"===" +active.getPhotoUrl()+"===" + active.getPraiseCount());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
