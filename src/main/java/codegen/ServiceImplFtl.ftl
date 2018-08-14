/*
 * Copyright (c)
 */
package  com.soft.platform.${packageName}.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import  com.soft.core.service.BaseServiceImpl;

import  com.soft.platform.${packageName}.service.${className}Service;
import  com.soft.platform.${packageName}.mapper.${className}Mapper;
import  com.soft.platform.${packageName}.model.${className};
import  org.springframework.stereotype.Service;

/**
 * 描述  ${entityName}操作service
 * @author ${author}
 * @version 1.0
 * @created ${currDate}
 */
@Service("${className?uncap_first}Service")
public class ${className}ServiceImpl  extends BaseServiceImpl implements ${className}Service {
    /**
     * 所引入的mapper
     */
    @Resource
    private ${className}Mapper ${className?uncap_first}Mapper;
    

}
