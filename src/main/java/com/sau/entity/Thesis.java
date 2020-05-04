package com.sau.entity;

import java.sql.Timestamp;

/**
 * 学生发表论文
 */
public class Thesis {

    private Integer id;
    private String title;          //题目
    private String description;    //详细描述
    private Integer fileId;
    private FileBinding file;
    private Integer studentId;
    private Student student;
    private Integer teacherId;
    private Teacher teacher;
    private Timestamp createTime;  //创建时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public FileBinding getFile() {
        return file;
    }

    public void setFile(FileBinding file) {
        this.file = file;
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

    @Override
    public String toString() {
        return "Thesis{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", fileId=" + fileId +
                ", file=" + file +
                ", studentId=" + studentId +
                ", student=" + student +
                ", teacherId=" + teacherId +
                ", teacher=" + teacher +
                ", createTime=" + createTime +
                '}';
    }
}
