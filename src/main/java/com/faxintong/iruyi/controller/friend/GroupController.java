package com.faxintong.iruyi.controller.friend;

import com.faxintong.iruyi.controller.BaseController;
import com.faxintong.iruyi.model.mybatis.vo.GroupVo;
import com.faxintong.iruyi.service.friend.GroupService;
import com.faxintong.iruyi.utils.Result;
import com.faxintong.iruyi.utils.ServletUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.faxintong.iruyi.utils.Constants.RESULTFAIL;
import static com.faxintong.iruyi.utils.Constants.RESULTSUCCESS;

/**
 * Created by bochenlong on 2015/5/10.
 */
@RestController
@RequestMapping("group")
public class GroupController extends BaseController{
    private Logger logger = LoggerFactory.getLogger(GroupController.class);

    @Autowired
    private GroupService groupService;

    /**
     * 创建群组
     * @param groupVo
     * @return
     */
    @RequestMapping(value = "creategroup")
    public String createGroup(GroupVo groupVo,HttpServletResponse response,HttpServletRequest request){
        try {
            // 参数校验
            if(groupVo == null) {
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "groupVo不能为空！"));
                return null;
            }

            groupVo.setOwnerId(getLawyerId(request));
            groupService.createGroup(groupVo);

            ServletUtils.responseJson(response,new Result(RESULTSUCCESS,"创建群组成功！"));
        }catch (Exception e){
            logger.error("创建群组失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "创建群组失败!"));
        }
        return null;
    }

    /**
     * 添加成员
     * @param lawyerIds
     * @return
     */
    @RequestMapping(value = "addme2group")
    public String addMe2Group(String lawyerIds,String groupId,HttpServletResponse response,HttpServletRequest request){
        try {
            // 参数校验
            if(StringUtils.isEmpty(lawyerIds)) {
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "律师Id不能为空！"));
                return null;
            }

            groupService.addMe2Group(lawyerIds.split(","),groupId);

            ServletUtils.responseJson(response,new Result(RESULTSUCCESS,"添加成员成功！"));
        }catch (Exception e){
            logger.error("创建群组失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "添加成员失败!"));
        }
        return null;
    }

}
