package com.sau.service.impl;

import com.sau.entity.ProjectAchievement;
import com.sau.mapper.ProjectAchievementMapper;
import com.sau.service.ProjectAchievementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@Service("projectAchievementService")
public class ProjectAchievementServiceImpl implements ProjectAchievementService {

    @Resource
    ProjectAchievementMapper mapper;

    @Override
    public List<ProjectAchievement> findAchievementByStudentId(Integer studentId) {
        return mapper.findProjectAchievementByStudentId(studentId);
    }

    @Override
    public List<ProjectAchievement> findAchievementByTeacherId(Integer teacherId) {
        return mapper.findProjectAchievementByTeacherId(teacherId);
    }

    @Override
    public boolean updateAchievement(ProjectAchievement projectAchievement) {
        return mapper.updateAchievement(projectAchievement) > 0;
    }

    @Override
    public boolean addAchievement(ProjectAchievement projectAchievement) {
        projectAchievement.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return mapper.insertAchievement(projectAchievement) > 0;
    }

    @Override
    public boolean deleteAchievementById(Integer id) {
        return mapper.deleteAchievementById(id) > 0;
    }

    @Override
    public boolean deleteAchievements(Integer[] ids) {
        boolean flag = true;
        for (Integer id : ids) {
            flag = flag && mapper.deleteAchievementById(id) > 0;
        }
        return flag;
    }
}
