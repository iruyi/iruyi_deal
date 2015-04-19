package com.faxintong.iruyi.service.active.impl;

import com.faxintong.iruyi.dao.general.ActiveGeneralMapper;
import com.faxintong.iruyi.dao.mybatis.active.ActiveMapper;
import com.faxintong.iruyi.model.mybatis.active.Active;
import com.faxintong.iruyi.service.active.ActiveService;
import com.faxintong.iruyi.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 15-4-18.
 */
@Service
public class ActiveServiceImpl implements ActiveService {

    @Autowired
    private ActiveGeneralMapper activeGeneralMapper;

    @Autowired
    private ActiveMapper activeMapper;

    private 

    @Override
    public List<Active> getActiveList(Pager pager) throws Exception {
        return activeGeneralMapper.getActiveList(pager.getStartCount(pager.getPageSize(), pager.getCurrentPage()), pager.getPageSize());
    }

    @Override
    public Active getActiveDetail(Long activeId) throws Exception {
        return activeMapper.selectByPrimaryKey(activeId);
    }

    @Override
    public void activeStore(Long activeId, Long lawyerId) throws Exception {

    }
}
