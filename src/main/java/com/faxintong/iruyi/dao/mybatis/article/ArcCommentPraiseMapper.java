package com.faxintong.iruyi.dao.mybatis.article;

import com.faxintong.iruyi.model.mybatis.article.ArcCommentPraise;
import com.faxintong.iruyi.model.mybatis.article.ArcCommentPraiseExample;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@OperateMyBatis
public interface ArcCommentPraiseMapper {
    int countByExample(ArcCommentPraiseExample example);

    int deleteByExample(ArcCommentPraiseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArcCommentPraise record);

    int insertSelective(ArcCommentPraise record);

    List<ArcCommentPraise> selectByExample(ArcCommentPraiseExample example);

    ArcCommentPraise selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArcCommentPraise record, @Param("example") ArcCommentPraiseExample example);

    int updateByExample(@Param("record") ArcCommentPraise record, @Param("example") ArcCommentPraiseExample example);

    int updateByPrimaryKeySelective(ArcCommentPraise record);

    int updateByPrimaryKey(ArcCommentPraise record);
}