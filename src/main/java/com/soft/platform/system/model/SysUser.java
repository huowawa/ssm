package com.soft.platform.system.model;

public class SysUser {
    /**
     * 主键
     */
    private String sysUserid;
    /**
     * 姓名
     */
    private String sysUserName;
    /**
     * 用户名
     */
    private String sysUserAccount;

    public String getSysUserid() {
        return sysUserid;
    }

    public void setSysUserid(String sysUserid) {
        this.sysUserid = sysUserid;
    }

    public String getSysUserName() {
        return sysUserName;
    }

    public void setSysUserName(String sysUserName) {
        this.sysUserName = sysUserName;
    }

    public String getSysUserAccount() {
        return sysUserAccount;
    }

    public void setSysUserAccount(String sysUserAccount) {
        this.sysUserAccount = sysUserAccount;
    }
}
