package com.faxintong.iruyi.dao.mybatis.active;

import com.faxintong.iruyi.model.mybatis.active.ActiveStore;
import com.faxintong.iruyi.model.mybatis.active.ActiveStoreExample;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@OperateMyBatis
public interface ActiveStoreMapper {
    int countByExample(ActiveStoreExample example);

    int deleteByExample(ActiveStoreExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActiveStore record);

    int insertSelective(ActiveStore record);

    List<ActiveStore> selectByExample(ActiveStoreExample example);

    ActiveStore selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ActiveStore record, @Param("example") ActiveStoreExample example);

    int updateByExample(@Param("record") ActiveStore record, @Param("example") ActiveStoreExample example);

    int updateByPrimaryKeySelective(ActiveStore record);

    int updateByPrimaryKey(ActiveStore record);
}