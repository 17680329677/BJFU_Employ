package com.tbms.core.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * Explain:     管理员
 * Date:        2018-06-16 17:41:50
 * Coder:       青枫
 * Version:     1.0
 */
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    /**姓名*/
    private String name;
    /**用户名*/
    private String username;
    /**密码*/
    private String password;
    /**手机号*/
    private String phone;
    /**邮箱*/
    private String email;
    /**部门代码*/
    private String departCode;
    /**部门名称*/
    private String departName;
    /**角色ID*/
    private String roleId;
    /**角色名称*/
    private String roleName;
    /**最后登录IP*/
    private String lastLoginIp;
    /**最后登录时间*/
    private int lastLoginTime;
    /**登录次数*/
    private int loginCount;
    /**创建时间*/
    private int createTime;
    /**更新时间*/
    private int updateTime;
    /**管理员状态*/
    private int status;

    private String rememberMe;
    public String getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(String rememberMe) {
        this.rememberMe = rememberMe;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartCode() {
        return this.departCode;
    }

    public void setDepartCode(String departCode) {
        this.departCode = departCode;
    }

    public String getDepartName() {
        return this.departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getLastLoginIp() {
        return this.lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public int getLastLoginTime() {
        return this.lastLoginTime;
    }

    public void setLastLoginTime(int lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public int getLoginCount() {
        return this.loginCount;
    }

    public void setLoginCount(int loginCount) {
        this.loginCount = loginCount;
    }

    public int getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public int getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(int updateTime) {
        this.updateTime = updateTime;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    /**
     * 密码盐
     */
    public String getCredentialsSalt(){
        return this.username;
    }

    public String toString(){
        StringBuilder strBuf = new StringBuilder("UserDTO{\n");
        strBuf.append("id:").append(this.id).append(",\n");
        strBuf.append("name:").append(this.name).append(",\n");
        strBuf.append("username:").append(this.username).append(",\n");
        strBuf.append("password:").append(this.password).append(",\n");
        strBuf.append("phone:").append(this.phone).append(",\n");
        strBuf.append("email:").append(this.email).append(",\n");
        strBuf.append("departCode:").append(this.departCode).append(",\n");
        strBuf.append("departName:").append(this.departName).append(",\n");
        strBuf.append("roleId:").append(this.roleId).append(",\n");
        strBuf.append("roleName:").append(this.roleName).append(",\n");
        strBuf.append("lastLoginIp:").append(this.lastLoginIp).append(",\n");
        strBuf.append("lastLoginTime:").append(this.lastLoginTime).append(",\n");
        strBuf.append("loginCount:").append(this.loginCount).append(",\n");
        strBuf.append("createTime:").append(this.createTime).append(",\n");
        strBuf.append("updateTime:").append(this.updateTime).append(",\n");
        strBuf.append("status:").append(this.status).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return getId() == userDTO.getId();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
