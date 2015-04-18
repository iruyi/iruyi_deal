package com.faxintong.iruyi.dao.mybatis.microview;

import com.faxintong.iruyi.model.mybatis.microview.ViewAttention;
import com.faxintong.iruyi.model.mybatis.microview.ViewAttentionExample;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@OperateMyBatis
public interface ViewAttentionMapper {
    int countByExample(ViewAttentionExample example);

    int deleteByExample(ViewAttentionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ViewAttention record);

    int insertSelective(ViewAttention record);

    List<ViewAttention> selectByExample(ViewAttentionExample example);

    ViewAttention selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ViewAttention record, @Param("example") ViewAttentionExample example);

    int updateByExample(@Param("record") ViewAttention record, @Param("example") ViewAttentionExample example);

    int updateByPrimaryKeySelective(ViewAttention record);

    int updateByPrimaryKey(ViewAttention record);
}