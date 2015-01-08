package com.faxintong.iruyi.dao.mybatis.order;

import com.faxintong.iruyi.model.mybatis.order.ReceiveOrder;
import com.faxintong.iruyi.model.mybatis.order.ReceiveOrderExample;
import java.util.List;

import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;
@OperateMyBatis
public interface ReceiveOrderMapper {
    int countByExample(ReceiveOrderExample example);

    int deleteByExample(ReceiveOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReceiveOrder record);

    int insertSelective(ReceiveOrder record);

    List<ReceiveOrder> selectByExample(ReceiveOrderExample example);

    ReceiveOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReceiveOrder record, @Param("example") ReceiveOrderExample example);

    int updateByExample(@Param("record") ReceiveOrder record, @Param("example") ReceiveOrderExample example);

    int updateByPrimaryKeySelective(ReceiveOrder record);

    int updateByPrimaryKey(ReceiveOrder record);
}