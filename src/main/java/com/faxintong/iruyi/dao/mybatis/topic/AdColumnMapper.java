package com.faxintong.iruyi.dao.mybatis.topic;

import com.faxintong.iruyi.model.mybatis.topic.AdColumn;
import com.faxintong.iruyi.model.mybatis.topic.AdColumnExample;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@OperateMyBatis
public interface AdColumnMapper {
    int countByExample(AdColumnExample example);

    int deleteByExample(AdColumnExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdColumn record);

    int insertSelective(AdColumn record);

    List<AdColumn> selectByExample(AdColumnExample example);

    AdColumn selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AdColumn record, @Param("example") AdColumnExample example);

    int updateByExample(@Param("record") AdColumn record, @Param("example") AdColumnExample example);

    int updateByPrimaryKeySelective(AdColumn record);

    int updateByPrimaryKey(AdColumn record);
}