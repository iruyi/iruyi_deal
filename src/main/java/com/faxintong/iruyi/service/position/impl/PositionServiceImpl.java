package com.faxintong.iruyi.service.position.impl;

import com.faxintong.iruyi.dao.general.PositionGeneralMapper;
import com.faxintong.iruyi.model.mybatis.vo.PositionVo;
import com.faxintong.iruyi.service.position.PositionService;
import com.faxintong.iruyi.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yunaxie on 2015/4/21.
 */
@Service
public class PositionServiceImpl implements PositionService{
    @Autowired
    private PositionGeneralMapper positionGeneralMapper;

    @Override
    @Transactional
    public void positionStore(Long positionId, Long lawyerId) {
        positionGeneralMapper.insertPositionStore(positionId,lawyerId);
    }

    @Override
    public List<PositionVo> getPositionList(Pager pager) {
        return positionGeneralMapper.selectPositionVo(pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()),pager.getPageSize());
    }

    @Override
    public PositionVo positionDetail(Long positionId, Long lawyerId) {
        return positionGeneralMapper.selectPositionVoOne(positionId,lawyerId);
    }

    @Override
    public List<PositionVo> getStoreList(Pager pager, Long lawyerId) {
        return positionGeneralMapper.selectPositionStore(pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()),pager.getPageSize(),lawyerId);
    }


}
