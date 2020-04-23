package com.sau.service;

import com.sau.entity.BusinessPractice;

import java.util.List;

public interface BusinessPracticeService {

    List<BusinessPractice> getPracticeByStudentId(Integer studentId);
    boolean updatePractice(BusinessPractice businessPractice);
    boolean addPractice(BusinessPractice businessPractice);
    boolean deletePracticeById(Integer[] ids);
}
