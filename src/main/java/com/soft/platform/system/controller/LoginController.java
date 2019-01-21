/*
 * Copyright (c)
 */
package com.soft.platform.system.controller;

import com.soft.core.util.PlatPropertiesUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Properties;

/**
 * 登录控制器
 *
 * @author David Lin
 * @version: 1.0
 *
 * @date 2019-01-20 7:11
 */
@Controller
public class LoginController {

    /**
     * 日志类
     */
    public static final Logger LOG = LogManager.getLogger(LoginController.class);

    /**
     * 跳转到登录页面
     * @param request
     * @return
     */
    @GetMapping("/login")
    public String goToLogin(HttpServletRequest request){

        try {
            //是否开启验证码
            Properties configProperties = PlatPropertiesUtil.getPropertiesByPath("conf/config.properties");
            String isCaptcha = configProperties.getProperty("iscaptcha");
            request.setAttribute("isCaptcha",isCaptcha);
        } catch (Exception e) {
           LOG.error(e);
        }

        return "login";
    }

    /**
     * 登录验证
     * @param request
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String captcha = request.getParameter("captcha");

        LOG.info(captcha);
        return username;
    }


}
