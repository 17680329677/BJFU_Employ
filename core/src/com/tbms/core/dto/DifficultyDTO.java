package com.tbms.core.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * Explain:     困难学生信息
 * Date:        2019-05-06 19:11:42
 * Coder:       青枫
 * Version:     1.0
 */
public class DifficultyDTO {

    /**ID*/
    private int id;
    /**学号*/
    @Excel(name = "学号",width=15)
    private String account;
    /**姓名*/
    @Excel(name = "姓名",width=15)
    private String name;
    /**毕业年份*/
    @Excel(name = "毕业年份",width=10)
    private int graduateYear;
    /**二级学院名称*/
    @Excel(name = "学院",width=20)
    private String depart;
    /**专业*/
    @Excel(name = "专业",width=20)
    private String major;
    /**就业困难情况概述*/
    @Excel(name = "就业困难情况概述",width=20)
    private String description;
    /**类型代码*/
    private int code;
    /**就业困难类型*/
    @Excel(name = "就业困难类型",width=20)
    private String type;
    /**目前就业进展*/
    @Excel(name = "目前就业进展",width=20)
    private String process;
    /**学院帮扶措施*/
    @Excel(name = "学院帮扶措施",width=20)
    private String measure;
    /**添加时间*/
    private int createTime;
    /**修改时间*/
    private int updateTime;
    /**备注*/
    @Excel(name = "备注",width=20)
    private String remark;
    /**状态*/
    private int status;
    /**困难人数*/
    private int count;
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return this.account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGraduateYear() {
        return graduateYear;
    }

    public void setGraduateYear(int graduateYear) {
        this.graduateYear = graduateYear;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProcess() {
        return this.process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getMeasure() {
        return this.measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public int getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public int getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(int updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String toString(){
        StringBuilder strBuf = new StringBuilder("DifficultyDTO{\n");
        strBuf.append("id:").append(this.id).append(",\n");
        strBuf.append("account:").append(this.account).append(",\n");
        strBuf.append("description:").append(this.description).append(",\n");
        strBuf.append("code:").append(this.code).append(",\n");
        strBuf.append("type:").append(this.type).append(",\n");
        strBuf.append("process:").append(this.process).append(",\n");
        strBuf.append("measure:").append(this.measure).append(",\n");
        strBuf.append("remark:").append(this.remark).append(",\n");
        strBuf.append("status:").append(this.status).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
