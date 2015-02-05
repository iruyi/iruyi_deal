package com.faxintong.iruyi.order;

import com.faxintong.iruyi.base.BaseTest;
import com.faxintong.iruyi.model.general.order.GeneralOrder;
import com.faxintong.iruyi.model.mybatis.order.Order;
import com.faxintong.iruyi.service.order.receive.ReceiveService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by hehj on 15-1-15.
 */
public class ReceiveServiceTest extends BaseTest {

    @Autowired
    private ReceiveService receiveService;

    @Test
    public void testFindAvailableOrders(){
        try {
            Long lawyerId = 5l;
            List<GeneralOrder> orderList = receiveService.findAvailReceiveOrders(lawyerId);
            for(GeneralOrder order : orderList){
                System.out.println("匹配的单子：" + order.getTitle() + " " +order.getCityName() + " " + order.getDescription());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConfirmOrder(){
        try {
            Long orderId = 2l;
            Long lawyerId = 3l;
            receiveService.confirmOrder(orderId, lawyerId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
     public void testRevokeOrder(){
        try {
            Long orderId = 2l;
            Long lawyerId = 3l;
            receiveService.revokeOrder(orderId, lawyerId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCancelOrder(){
        try {
            Long orderId = 2l;
            Long lawyerId = 3l;
            receiveService.cancelOrder(orderId, lawyerId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
