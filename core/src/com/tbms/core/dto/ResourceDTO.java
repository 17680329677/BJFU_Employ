package com.tbms.core.dto;

import java.util.List;

/**
 * Explain:     资源
 * Date:        2018-06-16 17:41:49
 * Coder:       青枫
 * Version:     1.0
 */
public class ResourceDTO {

    /**编号*/
    private int id;
    /**名称*/
    private String name;
    /**资源类型*/
    private String type;
    /**链接地址*/
    private String url;
    /**父编号*/
    private int parentId;
    /**父编号列表*/
    private String parentIds;
    /**权限字符串*/
    private String permission;
    /**是否有效*/
    private int available;
    /**图标*/
    private String icon;
    /**优先级*/
    private int priority;

    private List<ResourceDTO> children;

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

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getParentId() {
        return this.parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return this.parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getPermission() {
        return this.permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public int getAvailable() {
        return this.available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public List<ResourceDTO> getChildren() {
        return children;
    }

    public void setChildren(List<ResourceDTO> children) {
        this.children = children;
    }

    public boolean isRootNode() {
        return parentId == 0;
    }

    @Override
    public String toString(){
        StringBuilder strBuf = new StringBuilder("ResourceDTO{\n");
        strBuf.append("id:").append(this.id).append(",\n");
        strBuf.append("name:").append(this.name).append(",\n");
        strBuf.append("type:").append(this.type).append(",\n");
        strBuf.append("url:").append(this.url).append(",\n");
        strBuf.append("parentId:").append(this.parentId).append(",\n");
        strBuf.append("parentIds:").append(this.parentIds).append(",\n");
        strBuf.append("permission:").append(this.permission).append(",\n");
        strBuf.append("available:").append(this.available).append(",\n");
        strBuf.append("icon:").append(this.icon).append(",\n");
        strBuf.append("priority:").append(this.priority).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
