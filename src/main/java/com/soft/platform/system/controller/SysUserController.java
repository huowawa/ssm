/*
 * Copyright
 */
package com.soft.platform.system.controller;

import com.soft.platform.system.model.SysUser;
import com.soft.platform.system.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 描述  TODO 系统管理-用户管理
 *
 * @author David Lin
 * @version 1.0
 * @created 2018年08月19日  00:25:53
 */
@Controller
@RequestMapping(value = "/sysUser")
public class SysUserController {

    /**
     * 日志类
     */
    public static final Logger LOG = LoggerFactory.getLogger(SysUserController.class);
    /**
     * 引入Service
     */
    @Resource
    private SysUserService sysUserService;

    @RequestMapping("/getUser")
    @ResponseBody
    public SysUser getRecord(HttpServletRequest request){
        SysUser sysuser = sysUserService.getById("402883524863ab1f014863ab1f340000");
        return sysuser;
    }


}

