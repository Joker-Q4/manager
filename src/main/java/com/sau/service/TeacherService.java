package com.sau.service;

import com.sau.entity.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getAllTeachers();
    Teacher getTeacherById(Integer id);
    boolean deleteTeacher(Integer id);
    boolean deleteTeachers(Integer[] ids);
    boolean updateTeacher(Teacher teacher);
    boolean addTeacher(Teacher teacher);
}
