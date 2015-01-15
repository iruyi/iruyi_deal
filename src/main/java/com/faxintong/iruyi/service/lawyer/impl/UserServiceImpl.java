package com.faxintong.iruyi.service.lawyer.impl;

import com.faxintong.iruyi.dao.mybatis.lawyer.LawyerMapper;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.lawyer.LawyerExample;
import com.faxintong.iruyi.service.lawyer.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hehj on 15-1-3.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private LawyerMapper lawyerMapper;

    @Override
    public void registerLawyer(Lawyer lawyer) throws Exception {
        lawyerMapper.insertSelective(lawyer);
    }

    @Override
    public boolean regisValidate(String phone) throws Exception {
        return phone.matches("^1[0-9]{10}$");
    }

    @Override
    public boolean loginValidate(String phone, String password) throws Exception {
        LawyerExample lawyerExample = new LawyerExample();
        lawyerExample.createCriteria().andPhoneEqualTo(phone).andPasswordEqualTo(password);
        return lawyerMapper.countByExample(lawyerExample) == 1;
    }

    @Override
    public boolean containsPhone(String phone) throws Exception {
        LawyerExample lawyerExample = new LawyerExample();
        lawyerExample.createCriteria().andPhoneEqualTo(phone);
        return lawyerMapper.selectByExample(lawyerExample).size() == 1;
    }

    @Override
    public Lawyer getLawyer(String phone) {
        LawyerExample lawyerExample = new LawyerExample();
        lawyerExample.createCriteria().andPhoneEqualTo(phone);
        List<Lawyer> lawyerList = lawyerMapper.selectByExample(lawyerExample);
        return lawyerList.size() == 1 ? lawyerList.get(0) : null;
    }

    @Override
    public Lawyer getLawyerByPrimaryKey(Long key) {
        return lawyerMapper.selectByPrimaryKey(key);
    }

    @Override
    public List<Lawyer> getLawyersByPhone(List<String> phones) {
        LawyerExample lawyerExample = new LawyerExample();
        lawyerExample.createCriteria().andPhoneIn(phones);
        return lawyerMapper.selectByExample(lawyerExample);
    }

    @Override
    public void updateLawyerInfo(Lawyer lawyer) {
        lawyerMapper.updateByPrimaryKey(lawyer);
    }


}
