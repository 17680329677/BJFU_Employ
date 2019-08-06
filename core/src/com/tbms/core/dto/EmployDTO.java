package com.tbms.core.dto;

/**
 * Explain:     就业信息
 * Date:        2019-02-08 10:14:37
 * Coder:       青枫
 * Version:     1.0
 */
public class EmployDTO {

    /**ID*/
    private int id;
    /**学号*/
    private String account;
    /**工作职位类别*/
    private String job;
    /**工作职位类别代码*/
    private int jobCode;
    /**单位名称*/
    private String company;
    /**单位组织机构代码*/
    private String companyCode;
    /**单位隶属部门*/
    private String organization;
    /**单位隶属部门代码*/
    private String organizationCode;
    /**单位行业*/
    private String industry;
    /**单位行业代码*/
    private int industryCode;
    /**单位性质*/
    private String property;
    /**单位性质代码*/
    private String propertyCode;
    /**单位所在地*/
    private String companyAddr;
    /**单位所在地代码*/
    private String companyAddrCode;
    /**单位联系人*/
    private String comContacts;
    /**单位联系电话*/
    private String comPhone;
    /**单位电子信箱*/
    private String comEmail;
    /**单位地址*/
    private String comAddress;
    /**单位邮政编码*/
    private String comPostcode;
    /**单位传真*/
    private String comFax;
    /**基层证书发放范围*/
    private String certificate;
    /**基层证书发放范围代码*/
    private int certificateCode;
    /**特殊职位*/
    private String specialJob;
    /**特殊职位代码*/
    private int specialJobCode;
    /**落实工作渠道*/
    private String channels;
    /**落实工作渠道代码*/
    private int channelsCode;
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

    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getJobCode() {
        return this.jobCode;
    }

    public void setJobCode(int jobCode) {
        this.jobCode = jobCode;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyCode() {
        return this.companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getOrganization() {
        return this.organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getOrganizationCode() {
        return this.organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getIndustry() {
        return this.industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public int getIndustryCode() {
        return this.industryCode;
    }

    public void setIndustryCode(int industryCode) {
        this.industryCode = industryCode;
    }

    public String getProperty() {
        return this.property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getPropertyCode() {
        return this.propertyCode;
    }

    public void setPropertyCode(String propertyCode) {
        this.propertyCode = propertyCode;
    }

    public String getCompanyAddr() {
        return this.companyAddr;
    }

    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr;
    }

    public String getCompanyAddrCode() {
        return this.companyAddrCode;
    }

    public void setCompanyAddrCode(String companyAddrCode) {
        this.companyAddrCode = companyAddrCode;
    }

    public String getComContacts() {
        return this.comContacts;
    }

    public void setComContacts(String comContacts) {
        this.comContacts = comContacts;
    }

    public String getComPhone() {
        return this.comPhone;
    }

    public void setComPhone(String comPhone) {
        this.comPhone = comPhone;
    }

    public String getComEmail() {
        return this.comEmail;
    }

    public void setComEmail(String comEmail) {
        this.comEmail = comEmail;
    }

    public String getComAddress() {
        return this.comAddress;
    }

    public void setComAddress(String comAddress) {
        this.comAddress = comAddress;
    }

    public String getComPostcode() {
        return this.comPostcode;
    }

    public void setComPostcode(String comPostcode) {
        this.comPostcode = comPostcode;
    }

    public String getComFax() {
        return this.comFax;
    }

    public void setComFax(String comFax) {
        this.comFax = comFax;
    }

    public String getCertificate() {
        return this.certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public int getCertificateCode() {
        return this.certificateCode;
    }

    public void setCertificateCode(int certificateCode) {
        this.certificateCode = certificateCode;
    }

    public String getSpecialJob() {
        return this.specialJob;
    }

    public void setSpecialJob(String specialJob) {
        this.specialJob = specialJob;
    }

    public int getSpecialJobCode() {
        return this.specialJobCode;
    }

    public void setSpecialJobCode(int specialJobCode) {
        this.specialJobCode = specialJobCode;
    }

    public String getChannels() {
        return this.channels;
    }

    public void setChannels(String channels) {
        this.channels = channels;
    }

    public int getChannelsCode() {
        return this.channelsCode;
    }

    public void setChannelsCode(int channelsCode) {
        this.channelsCode = channelsCode;
    }

    public String toString(){
        StringBuilder strBuf = new StringBuilder("EmployDTO{\n");
        strBuf.append("id:").append(this.id).append(",\n");
        strBuf.append("account:").append(this.account).append(",\n");
        strBuf.append("job:").append(this.job).append(",\n");
        strBuf.append("jobCode:").append(this.jobCode).append(",\n");
        strBuf.append("company:").append(this.company).append(",\n");
        strBuf.append("companyCode:").append(this.companyCode).append(",\n");
        strBuf.append("organization:").append(this.organization).append(",\n");
        strBuf.append("organizationCode:").append(this.organizationCode).append(",\n");
        strBuf.append("industry:").append(this.industry).append(",\n");
        strBuf.append("industryCode:").append(this.industryCode).append(",\n");
        strBuf.append("property:").append(this.property).append(",\n");
        strBuf.append("propertyCode:").append(this.propertyCode).append(",\n");
        strBuf.append("companyAddr:").append(this.companyAddr).append(",\n");
        strBuf.append("companyAddrCode:").append(this.companyAddrCode).append(",\n");
        strBuf.append("comContacts:").append(this.comContacts).append(",\n");
        strBuf.append("comPhone:").append(this.comPhone).append(",\n");
        strBuf.append("comEmail:").append(this.comEmail).append(",\n");
        strBuf.append("comAddress:").append(this.comAddress).append(",\n");
        strBuf.append("comPostcode:").append(this.comPostcode).append(",\n");
        strBuf.append("comFax:").append(this.comFax).append(",\n");
        strBuf.append("certificate:").append(this.certificate).append(",\n");
        strBuf.append("certificateCode:").append(this.certificateCode).append(",\n");
        strBuf.append("specialJob:").append(this.specialJob).append(",\n");
        strBuf.append("specialJobCode:").append(this.specialJobCode).append(",\n");
        strBuf.append("channels:").append(this.channels).append(",\n");
        strBuf.append("channelsCode:").append(this.channelsCode).append(",\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
