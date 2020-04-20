package com.sau.service;

import com.sau.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    Student getStudentById(Integer id);
    boolean deleteStudent(Integer id);
    boolean deleteStudents(Integer[] ids);
    boolean updateStudent(Student student);
    boolean addStudent(Student student);
}
