package com.sau.mapper;

import com.sau.entity.ScienceTechnologyAchievementAward;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface STAwardMapper {

    List<ScienceTechnologyAchievementAward> findSTAwardByStudentId(Integer studentId);
    List<ScienceTechnologyAchievementAward> findSTAwardByTeacherId(Integer teacherId);
    Integer updateAward(ScienceTechnologyAchievementAward scienceTechnologyAchievementAward);
    Integer insertAward(ScienceTechnologyAchievementAward scienceTechnologyAchievementAward);
    Integer deleteAwardById(Integer id);
}
