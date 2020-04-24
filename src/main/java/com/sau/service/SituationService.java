package com.sau.service;

import com.sau.entity.TeachingSituation;

import java.util.List;

public interface SituationService {

    List<TeachingSituation> getSituationByTeacherId(Integer teacherId);
    boolean updateSituation(TeachingSituation teachingSituation);
    boolean addSituation(TeachingSituation teachingSituation);
    boolean deleteSituationById(Integer[] ids);
}
