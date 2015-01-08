package com.faxintong.iruyi.dao.mybatis.price;

import com.faxintong.iruyi.model.mybatis.price.ReceivePriceRule;
import com.faxintong.iruyi.model.mybatis.price.ReceivePriceRuleExample;
import java.util.List;

import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;
@OperateMyBatis
public interface ReceivePriceRuleMapper {
    int countByExample(ReceivePriceRuleExample example);

    int deleteByExample(ReceivePriceRuleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReceivePriceRule record);

    int insertSelective(ReceivePriceRule record);

    List<ReceivePriceRule> selectByExample(ReceivePriceRuleExample example);

    ReceivePriceRule selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReceivePriceRule record, @Param("example") ReceivePriceRuleExample example);

    int updateByExample(@Param("record") ReceivePriceRule record, @Param("example") ReceivePriceRuleExample example);

    int updateByPrimaryKeySelective(ReceivePriceRule record);

    int updateByPrimaryKey(ReceivePriceRule record);
}