package com.sau.service.impl;

import com.sau.entity.TeachingSituation;
import com.sau.mapper.SituationMapper;
import com.sau.service.SituationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("situationService")
public class SituationServiceImpl implements SituationService {

    @Resource
    SituationMapper situationMapper;

    @Override
    public List<TeachingSituation> getSituationByTeacherId(Integer teacherId) {
        return situationMapper.findSituationByTeacherId(teacherId);
    }

    @Override
    public boolean updateSituation(TeachingSituation teachingSituation) {
        return situationMapper.updateSituation(teachingSituation) > 0;
    }

    @Override
    public boolean addSituation(TeachingSituation teachingSituation) {
        return situationMapper.insertSituation(teachingSituation) > 0;
    }

    @Override
    public boolean deleteSituationById(Integer[] ids) {
        boolean flag = true;
        for (Integer id : ids) {
            flag = flag && situationMapper.deleteSituation(id) > 0;
        }
        return flag;
    }
}
