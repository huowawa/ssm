/*
 * Copyright
 */
package com.soft.platform.${packageName}.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.soft.platform.${packageName}.service.${className}Service;
import com.soft.platform.${packageName}.model.${className};

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 描述  TODO ${entityName}
 * @author ${author}
 * @version 1.0
 * @created ${currDate}
 */
@Controller
@RequestMapping(value="/${className?uncap_first}")
public class ${className}Controller  {
    
    /**
     * 日志类
     */
    public static final Logger LOG = LoggerFactory.getLogger(${className}Controller.class);
    /**
     * 引入Service
     */
    @Resource
    private ${className}Service ${className?uncap_first}Service;
    

}

