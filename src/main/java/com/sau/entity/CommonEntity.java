package com.sau.entity;

import java.sql.Timestamp;

public class CommonEntity {

    private Integer id;
    private String name;
    private String title;
    private String description;
    private Integer fileId;
    private Integer studentId;
    private Student student;
    private Integer teacherId;
    private Teacher teacher;
    private Timestamp createTime;
    private String create;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
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

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getCreate() {
        return create;
    }

    public void setCreate(String create) {
        this.create = create;
    }

    @Override
    public String toString() {
        return "CommonEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", fileId=" + fileId +
                ", studentId=" + studentId +
                ", student=" + student +
                ", teacherId=" + teacherId +
                ", teacher=" + teacher +
                ", createTime=" + createTime +
                '}';
    }

    public String getString(){
        return id + " " +
                name + " " +
                description + " " +
                fileId + " " +
                studentId + " " +
                student + " " +
                teacherId + " " +
                teacher + " " +
                create;
    }
}
