package com.faxintong.iruyi.utils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bochenlong on 2015/5/10.
 */
public class HxUtils {
    public static JsonNodeFactory factory = new JsonNodeFactory(false);

    public static Token token;

    /**
     * Send SSL Request
     *
     * @return
     */
    public static ObjectNode sendHTTPRequest(URL url, Object dataBody, String method) {

        HttpClient httpClient = getClient(true);

        ObjectNode resObjectNode = factory.objectNode();

        try {

            HttpResponse response = null;

            if (method.equals("POST")) {
                HttpPost httpPost = new HttpPost(url.toURI());

                Token.applyAuthentication(httpPost, getToken());
                httpPost.setEntity(new StringEntity(dataBody.toString(), "UTF-8"));

                response = httpClient.execute(httpPost);
            } else if (method.equals("PUT")) {
                HttpPut httpPut = new HttpPut(url.toURI());
                Token.applyAuthentication(httpPut, getToken());
                httpPut.setEntity(new StringEntity(dataBody.toString(), "UTF-8"));

                response = httpClient.execute(httpPut);
            } else if (method.equals("GET")) {

                HttpGet httpGet = new HttpGet(url.toURI());
                Token.applyAuthentication(httpGet, getToken());

                response = httpClient.execute(httpGet);

            } else if (method.equals("DELETE")) {
                HttpDelete httpDelete = new HttpDelete(url.toURI());

                Token.applyAuthentication(httpDelete, getToken());

                response = httpClient.execute(httpDelete);
            }

            HttpEntity entity = response.getEntity();
            if (null != entity) {
                String responseContent = EntityUtils.toString(entity, "UTF-8");
                EntityUtils.consume(entity);

                ObjectMapper mapper = new ObjectMapper();
                JsonFactory factory = mapper.getFactory();
                JsonParser jp = factory.createParser(responseContent);

                resObjectNode = mapper.readTree(jp);
                resObjectNode.put("statusCode", response.getStatusLine().getStatusCode());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            httpClient.getConnectionManager().shutdown();
        }

        return resObjectNode;
    }


    /**
     * Create a httpClient instance
     *
     * @param isSSL
     * @return HttpClient instance
     */
    public static HttpClient getClient(boolean isSSL) {

        HttpClient httpClient = new DefaultHttpClient();
        if (isSSL) {
            X509TrustManager xtm = new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };

            try {
                SSLContext ctx = SSLContext.getInstance("TLS");

                ctx.init(null, new TrustManager[] { xtm }, null);

                SSLSocketFactory socketFactory = new SSLSocketFactory(ctx);

                httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", 443, socketFactory));

            } catch (Exception e) {
                throw new RuntimeException();
            }
        }

        return httpClient;
    }

    public static URL getURL(String path) {
        URL url = null;

        try {
            url = new URL(Constants.API_HTTP_SCHEMA, Constants.API_SERVER_HOST, "/" + path);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    public static Token  getToken() {
        if (null == token || token.isExpired()) {
            try {
                ObjectNode objectNode = HxUtils.factory.objectNode();
                objectNode.put("grant_type", "client_credentials");
                objectNode.put("client_id", Constants.APP_CLIENT_ID);
                objectNode.put("client_secret", Constants.APP_CLIENT_SECRET);
                List<NameValuePair> headers = new ArrayList<NameValuePair>();
                headers.add(new BasicNameValuePair("Content-Type", "application/json"));

                HttpPost httpPost = new HttpPost();
                httpPost.setURI(Constants.TOKEN_APP_URL.toURI());

                if (null != headers && !headers.isEmpty()) {
                    for (NameValuePair nameValuePair : headers) {
                        httpPost.addHeader(nameValuePair.getName(), nameValuePair.getValue());
                    }
                }
                httpPost.setEntity(new StringEntity(objectNode.toString(), "UTF-8"));

                HttpResponse tokenResponse = HxUtils.getClient(true).execute(httpPost);
                HttpEntity entity = tokenResponse.getEntity();

                String results = EntityUtils.toString(entity, "UTF-8");

                if (tokenResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

                    ObjectMapper mapper = new ObjectMapper();

                    JsonFactory factory = mapper.getFactory();
                    JsonParser jp = factory.createParser(results);
                    JsonNode json = mapper.readTree(jp);

                    String accessToken = json.get("access_token").asText();
                    Long expiredAt = System.currentTimeMillis() + json.get("expires_in").asLong() * 1000;

                    token = new Token(accessToken, expiredAt);
                }
            } catch (Exception e) {
                throw new RuntimeException("Some errors ocuured while fetching a token by username and password .");
            }
        }

        return token;
    }


    public static void main(String[] args) {

    }

}
