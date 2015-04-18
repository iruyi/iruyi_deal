package com.faxintong.iruyi.dao.mybatis.microview;

import com.faxintong.iruyi.model.mybatis.microview.ViewDiscuss;
import com.faxintong.iruyi.model.mybatis.microview.ViewDiscussExample;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@OperateMyBatis
public interface ViewDiscussMapper {
    int countByExample(ViewDiscussExample example);

    int deleteByExample(ViewDiscussExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ViewDiscuss record);

    int insertSelective(ViewDiscuss record);

    List<ViewDiscuss> selectByExample(ViewDiscussExample example);

    ViewDiscuss selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ViewDiscuss record, @Param("example") ViewDiscussExample example);

    int updateByExample(@Param("record") ViewDiscuss record, @Param("example") ViewDiscussExample example);

    int updateByPrimaryKeySelective(ViewDiscuss record);

    int updateByPrimaryKey(ViewDiscuss record);
}