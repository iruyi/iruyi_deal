package com.faxintong.iruyi.service.order.receive.impl;

import com.faxintong.iruyi.dao.general.order.OrderGeneralMapper;
import com.faxintong.iruyi.dao.general.order.ReceiveGeneralMapper;
import com.faxintong.iruyi.dao.mybatis.order.ReceiveOrderMapper;
import com.faxintong.iruyi.model.mybatis.order.Order;
import com.faxintong.iruyi.model.mybatis.order.ReceiveOrder;
import com.faxintong.iruyi.model.mybatis.order.ReceiveOrderExample;
import com.faxintong.iruyi.service.order.receive.ReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.faxintong.iruyi.utils.Constants.*;

/**
 * Created by hehj on 15-1-3.
 */
@Service
public class ReceiveServiceImpl implements ReceiveService {

    @Autowired
    private ReceiveGeneralMapper receiveGeneralMapper;

    @Autowired
    private OrderGeneralMapper orderGeneralMapper;

    @Override
    public List<Order> findAvailReceiveOrders(Long lawyerId) throws Exception {
        /*if(flag.intValue() == 0){//没有限制
            return receiveGeneralMapper.findAvailableOrders(lawyerId);
        }else if(flag.intValue() == 1){//匹配在白名单里的
            return receiveGeneralMapper.findInWhiteListOrders(lawyerId);
        }else if(flag.intValue() == 2){//匹配没在黑名单里的

        }*/
        return receiveGeneralMapper.findAvailReceiveOrders(lawyerId);
    }

    @Override
    public List<Order> findReceivingOrders(Long lawyerId) throws Exception {
        return receiveGeneralMapper.findReceivingOrders(lawyerId);//获取竞标中的和待确认的单子
    }

    @Override
    public List<Order> findOrdersByStatus(Long lawyerId, Integer status) throws Exception {
        return receiveGeneralMapper.findOrdersByStatus(lawyerId, status);
    }

    @Transactional
    public void receiveOrder(Long orderId, Long lawyerId) throws Exception {
        receiveGeneralMapper.receiveOrder(orderId, lawyerId);
    }

    @Transactional
    public void confirmOrder(Long orderId, Long lawyerId) throws Exception {
        receiveGeneralMapper.updateReceiveStatus(orderId, FAIL);//竞标中未选中者状态改为接单失败
        receiveGeneralMapper.confirmOrRevoke(orderId, lawyerId, SUCCESS);//竞标中被选中者状态改为接单成功
        orderGeneralMapper.updateOrderStatus(orderId, SUCCESS);//更新单子状态为接单成功状态
    }

    @Transactional
    public void revokeOrder(Long orderId, Long lawyerId) throws Exception {
        receiveGeneralMapper.confirmOrRevoke(orderId, lawyerId, FORGO);//竞标中被选中者放弃接单
    }

    @Transactional
    public void cancelOrder(Long orderId, Long lawyerId) throws Exception {
        receiveGeneralMapper.cancelOrder(orderId, lawyerId, CANCEL);//针对接单成功者作废单子
        orderGeneralMapper.updateOrderStatus(orderId, CANCEL);//更新单子状态为作废状态
    }

}
