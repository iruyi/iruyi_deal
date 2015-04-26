package com.faxintong.iruyi.vote;

import com.faxintong.iruyi.base.BaseTest;
import com.faxintong.iruyi.model.mybatis.active.Active;
import com.faxintong.iruyi.model.mybatis.vo.VoteOptionVo;
import com.faxintong.iruyi.model.mybatis.vo.VoteVo;
import com.faxintong.iruyi.model.mybatis.vote.VoteOption;
import com.faxintong.iruyi.service.active.ActiveService;
import com.faxintong.iruyi.service.vote.VoteService;
import com.faxintong.iruyi.utils.Pager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 15-4-19.
 */
public class VoteServiceTest extends BaseTest {

    @Autowired
    private VoteService voteService;

    @Test
    public void testVoteChoise(){
        try {
            voteService.voteChoise(2L,1L,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetVoteList(){
        Pager pager = new Pager();
        pager.setCurrentPage(1);
        pager.setPageSize(2);
        try {
            List<VoteVo> list = voteService.getVoteList(pager,null);
            for(VoteVo voteVo : list) {
                System.out.println("投票：" + voteVo.getContent());
                for(VoteOptionVo v : list.get(0).getVoteOptionVos()) {
                    System.out.println(v.getContent());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testVoteDetail(){
        try {
            VoteVo voteVo = voteService.voteDetail(1L);
            System.out.println("投票参与人员总数：" + voteVo.getVoteSum());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
