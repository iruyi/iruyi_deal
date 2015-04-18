package com.faxintong.iruyi.dao.mybatis.article;

import com.faxintong.iruyi.model.mybatis.article.ArticlePraise;
import com.faxintong.iruyi.model.mybatis.article.ArticlePraiseExample;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@OperateMyBatis
public interface ArticlePraiseMapper {
    int countByExample(ArticlePraiseExample example);

    int deleteByExample(ArticlePraiseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArticlePraise record);

    int insertSelective(ArticlePraise record);

    List<ArticlePraise> selectByExample(ArticlePraiseExample example);

    ArticlePraise selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArticlePraise record, @Param("example") ArticlePraiseExample example);

    int updateByExample(@Param("record") ArticlePraise record, @Param("example") ArticlePraiseExample example);

    int updateByPrimaryKeySelective(ArticlePraise record);

    int updateByPrimaryKey(ArticlePraise record);
}