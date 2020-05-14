package com.sau.entity;

import java.sql.Timestamp;

/**
 * 学生获奖情况
 */
public class Prize {

    private Integer id;
    private String name;
    private String description;
    private Timestamp createTime;
    private Integer studentId;
    private Student student;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Prize{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", studentId=" + studentId +
                ", student=" + student +
                '}';
    }

    public String getString(){
        return id + " " +
                name + " " +
                description + " " +
                createTime + " " +
                studentId + " " +
                student;
    }
}
