package com.sau.service;

import com.sau.entity.Thesis;

import java.util.List;

public interface ThesisService {

    List<Thesis> getThesisByStudentId(Integer studentId);
    List<Thesis> getThesisByTeacherId(Integer teacherId);
    boolean updateThesis(Thesis thesis);
    boolean addThesis(Thesis thesis);
    boolean deleteThesis(Integer[] ids);
}
