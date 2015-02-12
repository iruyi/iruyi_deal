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

import java.util.ArrayList;
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
        Community community = communityMapper.selectByPrimaryKey(communityId);
        if(community.getType() == COMMUNITY_REPLY) {
            ReplyPraiseExample replyPraiseExample = new ReplyPraiseExample();
            replyPraiseExample.createCriteria().andReplyIdEqualTo(community.getId());
            replyPraiseMapper.deleteByExample(replyPraiseExample);
            communityMapper.deleteByPrimaryKey(communityId);
        }else{
            CommunityExample communityExample = new CommunityExample();
            communityExample.createCriteria().andIssueIdEqualTo(community.getId());
            List<Community> communityList = communityMapper.selectByExample(communityExample);

            List<Long> idList = new ArrayList<Long>();
            for(Community community1 : communityList){
                idList.add(community1.getId());
            }

            ReplyPraiseExample replyPraiseExample = new ReplyPraiseExample();
            replyPraiseExample.createCriteria().andReplyIdIn(idList);
            replyPraiseMapper.deleteByExample(replyPraiseExample);

            communityMapper.deleteByExample(communityExample);
            communityMapper.deleteByPrimaryKey(communityId);
        }
    }

    @Override
    public List<Community> getCommunityNews(Long lawyerId, Integer page, Integer pageSize) {
        int start = (page - 1) * pageSize;
        int end = start + pageSize;
        String limit = "limit " + start + "," + end + " ";
        CommunityExample communityExample = new CommunityExample();
        communityExample.setOrderByClause("create_date desc " + limit);
        List<Community> communityList = communityMapper.selectByExample(communityExample);
        for(Community community: communityList){
            if(community.getType() == COMMUNITY_REPLY){
                community.setHasPraised(hasPraised(lawyerId, community.getId()));
            }
        }
        return communityList;
    }

    @Override
    @Transactional
    public void createCommunityPraise(Long lawyerId, Long communityId) {
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

    public boolean hasPraised(Long lawyerId, Long communityId){
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

    @Override
    public void deletePraise(Long praiseId) {
        replyPraiseMapper.deleteByPrimaryKey(praiseId);
    }

    @Override
    public boolean isIssueOwner(Long lawyerId, Long issueId) {
        CommunityExample communityExample = new CommunityExample();
        communityExample.createCriteria().andLawyerIdEqualTo(lawyerId).andIdEqualTo(issueId).andTypeEqualTo(COMMUNITY_ISSUE);
        return communityMapper.countByExample(communityExample) == 1;
    }

    @Override
    public boolean isReplyOwner(Long lawyerId, Long replyId) {
        CommunityExample communityExample = new CommunityExample();
        communityExample.createCriteria().andLawyerIdEqualTo(lawyerId).andIdEqualTo(replyId).andTypeEqualTo(COMMUNITY_REPLY);
        return communityMapper.countByExample(communityExample) == 1;
    }
}
