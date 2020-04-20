package com.sau.service.impl;

import com.sau.entity.Prize;
import com.sau.mapper.PrizeMapper;
import com.sau.service.PrizeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("prizeService")
public class PrizeServiceImpl implements PrizeService {

    @Resource
    PrizeMapper prizeMapper;

    @Override
    public List<Prize> getPrizeByStudentId(Integer studentId) {
        return prizeMapper.findPrizeByStudentId(studentId);
    }

    @Override
    public boolean updatePrize(Prize prize) {
        return prizeMapper.updatePrize(prize) > 0;
    }
}
