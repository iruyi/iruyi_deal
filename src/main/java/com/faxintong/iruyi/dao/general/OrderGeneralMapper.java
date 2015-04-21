package com.faxintong.iruyi.dao.general;

import com.faxintong.iruyi.model.mybatis.order.Order;
import com.faxintong.iruyi.model.mybatis.vo.OrderVo;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by yunaxie on 2015/4/21.
 */
@OperateMyBatis
public interface OrderGeneralMapper {
    int insertOrder(@Param("order")Order order);

    @Insert("insert into order_receive (order_id,lawyer_id,create_date) values(#{orderId},#{lawyerId},now())")
    int insertOrderReceive(@Param("orderId")Long orderId, @Param("lawyerId")Long lawyerId);

    @Update("update order_receive set content = #{content} where order_id = #{orderId} and lawyer_id = #{lawyerId")
    int updateOrderReceive(@Param("orderId")Long orderId, @Param("content")String content, @Param("lawyerId")Long lawyerId);

    @ResultType(OrderVo.class)
    @Select("select o.id,o.type,o.title,o.content,o.city_name cityName,o.deadline_date deadDate,o.keywords,o.price" +
            ",(select count(*) from order_receive orc where orc.order_id = o.id) interestCount" +
            " from `order` o" +
            " order by o.create_date" +
            " limit #{startCount},#{pageSize}"
            )
    List<OrderVo> selectOrderVo(@Param("startCount")Integer startCount, @Param("pageSize")Integer pageSize);

    @Select("select count(*) from `order` where lawyer_id =#{lawyerId}")
    int countIssueByLawyerId(@Param("lawyerId")Long lawyerId);

    @Select("select count(*) from order_receive where lawyer_id =#{lawyerId}")
    int countIssueOfmyInterest(@Param("lawyerId")Long lawyerId);
}
