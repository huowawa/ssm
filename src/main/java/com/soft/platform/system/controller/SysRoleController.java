/*
 * Copyright
 */
package com.soft.platform.system.controller;

import com.soft.platform.system.service.SysRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 描述  TODO 系统管理-角色管理
 * @author David Lin
 * @version 1.0
 * @created 2018年08月18日  18:03:15
 */
@Controller
@RequestMapping(value="/sysRole")
public class SysRoleController  {
    
    /**
     * 日志类
     */
    public static final Logger LOG = LoggerFactory.getLogger(SysRoleController.class);
    /**
     * 引入Service
     */
    @Resource
    private SysRoleService sysRoleService;
    

}

