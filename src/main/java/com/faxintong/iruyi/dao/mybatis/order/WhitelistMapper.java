package com.faxintong.iruyi.dao.mybatis.order;

import com.faxintong.iruyi.model.mybatis.order.Whitelist;
import com.faxintong.iruyi.model.mybatis.order.WhitelistExample;
import java.util.List;

import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;
@OperateMyBatis
public interface WhitelistMapper {
    int countByExample(WhitelistExample example);

    int deleteByExample(WhitelistExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Whitelist record);

    int insertSelective(Whitelist record);

    List<Whitelist> selectByExample(WhitelistExample example);

    Whitelist selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Whitelist record, @Param("example") WhitelistExample example);

    int updateByExample(@Param("record") Whitelist record, @Param("example") WhitelistExample example);

    int updateByPrimaryKeySelective(Whitelist record);

    int updateByPrimaryKey(Whitelist record);
}