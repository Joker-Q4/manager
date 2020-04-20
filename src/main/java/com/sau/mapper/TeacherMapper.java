package com.sau.mapper;

import com.sau.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherMapper {

    List<Teacher> findAllTeacher();
    Teacher findTeacherById(Integer teacherId);
}
