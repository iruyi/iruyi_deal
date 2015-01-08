package com.faxintong.iruyi.service.lawyer.impl;

import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.service.lawyer.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by hehj on 15-1-3.
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void registerLawyer(Lawyer lawyer) throws Exception {

    }

    @Override
    public boolean regisValidate(String phone) throws Exception {
        return false;
    }

    @Override
    public boolean loginValidate(String loginName, String password) throws Exception {
        return false;
    }
}
