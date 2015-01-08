package com.faxintong.iruyi.dao.mybatis.friendcircle;

import com.faxintong.iruyi.model.mybatis.friendcircle.Paper;
import com.faxintong.iruyi.model.mybatis.friendcircle.PaperExample;
import java.util.List;

import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;
@OperateMyBatis
public interface PaperMapper {
    int countByExample(PaperExample example);

    int deleteByExample(PaperExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Paper record);

    int insertSelective(Paper record);

    List<Paper> selectByExampleWithBLOBs(PaperExample example);

    List<Paper> selectByExample(PaperExample example);

    Paper selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Paper record, @Param("example") PaperExample example);

    int updateByExampleWithBLOBs(@Param("record") Paper record, @Param("example") PaperExample example);

    int updateByExample(@Param("record") Paper record, @Param("example") PaperExample example);

    int updateByPrimaryKeySelective(Paper record);

    int updateByPrimaryKeyWithBLOBs(Paper record);

    int updateByPrimaryKey(Paper record);
}