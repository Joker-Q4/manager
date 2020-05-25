package com.sau.service;

import com.sau.entity.Grade;

import java.util.List;

public interface GradeService {

    List<Grade> getGradeByStudentId(Integer studentId);
    List<Double> getCombinedLanguage();
    List<Double> getCombinedLanguagePlus();
    List<Double> getAdvancedMathematics();
    List<Double> getEnglish();
    List<Double> getDataStructure();
    List<Double> getJava();
    List<Double> getComputerPrinciples();
    List<Double> getComputerNetwork();
    List<Double> getOracle();
    List<Double> getWeb();
    boolean updateGrade(Grade grade);
    boolean addGrade(Grade grade);
}
