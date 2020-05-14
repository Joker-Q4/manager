package com.sau.entity;

public class Teacher {

    private Integer id;               //主键
    private String name;              //姓名
    private String sex;               //性别
    private String phoneNumber;       //联系方式
    private String address;           //家庭住址
    private String academicDegree;    //学位
    private String title;             //高级职称

    //授课情况
    private String teachingSituation;
    //行业实践经历
    private String industryExperience;
    //论文情况
    private String thesis;
    //项目成果
    private String projectAchievement;
    //科技成果
    private String scienceTechnologyAchievementAward;
    //专利授权
    private String patentAuthorization;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTeachingSituation() {
        return teachingSituation;
    }

    public void setTeachingSituation(String teachingSituation) {
        this.teachingSituation = teachingSituation;
    }

    public String getIndustryExperience() {
        return industryExperience;
    }

    public void setIndustryExperience(String industryExperience) {
        this.industryExperience = industryExperience;
    }

    public String getThesis() {
        return thesis;
    }

    public void setThesis(String thesis) {
        this.thesis = thesis;
    }

    public String getProjectAchievement() {
        return projectAchievement;
    }

    public void setProjectAchievement(String projectAchievement) {
        this.projectAchievement = projectAchievement;
    }

    public String getScienceTechnologyAchievementAward() {
        return scienceTechnologyAchievementAward;
    }

    public void setScienceTechnologyAchievementAward(String scienceTechnologyAchievementAward) {
        this.scienceTechnologyAchievementAward = scienceTechnologyAchievementAward;
    }

    public String getPatentAuthorization() {
        return patentAuthorization;
    }

    public void setPatentAuthorization(String patentAuthorization) {
        this.patentAuthorization = patentAuthorization;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", academicDegree='" + academicDegree + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public String getString(){
        return id + " " +
                name + " " +
                sex + " " +
                phoneNumber + " " +
                address + " " +
                title + " " +
                academicDegree + " " +
                teachingSituation + " " +
                industryExperience + " " +
                thesis + " " +
                projectAchievement + " " +
                scienceTechnologyAchievementAward + " " +
                patentAuthorization;
    }
}
