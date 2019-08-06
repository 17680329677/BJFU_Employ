package com.tbms.core.dto;

/**
 * Explain:     部门管理
 * Date:        2019-02-02 08:43:22
 * Coder:       青枫
 * Version:     1.0
 */
public class DepartDTO {

    private int id;
    /**部门代码*/
    private String code;
    /**部门名称*/
    private String name;
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        StringBuilder strBuf = new StringBuilder("DepartDTO{\n");
        strBuf.append("id:").append(this.id).append(",\n");
        strBuf.append("code:").append(this.code).append(",\n");
        strBuf.append("name:").append(this.name).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
