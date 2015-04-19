package com.faxintong.iruyi.active;

import com.faxintong.iruyi.base.BaseTest;
import com.faxintong.iruyi.model.mybatis.active.Active;
import com.faxintong.iruyi.service.active.ActiveService;
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

    @Test
    public void testgetActiveList(){
        Pager pager = new Pager();
        pager.setCurrentPage(2);
        try {
            List<Active> list = activeService.getActiveList(pager);
            System.out.println("========================list size="+list.size());
            System.out.println("========================第"+pager.getCurrentPage()+"页");
            for(Active active : list){
                System.out.println(active.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
