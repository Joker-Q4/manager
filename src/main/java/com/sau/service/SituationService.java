package com.sau.service;

import com.sau.entity.TeachingSituation;

import java.util.List;

public interface SituationService {

    List<TeachingSituation> getSituationByTeacherId(Integer teacherId);
}
