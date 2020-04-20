package com.sau.service;

import com.sau.entity.Thesis;

import java.util.List;

public interface ThesisService {

    List<Thesis> getThesisByStudentId(Integer studentId);
}
