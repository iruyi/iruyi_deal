package com.faxintong.iruyi.lawyer;

import com.faxintong.iruyi.base.BaseTest;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.service.lawyer.LawyerService;
import com.faxintong.iruyi.utils.Pager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by bochenlong on 2015/4/19.
 */
public class LawyerServiceTest extends BaseTest{
    @Autowired
    private LawyerService lawyerService;
    private Pager pager;

    @Test
    public void testGetAttetionList() {
        try {
            initParams();
            List<Lawyer> lawyerList = lawyerService.getAttetionList(pager,1L);
            System.out.println(lawyerList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initParams() {
        pager = new Pager();
        pager.setPageSize(2);
        pager.setCurrentPage(1);
    }
}
