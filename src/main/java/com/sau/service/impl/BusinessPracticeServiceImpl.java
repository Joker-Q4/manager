package com.sau.service.impl;

import com.sau.entity.BusinessPractice;
import com.sau.mapper.BusinessPracticeMapper;
import com.sau.service.BusinessPracticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("businessPracticeService")
public class BusinessPracticeServiceImpl implements BusinessPracticeService {

    @Resource
    BusinessPracticeMapper businessPracticeMapper;

    @Override
    public List<BusinessPractice> getPracticeByStudentId(Integer studentId) {
        return businessPracticeMapper.findPracticeByStudentId(studentId);
    }
}
