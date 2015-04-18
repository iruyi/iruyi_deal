package com.faxintong.iruyi.dao.mybatis.lawyer;

import com.faxintong.iruyi.model.mybatis.lawyer.LawyerAttention;
import com.faxintong.iruyi.model.mybatis.lawyer.LawyerAttentionExample;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@OperateMyBatis
public interface LawyerAttentionMapper {
    int countByExample(LawyerAttentionExample example);

    int deleteByExample(LawyerAttentionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LawyerAttention record);

    int insertSelective(LawyerAttention record);

    List<LawyerAttention> selectByExample(LawyerAttentionExample example);

    LawyerAttention selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LawyerAttention record, @Param("example") LawyerAttentionExample example);

    int updateByExample(@Param("record") LawyerAttention record, @Param("example") LawyerAttentionExample example);

    int updateByPrimaryKeySelective(LawyerAttention record);

    int updateByPrimaryKey(LawyerAttention record);
}