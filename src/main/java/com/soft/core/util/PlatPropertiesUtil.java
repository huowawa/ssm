/*
 * Copyright (c)
 */
package com.soft.core.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.util.Properties;

/**
 * properties属性文件操作工具类
 *
 * @author David Lin
 * @version: 1.0
 * @date 2018-08-11 23:21
 */
public class PlatPropertiesUtil {

    /**
     * 获取properties信息
     *
     * @param fileName
     * @return
     */
    public static Properties getPropertiesByPath(String fileName) throws  Exception {
        Resource resource = new ClassPathResource(fileName);
        Properties properties = PropertiesLoaderUtils.loadProperties(resource);
        return properties;
    }
}
