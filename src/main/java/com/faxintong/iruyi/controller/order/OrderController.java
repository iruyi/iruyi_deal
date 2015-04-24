package com.faxintong.iruyi.controller.order;

import com.faxintong.iruyi.controller.BaseController;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.order.Order;
import com.faxintong.iruyi.model.mybatis.vo.OrderVo;
import com.faxintong.iruyi.service.order.OrderService;
import com.faxintong.iruyi.utils.Pager;
import com.faxintong.iruyi.utils.Result;
import com.faxintong.iruyi.utils.ServletUtils;
import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

import static com.faxintong.iruyi.utils.Constants.DATA;

/**
 * Created by hehongju on 2015/2/11.
 */
@RestController
@RequestMapping("order")
public class OrderController extends BaseController{
    private Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private OrderService orderService;

    /**
     * 发布商机
     * @param order
     * @return
     *
     * @note
     *  发布商机
     *   必须登录
     *    需要参数 类型、标题、内容、城市、
     *
     *    //TODO 没有黑白名单表
     *       order 表 缺少city相关字段 已加
     *
     *       这个黑白名单的设计  跟商机列表怎么处理
     *       是不是没登陆的话 就能查看全部的 不含黑白名单的商机列表
     *        如果登录的话，不仅能查看全部的不含黑白名单的商机列表，而且能查看被指定的白名单列表,且不能查看黑名单列表
     *
     */
    @RequestMapping(value = "reportOrder")
    public String reportOrder(OrderVo order,HttpServletRequest request,HttpServletResponse response) {
        try {
            if(order == null || StringUtils.isEmpty(order.getTitle()) || StringUtils.isEmpty(order.getContent())) {
                ServletUtils.responseJson(response, new Result(0, "商机标题或内容为空！"));
                return null;
            }

            if(order.getType() == null) {
                ServletUtils.responseJson(response, new Result(0, "商机类型为空！"));
                return null;
            }

            Lawyer lawyer = getLawyer(request);
            order.setLawyerId(lawyer.getId());
            order.setLawyerName(lawyer.getName());

            orderService.reportOrder(order);
            ServletUtils.responseJson(response, new Result(1, "发布商机成功！"));


        }catch (Exception e){
            logger.error("发布商机失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(0, "发布商机失败！"));
        }
        return null;
    }

    /**
     * 获取单子列表
     * @param pager
     * @return
     */
    @RequestMapping(value = "getOrderList")
    public String getOrderList(Pager pager,ModelMap modelMap,HttpServletRequest request,HttpServletResponse response) {
        try {
            if(pager == null || pager.getCurrentPage() == null) {
                ServletUtils.responseJson(response, new Result(0, "当前页为空！"));
                return null;
            }

            List<OrderVo> orderVoList = orderService.getOrderList(pager, getLawyerId(request));
            modelMap.put(DATA,orderVoList);
            resultModelMap(1,"获取商机列表失败！",modelMap);

            return "order/getOrderList";
        }catch (Exception e){
            logger.error("获取商机列表失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(0, "获取商机列表失败！"));
        }
        return null;
    }

    /**
     * 单子详情
     * @param orderId
     * @return
     */
    @RequestMapping(value = "orderDetail")
    public String orderDetail(Long orderId,ModelMap modelMap,HttpServletRequest request,HttpServletResponse response) {
        try {
            if(orderId == null) {
                ServletUtils.responseJson(response, new Result(0, "商机ID详情失败！"));
                return null;
            }

            OrderVo orderVo = orderService.orderDetail(orderId,getLawyerId(request));
            modelMap.put(DATA,orderVo);
            resultModelMap(1,"获取商机详情成功！",modelMap);

            return "order/orderDetail";
        }catch (Exception e){
            logger.error("获取商机详情失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(0, "获取商机详情失败！"));
        }
        return null;
    }

    /**
     * 单子感兴趣
     * @param orderId
     * @return
     */
    @RequestMapping(value = "orderInterest")
    public Map<String, Object> orderInterest(Long orderId,HttpServletResponse response,HttpServletRequest request) {
        try {
            if(orderId == null) {
                ServletUtils.responseJson(response, new Result(0, "商机ID不能为空！"));
                return null;
            }

            orderService.orderInterest(orderId,getLawyerId(request));
            ServletUtils.responseJson(response, new Result(1, "商机感兴趣成功！"));
        }catch (Exception e){
            logger.error("商机感兴趣失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(0, "商机感兴趣失败！"));
        }
        return null;
    }

    /**
     * 单子留言
     * @param orderId
     * @param content
     * @return
     */
    @RequestMapping(value = "orderComment")
    public String orderComment(Long orderId, String content,HttpServletRequest request,HttpServletResponse response) {
        try {
            if(orderId == null || StringUtils.isEmpty(content)) {
                ServletUtils.responseJson(response, new Result(0, "商机ID或者留言内容为空！"));
                return null;
            }

            orderService.orderComment(orderId, content, getLawyerId(request));
            ServletUtils.responseJson(response, new Result(1, "商机留言成功！"));
        }catch (Exception e){
            logger.error("商机留言失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(0, "商机留言失败！"));
        }
        return null;
    }


}
