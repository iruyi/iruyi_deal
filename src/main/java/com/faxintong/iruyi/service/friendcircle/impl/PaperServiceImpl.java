package com.faxintong.iruyi.service.friendcircle.impl;

import com.faxintong.iruyi.dao.mybatis.friendcircle.PaperCommentMapper;
import com.faxintong.iruyi.dao.mybatis.friendcircle.PaperMapper;
import com.faxintong.iruyi.dao.mybatis.friendcircle.PaperPraiseMapper;
import com.faxintong.iruyi.model.mybatis.friendcircle.*;
import com.faxintong.iruyi.service.friendcircle.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by admin on 15-1-3.
 */
@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    private PaperMapper paperMapper;
    @Autowired
    private PaperCommentMapper paperCommentMapper;
    @Autowired
    private PaperPraiseMapper paperPraiseMapper;

    @Override
    @Transactional
    public void reportPaper(Paper paper) throws Exception {
        paperMapper.insertSelective(paper);
    }

    /**
     * 删除文章 文章评论 文章赞同
     * @param paperId
     * @throws Exception
     */
    @Override
    @Transactional
    public void deletePaperById(Long paperId) throws Exception {

        PaperExample paperExample = new PaperExample();
        paperExample.createCriteria().andIdEqualTo(paperId);
        paperMapper.deleteByExample(paperExample);

        PaperPraiseExample paperPraiseExample = new PaperPraiseExample();
        paperPraiseExample.createCriteria().andPaperIdEqualTo(paperId);
        paperPraiseMapper.deleteByExample(paperPraiseExample);

        PaperCommentExample paperCommentExample = new PaperCommentExample();
        paperCommentExample.createCriteria().andPaperIdEqualTo(paperId);
        paperCommentMapper.deleteByExample(paperCommentExample);
    }

    @Override
    public List<Paper> findPaperByLawyerId(List<Long> lawyerId) throws Exception {
        PaperExample paperExample = new PaperExample();
        paperExample.createCriteria().andLawyerIdIn(lawyerId);
        return paperMapper.selectByExample(paperExample);
    }

    @Override
    public Paper findPaperById(Long paperId) throws Exception {
        return paperMapper.selectByPrimaryKey(paperId);
    }

    @Override
    @Transactional
    public void reportPaperComment(Long lawyerId, Long paperId, String comment) throws Exception {
        PaperComment paperComment = new PaperComment();
        paperComment.setLawyerId(lawyerId);
        paperComment.setPaperId(paperId);
        paperComment.setComment(comment);
        paperComment.setCreateTime(new Date());
        paperCommentMapper.insertSelective(paperComment);
    }

    /**
     * 赞的时候是否应该更新一下个人中心呢？
     * @param lawyerId
     * @param lawyerName
     * @param paperId
     * @throws Exception
     */
    @Override
    public void praisePaper(Long lawyerId, String lawyerName, Long paperId) throws Exception {
        PaperPraiseExample paperPraiseExample = new PaperPraiseExample();
        paperPraiseExample.createCriteria().andLawyerIdEqualTo(lawyerId).andPaperIdEqualTo(paperId);
        if(paperPraiseMapper.countByExample(paperPraiseExample) == 0) {
            PaperPraise paperPraise = new PaperPraise();
            paperPraise.setLawyerId(lawyerId);
            paperPraise.setPaperId(paperId);
            paperPraise.setCreateTime(new Date());
            paperPraise.setLawyerName(lawyerName);
            paperPraiseMapper.insertSelective(paperPraise);
        }
        else {
            paperPraiseMapper.deleteByExample(paperPraiseExample);
        }
    }

    @Override
    public List<PaperComment> findPaperComments(Long paperId) throws Exception {
        PaperCommentExample paperCommentExample = new PaperCommentExample();
        paperCommentExample.createCriteria().andPaperIdEqualTo(paperId);
        return paperCommentMapper.selectByExample(paperCommentExample);
    }

    @Override
    public List<PaperPraise> findPaperPraises(Long paperId) throws Exception {
        PaperPraiseExample paperPraiseExample = new PaperPraiseExample();
        paperPraiseExample.createCriteria().andPaperIdEqualTo(paperId);
        return paperPraiseMapper.selectByExample(paperPraiseExample);
    }
}
