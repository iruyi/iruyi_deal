package com.faxintong.iruyi.service.indivcenter.impl;

import com.faxintong.iruyi.dao.mybatis.lawyer.LawyerMapper;
import com.faxintong.iruyi.model.general.Statistic;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.service.indivcenter.CenterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hehj on 15-1-3.
 */
@Service
public class CenterServiceImpl implements CenterService {

    private Logger logger = LoggerFactory.getLogger(CenterServiceImpl.class);

    @Autowired
    private LawyerMapper lawyerMapper;

    @Override
    public Lawyer findLawyerById(Long lawyerId) throws Exception {
        logger.info("律师id为" + lawyerId);
        return lawyerMapper.selectByPrimaryKey(lawyerId);
    }

    @Override
    public void modifyLawyer(Lawyer lawyer) throws Exception {
        logger.info("修改律师信息为：" + lawyer.toString());
        lawyerMapper.updateByPrimaryKeySelective(lawyer);
    }

    @Override
    public void modifyLawyerVersion(Lawyer lawyer) throws Exception {

    }

    @Override
    public Statistic lawyerStatistic(Long lawyerId) throws Exception {
        return null;
    }
}
