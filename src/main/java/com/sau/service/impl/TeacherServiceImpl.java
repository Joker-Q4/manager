package com.sau.service.impl;

import com.sau.entity.Teacher;
import com.sau.mapper.TeacherMapper;
import com.sau.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

    @Resource
    TeacherMapper teacherMapper;

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherMapper.findAllTeacher();
    }

    @Override
    public Teacher getTeacherById(Integer id) {
        return teacherMapper.findTeacherById(id);
    }
}
