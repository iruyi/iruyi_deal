package com.faxintong.iruyi.dao.general;

import com.faxintong.iruyi.model.mybatis.vo.CityVo;
import com.faxintong.iruyi.model.mybatis.vo.LawyerVo;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by yunaxie on 2015/4/21.
 */
@OperateMyBatis
public interface LawyerGeneralMapper {
    @ResultType(LawyerVo.class)
    @Select("select l.id,l.name,l.city_name cityName,l.photo_url photoUrl,l.law_office lawOffice,l.introduction" +
            ",(select count(*) from lawyer_attention la where la.lawyer_id = #{lawyerId}) attentionCount" +
            ",(select count(*) from lawyer_attention la1 where la1.other_lawyer_id = #{lawyerId}) fansCount" +
            " from lawyer l" +
            " where l.id = #{lawyerId}")
    LawyerVo selectLawyerVoOne(@Param("lawyerId")Long lawyerId);

    @Select("select id,name from city limit #{startCount},#{pageSize}")
    List<CityVo> selectCityVo(@Param("startCount")Integer startCount, @Param("pageSize")Integer pageSize);

    @ResultType(LawyerVo.class)
    @Select("select l.id,name,l.photo_url photoUrl" +
            " from lawyer_attention la" +
            " inner join lawyer l on l.id = la.other_lawyer_id" +
            " where la.lawyer_id = #{lawyerId}" +
            " limit #{startCount},#{pageSize}")
    List<LawyerVo> selectLawyerVo(@Param("startCount")Integer startCount, @Param("pageSize")Integer pageSize,@Param("lawyerId")Long lawyerId);

    @Select("select count(*) from lawyer_attention where lawyer_id = #{lawyerId}")
    int countFansByLawyerId(@Param("lawyerId")Long lawyerId);
}
