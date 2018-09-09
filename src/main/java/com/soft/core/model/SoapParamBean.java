/*
 * Copyright (c)
 */
package com.soft.core.model;

import java.util.List;
import java.util.Map;

/**
 * soap客户端请求实体
 *
 * @author David Lin
 * @version: 1.0
 * @date 2018-09-09 22:03
 */
public class SoapParamBean {
    /**
     * soap服务地址
     */
    private String url;
    /**
     * 请求调用的方法名称
     */
    private String method;
    /**
     * 命名空间
     */
    private String nameSpace;
    /**
     * 请求参数
     */
    private Map<String, String> paramsMap;
    /**
     * xml标签集合
     */
    private List<String> returnTags;

    /**
     * 无参构造函数
     */
    public SoapParamBean() {
        super();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }

    public Map<String, String> getParamsMap() {
        return paramsMap;
    }

    public void setParamsMap(Map<String, String> paramsMap) {
        this.paramsMap = paramsMap;
    }

    public List<String> getReturnTags() {
        return returnTags;
    }

    public void setReturnTags(List<String> returnTags) {
        this.returnTags = returnTags;
    }
}
