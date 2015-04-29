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

    String VIEW = "a.id,a.title,a.content,a.photo_url as photoUrl,a.address,a.active_time as activeTime,a.create_date as createDate";

    @Select("select " + VIEW + " from active a limit #{startCount},#{pagerSize}")
    public List<Active> getActiveList(@Param("startCount") Integer startCount, @Param("pagerSize") Integer pagerSize);

    @Select("select " + VIEW + " from active_store s,active a where s.lawyer_id=#{lawyerId} and s.active_id=a.id limit #{startCount},#{pagerSize}")
    public List<Active> getStoreActiveList(@Param("startCount") Integer startCount, @Param("pagerSize") Integer pagerSize, @Param("lawyerId") Long lawyerId);

    @Select("select l.photo_url from active_store s,lawyer l where s.active_id=#{activeId} and s.lawyer_id=l.id")
    public List<String> getPhotoList(@Param("activeId") Long activeId);

}
