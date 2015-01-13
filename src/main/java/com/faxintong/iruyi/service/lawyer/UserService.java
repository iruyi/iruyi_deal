package com.faxintong.iruyi.service.lawyer;

import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;

/**
 * Created by hehj on 15-1-3.
 */
public interface UserService {

    /**
     * 律师注册
     * @param lawyer
     */
    public void registerLawyer(Lawyer lawyer) throws Exception;

    /**
     * 注册验证
     * @param phone
     * @return
     * @throws Exception
     */
    public boolean regisValidate(String phone) throws Exception;

    /**
     * 登录验证
     * @param phone
     * @param password
     * @return
     * @throws Exception
     */
    public boolean loginValidate(String phone, String password) throws Exception;

    /**
     * 判断手机号是否已经注册
     * @param phone
     * @return
     * @throws Exception
     */
    public boolean containsPhone(String phone) throws Exception;

    /**
     * 获取律师
     * @param phone
     * @return
     */
    public Lawyer getLawyer(String phone);

    /**
     * 通过id获取律师
     * @param key
     * @return
     */
    public Lawyer getLawyerByPrimaryKey(Long key);
}
