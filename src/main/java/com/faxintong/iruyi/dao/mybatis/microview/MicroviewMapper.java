package com.faxintong.iruyi.dao.mybatis.microview;

import com.faxintong.iruyi.model.mybatis.microview.Microview;
import com.faxintong.iruyi.model.mybatis.microview.MicroviewExample;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@OperateMyBatis
public interface MicroviewMapper {
    int countByExample(MicroviewExample example);

    int deleteByExample(MicroviewExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Microview record);

    int insertSelective(Microview record);

    List<Microview> selectByExample(MicroviewExample example);

    Microview selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Microview record, @Param("example") MicroviewExample example);

    int updateByExample(@Param("record") Microview record, @Param("example") MicroviewExample example);

    int updateByPrimaryKeySelective(Microview record);

    int updateByPrimaryKey(Microview record);
}