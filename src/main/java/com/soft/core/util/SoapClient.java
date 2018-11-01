/*
 * Copyright (c)
 */
package com.soft.core.util;

import com.soft.core.model.SoapParamBean;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.Map;

/**
 * soap客户端请求工具类
 *
 * @author David Lin
 * @version: 1.0
 * @date 2018-09-09 22:09
 */
public class SoapClient {

    public String invokeWebService(SoapParamBean soapParamBean) throws  Exception {
        String url = soapParamBean.getUrl();
        String method = soapParamBean.getMethod();
        String nameSpace = soapParamBean.getNameSpace();
        Map<String, String> params = soapParamBean.getParamsMap();
        StringBuilder argsBuilder = new StringBuilder(64);

        for (Map.Entry<String, String> entry : params.entrySet()) {
            argsBuilder.append("         <").append(entry.getKey()).append(">").append(entry.getValue())
                    .append("</").append(entry.getKey()).append(">");
        }

        StringBuilder soapBuilder = new StringBuilder(64);
        soapBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        soapBuilder.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"");
        soapBuilder.append(" xmlns:web=\"").append(nameSpace).append("\" >");
        soapBuilder.append("   <soapenv:Header/>");
        soapBuilder.append("       <soapenv:Body>");
        soapBuilder.append("             <web:").append(method).append(">");
        soapBuilder.append("                      ").append(argsBuilder.toString());
        soapBuilder.append("               </web:").append(method).append(">");
        soapBuilder.append("    </soapenv:Body>");
        soapBuilder.append("</soapenv:Envelope>");

        String result = HttpClientUtil.sendHttpPost(url, soapBuilder.toString(), null);
        System.out.println(result);
        Document soapRes = Jsoup.parse(result);
        Elements returnEle = soapRes.getElementsByTag("return");
       return returnEle.text();
    }

}
