package com.sau.mapper;

import com.sau.entity.IndustryExperience;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExperienceMapper {

    List<IndustryExperience> findExperienceByTeacherId(Integer teacherId);
    Integer updateExperience(IndustryExperience industryExperience);
    Integer insertExperience(IndustryExperience industryExperience);
    Integer deleteExperienceById(Integer id);
}
