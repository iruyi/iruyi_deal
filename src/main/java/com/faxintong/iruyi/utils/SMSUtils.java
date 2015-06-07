package com.faxintong.iruyi.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by netfishx on 14-5-6.
 */
public class SMSUtils {
    private static Logger logger = LoggerFactory.getLogger(SMSUtils.class);
    private static RestTemplate restTemplate = new RestTemplate();
    private static final String REG_ID = "101100-WEB-HUAX-858513";
    private static final String PASSWORD = "TOJSCNSB";

    @Deprecated
    public static Boolean send(String mobile, String content) {
        final String url = UriComponentsBuilder.fromHttpUrl("http://www.stongnet.com/sdkhttp/sendsms.aspx")
                .queryParam("reg", REG_ID)
                .queryParam("pwd", PASSWORD)
                .queryParam("sourceadd", "")
                .queryParam("phone", mobile)
                .queryParam("content", content)
                .build().toUriString();
        final String result = restTemplate.getForObject(url, String.class);

        return result.startsWith("result=0&");
    }

    public static Boolean sendMandao(String mobile, String content) {
        try {
            String sn = "SDK-BBX-010-20494";
            String pwd = "41e65-e6";
            Client client = new Client(sn, pwd);
            String result = client.mdSmsSend_u(mobile, content, "", "", "");
            logger.info("发送短信：mobile:"+mobile+";content:"+content+";result:"+result);
            if (result.startsWith("-") || result.equals("")) {
                //发送短信，如果是以负号开头就是发送失败。
                logger.error("发送失败！返回值为：" + result + "请查看webservice返回值对照表");
                return false;
                //输出返回标识，为小于19位的正数，String类型的。记录您发送的批次。
            } else {
                logger.info("发送成功，返回值为：" + result);
                return true;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        }
    }

}
