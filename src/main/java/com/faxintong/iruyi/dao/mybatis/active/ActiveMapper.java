package com.faxintong.iruyi.dao.mybatis.active;

import com.faxintong.iruyi.model.mybatis.active.Active;
import com.faxintong.iruyi.model.mybatis.active.ActiveExample;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@OperateMyBatis
public interface ActiveMapper {
    int countByExample(ActiveExample example);

    int deleteByExample(ActiveExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Active record);

    int insertSelective(Active record);

    List<Active> selectByExample(ActiveExample example);

    Active selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Active record, @Param("example") ActiveExample example);

    int updateByExample(@Param("record") Active record, @Param("example") ActiveExample example);

    int updateByPrimaryKeySelective(Active record);

    int updateByPrimaryKey(Active record);
}