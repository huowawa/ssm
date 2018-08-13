package com.soft.platform.system.service.impl;

import com.soft.platform.system.mapper.SysUserMapper;
import com.soft.platform.system.model.SysUser;
import com.soft.platform.system.service.SysUserService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 *
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper mapper;

    @Override
    public List<SysUser> findAllUsers() {
        return mapper.findAllUsers();
    }

    public void show(){


    }
}
