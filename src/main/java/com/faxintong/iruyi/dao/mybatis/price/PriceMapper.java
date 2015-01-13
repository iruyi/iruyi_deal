package com.faxintong.iruyi.dao.mybatis.price;

import com.faxintong.iruyi.model.mybatis.price.Price;
import com.faxintong.iruyi.model.mybatis.price.PriceExample;
import java.util.List;

import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;
@OperateMyBatis
public interface PriceMapper {
    int countByExample(PriceExample example);

    int deleteByExample(PriceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Price record);

    int insertSelective(Price record);

    List<Price> selectByExample(PriceExample example);

    Price selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Price record, @Param("example") PriceExample example);

    int updateByExample(@Param("record") Price record, @Param("example") PriceExample example);

    int updateByPrimaryKeySelective(Price record);

    int updateByPrimaryKey(Price record);
}