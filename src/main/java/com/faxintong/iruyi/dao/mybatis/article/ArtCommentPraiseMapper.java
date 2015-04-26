package com.faxintong.iruyi.dao.mybatis.article;

import com.faxintong.iruyi.model.mybatis.article.ArtCommentPraise;
import com.faxintong.iruyi.model.mybatis.article.ArtCommentPraiseExample;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@OperateMyBatis
public interface ArtCommentPraiseMapper {
    int countByExample(ArtCommentPraiseExample example);

    int deleteByExample(ArtCommentPraiseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArtCommentPraise record);

    int insertSelective(ArtCommentPraise record);

    List<ArtCommentPraise> selectByExample(ArtCommentPraiseExample example);

    ArtCommentPraise selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArtCommentPraise record, @Param("example") ArtCommentPraiseExample example);

    int updateByExample(@Param("record") ArtCommentPraise record, @Param("example") ArtCommentPraiseExample example);

    int updateByPrimaryKeySelective(ArtCommentPraise record);

    int updateByPrimaryKey(ArtCommentPraise record);
}