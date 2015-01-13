package com.faxintong.iruyi.dao.mybatis.pay;

import com.faxintong.iruyi.model.mybatis.pay.PaymentRecord;
import com.faxintong.iruyi.model.mybatis.pay.PaymentRecordExample;
import java.util.List;

import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;
@OperateMyBatis
public interface PaymentRecordMapper {
    int countByExample(PaymentRecordExample example);

    int deleteByExample(PaymentRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PaymentRecord record);

    int insertSelective(PaymentRecord record);

    List<PaymentRecord> selectByExample(PaymentRecordExample example);

    PaymentRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PaymentRecord record, @Param("example") PaymentRecordExample example);

    int updateByExample(@Param("record") PaymentRecord record, @Param("example") PaymentRecordExample example);

    int updateByPrimaryKeySelective(PaymentRecord record);

    int updateByPrimaryKey(PaymentRecord record);
}