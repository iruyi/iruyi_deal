package com.faxintong.iruyi.dao.mybatis.price;

import com.faxintong.iruyi.model.mybatis.price.RejectPriceRule;
import com.faxintong.iruyi.model.mybatis.price.RejectPriceRuleExample;
import java.util.List;

import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;
@OperateMyBatis
public interface RejectPriceRuleMapper {
    int countByExample(RejectPriceRuleExample example);

    int deleteByExample(RejectPriceRuleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RejectPriceRule record);

    int insertSelective(RejectPriceRule record);

    List<RejectPriceRule> selectByExample(RejectPriceRuleExample example);

    RejectPriceRule selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RejectPriceRule record, @Param("example") RejectPriceRuleExample example);

    int updateByExample(@Param("record") RejectPriceRule record, @Param("example") RejectPriceRuleExample example);

    int updateByPrimaryKeySelective(RejectPriceRule record);

    int updateByPrimaryKey(RejectPriceRule record);
}