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
}
