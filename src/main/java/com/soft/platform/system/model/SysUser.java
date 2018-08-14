package com.soft.platform.system.model;

public class SysUser {
    /**
     * 主键
     */
    private String userId;
    /**
     * 姓名
     */
    private String fullName;
    /**
     * 用户名
     */
    private String userName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
