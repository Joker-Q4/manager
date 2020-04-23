package com.sau.service.impl;

import com.sau.entity.Grade;
import com.sau.mapper.GradeMapper;
import com.sau.service.GradeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("gradeService")
public class GradeServiceImpl implements GradeService {

    @Resource
    GradeMapper gradeMapper;

    @Override
    public List<Grade> getGradeByStudentId(Integer studentId) {
        return gradeMapper.findGradeByStudentId(studentId);
    }

    @Override
    public boolean updateGrade(Grade grade) {
        return gradeMapper.updateGrade(grade) > 0;
    }

    @Override
    public boolean addGrade(Grade grade) {
        return gradeMapper.insertGrade(grade) > 0;
    }
}
