package com.faxintong.iruyi.dao.general;

import com.faxintong.iruyi.model.mybatis.article.AppArticle;
import com.faxintong.iruyi.model.mybatis.article.ArticleComment;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by admin on 15-4-19.
 */
@OperateMyBatis
public interface ArticleGeneralMapper {

    String VIEW = "id,type,lawyer_id as lawyerId,url,comment,create_date as createDate";

    @Select("select " + VIEW + " from app_article limit #{startCount},#{pagerSize}")
    public List<AppArticle> getAppArticleList(@Param("startCount") Integer startCount, @Param("pagerSize") Integer pagerSize);

    @Select("select " + VIEW + " from app_article where lawyer_id=#{lawyerId} limit #{startCount},#{pagerSize}")
    public List<AppArticle> getOwnArticleList(@Param("startCount") Integer startCount, @Param("pagerSize") Integer pagerSize,@Param("lawyerId") Long lawyerId );

    @Select("select a.id,a.type,a.lawyer_id as lawyerId,a.url,a.comment,a.create_date as createDate " +
            "from app_article a,article_store s where a.id=s.article_id and s.lawyer_id=#{lawyerId} limit #{startCount},#{pagerSize}")
    public List<AppArticle> getStoreArticleList(@Param("startCount") Integer startCount, @Param("pagerSize") Integer pagerSize,@Param("lawyerId") Long lawyerId );

    @Select("select id,article_id as articleId,lawyer_id as lawyerId,lawyer_name as lawyerName,comment,create_time as createTime " +
            "from article_comment where lawyer_id=#{lawyerId} limit #{startCount},#{pagerSize}")
    public List<ArticleComment> getArticleCommentList(@Param("startCount") Integer startCount, @Param("pagerSize") Integer pagerSize,@Param("lawyerId") Long lawyerId );

}
