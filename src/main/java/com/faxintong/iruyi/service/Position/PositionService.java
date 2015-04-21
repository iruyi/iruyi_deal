package com.faxintong.iruyi.service.Position;

import com.faxintong.iruyi.model.mybatis.vo.PositionVo;
import com.faxintong.iruyi.utils.Pager;

import java.util.List;

/**
 * Created by yunaxie on 2015/4/21.
 */
public interface PositionService {
    /**
     * 职位收藏
     * @param positionId
     * @param lawyerId
     */
    void positionStore(Long positionId,Long lawyerId);

    /**
     * 获取招聘列表
     * @param pager
     * @return
     */
    List<PositionVo> getPositionList(Pager pager);

    /**
     * 获取招聘详情
     * @param positionId
     * @param lawyerId
     * @return
     */
    PositionVo positionDetail(Long positionId,Long lawyerId);

    /**
     * 获取收藏列表
     * @param pager
     * @param lawyerId
     * @return
     */
    List<PositionVo> getStoreList(Pager pager,Long lawyerId);
}
