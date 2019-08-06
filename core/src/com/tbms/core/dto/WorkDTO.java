package com.tbms.core.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * Explain:     学生全部信息
 * Date:        2019-03-09 11:37:05
 * Coder:       青枫
 * Version:     1.0
 */
public class WorkDTO {

    /**ID*/
    private int id;
    /**用户名*/
    @Excel(name = "学号",width=20)
    private String username;
    /**姓名*/
    @Excel(name = "姓名",width=20)
    private String name;
    /**出生日期*/
    @Excel(name = "出生日期",width=20)
    private String birthday;
    /**身份证号*/
    @Excel(name = "身份证号",width=20)
    private String card;
    /**手机电话*/
    @Excel(name = "手机电话",width=10)
    private String phone;
    /**邮箱*/
    @Excel(name = "邮箱",width=20)
    private String email;
    /**性别*/
    @Excel(name = "性别",width=5)
    private String gender;
    /**性别代码*/
    @Excel(name = "性别代码",width=5)
    private int genderCode;
    /**民族*/
    @Excel(name = "民族",width=10)
    private String ethnicity;
    /**民族代码*/
    @Excel(name = "民族代码",width=5)
    private int ethnicityCode;
    /**考生号*/
    @Excel(name = "考生号",width=20)
    private String candidateNumber;
    /**毕业日期*/
    @Excel(name = "毕业日期",width=15)
    private String graduateDate;
    /**毕业年份*/
    @Excel(name = "毕业年份",width=10)
    private int graduateYear;
    /**生源所在地*/
    @Excel(name = "生源所在地",width=20)
    private String enrollmentAddr;
    /**生源省市代码*/
    @Excel(name = "生源省市代码",width=10)
    private int enrollmentCode;
    /**政治面貌*/
    @Excel(name = "政治面貌",width=15)
    private String political;
    /**政治面貌代码*/
    @Excel(name = "政治面貌代码",width=5)
    private int politicalCode;
    /**院校名称*/
    @Excel(name = "院校名称",width=15)
    private String school;
    /**院校代码*/
    @Excel(name = "院校代码",width=10)
    private String schoolCode;
    /**二级学院名称*/
    @Excel(name = "二级学院名称",width=15)
    private String depart;
    /**二级学院代码*/
    @Excel(name = "二级学院代码",width=15)
    private String departCode;
    /**专业*/
    @Excel(name = "专业",width=15)
    private String major;
    /**专业代码*/
    @Excel(name = "专业代码",width=15)
    private String majorCode;
    /**班级名称*/
    @Excel(name = "班级名称",width=5)
    private String classes;
    /**班级代码*/
    @Excel(name = "班级代码",width=5)
    private String classesCode;
    /**学制*/
    @Excel(name = "学制",width=5)
    private String type;
    /**学制代码*/
    @Excel(name = "学制代码",width=5)
    private int typeCode;
    /**学位层次*/
    @Excel(name = "学位层次",width=10)
    private String degree;
    /**学位层次代码*/
    @Excel(name = "学位层次代码",width=5)
    private int degreeCode;
    /**学历*/
    @Excel(name = "学历",width=15)
    private String education;
    /**学历代码*/
    @Excel(name = "学历代码",width=5)
    private int educationCode;
    /**毕结业结论*/
    @Excel(name = "毕结业结论",width=5)
    private String graduation;
    /**入学时间*/
    @Excel(name = "入学时间",width=15)
    private String enrollment;
    /**师范生类别*/
    @Excel(name = "师范生类别",width=15)
    private String normal;
    /**师范生类别代码*/
    @Excel(name = "师范生类别代码",width=5)
    private int normalCode;
    /**有意向未就业原因*/
    @Excel(name = "有意向未就业原因",width=10)
    private String unemployed;
    /**有意向未就业原因代码*/
    @Excel(name = "有意向未就业原因代码",width=5)
    private int unemployedCode;
    /**培养方式*/
    @Excel(name = "培养方式",width=10)
    private String training;
    /**培养方式代码*/
    @Excel(name = "培养方式代码",width=5)
    private int trainingCode;
    /**培养单位*/
    @Excel(name = "培养单位",width=20)
    private String trainingUnit;
    /**当前所在级(在校生)*/
    @Excel(name = "当前所在级(在校生)",width=10)
    private int grade;
    /**是否毕业*/
    @Excel(name = "是否毕业",width=5)
    private int graduate;
    /**是否春季毕业生*/
    @Excel(name = "是否春季毕业生",width=5)
    private String springGraduate;
    /**综合测评*/
    @Excel(name = "综合测评",width=5)
    private String synEvaluation;
    /**班级排名*/
    @Excel(name = "班级排名",width=5)
    private String rank;
    /**困难生类别*/
    @Excel(name = "困难生类别",width=10)
    private String difficulty;
    /**是否担任过助管*/
    @Excel(name = "是否担任过助管",width=5)
    private String assistant;
    /**就业状态*/
    @Excel(name = "就业状态",width=15)
    private String employ;
    /**就业状态代码*/
    @Excel(name = "就业状态代码",width=5)
    private int employCode;
    /**就业状态修改时间*/
    private int employTime;
    /**就业项目*/
    @Excel(name = "就业项目",width=5)
    private String employProgram;
    /**签约时间*/
    @Excel(name = "签约时间",width=5)
    private String contract;
    /**是否担任过学业辅导员*/
    @Excel(name = "是否担任过学业辅导员",width=5)
    private String instructor;
    /**涉林行业*/
    @Excel(name = "涉林行业",width=5)
    private String forest;
    /**是否担任过学生干部*/
    @Excel(name = "是否担任过学生干部",width=5)
    private String cadre;
    /**导师姓名*/
    @Excel(name = "导师姓名",width=15)
    private String mentor;
    /**导师职称*/
    @Excel(name = "导师职称",width=15)
    private String mentorTitle;
    /**本科院校类别*/
    @Excel(name = "本科院校类别",width=15)
    private String undergraduateCat;
    /**本科院校*/
    @Excel(name = "本科院校",width=20)
    private String undergraduate;
    /**学籍变动*/
    @Excel(name = "学籍变动",width=5)
    private String changes;
    /**学籍变动代码*/
    @Excel(name = "学籍变动代码",width=5)
    private int changesCode;
    /**工作职位类别*/
    @Excel(name = "工作职位类别",width=20)
    private String job;
    /**工作职位类别代码*/
    @Excel(name = "工作职位类别代码",width=10)
    private int jobCode;
    /**单位名称*/
    @Excel(name = "单位名称",width=20)
    private String company;
    /**单位组织机构代码*/
    @Excel(name = "单位组织机构代码",width=20)
    private String companyCode;
    /**单位隶属部门*/
    @Excel(name = "单位隶属部门",width=20)
    private String organization;
    /**单位隶属部门代码*/
    @Excel(name = "单位隶属部门代码",width=10)
    private String organizationCode;
    /**单位行业*/
    @Excel(name = "单位行业",width=20)
    private String industry;
    /**单位行业代码*/
    @Excel(name = "单位行业代码",width=10)
    private int industryCode;
    /**单位性质*/
    @Excel(name = "单位性质",width=20)
    private String property;
    /**单位性质代码*/
    @Excel(name = "单位性质代码",width=10)
    private String propertyCode;
    /**单位所在地*/
    @Excel(name = "单位所在地",width=20)
    private String companyAddr;
    /**单位所在地代码*/
    @Excel(name = "单位所在地代码",width=10)
    private String companyAddrCode;
    /**单位联系人*/
    @Excel(name = "单位联系人",width=15)
    private String comContacts;
    /**单位联系电话*/
    @Excel(name = "单位联系电话",width=15)
    private String comPhone;
    /**单位电子信箱*/
    @Excel(name = "单位电子信箱",width=20)
    private String comEmail;
    /**单位地址*/
    @Excel(name = "单位地址",width=20)
    private String comAddress;
    /**单位邮政编码*/
    @Excel(name = "单位邮政编码",width=15)
    private String comPostcode;
    /**单位传真*/
    @Excel(name = "单位传真",width=10)
    private String comFax;
    /**基层证书发放范围*/
    @Excel(name = "基层证书发放范围",width=10)
    private String certificate;
    /**基层证书发放范围代码*/
    @Excel(name = "基层证书发放范围代码",width=10)
    private int certificateCode;
    /**特殊职位*/
    @Excel(name = "特殊职位",width=10)
    private String specialJob;
    /**特殊职位代码*/
    @Excel(name = "特殊职位代码",width=10)
    private int specialJobCode;
    /**落实工作渠道*/
    @Excel(name = "落实工作渠道",width=10)
    private String channels;
    /**落实工作渠道代码*/
    @Excel(name = "落实工作渠道代码",width=10)
    private int channelsCode;
    /**报到证签发类别*/
    @Excel(name = "报到证签发类别",width=15)
    private String registerType;
    /**报到证签发类别代码*/
    @Excel(name = "报到证签发类别代码",width=10)
    private int registerCode;
    /**就业形式*/
    @Excel(name = "就业形式",width=15)
    private String employForm;
    /**就业形式代码*/
    @Excel(name = "就业形式代码",width=10)
    private int employFormCode;
    /**毕业去向*/
    @Excel(name = "毕业去向",width=20)
    private String destination;
    /**毕业去向代码*/
    @Excel(name = "毕业去向代码",width=10)
    private int destinationCode;
    /**就业范围*/
    @Excel(name = "就业范围",width=10)
    private String employRange;
    /**就业范围代码*/
    @Excel(name = "就业范围代码",width=10)
    private int employRangeCode;
    /**派遣时间*/
    @Excel(name = "派遣时间",width=10)
    private String dispatchTime;
    /**报到期限*/
    @Excel(name = "报到期限",width=10)
    private String registDeadline;
    /**档案转寄单位*/
    @Excel(name = "档案转寄单位",width=20)
    private String recordCompany;
    /**档案转寄邮政编码*/
    @Excel(name = "档案转寄邮政编码",width=15)
    private String recordPostcode;
    /**档案转寄地址*/
    @Excel(name = "档案转寄地址",width=20)
    private String recordAddr;
    /**户口迁移地址*/
    @Excel(name = "户口迁移地址",width=20)
    private String permanentAddr;
    /**具体落实单位所在地代码*/
    @Excel(name = "具体落实单位所在地代码",width=20)
    private String implementCompCode;
    /**具体落实单位所在地*/
    @Excel(name = "具体落实单位所在地",width=20)
    private String implementCompAddr;
    /**具体落实单位名称*/
    @Excel(name = "具体落实单位名称",width=20)
    private String implementComp;
    /**派遣报到证号*/
    @Excel(name = "派遣报到证号",width=20)
    private String dispatchRegisterCode;
    /**档案收件人手机*/
    @Excel(name = "档案收件人手机",width=20)
    private String recordReceiverCellphone;
    /**档案收件人*/
    @Excel(name = "档案收件人",width=20)
    private String recordReceiver;
    /**档案收件人电话*/
    @Excel(name = "档案收件人电话",width=20)
    private String recordReceiverPhone;
    /**特殊就业类别*/
    @Excel(name = "特殊就业类别",width=20)
    private String specialEmploy;
    /**添加时间*/
    private int createTime;
    /**修改时间*/
    private int updateTime;
    /**备注*/
    private String remark;
    /**状态*/
    private int status;
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCard() {
        return this.card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getGenderCode() {
        return this.genderCode;
    }

    public void setGenderCode(int genderCode) {
        this.genderCode = genderCode;
    }

    public String getEthnicity() {
        return this.ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public int getEthnicityCode() {
        return this.ethnicityCode;
    }

    public void setEthnicityCode(int ethnicityCode) {
        this.ethnicityCode = ethnicityCode;
    }

    public String getCandidateNumber() {
        return this.candidateNumber;
    }

    public void setCandidateNumber(String candidateNumber) {
        this.candidateNumber = candidateNumber;
    }

    public String getGraduateDate() {
        return this.graduateDate;
    }

    public void setGraduateDate(String graduateDate) {
        this.graduateDate = graduateDate;
    }

    public int getGraduateYear() {
        return this.graduateYear;
    }

    public void setGraduateYear(int graduateYear) {
        this.graduateYear = graduateYear;
    }

    public String getEnrollmentAddr() {
        return this.enrollmentAddr;
    }

    public void setEnrollmentAddr(String enrollmentAddr) {
        this.enrollmentAddr = enrollmentAddr;
    }

    public int getEnrollmentCode() {
        return this.enrollmentCode;
    }

    public void setEnrollmentCode(int enrollmentCode) {
        this.enrollmentCode = enrollmentCode;
    }

    public String getPolitical() {
        return this.political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public int getPoliticalCode() {
        return this.politicalCode;
    }

    public void setPoliticalCode(int politicalCode) {
        this.politicalCode = politicalCode;
    }

    public String getSchool() {
        return this.school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSchoolCode() {
        return this.schoolCode;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
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

    public String getClasses() {
        return this.classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getClassesCode() {
        return this.classesCode;
    }

    public void setClassesCode(String classesCode) {
        this.classesCode = classesCode;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTypeCode() {
        return this.typeCode;
    }

    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }

    public String getDegree() {
        return this.degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getDegreeCode() {
        return this.degreeCode;
    }

    public void setDegreeCode(int degreeCode) {
        this.degreeCode = degreeCode;
    }

    public String getEducation() {
        return this.education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public int getEducationCode() {
        return this.educationCode;
    }

    public void setEducationCode(int educationCode) {
        this.educationCode = educationCode;
    }

    public String getGraduation() {
        return this.graduation;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation;
    }

    public String getEnrollment() {
        return this.enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public String getNormal() {
        return this.normal;
    }

    public void setNormal(String normal) {
        this.normal = normal;
    }

    public int getNormalCode() {
        return this.normalCode;
    }

    public void setNormalCode(int normalCode) {
        this.normalCode = normalCode;
    }

    public String getUnemployed() {
        return this.unemployed;
    }

    public void setUnemployed(String unemployed) {
        this.unemployed = unemployed;
    }

    public int getUnemployedCode() {
        return this.unemployedCode;
    }

    public void setUnemployedCode(int unemployedCode) {
        this.unemployedCode = unemployedCode;
    }

    public String getTraining() {
        return this.training;
    }

    public void setTraining(String training) {
        this.training = training;
    }

    public int getTrainingCode() {
        return this.trainingCode;
    }

    public void setTrainingCode(int trainingCode) {
        this.trainingCode = trainingCode;
    }

    public String getTrainingUnit() {
        return this.trainingUnit;
    }

    public void setTrainingUnit(String trainingUnit) {
        this.trainingUnit = trainingUnit;
    }

    public int getGrade() {
        return this.grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGraduate() {
        return this.graduate;
    }

    public void setGraduate(int graduate) {
        this.graduate = graduate;
    }

    public String getSpringGraduate() {
        return this.springGraduate;
    }

    public void setSpringGraduate(String springGraduate) {
        this.springGraduate = springGraduate;
    }

    public String getSynEvaluation() {
        return this.synEvaluation;
    }

    public void setSynEvaluation(String synEvaluation) {
        this.synEvaluation = synEvaluation;
    }

    public String getRank() {
        return this.rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDifficulty() {
        return this.difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getAssistant() {
        return this.assistant;
    }

    public void setAssistant(String assistant) {
        this.assistant = assistant;
    }

    public String getEmploy() {
        return this.employ;
    }

    public void setEmploy(String employ) {
        this.employ = employ;
    }

    public int getEmployCode() {
        return this.employCode;
    }

    public void setEmployCode(int employCode) {
        this.employCode = employCode;
    }

    public int getEmployTime() {
        return this.employTime;
    }

    public void setEmployTime(int employTime) {
        this.employTime = employTime;
    }

    public String getEmployProgram() {
        return this.employProgram;
    }

    public void setEmployProgram(String employProgram) {
        this.employProgram = employProgram;
    }

    public String getContract() {
        return this.contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getInstructor() {
        return this.instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getForest() {
        return this.forest;
    }

    public void setForest(String forest) {
        this.forest = forest;
    }

    public String getCadre() {
        return this.cadre;
    }

    public void setCadre(String cadre) {
        this.cadre = cadre;
    }

    public String getMentor() {
        return this.mentor;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }

    public String getMentorTitle() {
        return this.mentorTitle;
    }

    public void setMentorTitle(String mentorTitle) {
        this.mentorTitle = mentorTitle;
    }

    public String getUndergraduateCat() {
        return this.undergraduateCat;
    }

    public void setUndergraduateCat(String undergraduateCat) {
        this.undergraduateCat = undergraduateCat;
    }

    public String getUndergraduate() {
        return this.undergraduate;
    }

    public void setUndergraduate(String undergraduate) {
        this.undergraduate = undergraduate;
    }

    public String getChanges() {
        return this.changes;
    }

    public void setChanges(String changes) {
        this.changes = changes;
    }

    public int getChangesCode() {
        return this.changesCode;
    }

    public void setChangesCode(int changesCode) {
        this.changesCode = changesCode;
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
        return remark;
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

    public String toString(){
        StringBuilder strBuf = new StringBuilder("WorkDTO{\n");
        strBuf.append("id:").append(this.id).append(",\n");
        strBuf.append("username:").append(this.username).append(",\n");
        strBuf.append("name:").append(this.name).append(",\n");
        strBuf.append("birthday:").append(this.birthday).append(",\n");
        strBuf.append("card:").append(this.card).append(",\n");
        strBuf.append("phone:").append(this.phone).append(",\n");
        strBuf.append("email:").append(this.email).append(",\n");
        strBuf.append("gender:").append(this.gender).append(",\n");
        strBuf.append("genderCode:").append(this.genderCode).append(",\n");
        strBuf.append("ethnicity:").append(this.ethnicity).append(",\n");
        strBuf.append("ethnicityCode:").append(this.ethnicityCode).append(",\n");
        strBuf.append("candidateNumber:").append(this.candidateNumber).append(",\n");
        strBuf.append("graduateDate:").append(this.graduateDate).append(",\n");
        strBuf.append("graduateYear:").append(this.graduateYear).append(",\n");
        strBuf.append("enrollmentAddr:").append(this.enrollmentAddr).append(",\n");
        strBuf.append("enrollmentCode:").append(this.enrollmentCode).append(",\n");
        strBuf.append("political:").append(this.political).append(",\n");
        strBuf.append("politicalCode:").append(this.politicalCode).append(",\n");
        strBuf.append("school:").append(this.school).append(",\n");
        strBuf.append("schoolCode:").append(this.schoolCode).append(",\n");
        strBuf.append("depart:").append(this.depart).append(",\n");
        strBuf.append("departCode:").append(this.departCode).append(",\n");
        strBuf.append("major:").append(this.major).append(",\n");
        strBuf.append("majorCode:").append(this.majorCode).append(",\n");
        strBuf.append("classes:").append(this.classes).append(",\n");
        strBuf.append("classesCode:").append(this.classesCode).append(",\n");
        strBuf.append("type:").append(this.type).append(",\n");
        strBuf.append("typeCode:").append(this.typeCode).append(",\n");
        strBuf.append("degree:").append(this.degree).append(",\n");
        strBuf.append("degreeCode:").append(this.degreeCode).append(",\n");
        strBuf.append("education:").append(this.education).append(",\n");
        strBuf.append("educationCode:").append(this.educationCode).append(",\n");
        strBuf.append("graduation:").append(this.graduation).append(",\n");
        strBuf.append("enrollment:").append(this.enrollment).append(",\n");
        strBuf.append("normal:").append(this.normal).append(",\n");
        strBuf.append("normalCode:").append(this.normalCode).append(",\n");
        strBuf.append("unemployed:").append(this.unemployed).append(",\n");
        strBuf.append("unemployedCode:").append(this.unemployedCode).append(",\n");
        strBuf.append("training:").append(this.training).append(",\n");
        strBuf.append("trainingCode:").append(this.trainingCode).append(",\n");
        strBuf.append("trainingUnit:").append(this.trainingUnit).append(",\n");
        strBuf.append("grade:").append(this.grade).append(",\n");
        strBuf.append("graduate:").append(this.graduate).append(",\n");
        strBuf.append("springGraduate:").append(this.springGraduate).append(",\n");
        strBuf.append("synEvaluation:").append(this.synEvaluation).append(",\n");
        strBuf.append("rank:").append(this.rank).append(",\n");
        strBuf.append("difficulty:").append(this.difficulty).append(",\n");
        strBuf.append("assistant:").append(this.assistant).append(",\n");
        strBuf.append("employ:").append(this.employ).append(",\n");
        strBuf.append("employCode:").append(this.employCode).append(",\n");
        strBuf.append("employTime:").append(this.employTime).append(",\n");
        strBuf.append("employProgram:").append(this.employProgram).append(",\n");
        strBuf.append("contract:").append(this.contract).append(",\n");
        strBuf.append("instructor:").append(this.instructor).append(",\n");
        strBuf.append("forest:").append(this.forest).append(",\n");
        strBuf.append("cadre:").append(this.cadre).append(",\n");
        strBuf.append("mentor:").append(this.mentor).append(",\n");
        strBuf.append("mentorTitle:").append(this.mentorTitle).append(",\n");
        strBuf.append("undergraduateCat:").append(this.undergraduateCat).append(",\n");
        strBuf.append("undergraduate:").append(this.undergraduate).append(",\n");
        strBuf.append("changes:").append(this.changes).append(",\n");
        strBuf.append("changesCode:").append(this.changesCode).append(",\n");
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
        strBuf.append("createTime:").append(this.createTime).append(",\n");
        strBuf.append("updateTime:").append(this.updateTime).append(",\n");
        strBuf.append("remark:").append(this.remark).append("\n");
        strBuf.append("status:").append(this.status).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
