package com.faxintong.iruyi.service.friend;

/**
 * Created by bochenlong on 2015/5/10.
 */
public interface AttentionService {
    /**
     * 添加关注
     * @param lawyerId 要加关注的id
     * @param attenId 加关注的id
     */
    void makeAtten(Long lawyerId, Long attenId) throws Exception;

    /**
     * 删除关注
     * @param lawyerId
     * @param attenId
     */
    void delAtten(Long lawyerId, Long attenId) throws Exception;
}
