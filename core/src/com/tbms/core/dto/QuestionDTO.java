package com.tbms.core.dto;

import java.util.Date;

/**
 * Explain:     问题信息
 * Date:        2019-03-05 21:45:19
 * Coder:       dhz
 * Version:     1.0
 */
public class QuestionDTO {

    /**ID*/
    private int id;
    /**问卷ID*/
    private int paperId;
    /**创建时间*/
    private String createTime;
    /**问题类型*/
    private int questionType;
    /**问题标题*/
    private String questionTitle;
    /**问题选项*/
    private String questionOption;
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

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getQuestionType() {
        return this.questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    public String getQuestionTitle() {
        return this.questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionOption() {
        return this.questionOption;
    }

    public void setQuestionOption(String questionOption) {
        this.questionOption = questionOption;
    }

    public String toString(){
        StringBuilder strBuf = new StringBuilder("QuestionDTO{\n");
        strBuf.append("id:").append(this.id).append(",\n");
        strBuf.append("paperId:").append(this.paperId).append(",\n");
        strBuf.append("questionType:").append(this.questionType).append(",\n");
        strBuf.append("questionTitle:").append(this.questionTitle).append(",\n");
        strBuf.append("questionOption:").append(this.questionOption).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
