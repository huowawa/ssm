/*
 * Copyright (c)
 */
package com.soft.platform.developer.controller;

import com.soft.platform.developer.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 开发相关
 *
 * @author David Lin
 * @version: 1.0
 * @date 2018-08-11 23:13
 */
@Controller
@RequestMapping("/dev")
public class DeveloperController {

    /**
     * 开发属性
     */
    @Autowired
    private DeveloperService developerService;

    /**
     * 生成代码
     *
     * @param request
     * @return
     */
    @RequestMapping("/gencode")
    @ResponseBody
    public String genCode(HttpServletRequest request) {
        try {
            Map<String, Object> paramMap = new HashMap<>(8);
            paramMap.put("packagename", "system");
            paramMap.put("tablename", "T_MSJW_SYSTEM_SYSROLE"); // 表名称
            paramMap.put("classname", "SysRole"); // 获取CLASS名称
            paramMap.put("entityname", "系统管理-角色管理"); // 获取实体中文名称
            developerService.genCode(paramMap);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return "success";
    }
}
