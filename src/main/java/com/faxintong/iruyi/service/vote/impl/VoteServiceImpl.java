package com.faxintong.iruyi.service.vote.impl;

import com.faxintong.iruyi.dao.general.VoteGeneralMapper;
import com.faxintong.iruyi.model.mybatis.vo.VoteVo;
import com.faxintong.iruyi.model.mybatis.vote.Vote;
import com.faxintong.iruyi.service.vote.VoteService;
import com.faxintong.iruyi.utils.Pager;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 15-4-18.
 * @author bochenlong
 */
@Service
public class VoteServiceImpl implements VoteService {
    @Autowired
    private VoteGeneralMapper voteGeneralMapper;// vote Mybatis
    @Override
    public List<VoteVo> getVoteList(Pager pager) throws Exception {
        return voteGeneralMapper.selectVoteVoteOption(pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()), pager.getPageSize());
    }

    @Override
    public VoteVo voteDetail(Long voteId) throws Exception {
        List<Map<String,Long>> list = voteGeneralMapper.countVoteOptionGroupByOptionId(voteId);
        int sum = 0;
        Map<String,Integer> reMap = Maps.newHashMap();
        // 这里投个懒，手工过滤一遍，分装成对应的数据
        // 注意字段值要非常一致
        for(int i=0;i<list.size();i++) {
            Map<String,Long> map = list.get(i);
            int n = map.get("optionNum").intValue();
            sum += n;
            reMap.put(map.get("optionId").toString(),n);
        }

        VoteVo voteVo = new VoteVo();
        voteVo.setVoteSum(sum);
        voteVo.setOptionNumMap(reMap);
        return voteVo;
    }

    @Override
    @Transactional
    public void voteChoise(Long voteId, Long optionId, Long lawyerId) throws Exception {
        voteGeneralMapper.insertVoteResult(voteId,optionId,lawyerId);
    }
}
