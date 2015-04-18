package com.faxintong.iruyi.dao.mybatis.microview;

import com.faxintong.iruyi.model.mybatis.microview.ViewPraise;
import com.faxintong.iruyi.model.mybatis.microview.ViewPraiseExample;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@OperateMyBatis
public interface ViewPraiseMapper {
    int countByExample(ViewPraiseExample example);

    int deleteByExample(ViewPraiseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ViewPraise record);

    int insertSelective(ViewPraise record);

    List<ViewPraise> selectByExample(ViewPraiseExample example);

    ViewPraise selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ViewPraise record, @Param("example") ViewPraiseExample example);

    int updateByExample(@Param("record") ViewPraise record, @Param("example") ViewPraiseExample example);

    int updateByPrimaryKeySelective(ViewPraise record);

    int updateByPrimaryKey(ViewPraise record);
}