package com.sau.mapper;

import com.sau.entity.IndustryExperience;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExperienceMapper {

    List<IndustryExperience> findExperienceByTeacherId(Integer teacherId);
}
