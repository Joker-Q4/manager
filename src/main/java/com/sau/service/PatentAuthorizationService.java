package com.sau.service;

import com.sau.entity.PatentAuthorization;

import java.util.List;

public interface PatentAuthorizationService {

    List<PatentAuthorization> findAuthorizationByStudentId(Integer studentId);
    List<PatentAuthorization> findAuthorizationByTeacherId(Integer teacherId);
    boolean updateAuthorization(PatentAuthorization patentAuthorization);
    boolean addAuthorization(PatentAuthorization patentAuthorization);
    boolean deleteAuthorizationById(Integer id);
    boolean deleteAuthorizations(Integer[] ids);
}
