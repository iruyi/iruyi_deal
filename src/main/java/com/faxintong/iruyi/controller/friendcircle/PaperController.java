package com.faxintong.iruyi.controller.friendcircle;

import com.faxintong.iruyi.model.mybatis.friendcircle.Paper;
import com.faxintong.iruyi.model.mybatis.friendcircle.PaperComment;
import com.faxintong.iruyi.model.mybatis.friendcircle.PaperPraise;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ron on 2015/1/12.
 */
@RestController
@RequestMapping(value = "paper")
public class PaperController {

    public void reportPaper(Long lawyerId,Paper paper){

    }


    public void deletePaperById(Long paperId){

    }

    public List<Paper> findPaperByLawyerId(List<Long> lawyerId){
        return null;
    }

    public Paper findPaperById(Long paperId){
        return null
                ;
    }

    public void reportPaperComment(Long lawyerId,Long paperId,String comment){

    }

    public void praisePaper(Long lawyerId, String lawyerName, Long paperId) {

    }

    public List<PaperComment> findPaperComments(Long paperId){
        return null;
    }

    public List<PaperPraise> findPaperPraises(Long paperId){
        return null;
    }
}
