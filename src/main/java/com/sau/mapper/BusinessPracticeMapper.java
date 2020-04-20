package com.sau.mapper;

import com.sau.entity.BusinessPractice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BusinessPracticeMapper {

    List<BusinessPractice> findPracticeByStudentId(Integer studentId);
}
