package com.sau.controller;

import com.alibaba.fastjson.JSONObject;
import com.sau.entity.*;
import com.sau.global.Global;
import com.sau.global.GlobalKey;
import com.sau.global.JsonTools;
import com.sau.service.*;
import com.sau.utils.KMPUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    StudentService studentService;
    @Resource
    GradeService gradeService;
    @Resource
    PrizeService prizeService;
    @Resource
    BusinessPracticeService businessPracticeService;
    @Resource
    ThesisService thesisService;
    @Resource
    ProjectAchievementService projectAchievementService;
    @Resource
    STAwardService stAwardService;
    @Resource
    PatentAuthorizationService patentAuthorizationService;

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @GetMapping("/queryAllStudents")
    public Map<String, Object> queryAllStudents(
            @RequestParam(defaultValue = "") String studentId,
            @RequestParam(defaultValue = "") String key
    ){
        if(key.isEmpty()){
            if(studentId.isEmpty()){
                final List<Student> students = studentService.getAllStudents();
                return JsonTools.toResult(0, "成功", students.size(), students);
            }
            Student student = studentService.getStudentById(Integer.valueOf(studentId));
            if(student != null)
                return JsonTools.toResult(0, "成功", 1, student);
            else
                return JsonTools.toResult(0, "成功", 0, null);
        }else {
            final List<Student> students = studentService.getAllStudents();
            final List<Student> result = new ArrayList<>();
            for(Student student: students){
                Integer id = student.getId();
                setProperty(student, id);
                int[] temp = KMPUtils.kmpNext(key);
                if(KMPUtils.kmpSearch(student.getString(), key, temp) != -1){
                    //说明存在
                    result.add(student);
                }
            }
            return JsonTools.toResult(0, "成功", result.size(), result);
        }
    }

    @PostMapping("/deleteStudents")
    public Map<String, Object> deleteStudents(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        String[] idArr = CommonController.delete(properties);
        if(studentService.deleteStudents(Global.stringFormatInteger(idArr))){
            return JsonTools.toResult(0, "删除成功", 0, null);
        }
        return JsonTools.toResult(1, "删除失败", 0, null);
    }

    @GetMapping("/deleteStudent")
    public Map<String, Object> deleteStudent(@RequestParam(defaultValue = "") String id){
        if(id.isEmpty()){
            return JsonTools.toResult(0, "id不能为空", 0, null);
        }
        if(studentService.deleteStudent(Integer.valueOf(id)))
            return JsonTools.toResult(0, "删除成功", 0, null);
        else
            return JsonTools.toResult(1, "删除失败", 0, null);
    }

    @PostMapping("/updateStudent")
    public Map<String, Object> updateStudent(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        Student student = analyzeJson(properties);
        if(student.getId() == null){
            return JsonTools.toResult(1, "id不能为空", 0, null);
        }
        if(studentService.updateStudent(student))
            return JsonTools.toResult(0, "修改成功", 0, null);
        return JsonTools.toResult(1, "修改失败", 0, null);
    }

    @PostMapping("/addStudent")
    public Map<String, Object> addStudent(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        Student student = analyzeJson(properties);
        if(studentService.addStudent(student))
            return JsonTools.toResult(0, "添加成功", 0, null);
        return JsonTools.toResult(1, "添加失败", 0, null);
    }

    private Student analyzeJson(Properties properties){
        final String json = properties.getProperty("json");
        JSONObject jsonObject = JSONObject.parseObject(json);
        return getStudent(jsonObject);
    }

    private Student getStudent(JSONObject jsonObject){
        Student student = new Student();
        final String id = jsonObject.getString(GlobalKey.ID);
        if(id != null && !id.isEmpty()){
            student.setId(Integer.parseInt(id));
        }
        final String name = jsonObject.getString(GlobalKey.NAME);
        if(name != null && !name.isEmpty()){
            student.setName(name);
        }
        final String sex = jsonObject.getString(GlobalKey.SEX);
        if(sex != null && !sex.isEmpty()){
            student.setSex(sex);
        }
        final String phoneNumber = jsonObject.getString(GlobalKey.PHONE);
        if(phoneNumber != null && !phoneNumber.isEmpty()){
            student.setPhoneNumber(phoneNumber);
        }
        final String address = jsonObject.getString(GlobalKey.ADDRESS);
        if(address != null && !address.isEmpty()){
            student.setAddress(address);
        }
        return student;
    }

    private void setProperty(Student student, int id){
        //各科成绩
        List<Grade> gradeList = gradeService.getGradeByStudentId(id);
        StringBuilder gradeString = new StringBuilder();
        for(Grade grade: gradeList){
            gradeString.append(grade.getString());
        }
        student.setGrade(gradeString.toString());
        //获奖情况
        List<Prize> prizeList = prizeService.getPrizeByStudentId(id);
        StringBuilder prizeString = new StringBuilder();
        for(Prize prize: prizeList){
            prizeString.append(prize.getString());
        }
        student.setPrize(prizeString.toString());
        //企业实践活动
        List<BusinessPractice> practiceList = businessPracticeService.getPracticeByStudentId(id);
        StringBuilder practiceString = new StringBuilder();
        for(BusinessPractice businessPractice: practiceList){
            practiceString.append(businessPractice.getString());
        }
        student.setBusinessPractice(practiceString.toString());
        //论文情况
        List<Thesis> thesisList = thesisService.getThesisByStudentId(id);
        StringBuilder thesisString = new StringBuilder();
        for(Thesis thesis: thesisList){
            thesisString.append(thesis.getString());
        }
        student.setThesis(thesisString.toString());
        //项目成果
        List<ProjectAchievement> achievementList = projectAchievementService.findAchievementByStudentId(id);
        StringBuilder achievementString = new StringBuilder();
        for(ProjectAchievement projectAchievement: achievementList){
            achievementString.append(projectAchievement.getString());
        }
        student.setProjectAchievement(achievementString.toString());
        //科技成果
        List<ScienceTechnologyAchievementAward> STAAList = stAwardService.findSTAwardByStudentId(id);
        StringBuilder STAAString = new StringBuilder();
        for(ScienceTechnologyAchievementAward scienceTechnologyAchievementAward: STAAList){
            STAAString.append(scienceTechnologyAchievementAward.getString());
        }
        student.setScienceTechnologyAchievementAward(STAAString.toString());
        //专利授权
        List<PatentAuthorization> patentList = patentAuthorizationService.findAuthorizationByStudentId(id);
        StringBuilder patentString = new StringBuilder();
        for(PatentAuthorization patentAuthorization: patentList){
            patentString.append(patentAuthorization.getString());
        }
        student.setPatentAuthorization(patentString.toString());
    }
}
