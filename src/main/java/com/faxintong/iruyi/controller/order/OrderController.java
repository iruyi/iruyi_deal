package com.faxintong.iruyi.controller.order;

import com.faxintong.iruyi.controller.BaseController;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.vo.OrderVo;
import com.faxintong.iruyi.service.order.OrderService;
import com.faxintong.iruyi.utils.Pager;
import com.faxintong.iruyi.utils.Result;
import com.faxintong.iruyi.utils.ServletUtils;
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

import static com.faxintong.iruyi.utils.Constants.*;

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
     */
    @RequestMapping(value = "reportOrder")
    public String reportOrder(OrderVo order,HttpServletRequest request,HttpServletResponse response) {
        try {
            if(order == null || StringUtils.isEmpty(order.getTitle()) || StringUtils.isEmpty(order.getContent())) {
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "商机标题或内容为空！"));
                return null;
            }

            if(order.getType() == null) {
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "商机类型为空！"));
                return null;
            }

            Lawyer lawyer = getLawyer(request);
            order.setLawyerId(lawyer.getId());
            order.setLawyerName(lawyer.getName());

            orderService.reportOrder(order);
            ServletUtils.responseJson(response, new Result(RESULTSUCCESS, "发布商机成功！"));


        }catch (Exception e){
            logger.error("发布商机失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "发布商机失败！"));
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
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "当前页为空！"));
                return null;
            }

            List<OrderVo> orderVoList = orderService.getOrderList(pager, getLawyerId(request));
            modelMap.put(DATA,orderVoList);
            resultModelMap(RESULTSUCCESS,"获取商机列表成功！",modelMap);

            return "order/getOrderList";
        }catch (Exception e){
            logger.error("获取商机列表失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "获取商机列表失败！"));
        }
        return null;
    }

    /**
     * 搜索商机
     * @param pager
     * @return
     */
    @RequestMapping(value = "searchOrders")
    public String searchOrders(Pager pager, String title, String content, ModelMap modelMap,HttpServletRequest request,HttpServletResponse response) {
        try {
            if(pager == null || pager.getCurrentPage() == null) {
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "当前页为空！"));
                return null;
            }
            List<OrderVo> orderVoList = orderService.searchOrders(pager, getLawyerId(request), title, content);
            modelMap.put(DATA,orderVoList);
            resultModelMap(RESULTSUCCESS,"获取商机列表成功！",modelMap);
            return "order/getOrderList";
        }catch (Exception e){
            logger.error("获取商机列表失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "获取商机列表失败！"));
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
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "商机ID详情失败！"));
                return null;
            }

            OrderVo orderVo = orderService.orderDetail(orderId,getLawyerId(request));
            modelMap.put(DATA,orderVo);
            resultModelMap(RESULTSUCCESS,"获取商机详情成功！",modelMap);

            return "order/orderDetail";
        }catch (Exception e){
            logger.error("获取商机详情失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "获取商机详情失败！"));
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
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "商机ID不能为空！"));
                return null;
            }

            orderService.orderInterest(orderId,getLawyerId(request));
            ServletUtils.responseJson(response, new Result(RESULTSUCCESS, "商机感兴趣成功！"));
        }catch (Exception e){
            logger.error("商机感兴趣失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "商机感兴趣失败！"));
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
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "商机ID或者留言内容为空！"));
                return null;
            }

            orderService.orderComment(orderId, content, getLawyerId(request));
            ServletUtils.responseJson(response, new Result(RESULTSUCCESS, "商机留言成功！"));
        }catch (Exception e){
            logger.error("商机留言失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "商机留言失败！"));
        }
        return null;
    }


}
