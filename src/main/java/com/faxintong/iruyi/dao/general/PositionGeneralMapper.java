package com.faxintong.iruyi.dao.general;

import com.faxintong.iruyi.model.mybatis.vo.PositionVo;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yunaxie on 2015/4/21.
 */
@OperateMyBatis
public interface PositionGeneralMapper {
    @Insert("insert into position_store(position_id,lawyer_id) values(#{positionId},#{lawyerId})")
    int insertPositionStore(@Param("positionId")Long positionId,@Param("lawyerId")Long lawyerId);

    List<PositionVo> selectPositionVo(@Param("startCount")Integer startCount, @Param("pageSize")Integer pageSize);

    PositionVo selectPositionVoOne(@Param("positionId")Long positionId,@Param("lawyerId")Long lawyerId);

    List<PositionVo> selectPositionStore(@Param("startCount")Integer startCount, @Param("pageSize")Integer pageSize,@Param("lawyerId")Long lawyerId);

}
