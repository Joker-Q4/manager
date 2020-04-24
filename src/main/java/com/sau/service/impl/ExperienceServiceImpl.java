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

    @Override
    public boolean updateExperience(IndustryExperience industryExperience) {
        return experienceMapper.updateExperience(industryExperience) > 0;
    }

    @Override
    public boolean addExperience(IndustryExperience industryExperience) {
        return experienceMapper.insertExperience(industryExperience) > 0;
    }

    @Override
    public boolean deleteExperienceById(Integer[] ids) {
        boolean flag = true;
        for (Integer id : ids) {
            flag = flag && experienceMapper.deleteExperienceById(id) > 0;
        }
        return flag;
    }

}
