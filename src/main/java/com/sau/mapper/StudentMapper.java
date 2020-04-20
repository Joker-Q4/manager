package com.sau.mapper;

import com.sau.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    List<Student> findAllStudents();
    Student findStudentById(Integer studentId);
    Integer deleteStudentById(Integer studentId);
    Integer updateStudentById(Student student);
    Integer insertStudentById(Student student);
}
