package com.soft.platform.system.controller;

import com.soft.platform.system.model.SysUser;
import com.soft.platform.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

   @RequestMapping("/all")
    public List<SysUser> findAllUsers(HttpServletRequest request){
        return sysUserService.findAllUsers();
    }
}
