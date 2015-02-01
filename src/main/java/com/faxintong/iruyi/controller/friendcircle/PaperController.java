package com.faxintong.iruyi.controller.friendcircle;

import com.faxintong.iruyi.controller.BaseController;
import com.faxintong.iruyi.model.mybatis.friendcircle.Paper;
import com.faxintong.iruyi.service.friendcircle.PaperService;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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

    @RequestMapping(value = "report")
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
            paperService.reportPaper(lawyerId, paper);
            result.put(RESULT, true);
        } catch (Exception e) {
            logger.error("发表文章失败:" + e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "delete")
    public Map<String, Object> deletePaperById(Long paperId,
                                               HttpServletRequest request, HttpServletResponse response){
        Map<String , Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        try {
            paperService.deletePaperById(paperId);
            result.put(RESULT, true);
        } catch (Exception e) {
            logger.error("删除文章失败:" + e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "findLawyerPapers")
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

    @RequestMapping(value = "findPaper")
    public Map<String, Object> findPaperById(Long paperId){
        Map<String , Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        try {
            result.put("paper", paperService.findPaperById(paperId));
        }catch (Exception e){
            logger.error("根据文章ID查找文章失败:" + e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "comment/report")
    public Map<String, Object> reportPaperComment(Long paperId, String comment,
                                                  HttpServletRequest request,HttpServletResponse response){
        Map<String , Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        Long lawyerId = getLawyerId(request);
        try {
            paperService.reportPaperComment(lawyerId, paperId, comment);
            result.put(RESULT, true);
        }catch (Exception e){
            logger.error("发表评论失败:" + e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "praise")
    public Map<String , Object> praisePaper(String lawyerName, Long paperId,
                                            HttpServletRequest request, HttpServletResponse response) {
        Map<String , Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        Long lawyerId = getLawyerId(request);
        try {
            paperService.praisePaper(lawyerId, lawyerName, paperId);
            result.put(RESULT, true);
        } catch (Exception e) {
            logger.error("赞失败:" + e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "findPaperComments")
    public Map<String , Object> findPaperComments(Long paperId,
                                                  HttpServletRequest request, HttpServletResponse response){
        Map<String , Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        try {
            result.put("comments", paperService.findPaperComments(paperId));
            result.put(RESULT, true);
        } catch (Exception e) {
            logger.error("查找文章评论失败:" + e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "findPaperPraises")
    public Map<String , Object> findPaperPraises(Long paperId,
                                                 HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = Maps.newHashMap();
        result.put(RESULT, false);
        try {
            result.put("praise", paperService.findPaperPraises(paperId));
            result.put(RESULT, true);
        } catch (Exception e) {
            logger.error("查找文章赞失败:" + e.getMessage());
        }
        return result;
    }
}
