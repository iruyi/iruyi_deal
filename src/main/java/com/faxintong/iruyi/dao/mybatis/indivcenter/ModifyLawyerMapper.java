package com.faxintong.iruyi.dao.mybatis.indivcenter;

import com.faxintong.iruyi.model.mybatis.indivcenter.ModifyLawyer;
import com.faxintong.iruyi.model.mybatis.indivcenter.ModifyLawyerExample;
import java.util.List;

import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;
@OperateMyBatis
public interface ModifyLawyerMapper {
    int countByExample(ModifyLawyerExample example);

    int deleteByExample(ModifyLawyerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ModifyLawyer record);

    int insertSelective(ModifyLawyer record);

    List<ModifyLawyer> selectByExample(ModifyLawyerExample example);

    ModifyLawyer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ModifyLawyer record, @Param("example") ModifyLawyerExample example);

    int updateByExample(@Param("record") ModifyLawyer record, @Param("example") ModifyLawyerExample example);

    int updateByPrimaryKeySelective(ModifyLawyer record);

    int updateByPrimaryKey(ModifyLawyer record);
}