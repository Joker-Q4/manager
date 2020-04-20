package com.sau.service.impl;

import com.sau.entity.Thesis;
import com.sau.mapper.ThesisMapper;
import com.sau.service.ThesisService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("thesisService")
public class ThesisServiceImpl implements ThesisService {

    @Resource
    ThesisMapper thesisMapper;

    @Override
    public List<Thesis> getThesisByStudentId(Integer studentId) {
        return thesisMapper.findThesisByStudentId(studentId);
    }
}
