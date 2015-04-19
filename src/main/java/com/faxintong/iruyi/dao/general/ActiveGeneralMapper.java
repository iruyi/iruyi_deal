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

}
