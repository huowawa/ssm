/*
 * Copyright
 */
package com.soft.platform.system.controller;

import com.github.pagehelper.PageInfo;
import com.soft.platform.system.model.SysUser;
import com.soft.platform.system.service.SysUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public static final Logger log = LogManager.getLogger(SysUserController.class);
    /**
     * 引入Service
     */
    @Resource
    private SysUserService sysUserService;

    @RequestMapping("/getUser")
    @ResponseBody
    public SysUser getRecord(HttpServletRequest request) {
        SysUser param = new SysUser();
        param.setUsername("lysh_lxh");
        //SysUser sysuser = sysUserService.getById("402883524863ab1f014863ab1f340000");
        SysUser sysuser = sysUserService.getRecord(param);
        return sysuser;
    }

    @RequestMapping("/findUser")
    @ResponseBody
    public List<SysUser> findRecord(HttpServletRequest request) {
        SysUser param = new SysUser();
        param.setDepartId("4028b8a455473c240155473deccb01ce");
        return sysUserService.findRecord(param);
    }

    @RequestMapping("/save")
    @ResponseBody
    public String save(HttpServletRequest request) {
        SysUser sysUser = new SysUser();
        //sysUser.setUserId("helloworld2424");
        sysUser.setUsername("testone");
        sysUser.setFullname("我们的歌");
        sysUser.setPassword("lxdjglfsdkl24");
        sysUser.setStatus(new BigDecimal(1));
        sysUser.setDepartId("4028b8a455473c240155473ce06c0099");
        sysUser.setCreateTime("2018-08-22");
        sysUserService.saveRecord(sysUser);
        return "success";
    }

    @RequestMapping("/modify")
    @ResponseBody
    public String modifyRecord(HttpServletRequest request) {
        SysUser sysUser = new SysUser();
        sysUser.setUserId("helloworld2424");
        sysUser.setUsername("helloworld");
        sysUser.setDepartId("4028b8a455473c240155473ce06c0099");
        sysUser.setCreateTime("2017-08-22");
        sysUserService.modifyRecord(sysUser);
        return "Succes";
    }

    @RequestMapping("/remove")
    @ResponseBody
    public String removeRecord(HttpServletRequest request) {
        sysUserService.removeRecords("helloworld2424".split(","));
        return "Success";
    }

    @RequestMapping("datagrid")
    @ResponseBody
    public PageInfo<SysUser> datagrid(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<>(8);
        params.put("pageNum", "1");
        params.put("pageSize", "5");
        params.put("departId", "4028b8a455473c240155473deccb01ce");
        params.put("orderstr", "create_time asc");
        return sysUserService.datagrid(params);
    }

    @RequestMapping("/hello")
    public ModelAndView hello(HttpServletRequest request) {
        // SysUser sysuser = sysUserService.getById("402883524863ab1f014863ab1f340000");
        //  request.setAttribute("sysUser",sysuser);
        return new ModelAndView("/main/index");
    }

    @RequestMapping("/learn")
    public ModelAndView learn(HttpServletRequest request) {
        return new ModelAndView("/layui/StartLearn");
    }


}

