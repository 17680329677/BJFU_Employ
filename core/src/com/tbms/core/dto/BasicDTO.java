package com.tbms.core.dto;

/**
 * Explain:     基础信息
 * Date:        2019-03-08 11:31:00
 * Coder:       青枫
 * Version:     1.0
 */
public class BasicDTO {

    /**ID*/
    private int id;
    /**代码*/
    private String code;
    /**名称*/
    private String name;
    /**类型*/
    private String type;
    /**基础信息描述*/
    private String describe;
    /**状态*/
    private int status;
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

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescribe() {
        return this.describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String toString(){
        StringBuilder strBuf = new StringBuilder("BasicDTO{\n");
        strBuf.append("id:").append(this.id).append(",\n");
        strBuf.append("code:").append(this.code).append(",\n");
        strBuf.append("name:").append(this.name).append(",\n");
        strBuf.append("type:").append(this.type).append(",\n");
        strBuf.append("describe:").append(this.describe).append(",\n");
        strBuf.append("status:").append(this.status).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
