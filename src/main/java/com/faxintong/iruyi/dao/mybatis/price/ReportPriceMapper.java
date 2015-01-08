package com.faxintong.iruyi.dao.mybatis.price;

import com.faxintong.iruyi.model.mybatis.price.ReportPrice;
import com.faxintong.iruyi.model.mybatis.price.ReportPriceExample;
import java.util.List;

import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;
@OperateMyBatis
public interface ReportPriceMapper {
    int countByExample(ReportPriceExample example);

    int deleteByExample(ReportPriceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReportPrice record);

    int insertSelective(ReportPrice record);

    List<ReportPrice> selectByExample(ReportPriceExample example);

    ReportPrice selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReportPrice record, @Param("example") ReportPriceExample example);

    int updateByExample(@Param("record") ReportPrice record, @Param("example") ReportPriceExample example);

    int updateByPrimaryKeySelective(ReportPrice record);

    int updateByPrimaryKey(ReportPrice record);
}