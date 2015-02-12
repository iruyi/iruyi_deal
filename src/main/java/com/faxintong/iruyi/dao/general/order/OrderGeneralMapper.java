package com.faxintong.iruyi.dao.general.order;

import com.faxintong.iruyi.model.general.order.GeneralOrder;
import com.faxintong.iruyi.model.mybatis.order.Order;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

import static org.apache.ibatis.mapping.StatementType.*;

/**
 * Created by hehj on 15-1-18.
 */
@OperateMyBatis
public interface OrderGeneralMapper {

    @Update("update `order` set status=#{status},update_date=now() where id=#{orderId}")
    public void updateOrderStatus(@Param("orderId") Long orderId, @Param("status") Integer status) throws Exception;

    /*@Select("SELECT " +
            "o.title, " +
            "DATE_FORMAT(o.create_date, '%Y-%m-%d') as create_date, " +
            "CASE o.type " +
            "WHEN 1 THEN " +
            "'案源介绍' " +
            "WHEN 2 THEN " +
            "'协作介绍' " +
            "ELSE " +
            "'商务介绍' " +
            "END as type, " +
            "lc. NAME as category, " +
            "c. NAME as cityName, " +
            "o.description " +
            "FROM " +
            "`order` o, " +
            "order_rule ro, " +
            "city c, " +
            "lawyer_category lc " +
            "WHERE " +
            "o.id = #{orderId} " +
            "AND o.rule_id = ro.id " +
            "AND ro.city_id = c.id " +
            "AND ro.category_id = lc.id ")*/
    @Select("SELECT " +
            "o.title, " +
            "DATE_FORMAT(o.create_date, '%Y-%m-%d') as create_date, o.type, " +
            "lc.NAME as category, " +
            "c.NAME as cityName, " +
            "o.description " +
            "FROM " +
            "`order` o, " +
            "order_rule ro, " +
            "city c, " +
            "lawyer_category lc " +
            "WHERE " +
            "o.id = #{orderId} " +
            "AND o.rule_id = ro.id " +
            "AND ro.city_id = c.id " +
            "AND ro.category_id = lc.id ")
    public List<GeneralOrder> findOrderById(@Param("orderId") Long orderId) throws Exception;

    @SelectKey(statement = "SELECT LAST_INSERT_ID() AS id", keyProperty = "order.id", before = true, resultType = Long.class)
    @Insert("insert into `order`(title,lawyer_id,rule_id,status,type,is_delay,deadline_date,description,create_date,roster_type,keywords) " +
            "values(#{order.title},#{order.lawyerId},#{order.ruleId},#{order.status},#{order.type},#{order.isDelay},#{order.deadlineDate},#{order.description},#{order.createDate},#{order.rosterType},#{order.keywords})")
    public Long insertOrder(@Param("order") Order order) throws Exception;
}
