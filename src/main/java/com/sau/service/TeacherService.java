package com.sau.service;

import com.sau.entity.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getAllTeachers();
    Teacher getTeacherById(Integer id);
}
