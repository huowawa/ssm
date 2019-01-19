/*
 * Copyright (c)
 */
package com.soft.core.model;

import java.io.Serializable;
import java.util.List;

/**
 * 分页对象
 *
 * @author David Lin
 * @version: 1.0
 * @date 2019-01-01 21:41
 */
public class PaginBean<T> implements Serializable {

    private int code;

    private String msg;

    private List<T>data;
private int count;
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T>getData() {
        return data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setData(List<T>data) {
        this.data = data;
    }
}
