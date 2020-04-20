package com.sau.controller;

import com.sau.entity.BusinessPractice;
import com.sau.global.JsonTools;
import com.sau.service.BusinessPracticeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class BusinessPracticeController {

    @Resource
    BusinessPracticeService businessPracticeService;

    @GetMapping("/getPracticeByStudentId")
    public Map<String, Object> getPracticeByStudentId(@RequestParam(defaultValue = "") String studentId){
        if(studentId.isEmpty()){
            return JsonTools.toResult(1, "参数有误", 0, null);
        }
        final List<BusinessPractice> list = businessPracticeService.getPracticeByStudentId(Integer.valueOf(studentId));
        return JsonTools.toResult(0, "success", list.size(), list);
    }
}
