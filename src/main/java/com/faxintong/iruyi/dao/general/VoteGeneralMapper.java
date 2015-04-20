package com.faxintong.iruyi.dao.general;

import com.faxintong.iruyi.model.mybatis.vo.VoteVo;
import com.faxintong.iruyi.operate.OperateMyBatis;
import com.faxintong.iruyi.utils.Pager;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by yunaxie on 2015/4/20.
 */
@OperateMyBatis
public interface VoteGeneralMapper {

    int insertVoteResult(@Param("voteId")Long voteId, @Param("optionId")Long optionId, @Param("lawyerId")Long lawyerId);

    List<VoteVo> selectVoteVoteOption(@Param("startCount")Integer startCount, @Param("pageSize")Integer pageSize);

    @Select("select option_id optionId,count(id) optionNum from vote_result where vote_id = #{voteId} group by option_id")
    List<Map<String,Long>> countVoteOptionGroupByOptionId(@Param("voteId")Long voteId);
}
