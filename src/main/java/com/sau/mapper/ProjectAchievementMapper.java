package com.sau.mapper;

import com.sau.entity.ProjectAchievement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectAchievementMapper {

    List<ProjectAchievement> findProjectAchievementByStudentId(Integer studentId);
    List<ProjectAchievement> findProjectAchievementByTeacherId(Integer teacherId);
    Integer updateAchievement(ProjectAchievement projectAchievement);
    Integer insertAchievement(ProjectAchievement projectAchievement);
    Integer deleteAchievementById(Integer id);
}
