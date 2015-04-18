package com.faxintong.iruyi.service.lawyer;

import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.utils.Pager;

import java.util.List;

/**
 * Created by admin on 15-4-18.
 */
public interface LawyerService {

    /**
     * 获取律师关注列表
     * @param pager
     * @return
     */
    public List<Lawyer> getAttetionList(Pager pager) throws Exception;

}
