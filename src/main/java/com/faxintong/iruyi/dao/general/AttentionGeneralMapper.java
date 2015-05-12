package com.faxintong.iruyi.dao.general;

import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by bochenlong on 2015/5/10.
 */
@OperateMyBatis
public interface AttentionGeneralMapper {
    @Insert("insert into lawyer_attention(lawyer_id,other_lawyer_id,create_time) values(#{lawyerId},#{attenId},now())")
    int insertAtten(@Param("lawyerId") Long lawyerId, @Param("attenId") Long attenId);

    @Delete("delete from lawyer_attention where lawyer_id = #{lawyerId} and other_lawyer_id = #{attenId}")
    int delAtten(@Param("lawyerId") Long lawyerId, @Param("attenId") Long attenId);

    @Select("select count(*) from lawyer_attention where lawyer_id = #{lawyerId1} and other_lawyer_id = #{lawyerId2}")
    int selectIsAttent(@Param("lawyerId1")long lawyerId1,@Param("lawyerId2")Long lawyerId2);
}
