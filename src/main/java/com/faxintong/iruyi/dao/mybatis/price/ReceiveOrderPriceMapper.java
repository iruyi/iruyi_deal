package com.faxintong.iruyi.dao.mybatis.price;

import com.faxintong.iruyi.model.mybatis.price.ReceiveOrderPrice;
import com.faxintong.iruyi.model.mybatis.price.ReceiveOrderPriceExample;
import java.util.List;

import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;
@OperateMyBatis
public interface ReceiveOrderPriceMapper {
    int countByExample(ReceiveOrderPriceExample example);

    int deleteByExample(ReceiveOrderPriceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReceiveOrderPrice record);

    int insertSelective(ReceiveOrderPrice record);

    List<ReceiveOrderPrice> selectByExample(ReceiveOrderPriceExample example);

    ReceiveOrderPrice selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReceiveOrderPrice record, @Param("example") ReceiveOrderPriceExample example);

    int updateByExample(@Param("record") ReceiveOrderPrice record, @Param("example") ReceiveOrderPriceExample example);

    int updateByPrimaryKeySelective(ReceiveOrderPrice record);

    int updateByPrimaryKey(ReceiveOrderPrice record);
}