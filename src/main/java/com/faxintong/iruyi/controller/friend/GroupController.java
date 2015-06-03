package com.faxintong.iruyi.controller.friend;

import com.faxintong.iruyi.controller.BaseController;
import com.faxintong.iruyi.model.mybatis.vo.GroupVo;
import com.faxintong.iruyi.model.mybatis.vo.LawyerVo;
import com.faxintong.iruyi.service.friend.GroupService;
import com.faxintong.iruyi.utils.Pager;
import com.faxintong.iruyi.utils.Result;
import com.faxintong.iruyi.utils.ServletUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import static com.faxintong.iruyi.utils.Constants.*;

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
     * 获取律师群聊列表
     * @param pager
     * @return
     */
    @RequestMapping(value = "getlawyergroups")
    public String getlawyerGroups(Pager pager,ModelMap modelMap,HttpServletResponse response,HttpServletRequest request){
        try {
            if(pager == null) {
                ServletUtils.responseJson(response,new Result(RESULTFAIL,"当前页为空！"));
                return null;
            }

            List<GroupVo> groupVoList = groupService.getLaywerGroups(pager,getLawyerId(request));
            modelMap.put(DATA, groupVoList);
            resultModelMap(RESULTSUCCESS, "获取律师群聊成功！", modelMap);

            return "friend/getlawyergroups";
        }catch (Exception e){
            logger.error("获取律师群聊失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "获取律师群聊失败!"));
        }
        return null;
    }

    /**
     * 获取群聊律师列表
     * @param pager
     * @return
     */
    @RequestMapping(value = "getgrouplawyers")
    public String getGroupLawyers(Pager pager,String groupId,ModelMap modelMap,HttpServletResponse response,HttpServletRequest request){
        try {
            if(pager == null || StringUtils.isEmpty(groupId)) {
                ServletUtils.responseJson(response,new Result(RESULTFAIL,"当前页或者群聊id为空！"));
                return null;
            }

            List<LawyerVo> lawyerVoList = groupService.getGroupLawyer(pager, groupId);
            modelMap.put(DATA, lawyerVoList);
            resultModelMap(RESULTSUCCESS, "获取律师群聊成功！", modelMap);

            return "friend/getgrouplawyers";
        }catch (Exception e){
            logger.error("获取律师群聊失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "获取律师群聊失败!"));
        }
        return null;
    }

    /**
     * 获取群组详情
     * @param groupId
     * @param modelMap
     * @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "getgroupdetail")
    public String getGroupDetail(String groupId,ModelMap modelMap,HttpServletResponse response,HttpServletRequest request){
        try {
            if(StringUtils.isEmpty(groupId)) {
                ServletUtils.responseJson(response,new Result(RESULTFAIL,"群聊id为空！"));
                return null;
            }

            GroupVo groupVo = groupService.getLawyerGroup(groupId);
            modelMap.put(DATA, groupVo);
            resultModelMap(RESULTSUCCESS, "获取群聊详情成功！", modelMap);

            return "friend/getgroupdetail";
        }catch (Exception e){
            logger.error("获取群聊详情失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "获取群聊详情失败!"));
        }
        return null;
    }



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

            Integer count = groupService.countGroupByName(groupVo.getGroupName());
            if(count != null && count.intValue() > 0){
                ServletUtils.responseJson(response,new Result(RESULTSUCCESS,"该群已存在！"));
                return null;
            }

            groupVo.setOwnerId(getLawyerId(request));
            groupService.createGroup(groupVo);

            ServletUtils.responseJson(response,new Result(RESULTSUCCESS,"创建群聊成功！"));
        }catch (Exception e){
            logger.error("创建群聊失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "创建群聊失败!"));
        }
        return null;
    }

    /**
     * 删除群组
     * @param groupId
     * @return
     */
    @RequestMapping(value = "delgroup")
    public String delGroup(String groupId,HttpServletResponse response,HttpServletRequest request){
        try {
            // 参数校验
            if(StringUtils.isEmpty(groupId)) {
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "groupId不能为空！"));
                return null;
            }

            groupService.delGroup(groupId);

            ServletUtils.responseJson(response,new Result(RESULTSUCCESS,"删除群聊成功！"));
        }catch (Exception e){
            logger.error("删除群聊失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "删除群聊失败!"));
        }
        return null;
    }

    /**
     * 修改群组
     * @param groupVo
     * @return
     */
    @RequestMapping(value = "updategroup")
    public String updateGroup(GroupVo groupVo,HttpServletResponse response,HttpServletRequest request){
        try {
            // 参数校验
            if(groupVo == null) {
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "groupVo不能为空！"));
                return null;
            }

            if(StringUtils.isEmpty(groupVo.getGroupName()) || StringUtils.isEmpty(groupVo.getDesc())
                    || groupVo.getMaxUsers() == null) {
                return null;
            }

            groupService.updateGroup(groupVo);

            ServletUtils.responseJson(response,new Result(RESULTSUCCESS,"修改群聊成功！"));
        }catch (Exception e){
            logger.error("修改群聊失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "修改群聊失败!"));
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
            if(StringUtils.isEmpty(lawyerIds) || StringUtils.isEmpty(groupId)) {
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "律师Id或者群组id不能为空！"));
                return null;
            }

            groupService.addMe2Group(lawyerIds.split(","), groupId);

            ServletUtils.responseJson(response,new Result(RESULTSUCCESS,"添加成员成功！"));
        }catch (Exception e){
            logger.error("添加成员失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "添加成员失败!"));
        }
        return null;
    }

    /**
     * 删除成员
     * @param lawyerId
     * @return
     */
    @RequestMapping(value = "delmefgroup")
    public String delMefGroup(Long lawyerId,String groupId,HttpServletResponse response,HttpServletRequest request){
        try {
            // 参数校验
            if(lawyerId == null || StringUtils.isEmpty(groupId)) {
                ServletUtils.responseJson(response, new Result(RESULTFAIL, "律师Id或者群组id不能为空！"));
                return null;
            }

            groupService.delMefGroup(lawyerId,groupId);

            ServletUtils.responseJson(response,new Result(RESULTSUCCESS,"删除成员成功！"));
        }catch (Exception e){
            logger.error("删除成员失败:" + e.getMessage());
            ServletUtils.responseJson(response, new Result(RESULTFAIL, "删除成员失败!"));
        }
        return null;
    }

}
