package com.sau.service;

import com.sau.entity.BusinessPractice;

import java.util.List;

public interface BusinessPracticeService {

    List<BusinessPractice> getPracticeByStudentId(Integer studentId);
}
