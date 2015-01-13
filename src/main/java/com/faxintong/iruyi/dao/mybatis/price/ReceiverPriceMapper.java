package com.faxintong.iruyi.dao.mybatis.price;

import com.faxintong.iruyi.model.mybatis.price.ReceiverPrice;
import com.faxintong.iruyi.model.mybatis.price.ReceiverPriceExample;
import java.util.List;

import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;
@OperateMyBatis
public interface ReceiverPriceMapper {
    int countByExample(ReceiverPriceExample example);

    int deleteByExample(ReceiverPriceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReceiverPrice record);

    int insertSelective(ReceiverPrice record);

    List<ReceiverPrice> selectByExample(ReceiverPriceExample example);

    ReceiverPrice selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReceiverPrice record, @Param("example") ReceiverPriceExample example);

    int updateByExample(@Param("record") ReceiverPrice record, @Param("example") ReceiverPriceExample example);

    int updateByPrimaryKeySelective(ReceiverPrice record);

    int updateByPrimaryKey(ReceiverPrice record);
}