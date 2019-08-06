package com.tbms.core.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

/**
 * Explain:     就业统计
 * Date:        519-03-09 16:14:35
 * Coder:       青枫
 * Version:     1.0
 */
public class AnalyseDTO {

    /**ID*/
    private int id;
    /**学院*/
    @Excel(name = "学院",width=25)
    private String depart;
    /**学院代码*/
    private String departCode;
    /**专业*/
    @Excel(name = "专业",width=25)
    private String major;
    /**专业代码*/
    private String majorCode;
    /**学生人数*/
    @Excel(name = "学生人数",width=5)
    private int count;
    /**学生总数*/
    @Excel(name = "学生总数",width=5)
    private int total;
    /**签三方*/
    @Excel(name = "签三方",width=5)
    private int agreement;
    /**签合同*/
    @Excel(name = "签合同",width=5)
    private int contract;
    /**在职*/
    @Excel(name = "在职",width=5)
    private int incumbent;
    /**升学*/
    @Excel(name = "升学",width=5)
    private int relearning;
    /**签约合计*/
    @Excel(name = "签约合计",width=10)
    private int signings;
    /**签约率*/
    @Excel(name = "签约率",width=15)
    private double signrate;
    /**出国*/
    @Excel(name = "出国",width=5)
    private int abroad;
    /**单位证明*/
    @Excel(name = "单位证明",width=5)
    private int certificate;
    /**自由职业*/
    @Excel(name = "自由职业",width=5)
    private int liberal;
    /**自主创业*/
    @Excel(name = "自主创业",width=5)
    private int selfemployed;
    /**有意向在考虑*/
    @Excel(name = "有意向在考虑",width=5)
    private int intention;
    /**签约中*/
    @Excel(name = "签约中",width=5)
    private int signing;
    /**就业合计*/
    @Excel(name = "就业合计",width=10)
    private int employs;
    /**就业率*/
    @Excel(name = "就业率",width=15)
    private double employrate;
    /**拟参加公招考试*/
    @Excel(name = "拟参加公招考试",width=5)
    private int officer;
    /**其他求职中*/
    @Excel(name = "其他求职中",width=5)
    private int other;
    /**拟创业*/
    @Excel(name = "拟创业",width=5)
    private int work;
    /**暂不就业*/
    @Excel(name = "暂不就业",width=5)
    private int unemploy;
    /**拟升学*/
    @Excel(name = "拟升学",width=5)
    private int inrelearning;
    /**拟出国出境*/
    @Excel(name = "拟出国出境",width=5)
    private int inabroad;
    /**未就业合计*/
    @Excel(name = "未就业合计",width=10)
    private int unemploys;
    /**未就业率*/
    @Excel(name = "未就业率",width=15)
    private double unemployrate;
    /**总签约率*/
    private double allsignrate;
    /**总就业率*/
    private double allemployrate;
    /**总未就业率*/
    private double allunemployrate;
    /**添加时间*/
    private Date createTime;
    /**修改时间*/
    private Date updateTime;
    /**年度*/
    @Excel(name = "年度",width=10)
    private int year;
    /**学生类型*/
    @Excel(name = "学生类型",width=10)
    private String type;
    /**状态*/
    private int status;
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepart() {
        return this.depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getDepartCode() {
        return this.departCode;
    }

    public void setDepartCode(String departCode) {
        this.departCode = departCode;
    }

    public String getMajor() {
        return this.major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMajorCode() {
        return this.majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAgreement() {
        return this.agreement;
    }

    public void setAgreement(int agreement) {
        this.agreement = agreement;
    }

    public int getContract() {
        return this.contract;
    }

    public void setContract(int contract) {
        this.contract = contract;
    }

    public int getIncumbent() {
        return this.incumbent;
    }

    public void setIncumbent(int incumbent) {
        this.incumbent = incumbent;
    }

    public int getRelearning() {
        return this.relearning;
    }

    public void setRelearning(int relearning) {
        this.relearning = relearning;
    }

    public int getSignings() {
        return this.signings;
    }

    public void setSignings(int signings) {
        this.signings = signings;
    }

    public double getSignrate() {
        return this.signrate;
    }

    public void setSignrate(double signrate) {
        this.signrate = signrate;
    }

    public int getAbroad() {
        return this.abroad;
    }

    public void setAbroad(int abroad) {
        this.abroad = abroad;
    }

    public int getCertificate() {
        return this.certificate;
    }

    public void setCertificate(int certificate) {
        this.certificate = certificate;
    }

    public int getLiberal() {
        return this.liberal;
    }

    public void setLiberal(int liberal) {
        this.liberal = liberal;
    }

    public int getSelfemployed() {
        return this.selfemployed;
    }

    public void setSelfemployed(int selfemployed) {
        this.selfemployed = selfemployed;
    }

    public int getIntention() {
        return this.intention;
    }

    public void setIntention(int intention) {
        this.intention = intention;
    }

    public int getSigning() {
        return this.signing;
    }

    public void setSigning(int signing) {
        this.signing = signing;
    }

    public int getEmploys() {
        return this.employs;
    }

    public void setEmploys(int employs) {
        this.employs = employs;
    }

    public double getEmployrate() {
        return this.employrate;
    }

    public void setEmployrate(double employrate) {
        this.employrate = employrate;
    }

    public int getOfficer() {
        return this.officer;
    }

    public void setOfficer(int officer) {
        this.officer = officer;
    }

    public int getOther() {
        return this.other;
    }

    public void setOther(int other) {
        this.other = other;
    }

    public int getWork() {
        return this.work;
    }

    public void setWork(int work) {
        this.work = work;
    }

    public int getUnemploy() {
        return this.unemploy;
    }

    public void setUnemploy(int unemploy) {
        this.unemploy = unemploy;
    }

    public int getInrelearning() {
        return this.inrelearning;
    }

    public void setInrelearning(int inrelearning) {
        this.inrelearning = inrelearning;
    }

    public int getInabroad() {
        return this.inabroad;
    }

    public void setInabroad(int inabroad) {
        this.inabroad = inabroad;
    }

    public int getUnemploys() {
        return this.unemploys;
    }

    public void setUnemploys(int unemploys) {
        this.unemploys = unemploys;
    }

    public double getUnemployrate() {
        return this.unemployrate;
    }

    public void setUnemployrate(double unemployrate) {
        this.unemployrate = unemployrate;
    }

    public double getAllsignrate() {
        return this.allsignrate;
    }

    public void setAllsignrate(double allsignrate) {
        this.allsignrate = allsignrate;
    }

    public double getAllemployrate() {
        return this.allemployrate;
    }

    public void setAllemployrate(double allemployrate) {
        this.allemployrate = allemployrate;
    }

    public double getAllunemployrate() {
        return this.allunemployrate;
    }

    public void setAllunemployrate(double allunemployrate) {
        this.allunemployrate = allunemployrate;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String toString(){
        StringBuilder strBuf = new StringBuilder("AnalyseDTO{\n");
        strBuf.append("id:").append(this.id).append(",\n");
        strBuf.append("depart:").append(this.depart).append(",\n");
        strBuf.append("departCode:").append(this.departCode).append(",\n");
        strBuf.append("major:").append(this.major).append(",\n");
        strBuf.append("majorCode:").append(this.majorCode).append(",\n");
        strBuf.append("count:").append(this.count).append(",\n");
        strBuf.append("total:").append(this.total).append(",\n");
        strBuf.append("agreement:").append(this.agreement).append(",\n");
        strBuf.append("contract:").append(this.contract).append(",\n");
        strBuf.append("incumbent:").append(this.incumbent).append(",\n");
        strBuf.append("relearning:").append(this.relearning).append(",\n");
        strBuf.append("signings:").append(this.signings).append(",\n");
        strBuf.append("signrate:").append(this.signrate).append(",\n");
        strBuf.append("abroad:").append(this.abroad).append(",\n");
        strBuf.append("certificate:").append(this.certificate).append(",\n");
        strBuf.append("liberal:").append(this.liberal).append(",\n");
        strBuf.append("selfemployed:").append(this.selfemployed).append(",\n");
        strBuf.append("intention:").append(this.intention).append(",\n");
        strBuf.append("signing:").append(this.signing).append(",\n");
        strBuf.append("employs:").append(this.employs).append(",\n");
        strBuf.append("employrate:").append(this.employrate).append(",\n");
        strBuf.append("officer:").append(this.officer).append(",\n");
        strBuf.append("other:").append(this.other).append(",\n");
        strBuf.append("work:").append(this.work).append(",\n");
        strBuf.append("unemploy:").append(this.unemploy).append(",\n");
        strBuf.append("inrelearning:").append(this.inrelearning).append(",\n");
        strBuf.append("inabroad:").append(this.inabroad).append(",\n");
        strBuf.append("unemploys:").append(this.unemploys).append(",\n");
        strBuf.append("unemployrate:").append(this.unemployrate).append(",\n");
        strBuf.append("allsignrate:").append(this.allsignrate).append(",\n");
        strBuf.append("allemployrate:").append(this.allemployrate).append(",\n");
        strBuf.append("allunemployrate:").append(this.allunemployrate).append(",\n");
        strBuf.append("createTime:").append(this.createTime).append(",\n");
        strBuf.append("updateTime:").append(this.updateTime).append(",\n");
        strBuf.append("year:").append(this.year).append(",\n");
        strBuf.append("type:").append(this.type).append(",\n");
        strBuf.append("status:").append(this.status).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
