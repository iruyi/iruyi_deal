package com.faxintong.iruyi.dao.mybatis.lawyer;

import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.lawyer.LawyerExample;
import com.faxintong.iruyi.operate.OperateMyBatis;
import com.faxintong.iruyi.utils.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@OperateMyBatis
public interface LawyerMapper {
    /**获取指定律师关注的律师列表*/
    List<Lawyer> selectById(Pager pager,Integer id);

    int countByExample(LawyerExample example);

    int deleteByExample(LawyerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Lawyer record);

    int insertSelective(Lawyer record);

    List<Lawyer> selectByExample(LawyerExample example);

    Lawyer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Lawyer record, @Param("example") LawyerExample example);

    int updateByExample(@Param("record") Lawyer record, @Param("example") LawyerExample example);

    int updateByPrimaryKeySelective(Lawyer record);

    int updateByPrimaryKey(Lawyer record);
}