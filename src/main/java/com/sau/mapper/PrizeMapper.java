package com.sau.mapper;

import com.sau.entity.Prize;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PrizeMapper {

    List<Prize> findPrizeByStudentId(Integer studentId);
    int updatePrize(Prize prize);
}
