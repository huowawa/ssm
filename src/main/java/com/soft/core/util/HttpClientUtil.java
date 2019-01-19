/*
 * Copyright (c)
 */
package com.soft.core.util;

import org.apache.http.*;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * http连接工具类
 *
 * @author David Lin
 * @version: 1.0
 * @date 2018-09-09 22:45
 */
public class HttpClientUtil {
    /**
     * 1.创建httpclient
     * 2.创建请求方法对象
     * 3.设置参数
     * 4.设置请求头
     * 5.获取解析响应数据
     */

    /**
     * 连接池管理对象
     */
    private static PoolingHttpClientConnectionManager connectionManager;

    static {
        connectionManager = new PoolingHttpClientConnectionManager();
        // 最大连接数
        connectionManager.setMaxTotal(100);
        // 将每个路由的默认最大连接数增加到20
        connectionManager.setDefaultMaxPerRoute(20);
    }

    /**
     * http连接池获取HTTP client
     *
     * @param method
     * @return
     * @throws Exception
     */
    public static String executePoolingHttp(HttpRequestBase method) throws Exception {
        // 从连接池中获取client对象，多例
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager)
                .setRetryHandler(retryHandler(5)).build();
        // 构建请求配置信息
        RequestConfig config = RequestConfig.custom().setConnectTimeout(5000) // 创建连接的最长时间
                .setConnectionRequestTimeout(5000) // 从连接池中获取到连接的最长时间
                .setSocketTimeout(10 * 1000) // 数据传输的最长时间10s
                .build(); // 提交请求前测试连接是否可用

        // 设置请求配置信息
        method.setConfig(config);
        CloseableHttpResponse response = null;
        try {
            //发起http请求
            response = httpClient.execute(method);

            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                return content;
            }
        } finally {
            if (null != response) {
                response.close();
            }
        }
        return "";

    }

    /**
     * 请求重试处理
     *
     * @param tryTimes 重试次数
     * @return
     */
    public static HttpRequestRetryHandler retryHandler(final int tryTimes) {

        HttpRequestRetryHandler httpRequestRetryHandler = new HttpRequestRetryHandler() {
            @Override
            public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
                // 如果已经重试了n次，就放弃
                if (executionCount >= tryTimes) {
                    return false;
                }
                // 如果服务器丢掉了连接，那么就重试
                if (exception instanceof NoHttpResponseException) {
                    return true;
                }
                // 不要重试SSL握手异常
                if (exception instanceof SSLHandshakeException) {
                    return false;
                }
                // 超时
                if (exception instanceof InterruptedIOException) {
                    return false;
                }
                // 目标服务器不可达
                if (exception instanceof UnknownHostException) {
                    return true;
                }
                // 连接被拒绝
                if (exception instanceof ConnectTimeoutException) {
                    return false;
                }
                // SSL握手异常
                if (exception instanceof SSLException) {
                    return false;
                }
                HttpClientContext clientContext = HttpClientContext.adapt(context);
                HttpRequest request = clientContext.getRequest();
                // 如果请求是幂等的，就再次尝试
                if (!(request instanceof HttpEntityEnclosingRequest)) {
                    return true;
                }
                return false;
            }
        };
        return httpRequestRetryHandler;
    }

    /**
     * GET请求
     *
     * @param url
     * @param paramsMap
     * @param headMap
     * @return
     * @throws Exception
     */
    public static String sendHttpGet(String url, Map<String, Object> paramsMap, Map<String, String> headMap) throws Exception {
        URIBuilder uriBuilder = new URIBuilder(url);

        if(null != paramsMap){
            //设置get请求参数
            for (Map.Entry<String, Object> entry : paramsMap.entrySet()) {
                uriBuilder.setParameter(entry.getKey(), entry.getValue().toString());
            }
        }

        // 创建http GET请求
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        if (null != headMap) {
            //设置请求头
            for (Map.Entry<String, String> entry : headMap.entrySet()) {
                httpGet.setHeader(entry.getKey(), entry.getValue());
            }
        }

        return executePoolingHttp(httpGet);
    }

    /**
     * 发送post请求
     *
     * @param url
     * @param paramsMap
     * @param headMap
     * @return
     * @throws Exception
     */
    public static String sendHttpPost(String url, Map<String, Object> paramsMap, Map<String, String> headMap) throws Exception {
        // 创建http POST请求
        HttpPost httpPost = new HttpPost(url);
        // 设置post参数
        List<NameValuePair> paramsList = new ArrayList<>(16);
        for (Map.Entry<String, Object> entry : paramsMap.entrySet()) {
            paramsList.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
        }
        // 构造一个form表单式的实体
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(paramsList, Charset.forName("UTF-8"));
        // 将请求实体设置到httpPost对象中
        httpPost.setEntity(formEntity);
        if (null != headMap) {
            //设置请求头
            for (Map.Entry<String, String> entry : headMap.entrySet()) {
                httpPost.setHeader(entry.getKey(), entry.getValue());
            }
        }

        return executePoolingHttp(httpPost);
    }

    /**
     * 发送post请求
     *
     * @param url
     * @param paramStr
     * @param headMap
     * @return
     * @throws Exception
     */
    public static String sendHttpPost(String url, String paramStr, Map<String, String> headMap) throws Exception {
        // 创建http POST请求
        HttpPost httpPost = new HttpPost(url);

        StringEntity entity = new StringEntity(paramStr, Charset.forName("UTF-8"));
        // 将请求实体设置到httpPost对象中
        httpPost.setEntity(entity);
        //设置请求头
        if (null != headMap) {
            for (Map.Entry<String, String> entry : headMap.entrySet()) {
                httpPost.setHeader(entry.getKey(), entry.getValue());
            }
        }

        return executePoolingHttp(httpPost);
    }
}
