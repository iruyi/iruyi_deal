package com.faxintong.iruyi.dao.general.order;

import com.faxintong.iruyi.model.general.order.GeneralOrder;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by hehongju on 2015/2/12.
 */
@OperateMyBatis
public interface RejectGeneralMapper {

    String ORDER = "o.title,o.lawyer_id as lawyerId,o.status,o.type," +
            "o.description,DATE_FORMAT(o.create_date, '%Y-%m-%d') as createDate,o.update_date as updateDate,o.roster_type as rosterType,o.keywords";

    @Select("SELECT o.title,DATE_FORMAT(o.create_date, '%Y-%m-%d') as create_date, o.type, lc.NAME as category, c.NAME as cityName,o.description " +
            " from `order` o,order_rule ro,city c,lawyer_category lc where o.lawyer_id = #{lawyerId} AND o.rule_id = ro.id AND ro.city_id = c.id AND ro.category_id = lc.id")
    public List<GeneralOrder> findRejectOrders(@Param("lawyerId") Long lawyerId) throws Exception;

    @Select("SELECT o.title,DATE_FORMAT(o.create_date, '%Y-%m-%d') as create_date, o.type, lc.NAME as category, c.NAME as cityName,o.description " +
            " from `order` o,order_rule ro,city c,lawyer_category lc where o.lawyer_id = #{lawyerId} AND o.status=#{status} AND o.rule_id = ro.id AND ro.city_id = c.id AND ro.category_id = lc.id")
    public List<GeneralOrder> findOrdersByStatus(@Param("lawyerId") Long lawyerId, @Param("status") Integer status) throws Exception;
}
