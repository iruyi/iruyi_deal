package com.faxintong.iruyi.utils;

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

    /************************好友间关系*********************/
    public static final Integer UNCONFIRMED_FRIEND = 1;
    public static final Integer FRIEND = 2;
    public static final Integer DELETE = 3;

    /*************************律师甩单类型**********************/
    public static final Integer ORDER_COOPERATIVE = 1; //协作
    public static final Integer ORDER_CASE = 2;        //案例


}
