package com.faxintong.iruyi.service.lawyer.impl;

import com.faxintong.iruyi.dao.mybatis.lawyer.LawyerMapper;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.lawyer.LawyerExample;
import com.faxintong.iruyi.service.im.HxService;
import com.faxintong.iruyi.service.lawyer.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hehj on 15-1-3.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private LawyerMapper lawyerMapper;
    @Autowired
    private HxService hxService;

    @Override
    @Transactional
    public void registerLawyer(Lawyer lawyer) throws Exception {
        // 修改插入mapper ，返回插入值的id
        lawyerMapper.insertSelective(lawyer);
        // add 20150510 添加用户时，添加环信用户；两者都成功才成功
        Lawyer lawyer1 = getLawyer(lawyer.getPhone());
        hxService.registerHxUser(lawyer1.getId().toString(), String.valueOf(lawyer1.getPassword().hashCode()));
    }

    @Override
    public boolean regisValidate(String phone) throws Exception {
        return phone.matches("^[0-9]{11}$");
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
        Integer count = lawyerMapper.countByExample(lawyerExample);
        if(count != null && count.intValue() > 0){
            return true;
        }else{
            return false;
        }
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

    /**
     * 关于phones是否为空的控制!
     * @param phones
     * @return
     */
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
