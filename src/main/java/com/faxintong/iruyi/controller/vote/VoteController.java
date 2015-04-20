package com.faxintong.iruyi.controller.vote;

import com.faxintong.iruyi.controller.BaseController;
import com.faxintong.iruyi.model.mybatis.vo.VoteVo;
import com.faxintong.iruyi.service.vote.VoteService;
import com.faxintong.iruyi.utils.Pager;
import com.faxintong.iruyi.utils.RedisUtils;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

import static com.faxintong.iruyi.utils.Constants.*;

/**
 * Created by admin on 15-4-18.
 */
@RestController
@RequestMapping("vote")
public class VoteController extends BaseController{
    private Logger logger = LoggerFactory.getLogger(VoteController.class);

    @Autowired
    private VoteService voteService;// 投票服务

    /**
     * 获取投票列表
     * @param pager
     * @return
     */
    @RequestMapping(value = "getVoteList")
    public Map<String, Object> getVoteList(Pager pager){
        Map<String, Object> result = Maps.newHashMap();
        result.put(ERRCODE, 0);
        try {
            if(pager == null || pager.getCurrentPage() == null){
                result.put(ERRMESSAGE, "当前页为null");
                return result;
            }

            List<VoteVo> list = voteService.getVoteList(pager);

            result.put(ERRCODE, 1);
            result.put(ERRMESSAGE, "获取投票列表！");
            result.put(DATA, list);
        }catch (Exception e){
            logger.error("获取投票列表失败:" + e.getMessage());
            result.put(ERRMESSAGE, "获取投票列表失败!");
        }
        return result;
    }

    /**
     * 获取投票详情
     * @param voteId
     * @return
     */
    @RequestMapping(value = "voteDetail")
    public Map<String, Object> voteDetail(Long voteId){
        Map<String, Object> result = Maps.newHashMap();
        result.put(ERRCODE, 0);
        try {
            if(voteId == null){
                result.put(ERRMESSAGE, "投票ID为空！");
                return result;
            }

            VoteVo voteVo = voteService.voteDetail(voteId);

            result.put(ERRCODE, 1);
            result.put(ERRMESSAGE, "获取投票详情列表！");
            result.put(DATA, voteVo);
        }catch (Exception e){
            logger.error("获取投票详情失败:" + e.getMessage());
            result.put(ERRMESSAGE, "获取投票详情失败!");
        }
        return result;
    }

    /**
     * 投票选择
     * @param voteId
     * @param optionId
     * @return
     *
     * //TODO
     * 投票是否为必须登录操作；这里写可不登录逻辑，即如果登录则记录LawyerID，否则不记录
     */
    @RequestMapping(value = "voteChoise")
    public Map<String, Object> voteChoise(Long voteId, Long optionId, HttpServletRequest request){
        Map<String, Object> result = Maps.newHashMap();
        result.put(ERRCODE, 0);
        try {
            // 用户信息获取
            Long lawyerId = getLawyerId(request);

            // 非空校验
            if(voteId == null || optionId == null){
                result.put(ERRMESSAGE, "投票ID或者选项ID不能为空！");
                return result;
            }

            // 调用投票服务
            voteService.voteChoise(voteId,optionId,lawyerId);
            result.put(ERRCODE, 1);
            result.put(ERRMESSAGE, "投票成功！");

        }catch (Exception e){
            logger.error("投票失败:" + e.getMessage());
            result.put(ERRMESSAGE, "投票失败!");
        }
        return result;
    }
}
