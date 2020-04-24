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

    @Override
    public boolean deleteTeacher(Integer id) {
        return teacherMapper.deleteTeacherById(id) > 0;
    }

    @Override
    public boolean deleteTeachers(Integer[] ids) {
        boolean flag = true;
        for (Integer id : ids) {
            flag = flag && teacherMapper.deleteTeacherById(id) > 0;
        }
        return flag;
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher) > 0;
    }

    @Override
    public boolean addTeacher(Teacher teacher) {
        return teacherMapper.insertTeacher(teacher) > 0;
    }
}
