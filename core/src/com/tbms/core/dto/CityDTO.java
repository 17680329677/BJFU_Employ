package com.tbms.core.dto;

/**
 * Explain:     
 * Date:        2019-07-12 20:44:40
 * Coder:       dhz
 * Version:     1.0
 */
public class CityDTO {

    private int id;
    private String code;
    private String name;
    private String provincecode;
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

    public String getProvincecode() {
        return this.provincecode;
    }

    public void setProvincecode(String provincecode) {
        this.provincecode = provincecode;
    }

    public String toString(){
        StringBuilder strBuf = new StringBuilder("CityDTO{\n");
        strBuf.append("id:").append(this.id).append(",\n");
        strBuf.append("code:").append(this.code).append(",\n");
        strBuf.append("name:").append(this.name).append(",\n");
        strBuf.append("provincecode:").append(this.provincecode).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
