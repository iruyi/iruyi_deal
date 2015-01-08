package com.faxintong.iruyi.dao.mybatis.order;

import com.faxintong.iruyi.model.mybatis.order.OrderRule;
import com.faxintong.iruyi.model.mybatis.order.OrderRuleExample;
import java.util.List;

import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;
@OperateMyBatis
public interface OrderRuleMapper {
    int countByExample(OrderRuleExample example);

    int deleteByExample(OrderRuleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderRule record);

    int insertSelective(OrderRule record);

    List<OrderRule> selectByExample(OrderRuleExample example);

    OrderRule selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderRule record, @Param("example") OrderRuleExample example);

    int updateByExample(@Param("record") OrderRule record, @Param("example") OrderRuleExample example);

    int updateByPrimaryKeySelective(OrderRule record);

    int updateByPrimaryKey(OrderRule record);
}