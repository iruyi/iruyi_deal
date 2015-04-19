package com.faxintong.iruyi.dao.general;

import com.faxintong.iruyi.model.mybatis.article.AppArticle;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by admin on 15-4-19.
 */

public interface ArticleGeneralMapper {

    String VIEW = "id,type,lawyer_id as lawyerId,url,comment,create_date as createDate";

    @Select("select " + VIEW + " from app_article limit #{startCount},#{pagerSize}")
    public List<AppArticle> getAppArticleList(@Param("startCount") Integer startCount, @Param("pagerSize") Integer pagerSize);

}
