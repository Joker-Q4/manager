package com.sau.entity;

import com.sau.entity.vo.StudentVO;

public class Student {

    private Integer id;
    private String sn;
    private String name;
    private String sex;
    private String phoneNumber;
    private String address;

    private String base;
    private StudentVO studentVO;
    //各科成绩
    private String grade;
    //获奖情况
    private String prize;
    //企业实践活动
    private String businessPractice;
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

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
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


    public StudentVO getStudentVO() {
        return studentVO;
    }

    public void setStudentVO(StudentVO studentVO) {
        this.studentVO = studentVO;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
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

    public String getBusinessPractice() {
        return businessPractice;
    }

    public void setBusinessPractice(String businessPractice) {
        this.businessPractice = businessPractice;
    }

    public String getPatentAuthorization() {
        return patentAuthorization;
    }

    public void setPatentAuthorization(String patentAuthorization) {
        this.patentAuthorization = patentAuthorization;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getString(){
        return id + " " +
                sn + " " +
                name + " " +
                sex + " " +
                phoneNumber + " " +
                address + " " +
                grade + " " +
                prize + " " +
                thesis + " " +
                projectAchievement + " " +
                scienceTechnologyAchievementAward + " " +
                businessPractice + " " +
                patentAuthorization;
    }
}
