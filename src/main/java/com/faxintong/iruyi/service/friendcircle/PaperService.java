package com.faxintong.iruyi.service.friendcircle;

import com.faxintong.iruyi.model.mybatis.friendcircle.Paper;
import com.faxintong.iruyi.model.mybatis.friendcircle.PaperComment;
import com.faxintong.iruyi.model.mybatis.friendcircle.PaperPraise;

import java.util.List;

/**
 * Created by hehj on 15-1-3.
 */
public interface PaperService {

    /**
     * 律师发表文章
     * @param paper
     * @throws Exception
     */
    public void reportPaper(Paper paper) throws Exception;

    /**
     * 删除文章
     * @param paperId
     * @throws Exception
     */
    public void deletePaperById(Long paperId) throws Exception;

    /**
     * 获取文章列表
     * @param lawyerId
     * @return
     * @throws Exception
     */
    public List<Paper> findPaperByLawyerId(List<Long> lawyerId) throws Exception;

    /**
     * 获取文章详情
     * @param paperId
     * @return
     * @throws Exception
     */
    public Paper findPaperById(Long paperId) throws Exception;

    /**
     * 对文章发表评论
     * @param lawyerId
     * @param paperId
     * @param comment
     * @throws Exception
     */
    public void reportPaperComment(Long lawyerId,Long paperId,String comment) throws Exception;

    /**
     * 对文章点赞
     * @param lawyerId
     * @param paperId
     * @throws Exception
     */
    public void praisePaper(Long lawyerId, String lawyerName, Long paperId) throws Exception;

    /**
     * 获取文章评论列表
     * @param paperId
     * @return
     * @throws Exception
     */
    public List<PaperComment> findPaperComments(Long paperId) throws Exception;

    /**
     * 获取文章点赞列表
     * @param paperId
     * @return
     * @throws Exception
     */
    public List<PaperPraise> findPaperPraises(Long paperId) throws Exception;

    public List<Paper> findPapers(Integer page) throws Exception;

    /**
     * 给评论点赞
     * @param LawyerId
     * @param LawyerName
     * @param commentId
     * @throws Exception
     */
    public void praiseComment(Long LawyerId, String LawyerName, Long commentId) throws Exception;
}
