package com.sau.service;

import com.sau.entity.Prize;

import java.util.List;

public interface PrizeService {

    List<Prize> getPrizeByStudentId(Integer studentId);
    boolean updatePrize(Prize prize);
    boolean addPrize(Prize prize);
    boolean deletePrizes(Integer[] ids);
}
