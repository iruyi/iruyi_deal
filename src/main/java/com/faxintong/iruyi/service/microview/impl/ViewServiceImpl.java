package com.faxintong.iruyi.service.microview.impl;

import com.faxintong.iruyi.model.mybatis.microview.Microview;
import com.faxintong.iruyi.service.microview.ViewService;
import com.faxintong.iruyi.utils.Pager;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 15-4-18.
 */
@Service
public class ViewServiceImpl implements ViewService{


    @Override
    public List<Microview> getViewList(Pager pager) {
        return null;
    }

    @Override
    public Microview viewDetail(Long microViewId) {
        return null;
    }

    @Override
    public void viewAttention(Long microViewId, Long lawyerId) {

    }

    @Override
    public void viewDiscuss(Long lawyerId, Long microViewId, String content, Integer type) throws Exception {

    }

    @Override
    public void discussPraise(Long discussId, Long lawyerId) throws Exception {

    }

}
