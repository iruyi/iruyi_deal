package com.faxintong.iruyi.controller.vote;

import com.faxintong.iruyi.utils.Pager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by admin on 15-4-18.
 */
@RestController
@RequestMapping("vote")
public class VoteController {

    /**
     * 获取投票列表
     * @param pager
     * @return
     */
    @RequestMapping(value = "getVoteList")
    public Map<String, Object> getVoteList(Pager pager){

        return null;
    }

    /**
     * 获取投票详情
     * @param voteId
     * @return
     */
    @RequestMapping(value = "voteDetail")
    public Map<String, Object> voteDetail(Long voteId){

        return null;
    }

    /**
     * 投票选择
     * @param voteId
     * @param optionId
     * @return
     */
    @RequestMapping(value = "voteChoise")
    public Map<String, Object> voteChoise(Long voteId, Long optionId){

        return null;
    }
}
