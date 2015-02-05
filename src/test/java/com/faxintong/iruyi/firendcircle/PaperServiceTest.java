package com.faxintong.iruyi.firendcircle;

import com.faxintong.iruyi.model.mybatis.friendcircle.Paper;
import com.faxintong.iruyi.service.friendcircle.PaperService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by ron on 2015/1/29.
 */
public class PaperServiceTest {

    @Autowired
    private PaperService paperService;

    /**
    *
    * Method: reportPaper(Paper paper)
    *
    */
    @Test
    public void testReportPaper() throws Exception {
        try{
            Paper paper = new Paper();
            paper.setLawyerId(1L);
            paper.setCreateTime(new Date());
            paper.setPaperContent("this is a sad story");
            paper.setTitle("sad");
            paperService.reportPaper(paper);
            System.out.println("发表文章测试成功:" + paper);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
    *
    * Method: deletePaperById(Long paperId)
    *
    */
    @Test
    public void testDeletePaperById() throws Exception {
    }

    /**
    *
    * Method: findPaperByLawyerId(List<Long> lawyerId)
    *
    */
    @Test
    public void testFindPaperByLawyerId() throws Exception {
    }

    /**
    *
    * Method: findPaperById(Long paperId)
    *
    */
    @Test
    public void testFindPaperById() throws Exception {
    }

    /**
    *
    * Method: reportPaperComment(Long lawyerId, Long paperId, String comment)
    *
    */
    @Test
    public void testReportPaperComment() throws Exception {
    }

    /**
    *
    * Method: praisePaper(Long lawyerId, String lawyerName, Long paperId)
    *
    */
    @Test
    public void testPraisePaper() throws Exception {
    }

    /**
    *
    * Method: findPaperComments(Long paperId)
    *
    */
    @Test
    public void testFindPaperComments() throws Exception {
    }

    /**
    *
    * Method: findPaperPraises(Long paperId)
    *
    */
    @Test
    public void testFindPaperPraises() throws Exception {
    }
} 
