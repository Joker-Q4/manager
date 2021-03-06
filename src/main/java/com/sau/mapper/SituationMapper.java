package com.sau.mapper;

import com.sau.entity.TeachingSituation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SituationMapper {

    List<TeachingSituation> findSituationByTeacherId(Integer teacherId);
    Integer updateSituation(TeachingSituation teachingSituation);
    Integer insertSituation(TeachingSituation teachingSituation);
    Integer deleteSituation(Integer id);
}
