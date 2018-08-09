package com.soft.platform.system.mapper;

import com.soft.platform.system.model.SysUser;

import java.util.List;

public interface SysUserMapper {
    List<SysUser> findAllUsers();
}
