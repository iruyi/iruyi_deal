package com.faxintong.iruyi.dao.mybatis.pay;

import com.faxintong.iruyi.model.mybatis.pay.PaymentMode;
import com.faxintong.iruyi.model.mybatis.pay.PaymentModeExample;
import java.util.List;

import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;
@OperateMyBatis
public interface PaymentModeMapper {
    int countByExample(PaymentModeExample example);

    int deleteByExample(PaymentModeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PaymentMode record);

    int insertSelective(PaymentMode record);

    List<PaymentMode> selectByExample(PaymentModeExample example);

    PaymentMode selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PaymentMode record, @Param("example") PaymentModeExample example);

    int updateByExample(@Param("record") PaymentMode record, @Param("example") PaymentModeExample example);

    int updateByPrimaryKeySelective(PaymentMode record);

    int updateByPrimaryKey(PaymentMode record);
}