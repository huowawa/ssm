/*
 * Copyright (c)
 */
 
package  com.soft.platform.system.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 描述   系统管理-用户管理实体对象
 * @author David Lin
 * @version 1.0
 * @created 2018年08月22日  22:21:05
 */
public class SysUser implements java.io.Serializable  {
     /**
     * 主键
     */
    private String userId;

    /**
     * 注释
     */
    private String departId;
    /**
     * 注释
     */
    private String username;
    /**
     * 注释
     */
    private String fullname;
    /**
     * 注释
     */
    private String password;
    /**
     * 注释
     */
    private String mobile;
    /**
     * 注释
     */
    private String email;
    /**
     * 注释
     */
    private BigDecimal status;
    /**
     * 注释
     */
    private String createTime;
    /**
     * 注释
     */
    private BigDecimal sex;
    /**
     * 注释
     */
    private String isModifypass;
    /**
     * 注释
     */
    private String branchId;
    /**
     * 注释
     */
    private String position;
    /**
     * 注释
     */
    private String chineseAccount;
    /**
     * 注释
     */
    private String isLawperson;
    /**
     * 注释
     */
    private String birthday;
    /**
     * 注释
     */
    private String executorid;
    /**
     * 注释
     */
    private String credential;
    /**
     * 注释
     */
    private String sdate;
    /**
     * 注释
     */
    private String edate;
    /**
     * 注释
     */
    private String noEdate;
    /**
     * 注释
     */
    private String fixedPhone;
    /**
     * 登录失败次数
     */
    private BigDecimal failCount;

   public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }
    public String getDepartId() {
        return departId;
    }
    public void setDepartId(String departId) {
        this.departId = departId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public BigDecimal getStatus() {
        return status;
    }
    public void setStatus(BigDecimal status) {
        this.status = status;
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public BigDecimal getSex() {
        return sex;
    }
    public void setSex(BigDecimal sex) {
        this.sex = sex;
    }
    public String getIsModifypass() {
        return isModifypass;
    }
    public void setIsModifypass(String isModifypass) {
        this.isModifypass = isModifypass;
    }
    public String getBranchId() {
        return branchId;
    }
    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getChineseAccount() {
        return chineseAccount;
    }
    public void setChineseAccount(String chineseAccount) {
        this.chineseAccount = chineseAccount;
    }
    public String getIsLawperson() {
        return isLawperson;
    }
    public void setIsLawperson(String isLawperson) {
        this.isLawperson = isLawperson;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getExecutorid() {
        return executorid;
    }
    public void setExecutorid(String executorid) {
        this.executorid = executorid;
    }
    public String getCredential() {
        return credential;
    }
    public void setCredential(String credential) {
        this.credential = credential;
    }
    public String getSdate() {
        return sdate;
    }
    public void setSdate(String sdate) {
        this.sdate = sdate;
    }
    public String getEdate() {
        return edate;
    }
    public void setEdate(String edate) {
        this.edate = edate;
    }
    public String getNoEdate() {
        return noEdate;
    }
    public void setNoEdate(String noEdate) {
        this.noEdate = noEdate;
    }
    public String getFixedPhone() {
        return fixedPhone;
    }
    public void setFixedPhone(String fixedPhone) {
        this.fixedPhone = fixedPhone;
    }
    public BigDecimal getFailCount() {
        return failCount;
    }
    public void setFailCount(BigDecimal failCount) {
        this.failCount = failCount;
    }


}
