package com.faxintong.iruyi.order;

import com.faxintong.iruyi.base.BaseTest;
import com.faxintong.iruyi.model.mybatis.vo.OrderVo;
import com.faxintong.iruyi.model.mybatis.vo.PositionVo;
import com.faxintong.iruyi.service.Position.PositionService;
import com.faxintong.iruyi.service.order.OrderService;
import com.faxintong.iruyi.utils.Pager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by yunaxie on 2015/4/21.
 */
public class OrderServiceTest extends BaseTest{
    @Autowired
    private OrderService orderService;

    static Pager pager;
    {
        pager = new Pager();
        pager.setCurrentPage(1);
        pager.setPageSize(10);
    }

    @Test
    public void testGetPositionList() {
        try {
            List<OrderVo> orderList = orderService.getOrderList(pager,1L);
            for(OrderVo v : orderList) {
                System.out.println(v.getId() + "标题：" + v.getTitle() + "\n" +
                                "类型：" + v.getType() + "\n" +
                                "内容：" + v.getContent() + "\n" +
                     "地点：" + v.getCityName() + "\n"
                                + "关注数:" + v.getInterestCount() + "\n" +
                                "1L 是否关注" + v.getIsInterest()
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testOrderDetail() {
        try {
            OrderVo v = orderService.orderDetail(null, 28L);
                System.out.println("粉丝：" + v.getFansCount() + "\n" +
                                "发布数量：" + v.getIssueCount() + "\n" +
                                "感兴趣的数量：" + v.getInterestCount() + "\n"
                );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
