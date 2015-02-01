package com.faxintong.iruyi.dao.general.order;

import com.faxintong.iruyi.model.mybatis.order.Order;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by hehj on 15-1-15.
 */
@OperateMyBatis
public interface ReceiveGeneralMapper {

    String VIEW = "o.id,o.title,o.lawyer_id as lawyerId,o.rule_id as ruleId,o.status,o.type,o.is_delay as isDelay," +
            "o.deadline_date as deadlineDate,o.description,o.create_date as createDate,o.update_date as updateDate,o.roster_type as rosterType,o.keywords";

    /*@Select("select " +VIEW+ " from lawyer l,lawyer_category_rela r,order_rule ru,`order` o " +
            "where l.id=#{lawyerId} and l.id=r.lawyer_id and r.category_id=ru.category_id and l.city_id=ru.city_id and ru.id=o.rule_id and o.`status`=1 and o.deadline_date>now() and o.end_flag = 1 " +
            "and not EXISTS(select 1 from blacklist b where b.order_id=o.id and b.lawyer_id=l.id) " +
            "and not EXISTS(select 1 from receive_order rr where rr.lawyer_id=l.id and rr.order_id=o.id) limit 0,10")
    public List<Order> findNotInBlackListOrders(@Param("lawyerId") Long lawyerId) throws Exception;

    @Select("select " +VIEW+ " from lawyer l,lawyer_category_rela r,order_rule ru,`order` o " +
            "where l.id=#{lawyerId} and l.id=r.lawyer_id and r.category_id=ru.category_id and l.city_id=ru.city_id and ru.id=o.rule_id and o.`status`=1 and o.deadline_date>now() and o.end_flag = 1 " +
            "and EXISTS(select 1 from whitelist b where b.order_id=o.id and b.lawyer_id=l.id) " +
            "and not EXISTS(select 1 from receive_order rr where rr.lawyer_id=l.id and rr.order_id=o.id) limit 0,10")
    public List<Order> findInWhiteListOrders(@Param("lawyerId") Long lawyerId) throws Exception;

    @Select("select " +VIEW+ " from lawyer l,lawyer_category_rela r,order_rule ru,`order` o " +
            "where l.id=#{lawyerId} and l.id=r.lawyer_id and r.category_id=ru.category_id and l.city_id=ru.city_id and ru.id=o.rule_id and o.`status`=1 and o.deadline_date>now() and o.end_flag = 1 " +
            "and not EXISTS(select 1 from receive_order rr where rr.lawyer_id=l.id and rr.order_id=o.id) limit 0,10")
    public List<Order> findAvailReceiveOrders(@Param("lawyerId") Long lawyerId) throws Exception;*/

    @Select("select " + VIEW + " from lawyer l,lawyer_category_rela r,order_rule ru,`order` o " +
    "where l.id=#{lawyerId} and l.id=r.lawyer_id and r.category_id=ru.category_id and l.city_id=ru.city_id and ru.id=o.rule_id and o.`status`=1 and o.deadline_date>now() and o.roster_type = 0 " +
    "and not EXISTS(select 1 from receive_order rr where rr.lawyer_id=l.id and rr.order_id=o.id) " +
    "UNION " +
    "select " + VIEW + " from lawyer l,lawyer_category_rela r,order_rule ru,`order` o " +
    "where l.id=#{lawyerId} and l.id=r.lawyer_id and r.category_id=ru.category_id and l.city_id=ru.city_id and ru.id=o.rule_id and o.`status`=1 and o.deadline_date>now() and o.roster_type = 1 " +
    "and EXISTS(select 1 from whitelist b where b.order_id=o.id and b.lawyer_id=l.id) " +
    "and not EXISTS(select 1 from receive_order rr where rr.lawyer_id=l.id and rr.order_id=o.id) " +
    "UNION " +
    "select " + VIEW + " from lawyer l,lawyer_category_rela r,order_rule ru,`order` o " +
    "where l.id=#{lawyerId} and l.id=r.lawyer_id and r.category_id=ru.category_id and l.city_id=ru.city_id and ru.id=o.rule_id and o.`status`=1 and o.deadline_date>now() and o.roster_type = 2 " +
    "and not EXISTS(select 1 from blacklist b where b.order_id=o.id and b.lawyer_id=l.id) " +
    "and not EXISTS(select 1 from receive_order rr where rr.lawyer_id=l.id and rr.order_id=o.id)")
    public List<Order> findAvailReceiveOrders(@Param("lawyerId") Long lawyerId) throws Exception;

    @Update("update receive_order set status=#{status},update_date=now() where order_id=#{orderId} and lawyer_id=#{lawyerId}")
    public void confirmOrRevoke(@Param("orderId") Long orderId, @Param("lawyerId") Long lawyerId, @Param("status") Integer status) throws Exception;

    @Update("update receive_order set status=#{status},update_date=now() where order_id=#{orderId} and status=1")
    public void updateReceiveStatus(@Param("orderId") Long orderId, @Param("status") Integer status) throws Exception;

    @Update("update receive_order set status=#{status},update_date=now() where order_id=#{orderId} and lawyer_id=#{lawyerId} and status=5")
    public void cancelOrder(@Param("orderId") Long orderId, @Param("lawyerId") Long lawyerId, @Param("status") Integer status) throws Exception;

    @Select("select " + VIEW + " from `order` o, receive_order r where r.lawyer_id=3 and r.`status`=1 and r.order_id=o.id " +
            "UNION " +
            "select " + VIEW + " from `order` o, receive_order r where r.lawyer_id=3 and r.`status`=2 and r.order_id=o.id")
    public List<Order> findReceivingOrders(@Param("lawyerId") Long lawyerId) throws Exception;

    @Insert("insert into receive_order(order_id,lawyer_id,status,create_date) values(#{orderId},#{lawyerId},1,now()) ")
    public void receiveOrder(@Param("orderId") Long orderId, @Param("lawyerId") Long lawyerId) throws Exception;

    @Select("select " + VIEW + " from `order` o, receive_order r where r.lawyer_id=#{lawyerId} and r.`status`=#{status} and r.order_id=o.id ")
    public List<Order> findOrdersByStatus(@Param("lawyerId") Long lawyerId, @Param("status") Integer status) throws Exception;

}
