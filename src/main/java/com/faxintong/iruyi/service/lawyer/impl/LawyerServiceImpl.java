package com.faxintong.iruyi.service.lawyer.impl;

import com.faxintong.iruyi.model.mybatis.lawyer.City;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.service.lawyer.LawyerService;
import com.faxintong.iruyi.utils.Pager;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 15-4-18.
 */
@Service
public class LawyerServiceImpl implements LawyerService {

    @Override
    public List<Lawyer> getAttetionList(Pager pager) throws Exception {
        return null;
    }

    @Override
    public List<City> getCityList(Pager pager) {
        return null;
    }

}
