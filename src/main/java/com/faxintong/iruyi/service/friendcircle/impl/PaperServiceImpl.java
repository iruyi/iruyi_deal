package com.faxintong.iruyi.service.friendcircle.impl;

import com.faxintong.iruyi.model.mybatis.friendcircle.Paper;
import com.faxintong.iruyi.model.mybatis.friendcircle.PaperComment;
import com.faxintong.iruyi.model.mybatis.friendcircle.PaperPraise;
import com.faxintong.iruyi.service.friendcircle.PaperService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 15-1-3.
 */
@Service
public class PaperServiceImpl implements PaperService {
    @Override
    public void reportPaper(Long lawyerId, Paper paper) throws Exception {

    }

    @Override
    public void deletePaperById(Long paperId) throws Exception {

    }

    @Override
    public List<Paper> findPaperByLawyerId(List<Long> lawyerId) throws Exception {
        return null;
    }

    @Override
    public Paper findPaperById(Long paperId) throws Exception {
        return null;
    }

    @Override
    public void reportPaperComment(Long lawyerId, Long paperId, String comment) throws Exception {

    }

    @Override
    public void praisePaper(Long lawyerId, Long paperId) throws Exception {

    }

    @Override
    public List<PaperComment> findPaperComments(Long paperId) throws Exception {
        return null;
    }

    @Override
    public List<PaperPraise> findPaperPraises(Long paperId) throws Exception {
        return null;
    }
}
