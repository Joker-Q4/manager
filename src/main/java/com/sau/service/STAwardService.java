package com.sau.service;

import com.sau.entity.ScienceTechnologyAchievementAward;

import java.util.List;

public interface STAwardService {

    List<ScienceTechnologyAchievementAward> findSTAwardByStudentId(Integer studentId);
    List<ScienceTechnologyAchievementAward> findSTAwardByTeacherId(Integer teacherId);
    boolean updateSTAward(ScienceTechnologyAchievementAward scienceTechnologyAchievementAward);
    boolean addSTAward(ScienceTechnologyAchievementAward scienceTechnologyAchievementAward);
    boolean deleteSTAwardById(Integer id);
    boolean deleteSTAwards(Integer[] ids);
}
