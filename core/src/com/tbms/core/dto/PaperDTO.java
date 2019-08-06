package com.tbms.core.dto;

/**
 * Explain:     问卷表
 * Date:        2019-03-05 21:45:18O
 * Coder:       dhz
 * Version:     1.0
 */
public class PaperDTO {

    /**ID*/
    private int id;
    /**用户ID*/
    private int userId;
    /**问卷标题*/
    private String title;
    /**创建时间*/
    private String createTime;
    /**问卷状态*/
    private int status;
    /**开始时间*/
    private String startTime;
    /**结束时间*/
    private String endTime;
    /**问卷类型*/
    private String paperType;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    public String toString(){
        StringBuilder strBuf = new StringBuilder("PaperDTO{\n");
        strBuf.append("id:").append(this.id).append(",\n");
        strBuf.append("userId:").append(this.userId).append(",\n");
        strBuf.append("title:").append(this.title).append(",\n");
        strBuf.append("createTime:").append(this.createTime).append(",\n");
        strBuf.append("status:").append(this.status).append(",\n");
        strBuf.append("startTime:").append(this.startTime).append(",\n");
        strBuf.append("endTime:").append(this.endTime).append("\n");
        strBuf.append("paperType:").append(this.paperType).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
