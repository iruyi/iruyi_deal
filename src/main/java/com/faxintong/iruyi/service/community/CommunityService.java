package com.faxintong.iruyi.service.community;

import com.faxintong.iruyi.model.mybatis.community.Community;

import java.util.List;

/**
 * Created by ron on 2015/2/11.
 */
public interface CommunityService {

    /**
     * 社区新鲜事
     * @param community
     */
    public void createCommunity(Community community);

    /**
     * 删除新鲜事
     * @param communityId
     */
    public void deleteCommunity(Long communityId);

    /**
     *
     * @param page
     * @param pageSize
     * @return
     */
    public List<Community> getCommunityNews(Long lawyerId, Integer page, Integer pageSize);

    /**
     *
     * @param lawyerId
     * @param communityId
     */
    public void createCommunityPraise(Long lawyerId, Long communityId);

    /**
     *
     * @return
     */
    public Community getCommunity(Long communityId);

    /**
     * 判断问题是否存在
     * @param communityId
     * @return
     */
    public boolean issueIsExists(Long communityId);

    /**
     * 判断回复是否存在
     * @param communityId
     * @return
     */
    public boolean replyIsExists(Long communityId);

    public boolean hasPraised(Long lawyerId, Long communityId);

}
