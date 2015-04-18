package com.faxintong.iruyi.dao.mybatis.order;

import com.faxintong.iruyi.model.mybatis.order.OrderReceive;
import com.faxintong.iruyi.model.mybatis.order.OrderReceiveExample;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@OperateMyBatis
public interface OrderReceiveMapper {
    int countByExample(OrderReceiveExample example);

    int deleteByExample(OrderReceiveExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderReceive record);

    int insertSelective(OrderReceive record);

    List<OrderReceive> selectByExample(OrderReceiveExample example);

    OrderReceive selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderReceive record, @Param("example") OrderReceiveExample example);

    int updateByExample(@Param("record") OrderReceive record, @Param("example") OrderReceiveExample example);

    int updateByPrimaryKeySelective(OrderReceive record);

    int updateByPrimaryKey(OrderReceive record);
}