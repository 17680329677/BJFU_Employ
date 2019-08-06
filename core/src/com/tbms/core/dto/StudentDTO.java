package com.tbms.core.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;

/**
 * Explain:     学生
 * Date:        2019-02-02 08:34:30
 * Coder:       青枫
 * Version:     1.0
 */
public class StudentDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**ID*/
    private int id;
    /**用户名*/
    @Excel(name = "学号")
    private String username;
    /**密码*/
    @Excel(name = "密码")
    private String password;
    /**姓名*/
    @Excel(name = "姓名")
    private String name;
    /**绑定微信*/
    private String bindAccount;
    /**最近登录时间*/
    private int lastLoginTime;
    /**最近登录IP*/
    private String lastLoginIp;
    /**登录次数*/
    private int loginCount;
    /**添加时间*/
    private int createTime;
    /**修改时间*/
    private int updateTime;
    /**出生日期*/
    @Excel(name = "出生日期")
    private String birthday;
    /**身份证号*/
    @Excel(name = "身份证号")
    private String card;
    /**手机电话*/
    @Excel(name = "手机电话")
    private String phone;
    /**邮箱*/
    @Excel(name = "邮箱")
    private String email;
    /**家庭电话*/
    @Excel(name = "家庭电话")
    private String homePhone;
    /**微信号*/
    private String wechat;
    /**性别*/
    @Excel(name = "性别")
    private String gender;
    /**性别代码*/
    @Excel(name = "性别代码")
    private int genderCode;
    /**民族*/
    @Excel(name = "民族")
    private String ethnicity;
    /**民族代码*/
    @Excel(name = "民族代码")
    private int ethnicityCode;
    /**考生号*/
    @Excel(name = "考生号")
    private String candidateNumber;
    /**毕业日期*/
    @Excel(name = "毕业日期")
    private String graduateDate;
    /**毕业年份*/
    @Excel(name = "毕业年份")
    private int graduateYear;
    /**生源所在地*/
    @Excel(name = "生源所在地")
    private String enrollmentAddr;
    /**生源省市代码*/
    @Excel(name = "生源省市代码")
    private String enrollmentCode;
    /**政治面貌*/
    @Excel(name = "政治面貌")
    private String political;
    /**政治面貌代码*/
    @Excel(name = "政治面貌代码")
    private int politicalCode;
    /**院校名称*/
    @Excel(name = "院校名称")
    private String school;
    /**院校代码*/
    @Excel(name = "院校代码")
    private String schoolCode;
    /**二级学院名称*/
    @Excel(name = "二级学院名称")
    private String depart;
    /**二级学院代码*/
    @Excel(name = "二级学院代码")
    private String departCode;
    /**专业*/
    @Excel(name = "专业")
    private String major;
    /**专业代码*/
    @Excel(name = "专业代码")
    private String majorCode;
    /**班级名称*/
    private String classes;
    /**班级代码*/
    private String classesCode;
    /**学制*/
    @Excel(name = "学制")
    private String type;
    /**学制代码*/
    @Excel(name = "学制代码")
    private int typeCode;
    /**学位层次*/
    @Excel(name = "层次")
    private String degree;
    /**学位层次代码*/
    @Excel(name = "层次代码")
    private int degreeCode;
    /**学历*/
    @Excel(name = "学历")
    private String education;
    /**学历代码*/
    @Excel(name = "学历代码")
    private int educationCode;
    /**毕结业结论*/
    @Excel(name = "毕结业结论")
    private String graduation;
    /**入学时间*/
    @Excel(name = "入学时间")
    private String enrollment;
    /**师范生类别*/
    @Excel(name = "师范生类别")
    private String normal;
    /**师范生类别代码*/
    @Excel(name = "师范生类别代码")
    private int normalCode;
    /**有意向未就业原因*/
    private String unemployed;
    /**有意向未就业原因代码*/
    private int unemployedCode;
    /**培养方式*/
    @Excel(name = "培养方式")
    private String training;
    /**培养方式代码*/
    @Excel(name = "培养方式代码")
    private int trainingCode;
    /**培养单位*/
    @Excel(name = "培养单位")
    private String trainingUnit;
    /**当前所在级(在校生)*/
    @Excel(name = "年级")
    private int grade;
    /**是否毕业*/
    @Excel(name = "是否毕业")
    private int graduate;
    /**是否春季毕业生*/
    private String springGraduate;
    /**综合测评*/
    private String synEvaluation;
    /**班级排名*/
    private String rank;
    /**困难生类别*/
    private String difficulty;
    /**是否担任过助管*/
    private String assistant;
    /**就业状态*/
    private String employ;
    /**就业状态代码*/
    private int employCode;
    /**就业状态修改时间*/
    private int employTime;
    /**就业项目*/
    private String employProgram;
    /**签约时间*/
    private String contract;
    /**是否担任过学业辅导员*/
    private String instructor;
    /**涉林行业*/
    private String forest;
    /**是否担任过学生干部*/
    private String cadre;
    /**导师姓名*/
    @Excel(name = "导师姓名")
    private String mentor;
    /**导师职称*/
    @Excel(name = "导师职称")
    private String mentorTitle;
    /**本科院校类别*/
    @Excel(name = "本科院校类别")
    private String undergraduateCat;
    /**本科院校*/
    @Excel(name = "本科院校")
    private String undergraduate;
    /**学籍变动*/
    private String changes;
    /**学籍变动代码*/
    private int changesCode;
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

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBindAccount() {
        return this.bindAccount;
    }

    public void setBindAccount(String bindAccount) {
        this.bindAccount = bindAccount;
    }

    public int getLastLoginTime() {
        return this.lastLoginTime;
    }

    public void setLastLoginTime(int lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return this.lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public int getLoginCount() {
        return this.loginCount;
    }

    public void setLoginCount(int loginCount) {
        this.loginCount = loginCount;
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

    public String getHomePhone() {
        return this.homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getWechat() {
        return this.wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
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

    public String getEnrollmentCode() {
        return this.enrollmentCode;
    }

    public void setEnrollmentCode(String enrollmentCode) {
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

    /**
     * 密码盐
     */
    public String getCredentialsSalt(){
        return this.username;
    }

    public String toString(){
        StringBuilder strBuf = new StringBuilder("StudentDTO{\n");
        strBuf.append("id:").append(this.id).append(",\n");
        strBuf.append("username:").append(this.username).append(",\n");
        strBuf.append("password:").append(this.password).append(",\n");
        strBuf.append("name:").append(this.name).append(",\n");
        strBuf.append("bindAccount:").append(this.bindAccount).append(",\n");
        strBuf.append("lastLoginTime:").append(this.lastLoginTime).append(",\n");
        strBuf.append("lastLoginIp:").append(this.lastLoginIp).append(",\n");
        strBuf.append("loginCount:").append(this.loginCount).append(",\n");
        strBuf.append("createTime:").append(this.createTime).append(",\n");
        strBuf.append("updateTime:").append(this.updateTime).append(",\n");
        strBuf.append("birthday:").append(this.birthday).append(",\n");
        strBuf.append("card:").append(this.card).append(",\n");
        strBuf.append("phone:").append(this.phone).append(",\n");
        strBuf.append("email:").append(this.email).append(",\n");
        strBuf.append("homePhone:").append(this.homePhone).append(",\n");
        strBuf.append("wechat:").append(this.wechat).append(",\n");
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
        strBuf.append("remark:").append(this.remark).append(",\n");
        strBuf.append("status:").append(this.status).append("\n");
        strBuf.append("}");
        return strBuf.toString();
    }
}
