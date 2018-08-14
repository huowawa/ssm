/*
 * Copyright (c)
 */
package com.soft.platform.system.service.impl;

import com.soft.core.service.BaseServiceImpl;
import com.soft.platform.system.mapper.SysRoleMapper;
import com.soft.platform.system.model.SysRole;
import com.soft.platform.system.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述  系统管理-角色管理操作service
 *
 * @author David Lin
 * @version 1.0
 * @created 2018年08月14日  21:58:58
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends BaseServiceImpl implements SysRoleService {
    /**
     * 所引入的mapper
     */
    @Resource
    private SysRoleMapper sysRoleMapper;


    @Override
    public List<SysRole> findRoleByGroupId(String groupId) {
        return sysRoleMapper.findRoleByGroupId(groupId);
    }
}
