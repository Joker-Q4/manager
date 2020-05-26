package com.sau.service.impl;

import com.sau.entity.BusinessPractice;
import com.sau.mapper.BusinessPracticeMapper;
import com.sau.service.BusinessPracticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@Service("businessPracticeService")
public class BusinessPracticeServiceImpl implements BusinessPracticeService {

    @Resource
    BusinessPracticeMapper businessPracticeMapper;

    @Override
    public List<BusinessPractice> getPracticeByStudentId(Integer studentId) {
        List<BusinessPractice> list = businessPracticeMapper.findPracticeByStudentId(studentId);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(BusinessPractice businessPractice:list){
            businessPractice.setCreate(format.format(businessPractice.getCreateTime()));
        }
        return list;
    }

    @Override
    public boolean updatePractice(BusinessPractice businessPractice) {
        return businessPracticeMapper.updatePractice(businessPractice) > 0;
    }

    @Override
    public boolean addPractice(BusinessPractice businessPractice) {
        businessPractice.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return businessPracticeMapper.insertPractice(businessPractice) > 0;
    }

    @Override
    public boolean deletePracticeById(Integer[] ids) {
        boolean flag = true;
        for (Integer id : ids) {
            flag = flag && businessPracticeMapper.deletePracticeById(id) > 0;
        }
        return flag;
    }
}
