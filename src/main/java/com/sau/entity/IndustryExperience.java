package com.sau.entity;

import java.sql.Timestamp;

/**
 * 教师行业实践经历
 */
public class IndustryExperience {

    private Integer id;
    private String title;           //标题
    private String description;     //实践描述
    private Timestamp time;         //实践时间
    private String location;        //实践地点
    private Integer teacherId;      //实践教师
    private Teacher teacher;

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

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    @Override
    public String toString() {
        return "IndustryExperience{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", time=" + time +
                ", location='" + location + '\'' +
                ", teacherId=" + teacherId +
                ", teacher=" + teacher +
                '}';
    }
}
