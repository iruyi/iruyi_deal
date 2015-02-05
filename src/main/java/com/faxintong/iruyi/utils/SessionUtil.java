package com.faxintong.iruyi.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by hehongju on 2015/2/5.
 */
public class SessionUtil {

    public static String getSessionId() {
        return DigestUtils.md5Hex(System.currentTimeMillis() + RandomStringUtils.randomNumeric(6));
    }

}
