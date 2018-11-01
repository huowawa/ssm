/*
 * Copyright (c)
 */
package com.soft.platform.developer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通用控制器
 *
 * @author David Lin
 * @version: 1.0
 * @date 2018-09-22 15:10
 */
@Controller
@RequestMapping("/common")
public class CommonController {

    @RequestMapping("/hello")
    public ModelAndView redirect(HttpServletRequest request, HttpServletResponse response){
        String page = request.getParameter("page");

        return  new ModelAndView("/react/"+page);
    }
}
