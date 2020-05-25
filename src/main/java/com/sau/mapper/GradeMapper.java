package com.sau.mapper;

import com.sau.entity.Grade;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GradeMapper {

    List<Grade> findGradeByStudentId(Integer studentId);
    List<Double> findCombinedLanguage();
    List<Double> findCombinedLanguagePlus();
    List<Double> findAdvancedMathematics();
    List<Double> findEnglish();
    List<Double> findDataStructure();
    List<Double> findJava();
    List<Double> findComputerPrinciples();
    List<Double> findComputerNetwork();
    List<Double> findOracle();
    List<Double> findWeb();
    int updateGrade(Grade grade);
    int insertGrade(Grade grade);
}
