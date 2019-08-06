package com.tbms.core.dto;

/**
 * Explain:     角色资源
 * Date:        2018-06-16 17:41:50
 * Coder:       青枫
 * Version:     1.0
 */
public class RoleResourceDTO {

    private int id;
    /**角色ID*/
    private int roleId;
    /**资源ID*/
    private int resourceId;
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return this.roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getResourceId() {
        return this.resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String toString(){
        StringBuilder strBuf = new StringBuilder("RoleResourceDTO{\n");
        strBuf.append("id:").append(this.id).append(",\n");
        strBuf.append("roleId:").append(this.roleId).append(",\n");
        strBuf.append("resourceId:").append(this.resourceId).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
