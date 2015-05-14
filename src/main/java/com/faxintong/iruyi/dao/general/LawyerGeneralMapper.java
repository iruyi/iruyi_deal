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
            " ,(select count(*) from lawyer_attention la1 where la1.lawyer_id = la.other_lawyer_id and la1.other_lawyer_id = #{lawyerId}) isAttenEachOther" +
            " from lawyer_attention la" +
            " inner join lawyer l on l.id = la.other_lawyer_id" +
            " where la.lawyer_id = #{lawyerId}" +
            " limit #{startCount},#{pageSize}")
    List<LawyerVo> selectLawyerVo(@Param("startCount")Integer startCount, @Param("pageSize")Integer pageSize,@Param("lawyerId")Long lawyerId);

    @Select("select count(*) from lawyer_attention where lawyer_id = #{lawyerId}")
    int countFansByLawyerId(@Param("lawyerId")Long lawyerId);

    /**
     * 查看群组里的成员信息
     * @param groupId
     * @return
     */
    @Select("select l.id id,l.name name,l.photo_url photoUrl" +
            " from lawyer_group_member lgm" +
            " inner join lawyer l on l.id = lgm.lawyer_id" +
            " where lgm.group_id = #{groupId}" +
            " order by lgm.id" +
            " limit #{startCount},#{pageSize}")
    List<LawyerVo> selectGroupLaywer(@Param("startCount")Integer startCount, @Param("pageSize")Integer pageSize,@Param("groupId")String groupId);
}
