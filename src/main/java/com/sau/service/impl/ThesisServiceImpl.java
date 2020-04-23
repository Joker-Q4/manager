package com.sau.service.impl;

import com.sau.entity.Thesis;
import com.sau.mapper.ThesisMapper;
import com.sau.service.ThesisService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@Service("thesisService")
public class ThesisServiceImpl implements ThesisService {

    @Resource
    ThesisMapper thesisMapper;

    @Override
    public List<Thesis> getThesisByStudentId(Integer studentId) {
        return thesisMapper.findThesisByStudentId(studentId);
    }

    @Override
    public boolean updateThesis(Thesis thesis) {
        return thesisMapper.updateThesis(thesis) > 0;
    }

    @Override
    public boolean addThesis(Thesis thesis) {
        thesis.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return thesisMapper.insertThesis(thesis) > 0;
    }

    @Override
    public boolean deleteThesis(Integer[] ids) {
        boolean flag = true;
        for (Integer id : ids) {
            flag = flag && thesisMapper.deleteThesis(id) > 0;
        }
        return flag;
    }
}
