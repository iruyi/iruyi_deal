package com.faxintong.iruyi.lawyer;

import com.faxintong.iruyi.base.BaseTest;
import com.faxintong.iruyi.model.mybatis.lawyer.Lawyer;
import com.faxintong.iruyi.service.lawyer.UserService;
import com.faxintong.iruyi.utils.MD5;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ron on 2015/1/29.
 */
public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void testRegisterLawyer() throws Exception {
        Lawyer lawyer = new Lawyer();
        lawyer.setPhone("15216401111");
        lawyer.setPassword("123456");
        try{
            userService.registerLawyer(lawyer);
            System.out.println("注册测试成功!!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testRegisValidate() throws Exception {
        String phone = "1234567890";
        try {
            boolean test = userService.containsPhone(phone);
            System.out.println("测试注册手机号有效性" + test);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testLoginValidate() throws Exception {
        String userName = "bigWater";
        String password = MD5.newinstance().getMD5ofStr("123456");
        try {
            boolean test = userService.loginValidate(userName, password);
            System.out.println("登录测试结果!::" + test);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testContainsPhone() throws Exception {
        try {
            boolean test = userService.containsPhone("123456");
            System.out.println("手机号重复注册测试:" + test);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testGetLawyer() throws Exception {
        try {
            Lawyer lawyer = userService.getLawyer("123456");
            System.out.println("通过手机号获取律师信息测试成功:" + lawyer);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testGetLawyerByPrimaryKey() throws Exception {
        try {
            Long id = 1L;
            Lawyer lawyer = userService.getLawyerByPrimaryKey(id);
            System.out.println("通过主键获取律师信息测试成功:" + lawyer);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testGetLawyersByPhone() throws Exception {
        try {
            List<String> phones = new ArrayList<String>();
            phones.add("123456");
            phones.add("1521640");
            List<Lawyer> lawyerList = userService.getLawyersByPhone(phones);
            System.out.println("通过手机号列表批量获取律师信息测试成功:");
            for(Lawyer lawyer : lawyerList){
                System.out.println(lawyer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateLawyerInfo() throws Exception {
        Lawyer lawyer = userService.getLawyerByPrimaryKey(1L);
        lawyer.setName("heyhey");
        try {
            userService.updateLawyerInfo(lawyer);
            System.out.println("更新律师信息测试成功:\n" + lawyer);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
