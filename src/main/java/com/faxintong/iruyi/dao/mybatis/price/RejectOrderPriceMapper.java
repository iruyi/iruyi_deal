package com.faxintong.iruyi.dao.mybatis.price;

import com.faxintong.iruyi.model.mybatis.price.RejectOrderPrice;
import com.faxintong.iruyi.model.mybatis.price.RejectOrderPriceExample;
import java.util.List;

import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;
@OperateMyBatis
public interface RejectOrderPriceMapper {
    int countByExample(RejectOrderPriceExample example);

    int deleteByExample(RejectOrderPriceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RejectOrderPrice record);

    int insertSelective(RejectOrderPrice record);

    List<RejectOrderPrice> selectByExample(RejectOrderPriceExample example);

    RejectOrderPrice selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RejectOrderPrice record, @Param("example") RejectOrderPriceExample example);

    int updateByExample(@Param("record") RejectOrderPrice record, @Param("example") RejectOrderPriceExample example);

    int updateByPrimaryKeySelective(RejectOrderPrice record);

    int updateByPrimaryKey(RejectOrderPrice record);
}