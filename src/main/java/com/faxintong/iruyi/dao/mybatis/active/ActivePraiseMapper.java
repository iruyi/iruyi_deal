package com.faxintong.iruyi.dao.mybatis.active;

import com.faxintong.iruyi.model.mybatis.active.ActivePraise;
import com.faxintong.iruyi.model.mybatis.active.ActivePraiseExample;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@OperateMyBatis
public interface ActivePraiseMapper {
    int countByExample(ActivePraiseExample example);

    int deleteByExample(ActivePraiseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActivePraise record);

    int insertSelective(ActivePraise record);

    List<ActivePraise> selectByExample(ActivePraiseExample example);

    ActivePraise selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ActivePraise record, @Param("example") ActivePraiseExample example);

    int updateByExample(@Param("record") ActivePraise record, @Param("example") ActivePraiseExample example);

    int updateByPrimaryKeySelective(ActivePraise record);

    int updateByPrimaryKey(ActivePraise record);
}