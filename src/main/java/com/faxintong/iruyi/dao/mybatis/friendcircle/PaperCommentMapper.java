package com.faxintong.iruyi.dao.mybatis.friendcircle;

import com.faxintong.iruyi.model.mybatis.friendcircle.PaperComment;
import com.faxintong.iruyi.model.mybatis.friendcircle.PaperCommentExample;
import java.util.List;

import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;
@OperateMyBatis
public interface PaperCommentMapper {
    int countByExample(PaperCommentExample example);

    int deleteByExample(PaperCommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PaperComment record);

    int insertSelective(PaperComment record);

    List<PaperComment> selectByExample(PaperCommentExample example);

    PaperComment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PaperComment record, @Param("example") PaperCommentExample example);

    int updateByExample(@Param("record") PaperComment record, @Param("example") PaperCommentExample example);

    int updateByPrimaryKeySelective(PaperComment record);

    int updateByPrimaryKey(PaperComment record);
}