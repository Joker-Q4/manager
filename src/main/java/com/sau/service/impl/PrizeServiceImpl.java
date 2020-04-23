package com.sau.service.impl;

import com.sau.entity.Prize;
import com.sau.mapper.PrizeMapper;
import com.sau.service.PrizeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
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

    @Override
    public boolean addPrize(Prize prize) {
        prize.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return prizeMapper.insertPrize(prize) > 0;
    }

    @Override
    public boolean deletePrizes(Integer[] ids) {
        boolean flag = true;
        for (Integer id : ids) {
            flag = flag && prizeMapper.deletePrizeById(id) > 0;
        }
        return flag;
    }
}
