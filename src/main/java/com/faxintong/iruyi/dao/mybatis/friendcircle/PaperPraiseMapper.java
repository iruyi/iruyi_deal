package com.faxintong.iruyi.dao.mybatis.friendcircle;

import com.faxintong.iruyi.model.mybatis.friendcircle.PaperPraise;
import com.faxintong.iruyi.model.mybatis.friendcircle.PaperPraiseExample;
import java.util.List;

import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;
@OperateMyBatis
public interface PaperPraiseMapper {
    int countByExample(PaperPraiseExample example);

    int deleteByExample(PaperPraiseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PaperPraise record);

    int insertSelective(PaperPraise record);

    List<PaperPraise> selectByExample(PaperPraiseExample example);

    PaperPraise selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PaperPraise record, @Param("example") PaperPraiseExample example);

    int updateByExample(@Param("record") PaperPraise record, @Param("example") PaperPraiseExample example);

    int updateByPrimaryKeySelective(PaperPraise record);

    int updateByPrimaryKey(PaperPraise record);
}