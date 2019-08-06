package com.tbms.core.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Explain:     角色
 * Date:        2018-06-16 17:41:49
 * Coder:       青枫
 * Version:     1.0
 */
public class RoleDTO {

    private int id;
    private String role;
    private String name;
    private int status;
    private String resourceIds;
    private List<Integer> resourceIdList;
    private String resourceNames;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getResourceIds() {
        return resourceIds;
    }


    public List<Integer> getResourceIdList() {
        if (resourceIdList == null) {
            resourceIdList = new ArrayList<>();
        }
        return resourceIdList;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public void setResourceIdList(List<Integer> resourceIdList) {
        StringBuilder s = new StringBuilder();
        for (Integer resId : resourceIdList) {
            s.append(resId);
            s.append(",");
        }
        if (s.length() > 0) {
            s.deleteCharAt(s.length() - 1);
        }
        this.resourceIds = s.toString();
        this.resourceIdList = resourceIdList;
    }

    public String getResourceNames() {
        return resourceNames;
    }

    public void setResourceNames(String resourceNames) {
        this.resourceNames = resourceNames;
    }

    public String toString(){
        StringBuilder strBuf = new StringBuilder("RoleDTO{\n");
        strBuf.append("id:").append(this.id).append(",\n");
        strBuf.append("role:").append(this.role).append(",\n");
        strBuf.append("name:").append(this.name).append(",\n");
        strBuf.append("resourceIds:").append(this.resourceIds).append(",\n");
        strBuf.append("resourceNames:").append(this.resourceNames).append(",\n");
        strBuf.append("status:").append(this.status).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
