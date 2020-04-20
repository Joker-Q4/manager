package com.sau.service;

import com.sau.entity.IndustryExperience;

import java.util.List;

public interface ExperienceService {

    List<IndustryExperience> getExperienceByTeacherId(Integer teacherId);
}
