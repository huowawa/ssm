/*
 * Copyright (c)
 */
package com.soft.core.model;

import java.io.Serializable;

/**
 * 返回值实体对象
 *
 * @author David Lin
 * @version: 1.0
 * @date 2018-10-28 9:25
 */
public class ResultBean<T> implements Serializable {

    public static final int SUCCESS = 0;

    public static final int FAIL = 1;

    public static final int   NO_PERMISSION = 2;

    private String msg = "success";

    private int code = SUCCESS;

    private T data;

    public ResultBean(){
        super();
    }

    public ResultBean(T data){
        super();
        this.data = data;
    }

    public ResultBean(Throwable e){
        super();
        this.msg = e.toString();
        this.code  = FAIL;
    }


}

