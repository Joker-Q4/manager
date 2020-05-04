package com.sau.service;

import com.sau.entity.ProjectAchievement;

import java.util.List;

public interface ProjectAchievementService {

    List<ProjectAchievement> findAchievementByStudentId(Integer studentId);
    List<ProjectAchievement> findAchievementByTeacherId(Integer teacherId);
    boolean updateAchievement(ProjectAchievement projectAchievement);
    boolean addAchievement(ProjectAchievement projectAchievement);
    boolean deleteAchievementById(Integer id);
    boolean deleteAchievements(Integer[] ids);
}
