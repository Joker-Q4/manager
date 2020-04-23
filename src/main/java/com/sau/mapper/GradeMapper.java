package com.sau.mapper;

import com.sau.entity.Grade;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GradeMapper {

    List<Grade> findGradeByStudentId(Integer studentId);
    int updateGrade(Grade grade);
    int insertGrade(Grade grade);
}
