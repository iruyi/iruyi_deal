package com.faxintong.iruyi.dao.mybatis.article;

import com.faxintong.iruyi.model.mybatis.article.AppArticle;
import com.faxintong.iruyi.model.mybatis.article.AppArticleExample;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@OperateMyBatis
public interface AppArticleMapper {
    int countByExample(AppArticleExample example);

    int deleteByExample(AppArticleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppArticle record);

    int insertSelective(AppArticle record);

    List<AppArticle> selectByExample(AppArticleExample example);

    AppArticle selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AppArticle record, @Param("example") AppArticleExample example);

    int updateByExample(@Param("record") AppArticle record, @Param("example") AppArticleExample example);

    int updateByPrimaryKeySelective(AppArticle record);

    int updateByPrimaryKey(AppArticle record);
}