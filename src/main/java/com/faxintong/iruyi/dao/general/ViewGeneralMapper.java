package com.faxintong.iruyi.dao.general;

import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.vo.*;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by yunaxie on 2015/4/20.
 */
@OperateMyBatis
public interface ViewGeneralMapper {
    @Insert("insert into microview_praise(discuss_id,lawyer_id) values(#{discussId},#{lawyerId})")
    int insertViewPraise(@Param("discussId")Long discussId, @Param("lawyerId")Long lawyerId);

    @Insert("insert into microview_discuss(interview_id,type,content,lawyer_id,lawyer_name,create_date)" +
            " values(#{microViewId},#{type},#{content},#{lawyer.id},#{lawyer.name},now())" )
    int insertViewDiscuss(@Param("lawyer")Lawyer lawyer, @Param("microViewId")Long microViewId, @Param("content")String content, @Param("type")Integer type);

    @Insert("insert into microview_attention (interview_id,lawyer_id)" +
            " values(#{microViewId},#{lawyerId})" )
    int insertViewAtten(@Param("microViewId")Long microViewId, @Param("lawyerId")Long lawyerId);

    List<ViewVo> selectViewVo(@Param("startCount")Integer startCount, @Param("pageSize")Integer pageSize,@Param("lawyerId")Long lawyerId);

    ViewVo selectViewVoOne(@Param("microViewId")Long microViewId,@Param("lawyerId")Long lawyerId);

    List<ViewDiscussVo> selectViewDiscussVo(@Param("microViewId")Long microViewId,@Param("lawyerId")Long lawyerId);
}
