package com.faxintong.iruyi.utils;

import java.net.URL;

/**
 * Created by hehj on 15-1-3.
 */
public class Constants {
    public static final String SESSION_PREFIX = "session:";
    public static final String CAPTCHA_PREFIX = "captcha:";
    public static final String CAPTCHA_CODE_PREFIX = "captchaCode:";
    public static final String USER_PREFIX = "user:";
    public static final String FOLLOWING_PREFIX = "following:";
    public static final String FOLLOWED_BY_PREFIX = "followedby:";
    public static final String FOLLOWING_QUESTION_PREFIX = "followingQuestion:";
    public static final String FOLLOWED_QUESTION_PREFIX = "followedQuestion:";
    public static final String LIKE_PREFIX = "like:";
    public static final String LIKE_USER_PREFIX = "like_user:";
    public static final String UNLIKE_PREFIX = "unlike:";
    public static final String ONLINE_KEY = "online";
    public static final String ERR_MSG = "errMsg";
    public static final String RESULT = "result";
    public static final int PHOTO_MAX_SIZE = 2 * 1024 * 1024;
    public static final String LAST_MODIFIED = "lastModified";
    public static final String SEARCH_PREFIX = "search:";
    public static final String CODE_PREFIX = "code:";
    public static final String SOLUTION_PREFIX = "solution:";
    public static final String READED_MESSAGE_PREFIX = "readed_message:";
    public static final String DELETED_MESSAGE_PREFIX = "deleted_message:";
    public static final String TAG_QUESTION_COUNT_PREFIX = "tagQuestionCount:";
    public static final String ENCODING = "UTF-8";
    public static final String BASE_SCORE = "baseScore";
    public static final String ACTIVE_SCORE = "activeScore";
    public static final String REVIEW_SCORE = "reviewScore";
    public static final String VIEWED_COUNT = "view";
    public static final String AUTOINCREMENT = "autoincrement";
    public static final String DATA = "data";


    public static final String ERRCODE = "errcode";
    public static final String ERRMESSAGE = "errmessage";
    public static final Integer RESULTSUCCESS = 0;
    public static final Integer RESULTFAIL = 1;

    /**********************甩单、接单状态*******************/
    public static final Integer RECEIVING = 1;//竞标中
    public static final Integer RECEIVED = 2;//已接单，待确认
    public static final Integer FORGO = 3;//放弃接单，待确认
    public static final Integer FAIL = 4;//接单失败
    public static final Integer SUCCESS = 5;//接单成功
    public static final Integer CANCEL = 6;//单子作废
    public static final Integer CONTRACT_SIGNED = 7;//合同已签待确认
    public static final Integer PAYING = 8;//合同已确认待支付（支付中）
    public static final Integer COMMENTING = 9;//已支付待互评（互评中）
    public static final Integer COMMENTED = 10;//已互评

    /**********************单子是否延期状态*******************/
    public static final Integer NO_DELAY = 1;//未延期
    public static final Integer DELAY = 2;//已延期

    /**********************单子类型*******************/
    /**
     * 1-案源 2-协作外包 3-商务信息
     */
    public static final Integer ANYUAN = 1;
    public static final Integer WAIBAO = 2;
    public static final Integer SHANGWU = 3;

    /************************好友间关系*********************/
    public static final Integer UNCONFIRMED_FRIEND = 1;
    public static final Integer FRIEND = 2;
    public static final Integer DELETE = 3;

    /*************************律师甩单类型**********************/
    public static final Integer ORDER_COOPERATIVE = 1; //协作
    public static final Integer ORDER_CASE = 2;        //案例

    /*************************合同状态**********************/
    public static final Integer CONTRACT_COMMENTING = 2;//合同待确认
    public static final Integer CONTRACT_COMMENTED = 1;//合同已确认

    /*************************黑白名单**********************/
    public static final Integer ALL_LIST = 0;//所有律师
    public static final Integer WHITE_LIST = 1;//白名单
    public static final Integer BLACK_LIST = 2;//白名单

    /*************************社区事件类型*****************/
    public static final Integer COMMUNITY_ISSUE = 1; //提问
    public static final Integer COMMUNITY_REPLY = 2; //回复


    /*************************文章类型*********************/
    public static final Integer PAPER = 1; //文章


    /***************************环信*********************/
    // API_HTTP_SCHEMA
    public static String API_HTTP_SCHEMA = "https";
    // API_SERVER_HOST
    public static String API_SERVER_HOST = PropertiesUtils.getHxValue("API_SERVER_HOST");
    // APPKEY
    public static String APPKEY = PropertiesUtils.getHxValue("APPKEY");
    // APP_CLIENT_ID
    public static String APP_CLIENT_ID = PropertiesUtils.getHxValue("APP_CLIENT_ID");
    // APP_CLIENT_SECRET
    public static String APP_CLIENT_SECRET = PropertiesUtils.getHxValue("APP_CLIENT_SECRET");

    // ROLE_ADMIN
    public static String USER_ROLE_APPADMIN = "appAdmin";

    // URL
    public static final URL TOKEN_APP_URL = HxUtils.getURL(APPKEY.replace("#", "/") + "/token");
    public static final URL USERS_URL = HxUtils.getURL(APPKEY.replace("#", "/") + "/users");
    public static final URL CHATGROUPS_URL = HxUtils.getURL(APPKEY.replace("#", "/") + "/chatgroups");


    // GROUPMAXUSERS
    public static final Integer GROUP_MAXUSERS = 9999;
}
