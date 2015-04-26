package com.faxintong.iruyi.dao.mybatis.article;

import com.faxintong.iruyi.model.mybatis.article.ArticleStore;
import com.faxintong.iruyi.model.mybatis.article.ArticleStoreExample;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@OperateMyBatis
public interface ArticleStoreMapper {
    int countByExample(ArticleStoreExample example);

    int deleteByExample(ArticleStoreExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArticleStore record);

    int insertSelective(ArticleStore record);

    List<ArticleStore> selectByExample(ArticleStoreExample example);

    ArticleStore selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArticleStore record, @Param("example") ArticleStoreExample example);

    int updateByExample(@Param("record") ArticleStore record, @Param("example") ArticleStoreExample example);

    int updateByPrimaryKeySelective(ArticleStore record);

    int updateByPrimaryKey(ArticleStore record);
}