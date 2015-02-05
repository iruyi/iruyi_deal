package com.faxintong.iruyi.controller.friendcircle;

import com.faxintong.iruyi.controller.BaseController;
import com.faxintong.iruyi.model.mybatis.friendcircle.Paper;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.service.friendcircle.PaperService;
import com.google.common.collect.Maps;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.faxintong.iruyi.utils.Constants.*;

/**
 * Created by ron on 2015/1/12.
 */

@RestController
@RequestMapping("paper")
public class PaperController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(PaperController.class);

    @Autowired
    private PaperService paperService;

    @RequestMapping(value = "report", method = RequestMethod.POST)
    public Map<String, Object> reportPaper(@Valid Paper paper, BindingResult bindingResult,
                                           HttpServletRequest request, HttpServletResponse response){
        Map<String , Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        if(bindingResult.hasErrors()){
            result.put(ERR_MSG, bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        Long lawyerId = getLawyerId(request);
        try {
            paper.setLawyerId(lawyerId);
            paper.setCreateTime(new Date());
            paperService.reportPaper(paper);
            result.put(RESULT, true);
        } catch (Exception e) {
            logger.error("发表文章失败:" + e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public Map<String, Object> deletePaperById(@NotEmpty Long paperId, BindingResult bindingResult,
                                               HttpServletRequest request, HttpServletResponse response){
        Map<String , Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        if(bindingResult.hasErrors()){
            result.put(ERR_MSG, bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        try {
            paperService.deletePaperById(paperId);
            result.put(RESULT, true);
        } catch (Exception e) {
            logger.error("删除文章失败:" + e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "findLawyerPapers", method = RequestMethod.GET)
    public Map<String, Object> findPaperByLawyerId(List<Long> lawyerId,
                                                   HttpServletRequest request, HttpServletResponse response){
        Map<String , Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        try {
            result.put("paper", paperService.findPaperByLawyerId(lawyerId));
            result.put(RESULT, true);
        }catch (Exception e){
            logger.error("根据律师ID查找文章失败:" + e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "findPaper",  method = RequestMethod.GET)
    public Map<String, Object> findPaperById(@NotEmpty Long paperId, BindingResult bindingResult,
                                             HttpServletRequest request, HttpServletResponse response){
        Map<String , Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        if(bindingResult.hasErrors()){
            result.put(ERR_MSG, bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        try {
            result.put("paper", paperService.findPaperById(paperId));
        }catch (Exception e){
            logger.error("根据文章ID查找文章失败:" + e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "comment/report", method = RequestMethod.POST)
    public Map<String, Object> reportPaperComment(@NotEmpty Long paperId, @NotEmpty String comment,BindingResult bindingResult,
                                                  HttpServletRequest request,HttpServletResponse response){
        Map<String , Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        if(bindingResult.hasErrors()){
            result.put(ERR_MSG, bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        Long lawyerId = getLawyerId(request);
        try {
            paperService.reportPaperComment(lawyerId, paperId, comment);
            result.put(RESULT, true);
        }catch (Exception e){
            logger.error("发表评论失败:" + e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "praise", method = RequestMethod.POST)
    public Map<String , Object> praisePaper(@NotEmpty Long paperId, BindingResult bindingResult,
                                            HttpServletRequest request, HttpServletResponse response) {
        Map<String , Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        if(bindingResult.hasErrors()){
            result.put(ERR_MSG, bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        Lawyer lawyer = getLawyer(request);
        try {
            paperService.praisePaper(lawyer.getId(), lawyer.getName(), paperId);
            result.put(RESULT, true);
        } catch (Exception e) {
            logger.error("赞失败:" + e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "findPaperComments", method = RequestMethod.GET)
    public Map<String , Object> findPaperComments(@NotEmpty Long paperId, BindingResult bindingResult,
                                                  HttpServletRequest request, HttpServletResponse response){
        Map<String , Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        if(bindingResult.hasErrors()){
            result.put(ERR_MSG, bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        try {
            result.put("comments", paperService.findPaperComments(paperId));
            result.put(RESULT, true);
        } catch (Exception e) {
            logger.error("查找文章评论失败:" + e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "findPaperPraises",  method = RequestMethod.GET)
    public Map<String , Object> findPaperPraises(@NotEmpty Long paperId, BindingResult bindingResult,
                                                 HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        if(bindingResult.hasErrors()){
            result.put(ERR_MSG, bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        try {
            result.put("praise", paperService.findPaperPraises(paperId));
            result.put(RESULT, true);
        } catch (Exception e) {
            logger.error("查找文章赞失败:" + e.getMessage());
        }
        return result;
    }
}
