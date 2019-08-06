package com.tbms.core.dto;

/**
 * Explain:     
 * Date:        2018-08-05 08:58:06
 * Coder:       青枫
 * Version:     1.0
 */
public class LogDTO {

    /**ID*/
    private long id;
    /**用户名*/
    private String username;
    /**IP*/
    private String ip;
    /**请求方法*/
    private String method;
    /**URI*/
    private String uri;
    /**执行方法*/
    private String execMethod;
    /**执行时间*/
    private long execTime;
    /**参数*/
    private String args;
    /**返回值*/
    private String returnVal;
    /**执行描述*/
    private String execDesc;
    /**添加时间*/
    private int createTime;
    /**状态*/
    private String status;
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUri() {
        return this.uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getExecMethod() {
        return this.execMethod;
    }

    public void setExecMethod(String execMethod) {
        this.execMethod = execMethod;
    }

    public long getExecTime() {
        return this.execTime;
    }

    public void setExecTime(long execTime) {
        this.execTime = execTime;
    }

    public String getArgs() {
        return this.args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public String getReturnVal() {
        return this.returnVal;
    }

    public void setReturnVal(String returnVal) {
        this.returnVal = returnVal;
    }

    public String getExecDesc() {
        return this.execDesc;
    }

    public void setExecDesc(String execDesc) {
        this.execDesc = execDesc;
    }

    public int getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toString(){
        StringBuilder strBuf = new StringBuilder("LogDTO{\n");
        strBuf.append("id:").append(this.id).append(",\n");
        strBuf.append("username:").append(this.username).append(",\n");
        strBuf.append("ip:").append(this.ip).append(",\n");
        strBuf.append("method:").append(this.method).append(",\n");
        strBuf.append("uri:").append(this.uri).append(",\n");
        strBuf.append("execMethod:").append(this.execMethod).append(",\n");
        strBuf.append("execTime:").append(this.execTime).append(",\n");
        strBuf.append("args:").append(this.args).append(",\n");
        strBuf.append("returnVal:").append(this.returnVal).append(",\n");
        strBuf.append("execDesc:").append(this.execDesc).append(",\n");
        strBuf.append("createTime:").append(this.createTime).append(",\n");
        strBuf.append("status:").append(this.status).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
