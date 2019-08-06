package com.tbms.core.dto;

/**
 * Explain:     专业
 * Date:        2019-02-02 08:43:43
 * Coder:       青枫
 * Version:     1.0
 */
public class MajorDTO {

    private int id;
    /**专业代码*/
    private String code;
    /**专业名称*/
    private String name;
    /**学院代码*/
    private String departCode;
    /**学院名称*/
    private String departName;
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

    public String toString(){
        StringBuilder strBuf = new StringBuilder("MajorDTO{\n");
        strBuf.append("id:").append(this.id).append(",\n");
        strBuf.append("code:").append(this.code).append(",\n");
        strBuf.append("name:").append(this.name).append(",\n");
        strBuf.append("departCode:").append(this.departCode).append(",\n");
        strBuf.append("departName:").append(this.departName).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
