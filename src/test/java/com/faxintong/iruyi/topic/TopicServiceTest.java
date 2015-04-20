package com.faxintong.iruyi.topic;

import com.faxintong.iruyi.base.BaseTest;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.model.mybatis.vo.ReplyVo;
import com.faxintong.iruyi.model.mybatis.vo.TopicGroupVo;
import com.faxintong.iruyi.model.mybatis.vo.TopicVo;
import com.faxintong.iruyi.service.lawyer.UserService;
import com.faxintong.iruyi.service.topic.TopicService;
import com.faxintong.iruyi.utils.Pager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by yunaxie on 2015/4/20.
 */
public class TopicServiceTest extends BaseTest{
    @Autowired
    private TopicService topicService;
    @Autowired
    private UserService userService;
    static Pager pager;
    {
        pager = new Pager();
        pager.setCurrentPage(1);
        pager.setPageSize(2);
    }

    @Test
    public void testReportTopic() {
        try {
            Lawyer lawyer = userService.getLawyerByPrimaryKey(1L);
            topicService.reportTopic(1L,"月光用蓝猫",lawyer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetGroupList() {
        try {
            List<TopicGroupVo> topicGroupVoList = topicService.getGroupList(pager);
            for(int i=0;i<topicGroupVoList.size();i++) {
                System.out.println("话题组名称：" + topicGroupVoList.get(i).getGroupName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetGroupDetail() {
        try {
            TopicGroupVo topicGroupVo = topicService.getGroupDetail(1L,pager,1L);
            List<TopicVo> topicVoList = topicGroupVo.getTopicVoList();
            for(int i=0;i<topicVoList.size();i++) {
                System.out.println(topicVoList.get(i).getIsPraise());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetTopicDetail() {
        try {
            TopicVo topicVo = topicService.getTopicDetail(3L,10L);
            List<ReplyVo> replyVoList = topicVo.getReplyVoList();
            for(int i=0;i<replyVoList.size();i++) {
                ReplyVo replyVo = replyVoList.get(i);
                System.out.println(replyVo.getLawyerName() + "回复说：" + replyVo.getContent() + "，被点赞" +
                        replyVo.getPraiseCount() + "，我的点赞情况：" + replyVo.getIsPraise());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAttentionGroup() {
        try {
            topicService.attentionGroup(1L,28L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testTopicReply() {
        try {
            Lawyer lawyer = userService.getLawyerByPrimaryKey(1L);
            topicService.topicReply(3L,"hello world",lawyer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAttentionTopic() {
        try {
            topicService.attentionTopic(3L,28L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTopicReplyPraise() {
        try {
            topicService.topicReplyPraise(1L,28L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
