package com.faxintong.iruyi.firendcircle;

import com.faxintong.iruyi.base.BaseTest;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.service.friendcircle.FriendsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/** 
* FriendsServiceImpl Tester. 
* 
* @author ron
* @since 01, 30, 2015
* @version 1.0 
*/ 
public class FriendsServiceTest extends BaseTest {

    @Autowired
    private FriendsService friendsService;

    /**
    *
    * Method: searchLawyer(String name, String phone)
    *
    */
    @Test
    public void testSearchLawyer() throws Exception {
        try{
            List<Lawyer> lawyerList = friendsService.searchLawyer("bigWater","");
            System.out.println("根据姓名手机搜寻律师测试成功:");
            for (Lawyer lawyer: lawyerList){
                System.out.println(lawyer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
    *
    * Method: addSearchFriends(Long lawyerId, Long friendId)
    *
    */
    @Test
    public void testAddSearchFriends() throws Exception {
        try{
            Long lawyerId = 1L;
            Long friendId = 2L;
            friendsService.addSearchFriends(lawyerId, friendId);
            System.out.println("添加好友测试成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
    *
    * Method: friendConfirm(Long id)
    *
    */
    @Test
    public void testFriendConfirm() throws Exception {
        try{

        }catch (Exception e){

        }
    }

    /**
    *
    * Method: findFriends(Long lawyerId)
    *
    */
    @Test
    public void testFindFriends() throws Exception {
        //TODO: Test goes here...
    }


} 
