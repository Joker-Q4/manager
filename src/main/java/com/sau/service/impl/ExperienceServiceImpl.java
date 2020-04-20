package com.sau.service.impl;

import com.sau.entity.IndustryExperience;
import com.sau.mapper.ExperienceMapper;
import com.sau.service.ExperienceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("experienceService")
public class ExperienceServiceImpl implements ExperienceService {

    @Resource
    ExperienceMapper experienceMapper;

    @Override
    public List<IndustryExperience> getExperienceByTeacherId(Integer teacherId) {
        return experienceMapper.findExperienceByTeacherId(teacherId);
    }
}
