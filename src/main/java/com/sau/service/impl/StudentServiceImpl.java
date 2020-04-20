package com.sau.service.impl;

import com.sau.entity.Student;
import com.sau.mapper.StudentMapper;
import com.sau.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Resource
    StudentMapper studentMapper;

    @Override
    public List<Student> getAllStudents() {
        return studentMapper.findAllStudents();
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentMapper.findStudentById(id);
    }

    @Override
    public boolean deleteStudent(Integer id) {
        return studentMapper.deleteStudentById(id) > 0;
    }

    @Override
    public boolean deleteStudents(Integer[] ids) {
        boolean flag = true;
        for (Integer id : ids) {
            flag = flag && studentMapper.deleteStudentById(id) > 0;
        }
        return flag;
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentMapper.updateStudentById(student) > 0;
    }

    @Override
    public boolean addStudent(Student student) {
        return studentMapper.insertStudentById(student) > 0;
    }
}
