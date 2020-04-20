package com.sau.service;

import com.sau.entity.Grade;

import java.util.List;

public interface GradeService {

    List<Grade> getGradeByStudentId(Integer studentId);
    boolean updateGrade(Grade grade);
}
