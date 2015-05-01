package com.faxintong.iruyi.service.microview.impl;

import com.faxintong.iruyi.dao.general.LawyerGeneralMapper;
import com.faxintong.iruyi.dao.general.ViewGeneralMapper;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.microview.Microview;
import com.faxintong.iruyi.model.mybatis.microview.ViewDiscuss;
import com.faxintong.iruyi.model.mybatis.vo.ViewDiscussVo;
import com.faxintong.iruyi.model.mybatis.vo.ViewVo;
import com.faxintong.iruyi.service.microview.ViewService;
import com.faxintong.iruyi.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.View;
import java.util.List;

/**
 * Created by admin on 15-4-18.
 */
@Service
public class ViewServiceImpl implements ViewService{
    @Autowired
    private ViewGeneralMapper viewGeneralMapper;

    @Override
    public List<ViewVo> getViewList(Pager pager,Long lawyerId) {
        return viewGeneralMapper.selectViewVo(pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()), pager.getPageSize(),lawyerId);
    }

    @Override
    //TODO 以后要加分页
    public ViewVo viewDetail(Long microViewId,Long lawyerId,Pager pager) {
        ViewVo viewVo = viewGeneralMapper.selectViewVoOne(microViewId,lawyerId);
        List<ViewDiscussVo> viewDiscussList = viewGeneralMapper.selectViewDiscussVo(pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()),pager.getPageSize(),microViewId,lawyerId);
        viewVo.setViewDiscussVoList(viewDiscussList);
        return viewVo;
    }

    @Override
    @Transactional
    public void viewAttention(Long microViewId, Long lawyerId) {
        viewGeneralMapper.insertViewAtten(microViewId,lawyerId);
    }

    @Override
    @Transactional
    public void viewDiscuss(Lawyer lawyer, Long microViewId, String content, Integer type) throws Exception {
        viewGeneralMapper.insertViewDiscuss(lawyer,microViewId,content,type);
    }

    @Override
    @Transactional
    public void discussPraise(Long discussId, Long lawyerId) throws Exception {
        viewGeneralMapper.insertViewPraise(discussId,lawyerId);
    }

}
