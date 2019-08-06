package com.tbms.core.dto;

import java.util.Date;

/**
 * Explain:     
 * Date:        2019-06-02 13:53:22
 * Coder:       青枫
 * Version:     1.0
 */
public class TokenDTO {


    private int id;

    private int studentId;

    private String accessToken;

    private String refreshToken;

    private Date updateTime;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String toString(){
        StringBuilder strBuf = new StringBuilder("TokenDTO{\n");
        strBuf.append("id:").append(this.id).append(",\n");
        strBuf.append("studentId:").append(this.studentId).append(",\n");
        strBuf.append("accessToken:").append(this.accessToken).append(",\n");
        strBuf.append("refreshToken:").append(this.refreshToken).append(",\n");
        strBuf.append("updateTime:").append(this.updateTime).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
