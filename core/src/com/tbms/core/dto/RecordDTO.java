package com.tbms.core.dto;

/**
 * Explain:     档案信息
 * Date:        2019-02-08 10:14:37
 * Coder:       青枫
 * Version:     1.0
 */
public class RecordDTO {

    /**ID*/
    private int id;
    /**学号*/
    private String account;
    /**报到证签发类别*/
    private String registerType;
    /**报到证签发类别代码*/
    private int registerCode;
    /**就业形式*/
    private String employForm;
    /**就业形式代码*/
    private int employFormCode;
    /**毕业去向*/
    private String destination;
    /**毕业去向代码*/
    private int destinationCode;
    /**就业范围*/
    private String employRange;
    /**就业范围代码*/
    private int employRangeCode;
    /**派遣时间*/
    private String dispatchTime;
    /**报到期限*/
    private String registDeadline;
    /**档案转寄单位*/
    private String recordCompany;
    /**档案转寄邮政编码*/
    private String recordPostcode;
    /**档案转寄地址*/
    private String recordAddr;
    /**户口迁移地址*/
    private String permanentAddr;
    /**具体落实单位所在地代码*/
    private String implementCompCode;
    /**具体落实单位所在地*/
    private String implementCompAddr;
    /**具体落实单位名称*/
    private String implementComp;
    /**派遣报到证号*/
    private String dispatchRegisterCode;
    /**档案收件人手机*/
    private String recordReceiverCellphone;
    /**档案收件人*/
    private String recordReceiver;
    /**档案收件人电话*/
    private String recordReceiverPhone;
    /**特殊就业类别*/
    private String specialEmploy;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRegisterType() {
        return this.registerType;
    }

    public void setRegisterType(String registerType) {
        this.registerType = registerType;
    }

    public int getRegisterCode() {
        return this.registerCode;
    }

    public void setRegisterCode(int registerCode) {
        this.registerCode = registerCode;
    }

    public String getEmployForm() {
        return this.employForm;
    }

    public void setEmployForm(String employForm) {
        this.employForm = employForm;
    }

    public int getEmployFormCode() {
        return this.employFormCode;
    }

    public void setEmployFormCode(int employFormCode) {
        this.employFormCode = employFormCode;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDestinationCode() {
        return this.destinationCode;
    }

    public void setDestinationCode(int destinationCode) {
        this.destinationCode = destinationCode;
    }

    public String getEmployRange() {
        return this.employRange;
    }

    public void setEmployRange(String employRange) {
        this.employRange = employRange;
    }

    public int getEmployRangeCode() {
        return this.employRangeCode;
    }

    public void setEmployRangeCode(int employRangeCode) {
        this.employRangeCode = employRangeCode;
    }

    public String getDispatchTime() {
        return this.dispatchTime;
    }

    public void setDispatchTime(String dispatchTime) {
        this.dispatchTime = dispatchTime;
    }

    public String getRegistDeadline() {
        return this.registDeadline;
    }

    public void setRegistDeadline(String registDeadline) {
        this.registDeadline = registDeadline;
    }

    public String getRecordCompany() {
        return this.recordCompany;
    }

    public void setRecordCompany(String recordCompany) {
        this.recordCompany = recordCompany;
    }

    public String getRecordPostcode() {
        return this.recordPostcode;
    }

    public void setRecordPostcode(String recordPostcode) {
        this.recordPostcode = recordPostcode;
    }

    public String getRecordAddr() {
        return this.recordAddr;
    }

    public void setRecordAddr(String recordAddr) {
        this.recordAddr = recordAddr;
    }

    public String getPermanentAddr() {
        return this.permanentAddr;
    }

    public void setPermanentAddr(String permanentAddr) {
        this.permanentAddr = permanentAddr;
    }

    public String getImplementCompCode() {
        return this.implementCompCode;
    }

    public void setImplementCompCode(String implementCompCode) {
        this.implementCompCode = implementCompCode;
    }

    public String getImplementCompAddr() {
        return this.implementCompAddr;
    }

    public void setImplementCompAddr(String implementCompAddr) {
        this.implementCompAddr = implementCompAddr;
    }

    public String getImplementComp() {
        return this.implementComp;
    }

    public void setImplementComp(String implementComp) {
        this.implementComp = implementComp;
    }

    public String getDispatchRegisterCode() {
        return this.dispatchRegisterCode;
    }

    public void setDispatchRegisterCode(String dispatchRegisterCode) {
        this.dispatchRegisterCode = dispatchRegisterCode;
    }

    public String getRecordReceiverCellphone() {
        return this.recordReceiverCellphone;
    }

    public void setRecordReceiverCellphone(String recordReceiverCellphone) {
        this.recordReceiverCellphone = recordReceiverCellphone;
    }

    public String getRecordReceiver() {
        return this.recordReceiver;
    }

    public void setRecordReceiver(String recordReceiver) {
        this.recordReceiver = recordReceiver;
    }

    public String getRecordReceiverPhone() {
        return this.recordReceiverPhone;
    }

    public void setRecordReceiverPhone(String recordReceiverPhone) {
        this.recordReceiverPhone = recordReceiverPhone;
    }

    public String getSpecialEmploy() {
        return this.specialEmploy;
    }

    public void setSpecialEmploy(String specialEmploy) {
        this.specialEmploy = specialEmploy;
    }

    public String toString(){
        StringBuilder strBuf = new StringBuilder("RecordDTO{\n");
        strBuf.append("id:").append(this.id).append(",\n");
        strBuf.append("account:").append(this.account).append(",\n");
        strBuf.append("registerType:").append(this.registerType).append(",\n");
        strBuf.append("registerCode:").append(this.registerCode).append(",\n");
        strBuf.append("employForm:").append(this.employForm).append(",\n");
        strBuf.append("employFormCode:").append(this.employFormCode).append(",\n");
        strBuf.append("destination:").append(this.destination).append(",\n");
        strBuf.append("destinationCode:").append(this.destinationCode).append(",\n");
        strBuf.append("employRange:").append(this.employRange).append(",\n");
        strBuf.append("employRangeCode:").append(this.employRangeCode).append(",\n");
        strBuf.append("dispatchTime:").append(this.dispatchTime).append(",\n");
        strBuf.append("registDeadline:").append(this.registDeadline).append(",\n");
        strBuf.append("recordCompany:").append(this.recordCompany).append(",\n");
        strBuf.append("recordPostcode:").append(this.recordPostcode).append(",\n");
        strBuf.append("recordAddr:").append(this.recordAddr).append(",\n");
        strBuf.append("permanentAddr:").append(this.permanentAddr).append(",\n");
        strBuf.append("implementCompCode:").append(this.implementCompCode).append(",\n");
        strBuf.append("implementCompAddr:").append(this.implementCompAddr).append(",\n");
        strBuf.append("implementComp:").append(this.implementComp).append(",\n");
        strBuf.append("dispatchRegisterCode:").append(this.dispatchRegisterCode).append(",\n");
        strBuf.append("recordReceiverCellphone:").append(this.recordReceiverCellphone).append(",\n");
        strBuf.append("recordReceiver:").append(this.recordReceiver).append(",\n");
        strBuf.append("recordReceiverPhone:").append(this.recordReceiverPhone).append(",\n");
        strBuf.append("specialEmploy:").append(this.specialEmploy).append(",\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
