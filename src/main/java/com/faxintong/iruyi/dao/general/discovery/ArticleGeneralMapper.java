package com.faxintong.iruyi.dao.general.discovery;

import com.faxintong.iruyi.model.general.article.GeneralArticle;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by hehongju on 2015/2/13.
 */
@OperateMyBatis
public interface ArticleGeneralMapper {


    @Select("select id,title,content,creator,create_date from article where type=#{type} limit #{currentSize},#{pageSize}")
    public List<GeneralArticle> findArticles(@Param("pageSize") Integer pageSize, @Param("currentSize") Integer currentSize, @Param("type") Integer type) throws Exception;


}
