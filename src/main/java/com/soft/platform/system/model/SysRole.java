/*
 * Copyright (c)
 */
 
package  com.soft.platform.system.model;

/**
 * 描述   系统管理-角色管理实体对象
 * @author David Lin
 * @version 1.0
 * @created 2018年08月18日  18:03:15
 */
public class SysRole implements java.io.Serializable  {
    /**
     * 角色ID
     */
    private String roleId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色编码
     */
    private String roleCode;
    /**
     * 入库时间
     */
    private String createTime;
    /**
     * 角色组ID
     */
    private String groupId;
    
    public String getRoleId() {
        return roleId;
    }
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public String getRoleCode() {
        return roleCode;
    }
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getGroupId() {
        return groupId;
    }
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }


}
