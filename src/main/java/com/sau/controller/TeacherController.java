package com.sau.controller;

import com.alibaba.fastjson.JSONObject;
import com.sau.entity.*;
import com.sau.global.Global;
import com.sau.global.GlobalKey;
import com.sau.global.JsonTools;
import com.sau.service.*;
import com.sau.utils.KMPUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@RestController
@RequestMapping("teacher")
public class TeacherController {

    @Resource
    TeacherService teacherService;
    @Resource
    SituationService situationService;
    @Resource
    ExperienceService experienceService;
    @Resource
    ThesisService thesisService;
    @Resource
    ProjectAchievementService projectAchievementService;
    @Resource
    STAwardService stAwardService;
    @Resource
    PatentAuthorizationService patentAuthorizationService;

    @GetMapping("/queryTeachers")
    public Map<String, Object> queryTeachers(
            @RequestParam(defaultValue = "") String id,
            @RequestParam(defaultValue = "") String key
    ){
        if(key.isEmpty()){
            if(id.isEmpty()){
                final List<Teacher> teachers = teacherService.getAllTeachers();
                return JsonTools.toResult(0, "success", teachers.size(), teachers);
            }
            Teacher teacher = teacherService.getTeacherById(Integer.valueOf(id));
            if(teacher != null)
                return JsonTools.toResult(0, "success", 1, teacher);
            else
                return JsonTools.toResult(0, "success", 0, null);
        }else{
            final List<Teacher> teachers = teacherService.getAllTeachers();
            final List<Teacher> result = new ArrayList<>();
            for(Teacher teacher: teachers){
                setProperty(teacher, teacher.getId());
                int[] temp = KMPUtils.kmpNext(key);
                if(KMPUtils.kmpSearch(teacher.getString(), key, temp) != -1){
                    //说明存在
                    result.add(teacher);
                }
            }
            return JsonTools.toResult(0, "success", result.size(), result);
        }
    }

    @PostMapping("/deleteTeachers")
    public Map<String, Object> deleteTeachers(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        String[] idArr = CommonController.delete(properties);
        if(teacherService.deleteTeachers(Global.stringFormatInteger(idArr))){
            return JsonTools.toResult(0, "删除成功", 0, null);
        }
        return JsonTools.toResult(1, "删除失败", 0, null);
    }

    @GetMapping("/deleteTeacher")
    public Map<String, Object> deleteStudent(@RequestParam(defaultValue = "") String id){
        if(id.isEmpty()){
            return JsonTools.toResult(0, "id不能为空", 0, null);
        }
        if(teacherService.deleteTeacher(Integer.valueOf(id)))
            return JsonTools.toResult(0, "删除成功", 0, null);
        else
            return JsonTools.toResult(1, "删除失败", 0, null);
    }

    @PostMapping("/updateTeacher")
    public Map<String, Object> updateTeacher(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        Teacher Teacher = analyzeJson(properties);
        if(Teacher.getId() == null){
            return JsonTools.toResult(1, "id不能为空", 0, null);
        }
        if(teacherService.updateTeacher(Teacher))
            return JsonTools.toResult(0, "修改成功", 0, null);
        return JsonTools.toResult(1, "修改失败", 0, null);
    }

    @PostMapping("/addTeacher")
    public Map<String, Object> addTeacher(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        Teacher Teacher = analyzeJson(properties);
        if(teacherService.addTeacher(Teacher))
            return JsonTools.toResult(0, "添加成功", 0, null);
        return JsonTools.toResult(1, "添加失败", 0, null);
    }

    private Teacher analyzeJson(Properties properties){
        final String json = properties.getProperty("json");
        JSONObject jsonObject = JSONObject.parseObject(json);
        return getTeacher(jsonObject);
    }

    private Teacher getTeacher(JSONObject jsonObject){
        Teacher teacher = new Teacher();
        final String id = jsonObject.getString(GlobalKey.ID);
        if(id != null && !id.isEmpty()){
            teacher.setId(Integer.parseInt(id));
        }
        final String name = jsonObject.getString(GlobalKey.NAME);
        if(name != null && !name.isEmpty()){
            teacher.setName(name);
        }
        final String sex = jsonObject.getString(GlobalKey.SEX);
        if(sex != null && !sex.isEmpty()){
            teacher.setSex(sex);
        }
        final String phoneNumber = jsonObject.getString(GlobalKey.PHONE);
        if(phoneNumber != null && !phoneNumber.isEmpty()){
            teacher.setPhoneNumber(phoneNumber);
        }
        final String address = jsonObject.getString(GlobalKey.ADDRESS);
        if(address != null && !address.isEmpty()){
            teacher.setAddress(address);
        }
        final String academicDegree = jsonObject.getString(GlobalKey.ACADEMIC_DEGREE);
        if(academicDegree != null && !academicDegree.isEmpty()){
            teacher.setAcademicDegree(academicDegree);
        }
        //高级职称
        final String title = jsonObject.getString(GlobalKey.TITLE);
        if(title != null && !title.isEmpty()){
            teacher.setTitle(title);
        }
        return teacher;
    }

    private void setProperty(Teacher teacher, int id){
        //授课情况
        List<TeachingSituation> situationList = situationService.getSituationByTeacherId(id);
        StringBuilder prizeString = new StringBuilder();
        for(TeachingSituation teachingSituation: situationList){
            prizeString.append(teachingSituation.getString());
        }
        teacher.setTeachingSituation(prizeString.toString());
        //行业实践经历
        List<IndustryExperience> experienceList = experienceService.getExperienceByTeacherId(id);
        StringBuilder practiceString = new StringBuilder();
        for(IndustryExperience industryExperience: experienceList){
            practiceString.append(industryExperience.getString());
        }
        teacher.setIndustryExperience(practiceString.toString());
        //论文情况
        List<Thesis> thesisList = thesisService.getThesisByTeacherId(id);
        StringBuilder thesisString = new StringBuilder();
        for(Thesis thesis: thesisList){
            thesisString.append(thesis.getString());
        }
        teacher.setThesis(thesisString.toString());
        //项目成果
        List<ProjectAchievement> achievementList = projectAchievementService.findAchievementByTeacherId(id);
        StringBuilder achievementString = new StringBuilder();
        for(ProjectAchievement projectAchievement: achievementList){
            achievementString.append(projectAchievement.getString());
        }
        teacher.setProjectAchievement(achievementString.toString());
        //科技成果
        List<ScienceTechnologyAchievementAward> STAAList = stAwardService.findSTAwardByTeacherId(id);
        StringBuilder STAAString = new StringBuilder();
        for(ScienceTechnologyAchievementAward scienceTechnologyAchievementAward: STAAList){
            STAAString.append(scienceTechnologyAchievementAward.getString());
        }
        teacher.setScienceTechnologyAchievementAward(STAAString.toString());
        //专利授权
        List<PatentAuthorization> patentList = patentAuthorizationService.findAuthorizationByTeacherId(id);
        StringBuilder patentString = new StringBuilder();
        for(PatentAuthorization patentAuthorization: patentList){
            patentString.append(patentAuthorization.getString());
        }
        teacher.setPatentAuthorization(patentString.toString());
    }
}
