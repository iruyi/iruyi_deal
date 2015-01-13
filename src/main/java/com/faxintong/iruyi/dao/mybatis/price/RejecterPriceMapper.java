package com.faxintong.iruyi.dao.mybatis.price;

import com.faxintong.iruyi.model.mybatis.price.RejecterPrice;
import com.faxintong.iruyi.model.mybatis.price.RejecterPriceExample;
import java.util.List;

import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;
@OperateMyBatis
public interface RejecterPriceMapper {
    int countByExample(RejecterPriceExample example);

    int deleteByExample(RejecterPriceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RejecterPrice record);

    int insertSelective(RejecterPrice record);

    List<RejecterPrice> selectByExample(RejecterPriceExample example);

    RejecterPrice selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RejecterPrice record, @Param("example") RejecterPriceExample example);

    int updateByExample(@Param("record") RejecterPrice record, @Param("example") RejecterPriceExample example);

    int updateByPrimaryKeySelective(RejecterPrice record);

    int updateByPrimaryKey(RejecterPrice record);
}