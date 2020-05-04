package com.sau.mapper;

import com.sau.entity.PatentAuthorization;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PatentAuthorizationMapper {

    List<PatentAuthorization> findPatentAuthorizationByStudentId(Integer studentId);
    List<PatentAuthorization> findPatentAuthorizationByTeacherId(Integer teacherId);
    Integer updatePatentAuthorization(PatentAuthorization patentAuthorization);
    Integer insertPatentAuthorization(PatentAuthorization patentAuthorization);
    Integer deletePatentAuthorizationById(Integer id);
}
