package com.sau.service.impl;

import com.sau.entity.PatentAuthorization;
import com.sau.mapper.PatentAuthorizationMapper;
import com.sau.service.PatentAuthorizationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@Service("patentAuthorizationService")
public class PatentAuthorizationServiceImpl implements PatentAuthorizationService {

    @Resource
    PatentAuthorizationMapper patentAuthorizationMapper;

    @Override
    public List<PatentAuthorization> findAuthorizationByStudentId(Integer studentId) {
        List<PatentAuthorization> list = patentAuthorizationMapper.findPatentAuthorizationByStudentId(studentId);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(PatentAuthorization patentAuthorization:list){
            patentAuthorization.setCreate(format.format(patentAuthorization.getCreateTime()));
        }
        return list;
    }

    @Override
    public List<PatentAuthorization> findAuthorizationByTeacherId(Integer teacherId) {
        List<PatentAuthorization> list = patentAuthorizationMapper.findPatentAuthorizationByTeacherId(teacherId);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(PatentAuthorization patentAuthorization:list){
            patentAuthorization.setCreate(format.format(patentAuthorization.getCreateTime()));
        }
        return list;
    }

    @Override
    public boolean updateAuthorization(PatentAuthorization patentAuthorization) {
        return patentAuthorizationMapper.updatePatentAuthorization(patentAuthorization) > 0;
    }

    @Override
    public boolean addAuthorization(PatentAuthorization patentAuthorization) {
        patentAuthorization.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return patentAuthorizationMapper.insertPatentAuthorization(patentAuthorization) > 0;
    }

    @Override
    public boolean deleteAuthorizationById(Integer id) {
        return patentAuthorizationMapper.deletePatentAuthorizationById(id) > 0;
    }

    @Override
    public boolean deleteAuthorizations(Integer[] ids) {
        boolean flag = true;
        for (Integer id : ids) {
            flag = flag && patentAuthorizationMapper.deletePatentAuthorizationById(id) > 0;
        }
        return flag;
    }
}
