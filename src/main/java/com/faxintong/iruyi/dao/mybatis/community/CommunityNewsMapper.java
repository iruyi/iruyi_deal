package com.faxintong.iruyi.dao.mybatis.community;

import com.faxintong.iruyi.model.mybatis.community.CommunityNews;
import com.faxintong.iruyi.operate.OperateMyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ron on 2015/2/10.
 */
@OperateMyBatis
public interface CommunityNewsMapper {
    List<CommunityNews> getCommunityNews(@Param("page") Integer page,@Param("pageSize")  Integer pageSize);
}
