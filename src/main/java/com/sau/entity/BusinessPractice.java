package com.sau.entity;

import java.sql.Timestamp;

/**
 * 学生的企业实践活动
 */
public class BusinessPractice {

    private Integer id;
    private String name;   //企业名称
    private String description;  //详细描述
    private Timestamp createTime;   //创建时间
    private Integer studentId;   //绑定学生

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

    @Override
    public String toString() {
        return "BusinessPractice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", studentId=" + studentId +
                '}';
    }
}
