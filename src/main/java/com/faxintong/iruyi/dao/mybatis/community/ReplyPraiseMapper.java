package com.faxintong.iruyi.dao.mybatis.community;

import com.faxintong.iruyi.model.mybatis.community.ReplyPraise;
import com.faxintong.iruyi.model.mybatis.community.ReplyPraiseExample;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@OperateMyBatis
public interface ReplyPraiseMapper {
    int countByExample(ReplyPraiseExample example);

    int deleteByExample(ReplyPraiseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReplyPraise record);

    int insertSelective(ReplyPraise record);

    List<ReplyPraise> selectByExample(ReplyPraiseExample example);

    ReplyPraise selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReplyPraise record, @Param("example") ReplyPraiseExample example);

    int updateByExample(@Param("record") ReplyPraise record, @Param("example") ReplyPraiseExample example);

    int updateByPrimaryKeySelective(ReplyPraise record);

    int updateByPrimaryKey(ReplyPraise record);
}