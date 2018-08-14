/*
 * Copyright (c)
 */
package com.soft.platform.system.mapper;

import com.soft.core.mapper.BaseMapper;
import com.soft.platform.system.model.SysRole;

import java.util.List;

/**
 * 描述   系统管理-角色管理操作mapper
 *
 * @author David Lin
 * @version 1.0
 * @created 2018年08月14日  21:58:58
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
    /**
     * 根据分组ID 获取角色信息
     * @param groupId
     * @return
     */
    List<SysRole> findRoleByGroupId (String groupId);

}
