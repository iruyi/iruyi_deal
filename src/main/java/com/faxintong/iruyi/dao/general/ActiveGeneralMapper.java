package com.faxintong.iruyi.dao.general;

import com.faxintong.iruyi.model.mybatis.active.Active;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by admin on 15-4-19.
 */
@OperateMyBatis
public interface ActiveGeneralMapper {

    String VIEW = "id,title,content,photo_url as photoUrl,address,active_time as activeTime,create_date as createDate";

    @Select("select " + VIEW + " from active limit #{startCount},#{pagerSize}")
    public List<Active> getActiveList(@Param("startCount") Integer startCount, @Param("pagerSize") Integer pagerSize);

    @Select("select " + VIEW + " from active where lawyer_id=#{lawyerId} limit #{startCount},#{pagerSize}")
    public List<Active> getStoreActiveList(@Param("startCount") Integer startCount, @Param("pagerSize") Integer pagerSize, @Param("lawyerId") Long lawyerId);

    @Select("select l.photo_url from active_store s,lawyer l where s.active_id=#{activeId} and s.lawyer_id=l.id")
    public List<String> getPhotoList(@Param("activeId") Long activeId);

}
