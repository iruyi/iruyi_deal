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

    String VIEW = "id,title,lawyer_id as lawyerId,lawyer_name as lawyerName,acro,content,url,create_date as createDate";

    @Select("select " + VIEW + " from app_article limit #{startCount},#{pagerSize}")
    public List<AppArticle> getAppArticleList(@Param("startCount") Integer startCount, @Param("pagerSize") Integer pagerSize);

    @Select("select " + VIEW + " from app_article where title like CONCAT('%',#{title},'%' ) limit #{startCount},#{pagerSize}")
    public List<AppArticle> titleAppArticle(@Param("startCount") Integer startCount, @Param("pagerSize") Integer pagerSize, @Param("title") String title);

    @Select("select " + VIEW + " from app_article where content like CONCAT('%',#{content},'%' ) limit #{startCount},#{pagerSize}")
    public List<AppArticle> contentAppArticle(@Param("startCount") Integer startCount, @Param("pagerSize") Integer pagerSize, @Param("content") String content);

    @Select("select " + VIEW + " from app_article where title like CONCAT('%',#{title},'%' ) and content like CONCAT('%',#{content},'%' ) limit #{startCount},#{pagerSize}")
    public List<AppArticle> allAppArticle(@Param("startCount") Integer startCount, @Param("pagerSize") Integer pagerSize, @Param("title") String title, @Param("content") String content);

    @Select("select id,article_id as articleId,lawyer_id as lawyerId,lawyer_name as lawyerName,`comment`,create_time as createTime from article_comment where article_id=#{articleId} limit #{startCount},#{pagerSize}")
    public List<ArticleComment> getCommentList(@Param("startCount") Integer startCount, @Param("pagerSize") Integer pagerSize,@Param("articleId") Long articleId);

    @Select("select " + VIEW + " from app_article where lawyer_id=#{lawyerId} limit #{startCount},#{pagerSize}")
    public List<AppArticle> getOwnArticleList(@Param("startCount") Integer startCount, @Param("pagerSize") Integer pagerSize,@Param("lawyerId") Long lawyerId );

    @Select("select a.id,a.title,a.lawyer_id as lawyerId,a.lawyer_name as lawyerName,a.url,a.content,a.acro,a.create_date as createDate " +
            "from app_article a,article_store s where a.id=s.article_id and s.lawyer_id=#{lawyerId} limit #{startCount},#{pagerSize}")
    public List<AppArticle> getStoreArticleList(@Param("startCount") Integer startCount, @Param("pagerSize") Integer pagerSize,@Param("lawyerId") Long lawyerId );

    /*@Select("select id,article_id as articleId,lawyer_id as lawyerId,lawyer_name as lawyerName,content,acro,create_time as createTime " +
            "from article_comment where lawyer_id=#{lawyerId} limit #{startCount},#{pagerSize}")
    public List<ArticleComment> getArticleCommentList(@Param("startCount") Integer startCount, @Param("pagerSize") Integer pagerSize,@Param("lawyerId") Long lawyerId );*/

    @Select("select c.id,c.article_id as articleId,c.lawyer_id as lawyerId,c.lawyer_name as lawyerName,c.content,c.acro,c.create_time as createTime " +
            "from article_comment c,article_comment_praise p where p.lawyer_id=#{lawyerId} and p.comment_id=c.id limit #{startCount},#{pagerSize}")
    public List<ArticleComment> getArticleCommentPraiseList(@Param("startCount") Integer startCount, @Param("pagerSize") Integer pagerSize,@Param("lawyerId") Long lawyerId );

}
