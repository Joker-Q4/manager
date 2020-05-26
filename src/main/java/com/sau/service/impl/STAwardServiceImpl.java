package com.sau.service.impl;

import com.sau.entity.ScienceTechnologyAchievementAward;
import com.sau.mapper.STAwardMapper;
import com.sau.service.STAwardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@Service("stAwardService")
public class STAwardServiceImpl implements STAwardService {

    @Resource
    STAwardMapper stAwardMapper;

    @Override
    public List<ScienceTechnologyAchievementAward> findSTAwardByStudentId(Integer studentId) {
        List<ScienceTechnologyAchievementAward> list = stAwardMapper.findSTAwardByStudentId(studentId);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(ScienceTechnologyAchievementAward scienceTechnologyAchievementAward:list){
            scienceTechnologyAchievementAward.setCreate(format.format(scienceTechnologyAchievementAward.getCreateTime()));
        }
        return list;
    }

    @Override
    public List<ScienceTechnologyAchievementAward> findSTAwardByTeacherId(Integer teacherId) {
        List<ScienceTechnologyAchievementAward> list = stAwardMapper.findSTAwardByTeacherId(teacherId);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(ScienceTechnologyAchievementAward scienceTechnologyAchievementAward:list){
            scienceTechnologyAchievementAward.setCreate(format.format(scienceTechnologyAchievementAward.getCreateTime()));
        }
        return list;
    }

    @Override
    public boolean updateSTAward(ScienceTechnologyAchievementAward scienceTechnologyAchievementAward) {
        return stAwardMapper.updateAward(scienceTechnologyAchievementAward) > 0;
    }

    @Override
    public boolean addSTAward(ScienceTechnologyAchievementAward scienceTechnologyAchievementAward) {
        scienceTechnologyAchievementAward.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return stAwardMapper.insertAward(scienceTechnologyAchievementAward) > 0;
    }

    @Override
    public boolean deleteSTAwardById(Integer id) {
        return stAwardMapper.deleteAwardById(id) > 0;
    }

    @Override
    public boolean deleteSTAwards(Integer[] ids) {
        boolean flag = true;
        for (Integer id : ids) {
            flag = flag && stAwardMapper.deleteAwardById(id) > 0;
        }
        return flag;
    }
}
