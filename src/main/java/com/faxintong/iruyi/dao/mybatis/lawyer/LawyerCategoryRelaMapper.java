package com.faxintong.iruyi.dao.mybatis.lawyer;

import com.faxintong.iruyi.model.mybatis.lawyer.LawyerCategoryRela;
import com.faxintong.iruyi.model.mybatis.lawyer.LawyerCategoryRelaExample;
import java.util.List;

import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;
@OperateMyBatis
public interface LawyerCategoryRelaMapper {
    int countByExample(LawyerCategoryRelaExample example);

    int deleteByExample(LawyerCategoryRelaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LawyerCategoryRela record);

    int insertSelective(LawyerCategoryRela record);

    List<LawyerCategoryRela> selectByExample(LawyerCategoryRelaExample example);

    LawyerCategoryRela selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LawyerCategoryRela record, @Param("example") LawyerCategoryRelaExample example);

    int updateByExample(@Param("record") LawyerCategoryRela record, @Param("example") LawyerCategoryRelaExample example);

    int updateByPrimaryKeySelective(LawyerCategoryRela record);

    int updateByPrimaryKey(LawyerCategoryRela record);
}