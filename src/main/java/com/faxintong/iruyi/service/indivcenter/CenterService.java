package com.faxintong.iruyi.service.indivcenter;

import com.faxintong.iruyi.model.general.Statistic;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;

/**
 * Created by hehj on 15-1-3.
 */
public interface CenterService {

    /**
     * 通过律师id获取律师详情
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public Lawyer findLawyerById(Long lawyerId) throws Exception;

    /**
     * 已注册成功律师修改不需要审核部分
     * @param lawyer
     * @throws Exception
     */
    public void modifyLawyer(Lawyer lawyer) throws Exception;

    /**
     * 已注册成功律师修改需要审核部分
     * @param lawyer
     * @throws Exception
     */
    public void modifyLawyerVersion(Lawyer lawyer) throws Exception;

    /**
     * 律师相关数据统计
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public Statistic lawyerStatistic(Long lawyerId) throws Exception;
}
