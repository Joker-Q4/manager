package com.sau.controller;

import com.sau.entity.IndustryExperience;
import com.sau.entity.Teacher;
import com.sau.entity.TeachingSituation;
import com.sau.global.JsonTools;
import com.sau.service.ExperienceService;
import com.sau.service.SituationService;
import com.sau.service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class TeacherController {

    @Resource
    TeacherService teacherService;

    @Resource
    SituationService situationService;

    @Resource
    ExperienceService experienceService;

    @GetMapping("/queryTeachers")
    public Map<String, Object> queryTeachers(@RequestParam(defaultValue = "") String id){
        if(id.isEmpty()){
            final List<Teacher> teachers = teacherService.getAllTeachers();
            return JsonTools.toResult(0, "success", teachers.size(), teachers);
        }
        Teacher teacher = teacherService.getTeacherById(Integer.valueOf(id));
        if(teacher != null)
            return JsonTools.toResult(0, "success", 1, teacher);
        else
            return JsonTools.toResult(0, "success", 0, null);
    }

    @GetMapping("/getSituationByTeacherId")
    public Map<String, Object> getSituationByTeacherId(@RequestParam(defaultValue = "") String teacherId){
        if(teacherId.isEmpty()){
            return JsonTools.toResult(1, "参数有误", 0, null);
        }
        final List<TeachingSituation> list = situationService.getSituationByTeacherId(Integer.valueOf(teacherId));
        return JsonTools.toResult(0, "success", list.size(), list);
    }

    @GetMapping("/getExperienceByTeacherId")
    public Map<String, Object> getExperienceByTeacherId(@RequestParam(defaultValue = "") String teacherId){
        if(teacherId.isEmpty()){
            return JsonTools.toResult(1, "参数有误", 0, null);
        }
        final List<IndustryExperience> list = experienceService.getExperienceByTeacherId(Integer.valueOf(teacherId));
        return JsonTools.toResult(0, "success", list.size(), list);
    }
}
