/*
 * Copyright (c)
 */
package com.soft.platform.developer.service;

import java.util.Map;

/**
 * 开发编程
 *
 * @author David Lin
 * @version: 1.0
 * @date 2018-08-11 23:33
 */
public interface DeveloperService {
    /**
     * 根据参数生成代码
     * @param param
     * @throws Exception
     */
    public void genCode(Map<String,Object> param) throws  Exception;

}
