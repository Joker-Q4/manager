package com.sau.controller;

import com.sau.entity.Thesis;
import com.sau.global.JsonTools;
import com.sau.service.ThesisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class ThesisController {

    @Resource
    ThesisService thesisService;

    @GetMapping("/getThesisByStudentId")
    public Map<String, Object> getThesisByStudentId(@RequestParam(defaultValue = "") String studentId){
        if(studentId.isEmpty()){
            return JsonTools.toResult(1, "参数有误", 0, null);
        }
        final List<Thesis> list = thesisService.getThesisByStudentId(Integer.valueOf(studentId));
        return JsonTools.toResult(0, "success", list.size(), list);
    }
}
