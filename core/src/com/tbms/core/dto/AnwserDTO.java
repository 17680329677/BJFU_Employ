package com.tbms.core.dto;

import java.util.Date;

/**
 * Explain:     答案信息
 * Date:        2019-03-05 21:45:18
 * Coder:       dhz
 * Version:     1.0
 */
public class AnwserDTO {

    /**ID*/
    private int id;
    /**问卷ID*/
    private int paperId;
    /**问题ID*/
    private int questionId;
    /**问题类型*/
    private int questionType;
    /**提交时间*/
    private String submitTime;
    /**提交选项*/
    private String submitOption;
    /**提交人*/
    private int studentId;
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPaperId() {
        return this.paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public int getQuestionId() {
        return this.questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getQuestionType() {
        return this.questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    public String getSubmitTime() {
        return this.submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public String getSubmitOption() {
        return this.submitOption;
    }

    public void setSubmitOption(String submitOption) {
        this.submitOption = submitOption;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String toString(){
        StringBuilder strBuf = new StringBuilder("AnwserDTO{\n");
        strBuf.append("id:").append(this.id).append(",\n");
        strBuf.append("paperId:").append(this.paperId).append(",\n");
        strBuf.append("questionId:").append(this.questionId).append(",\n");
        strBuf.append("questionType:").append(this.questionType).append(",\n");
        strBuf.append("submitTime:").append(this.submitTime).append(",\n");
        strBuf.append("submitOption:").append(this.submitOption).append(",\n");
        strBuf.append("studentId:").append(this.studentId).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
