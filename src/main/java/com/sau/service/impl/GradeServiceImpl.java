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
    public List<Double> getCombinedLanguage() {
        return gradeMapper.findCombinedLanguage();
    }

    @Override
    public List<Double> getCombinedLanguagePlus() {
        return gradeMapper.findCombinedLanguagePlus();
    }

    @Override
    public List<Double> getAdvancedMathematics() {
        return gradeMapper.findAdvancedMathematics();
    }

    @Override
    public List<Double> getEnglish() {
        return gradeMapper.findEnglish();
    }

    @Override
    public List<Double> getDataStructure() {
        return gradeMapper.findDataStructure();
    }

    @Override
    public List<Double> getJava() {
        return gradeMapper.findJava();
    }

    @Override
    public List<Double> getComputerPrinciples() {
        return gradeMapper.findComputerPrinciples();
    }

    @Override
    public List<Double> getComputerNetwork() {
        return gradeMapper.findComputerNetwork();
    }

    @Override
    public List<Double> getOracle() {
        return gradeMapper.findOracle();
    }

    @Override
    public List<Double> getWeb() {
        return gradeMapper.findWeb();
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
