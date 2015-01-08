package com.faxintong.iruyi.dao.mybatis.lawyer;

import com.faxintong.iruyi.model.mybatis.lawyer.LawyerSkill;
import com.faxintong.iruyi.model.mybatis.lawyer.LawyerSkillExample;
import java.util.List;

import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;
@OperateMyBatis
public interface LawyerSkillMapper {
    int countByExample(LawyerSkillExample example);

    int deleteByExample(LawyerSkillExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LawyerSkill record);

    int insertSelective(LawyerSkill record);

    List<LawyerSkill> selectByExample(LawyerSkillExample example);

    LawyerSkill selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LawyerSkill record, @Param("example") LawyerSkillExample example);

    int updateByExample(@Param("record") LawyerSkill record, @Param("example") LawyerSkillExample example);

    int updateByPrimaryKeySelective(LawyerSkill record);

    int updateByPrimaryKey(LawyerSkill record);
}