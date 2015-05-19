package com.faxintong.iruyi.positon;

import com.faxintong.iruyi.base.BaseTest;
import com.faxintong.iruyi.model.mybatis.vo.PositionVo;
import com.faxintong.iruyi.service.position.PositionService;
import com.faxintong.iruyi.utils.Pager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by yunaxie on 2015/4/21.
 */
public class PositionServiceTest extends BaseTest{
    @Autowired
    private PositionService positionService;

    static Pager pager;
    {
        pager = new Pager();
        pager.setCurrentPage(1);
        pager.setPageSize(2);
    }

    @Test
    public void testGetPositionList() {
        try {
            List<PositionVo> positionVoList = positionService.getPositionList(pager);
            for(PositionVo positionVo : positionVoList) {
                System.out.println(positionVo.getOfficeName() + "招聘律师 \n"
                    + "薪水：" + positionVo.getSalary() + "\n"
                                + "地点:" + positionVo.getCityName()
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPositionDetail() {
        try {
            PositionVo positionVo = positionService.positionDetail(1L,1L);
            System.out.println(positionVo.getOfficeName() + "招聘,title:" + positionVo.getTitle()
            +"\n content:" + positionVo.getContent() + "\n 我是否关注：" + positionVo.getIsCollection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetStoreList() {
        try {
            List<PositionVo> positionVoList = positionService.getStoreList(pager, 1L);
            for(PositionVo v : positionVoList) {
                System.out.println(v.getOfficeName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
