package com.faxintong.iruyi.controller.vote;

import com.faxintong.iruyi.controller.BaseController;
import com.faxintong.iruyi.model.mybatis.vo.VoteVo;
import com.faxintong.iruyi.service.vote.VoteService;
import com.faxintong.iruyi.utils.Pager;
import com.faxintong.iruyi.utils.RedisUtils;
import com.faxintong.iruyi.utils.Result;
import com.faxintong.iruyi.utils.ServletUtils;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
     *
     */
    @RequestMapping(value = "getVoteList")
    public String getVoteList(Pager pager,ModelMap modelMap,HttpServletRequest request,HttpServletResponse response){
        try {
            if(pager == null || pager.getCurrentPage() == null){
                ServletUtils.responseJson(response,new Result(RESULTFAIL,"当前页为null！"));
                return null;
            }

            List<VoteVo> voteVoList = voteService.getVoteList(pager,getLawyerId(request));

            modelMap.put(DATA,voteVoList);
            resultModelMap(RESULTSUCCESS, "获取投票列表成功！",modelMap);

            return "vote/getVoteList";
        }catch (Exception e){
            logger.error("获取投票列表失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "获取投票列表失败！"));
        }
        return null;
    }

    /**
     * 获取投票详情
     * @param voteId
     * @return
     */
    @RequestMapping(value = "voteDetail")
    public String voteDetail(Long voteId,ModelMap modelMap,HttpServletResponse response){
        try {
            if(voteId == null){
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "投票ID为空！"));
                return null;
            }

            VoteVo voteVo = voteService.voteDetail(voteId);

            modelMap.put(DATA, voteVo);
            resultModelMap(RESULTSUCCESS,"获取投票详情成功！",modelMap);

            return "vote/voteDetail";
        }catch (Exception e){
            logger.error("获取投票详情失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "获取投票详情失败！"));
        }
        return null;
    }

    /**
     * 投票选择
     * @param voteId
     * @param optionId
     * @return
     */
    @RequestMapping(value = "voteChoise")
    public String voteChoise(Long voteId, Long optionId, HttpServletRequest request, HttpServletResponse response){
        try {
            // 用户信息获取
            Long lawyerId = getLawyerId(request);

            // 非空校验
            if(voteId == null || optionId == null){
                ServletUtils.responseJson(response,new Result(RESULTFAIL,"投票ID或者选项ID不能为空！"));
                return null;
            }

            // 调用投票服务
            voteService.voteChoise(voteId, optionId, lawyerId);
            ServletUtils.responseJson(response, new Result(RESULTSUCCESS, "投票成功！"));

        }catch (Exception e){
            logger.error("投票失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL,e.getMessage()));
        }
        return null;
    }
}
