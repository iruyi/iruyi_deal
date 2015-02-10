package com.faxintong.iruyi.dao.general.order;

import com.faxintong.iruyi.model.general.lawyer.ReceiveLawyer;
import com.faxintong.iruyi.model.general.order.GeneralOrder;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
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

    String ORDER = " o.id,o.title,o.lawyer_id as lawyerId,o.rule_id as ruleId,o.status,o.type,o.is_delay as isDelay," +
            "o.deadline_date as deadlineDate,o.description,o.create_date as createDate,o.update_date as updateDate,o.roster_type as rosterType,o.keywords";

    String RECEIVE_ORDER = "l.name,l.sex,l.city_id as cityId,l.city_name as cityName,ro.order_id as orderId,ro.lawyer_id as lawyerId,ro.status";

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

    @Update("update receive_order set status=#{status},update_date=now() where order_id=#{orderId} and lawyer_id=#{lawyerId}")
    public void confirmOrRevoke(@Param("orderId") Long orderId, @Param("lawyerId") Long lawyerId, @Param("status") Integer status) throws Exception;

    /*@Select("select " + VIEW + " from lawyer l,lawyer_category_rela r,order_rule ru,`order` o " +
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
    "and not EXISTS(select 1 from receive_order rr where rr.lawyer_id=l.id and rr.order_id=o.id)")*/
    @Select("SELECT " + ORDER + ",c. name AS cityName                       " +
            "FROM   lawyer l,                                             " +
            "       lawyer_category_rela r,                               " +
            "       order_rule ru,                                        " +
            "       `order` o,                                            " +
            "       city c                                                " +
            "WHERE  l.id = 1                                              " +
            "       AND l.id = r.lawyer_id                                " +
            "       AND r.category_id = ru.category_id                    " +
            "       AND l.city_id = ru.city_id                            " +
            "       AND ru.id = o.rule_id                                 " +
            "       AND o.`status` = 1                                    " +
            "       AND o.deadline_date > Now()                           " +
            "       AND o.roster_type = 0                                 " +
            "       AND ru.city_id = c.id                                 " +
            "       AND o.type != 3                                       " +
            "       AND NOT EXISTS (SELECT 1                              " +
            "                       FROM   receive_order rr               " +
            "                       WHERE  rr.lawyer_id = l.id            " +
            "                              AND rr.order_id = o.id)        " +
            "UNION                                                        " +
            "SELECT " + ORDER + ",c. name AS cityName                       " +
            "FROM   lawyer l,                                             " +
            "       lawyer_category_rela r,                               " +
            "       order_rule ru,                                        " +
            "       `order` o,                                            " +
            "       city c                                                " +
            "WHERE  l.id = 1                                              " +
            "       AND l.id = r.lawyer_id                                " +
            "       AND r.category_id = ru.category_id                    " +
            "       AND l.city_id = ru.city_id                            " +
            "       AND ru.id = o.rule_id                                 " +
            "       AND o.`status` = 1                                    " +
            "       AND o.deadline_date > Now()                           " +
            "       AND o.roster_type = 1                                 " +
            "       AND ru.city_id = c.id                                 " +
            "       AND o.type != 3                                       " +
            "       AND EXISTS (SELECT 1                                  " +
            "                   FROM   whitelist b                        " +
            "                   WHERE  b.order_id = o.id                  " +
            "                          AND b.lawyer_id = l.id)            " +
            "       AND NOT EXISTS (SELECT 1                              " +
            "                       FROM   receive_order rr               " +
            "                       WHERE  rr.lawyer_id = l.id            " +
            "                              AND rr.order_id = o.id)        " +
            "UNION                                                        " +
            "SELECT " + ORDER + ",c. name AS cityName                       " +
            "FROM   lawyer l,                                             " +
            "       lawyer_category_rela r,                               " +
            "       order_rule ru,                                        " +
            "       `order` o,                                            " +
            "       city c                                                " +
            "WHERE  l.id = 1                                              " +
            "       AND l.id = r.lawyer_id                                " +
            "       AND r.category_id = ru.category_id                    " +
            "       AND l.city_id = ru.city_id                            " +
            "       AND ru.id = o.rule_id                                 " +
            "       AND o.`status` = 1                                    " +
            "       AND o.deadline_date > Now()                           " +
            "       AND o.roster_type = 2                                 " +
            "       AND ru.city_id = c.id                                 " +
            "       AND o.type != 3                                       " +
            "       AND NOT EXISTS (SELECT 1                              " +
            "                       FROM   blacklist b                    " +
            "                       WHERE  b.order_id = o.id              " +
            "                              AND b.lawyer_id = l.id)        " +
            "       AND NOT EXISTS (SELECT 1                              " +
            "                       FROM   receive_order rr               " +
            "                       WHERE  rr.lawyer_id = l.id            " +
            "                              AND rr.order_id = o.id)        ")
    public List<GeneralOrder> findAvailReceiveOrders(@Param("lawyerId") Long lawyerId) throws Exception;

    @Update("update receive_order set status=#{status},update_date=now() where order_id=#{orderId} and status=1")
    public void updateReceiveStatus(@Param("orderId") Long orderId, @Param("status") Integer status) throws Exception;

    @Update("update receive_order set status=#{status},update_date=now() where order_id=#{orderId} and lawyer_id=#{lawyerId} and status=5")
    public void cancelOrder(@Param("orderId") Long orderId, @Param("lawyerId") Long lawyerId, @Param("status") Integer status) throws Exception;

    @Select("select " + ORDER + " from `order` o, receive_order r where r.lawyer_id=3 and r.`status`=1 and r.order_id=o.id " +
            "UNION " +
            "select " + ORDER + " from `order` o, receive_order r where r.lawyer_id=3 and r.`status`=2 and r.order_id=o.id")
    public List<Order> findReceivingOrders(@Param("lawyerId") Long lawyerId) throws Exception;

    @Insert("insert into receive_order(order_id,lawyer_id,status,create_date) values(#{orderId},#{lawyerId},1,now()) ")
    public void receiveOrder(@Param("orderId") Long orderId, @Param("lawyerId") Long lawyerId) throws Exception;

    @Select("select " + ORDER + " from `order` o, receive_order r where r.lawyer_id=#{lawyerId} and r.`status`=#{status} and r.order_id=o.id ")
    public List<Order> findOrdersByStatus(@Param("lawyerId") Long lawyerId, @Param("status") Integer status) throws Exception;

    @Select("select " + RECEIVE_ORDER + " from receive_order ro,lawyer l where ro.order_id=#{orderId} and ro.lawyer_id=l.id ")
    public List<ReceiveLawyer> findReceiveOrderLawyers(@Param("orderId") Long orderId) throws Exception;

    @Select("update receive_order set status=#{status},update_date=now() where order_id=#{orderId} and lawyer_id=#{lawyerId} ")
    public void chooseBestLawyer(@Param("orderId") Long orderId, @Param("lawyerId") Long lawyerId, @Param("status") Integer status) throws Exception;
}
