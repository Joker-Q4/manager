package com.sau.mapper;

import com.sau.entity.Thesis;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ThesisMapper {

    List<Thesis> findThesisByStudentId(Integer studentId);
    Integer updateThesis(Thesis thesis);
    Integer insertThesis(Thesis thesis);
    Integer deleteThesis(Integer id);
}
