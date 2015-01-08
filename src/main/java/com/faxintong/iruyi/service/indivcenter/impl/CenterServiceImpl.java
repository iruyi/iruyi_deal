package com.faxintong.iruyi.service.indivcenter.impl;

import com.faxintong.iruyi.dao.mybatis.lawyer.LawyerMapper;
import com.faxintong.iruyi.model.general.Statistic;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.service.indivcenter.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hehj on 15-1-3.
 */
@Service
public class CenterServiceImpl implements CenterService {

    @Autowired
    private LawyerMapper lawyerMapper;

    @Override
    public Lawyer findLawyerById(Long lawyerId) throws Exception {
        if(lawyerId == null){
            return null;
        }
        return lawyerMapper.selectByPrimaryKey(lawyerId);
    }

    @Override
    public void modifyLawyer(Lawyer lawyer) throws Exception {

    }

    @Override
    public void modifyLawyerVersion(Lawyer lawyer) throws Exception {

    }

    @Override
    public Statistic lawyerStatistic(Long lawyerId) throws Exception {
        return null;
    }
}
