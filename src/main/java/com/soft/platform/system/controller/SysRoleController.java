/*
 * Copyright
 */
package com.soft.platform.system.controller;

import com.soft.platform.system.model.SysRole;
import com.soft.platform.system.service.SysRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 描述  TODO 系统管理-角色管理
 *
 * @author David Lin
 * @version 1.0
 * @created 2018年08月14日  21:58:58
 */
@Controller
@RequestMapping(value = "/sysRole")
public class SysRoleController {

    /**
     * 日志类
     */
    public static final Logger LOG = LoggerFactory.getLogger(SysRoleController.class);
    /**
     * 引入Service
     */
    @Resource
    private SysRoleService sysRoleService;

    /**
     *
     * @param request
     * @return
     */
    @RequestMapping("/findRole")
    @ResponseBody
    public List<SysRole> findRole(HttpServletRequest request){
        return sysRoleService.findRoleByGroupId("4028098156928d9101569300533d0039");
    }


}

