/*
 * Copyright (c)
 */
package  com.soft.platform.system.service.impl;

import com.soft.core.mapper.BaseMapper;
import com.soft.core.service.BaseServiceImpl;
import com.soft.platform.system.mapper.SysUserMapper;
import com.soft.platform.system.model.SysUser;
import com.soft.platform.system.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 描述  系统管理-用户管理操作service
 * @author David Lin
 * @version 1.0
 * @created 2018年08月19日  00:25:53
 */
@Service("sysUserService")
public class SysUserServiceImpl  extends BaseServiceImpl<SysUser> implements SysUserService {
    /**
     * 所引入的mapper
     */
    @Resource
    private SysUserMapper sysUserMapper;


     /**
     * 获取mapper对象
     *
     * @return
     */
    @Override
    protected BaseMapper getMapper() {
        return sysUserMapper;
    }
    

}
