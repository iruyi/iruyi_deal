package com.faxintong.iruyi.service.active.impl;

import com.faxintong.iruyi.model.mybatis.active.Active;
import com.faxintong.iruyi.service.active.ActiveService;
import com.faxintong.iruyi.utils.Pager;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 15-4-18.
 */
@Service
public class ActiveServiceImpl implements ActiveService {
    @Override
    public List<Active> getActiveList(Pager pager) throws Exception {
        return null;
    }

    @Override
    public Active getActiveDetail(Long activeId) throws Exception {
        return null;
    }

    @Override
    public void activeStore(Long activeId, Long lawyerId) throws Exception {

    }
}
