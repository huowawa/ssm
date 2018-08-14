/*
 * Copyright (c)
 */
package com.soft.platform.system.service;

import com.soft.core.service.BaseService;
import com.soft.platform.system.model.SysRole;

import java.util.List;


/**
 * 描述  系统管理-角色管理操作service
 *
 * @author David Lin
 * @version 1.0
 * @created 2018年08月14日  21:58:58
 */
public interface SysRoleService extends BaseService {
    /**
     * 根据分组ID 获取角色信息
     * @param groupId
     * @return
     */
    List<SysRole> findRoleByGroupId (String groupId);
}
