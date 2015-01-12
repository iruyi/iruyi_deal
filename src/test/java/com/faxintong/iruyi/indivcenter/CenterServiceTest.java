package com.faxintong.iruyi.indivcenter;

import com.faxintong.iruyi.base.BaseTest;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.service.indivcenter.CenterService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hehj on 15-1-12.
 */
public class CenterServiceTest extends BaseTest {

    @Autowired
    private CenterService centerService;

    @Test
    public void testFindLawyerById(){
        Long lawyerId = 2l;
        try {
            Lawyer lawyer = centerService.findLawyerById(lawyerId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
