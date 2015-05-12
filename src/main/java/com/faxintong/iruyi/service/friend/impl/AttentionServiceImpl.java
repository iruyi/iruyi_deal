package com.faxintong.iruyi.service.friend.impl;

import com.faxintong.iruyi.dao.general.AttentionGeneralMapper;
import com.faxintong.iruyi.service.friend.AttentionService;
import com.faxintong.iruyi.service.im.HxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by bochenlong on 2015/5/10.
 */
@Service
public class AttentionServiceImpl implements AttentionService {
    @Autowired
    private AttentionGeneralMapper attentionGeneralMapper;
    @Autowired
    private HxService hxService;

    @Override
    @Transactional
    public void makeAtten(Long lawyerId, Long attenId) throws Exception {
        int hasAtten = attentionGeneralMapper.selectIsAttent(lawyerId,attenId);
        if(hasAtten>0) {
            throw new Exception("已关注改用户！");
        }

        attentionGeneralMapper.insertAtten(lawyerId, attenId);
        // add 20150510 如果相互关注，则添加环信好友；两者都成功才成功
        // 环信加好友都是双向的
        int n = attentionGeneralMapper.selectIsAttent(attenId,lawyerId);
        hxService.makeHxFriend(lawyerId.toString(), attenId.toString());
    }

    @Override
    @Transactional
    public void delAtten(Long lawyerId, Long attenId) throws Exception {
        attentionGeneralMapper.delAtten(lawyerId, attenId);
        // add 20150510 删除好友时，删除环信好友；两者都删除才成功
        hxService.delHxFriend(lawyerId.toString(),attenId.toString());
    }
}
