package com.faxintong.iruyi.service.article.impl;

import com.faxintong.iruyi.dao.general.ArticleGeneralMapper;
import com.faxintong.iruyi.dao.mybatis.article.AppArticleMapper;
import com.faxintong.iruyi.dao.mybatis.article.ArticleCommentMapper;
import com.faxintong.iruyi.dao.mybatis.article.ArticlePraiseMapper;
import com.faxintong.iruyi.dao.mybatis.article.ArticleStoreMapper;
import com.faxintong.iruyi.model.mybatis.article.*;
import com.faxintong.iruyi.model.mybatis.vo.AppArticleVo;
import com.faxintong.iruyi.service.article.ArticleService;
import com.faxintong.iruyi.utils.Pager;
import com.faxintong.iruyi.utils.PaperUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 15-4-18.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private AppArticleMapper appArticleMapper;

    @Autowired
    private ArticleGeneralMapper articleGeneralMapper;

    @Autowired
    private ArticleCommentMapper articleCommentMapper;

    @Autowired
    private ArticlePraiseMapper articlePraiseMapper;

    @Autowired
    private ArticleStoreMapper articleStoreMapper;

    @Override
    public void reportArticle(String comment, String url, Long lawyerId) throws Exception {
        AppArticle appArticle = new AppArticle();
        appArticle.setLawyerId(lawyerId);
        appArticle.setComment(comment);
        appArticle.setUrl(url);
        appArticle.setCreateDate(new Date());
        appArticle.setAcro(PaperUtil.getPaperAcro(url));
        appArticleMapper.insertSelective(appArticle);
    }

    @Override
    public List<AppArticleVo> articleList(Pager pager, Long lawyerId) throws Exception {
        List<AppArticle> list = articleGeneralMapper.getAppArticleList(pager.getStartCount(pager.getPageSize(),pager.getCurrentPage()), pager.getPageSize());
        List<AppArticleVo> articleVoList = new ArrayList<AppArticleVo>();
        for(AppArticle article : list){
            AppArticleVo appArticleVo = new AppArticleVo();
            ArticleCommentExample commentExample = new ArticleCommentExample();
            commentExample.createCriteria().andArticleIdEqualTo(article.getId());
            Integer commontCount = articleCommentMapper.countByExample(commentExample);
            appArticleVo.setCommentCount(commontCount);
            ArticlePraiseExample praiseExample = new ArticlePraiseExample();
            praiseExample.createCriteria().andArticleIdEqualTo(article.getId());
            Integer praiseCount = articlePraiseMapper.countByExample(praiseExample);
            appArticleVo.setPraiseCount(praiseCount);
            ArticlePraiseExample example = new ArticlePraiseExample();
            example.createCriteria().andArticleIdEqualTo(article.getId()).andLawyerIdEqualTo(lawyerId);
            Integer isPaise = articlePraiseMapper.countByExample(example);
            if(isPaise != null && isPaise.intValue() > 0){
                appArticleVo.setIsPraise(1);//已点赞
            }else{
                appArticleVo.setIsPraise(0);//未点赞
            }
            BeanUtils.copyProperties(article, appArticleVo);
            articleVoList.add(appArticleVo);
        }
        return articleVoList;
    }

    @Override
    public AppArticle articleDetail(Long articleId) throws Exception {
        return appArticleMapper.selectByPrimaryKey(articleId);
    }

    @Override
    public void articleComment(Long articleId, String comment, Long lawyerId) throws Exception {
        ArticleComment articleComment = new ArticleComment();
        articleComment.setArticleId(articleId);
        articleComment.setComment(comment);
        articleComment.setLawyerId(lawyerId);
        articleComment.setCreateTime(new Date());
        articleCommentMapper.insert(articleComment);
    }

    @Override
    public void articlePraise(Long articleId, Long lawyerId) throws Exception {
        ArticlePraise articlePraise = new ArticlePraise();
        articlePraise.setLawyerId(lawyerId);
        articlePraise.setArticleId(articleId);
        articlePraiseMapper.insert(articlePraise);
    }

    @Override
    public void articleStore(Long articleId, Long lawyerId) throws Exception {
        ArticleStore articleStore = new ArticleStore();
        articleStore.setArticleId(articleId);
        articleStore.setLawyerId(lawyerId);
        articleStoreMapper.insertSelective(articleStore);
    }

}
