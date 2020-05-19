package com.sau.entity.vo;

public class TeacherVO {

    private Integer id;               //主键
    private String sn;                //教师编号
    private String name;              //姓名
    private String sex;               //性别
    private String phoneNumber;       //联系方式
    private String address;           //家庭住址
    private String academicDegree;    //学位
    private String title;             //高级职称

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

    public String getString(){
        return id + " " +
                sn + " " +
                name + " " +
                sex + " " +
                phoneNumber + " " +
                address + " " +
                title + " " +
                academicDegree;
    }
}
