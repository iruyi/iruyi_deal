package com.faxintong.iruyi.utils;

import net.sf.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by admin on 15-4-26.
 */
public class PaperUtil {

    public static String getPaperAcro(String paperUrl){
        try{
            StringBuffer url = new StringBuffer();
            url.append("http://api.tuofeng.cn/zhaiyao/v2/url?url=").
                    append(URLEncoder.encode(""+paperUrl+"", "UTF-8")).
                    append("&key=VP2qNqnCVXre3lQN").append("&size=100");
            //服务的地址
            URL wsUrl = new URL(url.toString());
            HttpURLConnection conn = (HttpURLConnection) wsUrl.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
            InputStream is = conn.getInputStream();
            byte[] b = new byte[1024];
            int len = 0;
            String json = "";
            while((len = is.read(b)) != -1){
                String ss = new String(b,0,len,"UTF-8");
                json += ss;
            }
            JSONObject object = JSONObject.fromObject(json);
            is.close();
            conn.disconnect();
            return URLDecoder.decode((String) object.get("summary"), "UTF-8");
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args){
        System.out.println(getPaperAcro("http://www.duanwenxue.com/article/552626.html"));
    }
}
