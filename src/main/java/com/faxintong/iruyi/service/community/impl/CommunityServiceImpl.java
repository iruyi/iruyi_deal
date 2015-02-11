package com.faxintong.iruyi.service.community.impl;

import com.faxintong.iruyi.dao.mybatis.community.CommunityMapper;
import com.faxintong.iruyi.dao.mybatis.community.ReplyPraiseMapper;
import com.faxintong.iruyi.model.mybatis.community.Community;
import com.faxintong.iruyi.model.mybatis.community.CommunityExample;
import com.faxintong.iruyi.model.mybatis.community.ReplyPraise;
import com.faxintong.iruyi.model.mybatis.community.ReplyPraiseExample;
import com.faxintong.iruyi.service.community.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import static com.faxintong.iruyi.utils.Constants.*;

/**
 * Created by ron on 2015/2/11.
 */
@Service
public class CommunityServiceImpl implements CommunityService{

    @Autowired
    private CommunityMapper communityMapper;
    @Autowired
    private ReplyPraiseMapper replyPraiseMapper;

    @Override
    @Transactional
    public void createCommunity(Community community) {
        communityMapper.insertSelective(community);
    }

    @Override
    @Transactional
    public void deleteCommunity(Long communityId) {
        communityMapper.deleteByPrimaryKey(communityId);
    }

    @Override
    public List<Community> getCommunityNews(Integer page, Integer pageSize) {
        CommunityExample communityExample = new CommunityExample();
        communityExample.setOrderByClause("create_date desc");
        return communityMapper.selectByExample(communityExample);
    }

    @Override
    @Transactional
    public void createCommunityPraise(Long lawyerId, Long communityId) {
        if(hasPraised(lawyerId, communityId))
            return;
        ReplyPraise replyPraise = new ReplyPraise();
        replyPraise.setLawyerId(lawyerId);
        replyPraise.setCreateDate(new Date());
        replyPraise.setReplyId(communityId);
        replyPraiseMapper.insertSelective(replyPraise);
        Community community = communityMapper.selectByPrimaryKey(communityId);
        community.setPraiseCount(community.getPraiseCount() + 1);
        communityMapper.updateByPrimaryKey(community);
    }

    @Override
    public Community getCommunity(Long communityId) {
        return communityMapper.selectByPrimaryKey(communityId);
    }

    private boolean hasPraised(Long lawyerId, Long communityId){
        ReplyPraiseExample replyPraiseExample = new ReplyPraiseExample();
        replyPraiseExample.createCriteria().andLawyerIdEqualTo(lawyerId).andReplyIdEqualTo(communityId);
        return replyPraiseMapper.countByExample(replyPraiseExample) != 0;
    }

    @Override
    public boolean issueIsExists(Long communityId) {
        Community community = communityMapper.selectByPrimaryKey(communityId);
        return community == null ? false : community.getType() == COMMUNITY_ISSUE;
    }

    @Override
    public boolean replyIsExists(Long communityId) {
        Community community = communityMapper.selectByPrimaryKey(communityId);
        return community == null ? false : community.getType() == COMMUNITY_REPLY;
    }
}
