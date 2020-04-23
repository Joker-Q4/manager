package com.sau.controller;

import com.alibaba.fastjson.JSONObject;
import com.sau.entity.Grade;
import com.sau.global.Global;
import com.sau.global.GlobalKey;
import com.sau.global.JsonTools;
import com.sau.service.GradeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@RestController
@RequestMapping("/grade")
public class GradeController {

    @Resource
    GradeService gradeService;

    @GetMapping("/getGradeByStudentId")
    public Map<String, Object> getGradeByStudentId(@RequestParam(defaultValue = "") String studentId){
        if(studentId.isEmpty()){
            return JsonTools.toResult(1, "参数有误", 0, null);
        }
        final List<Grade> list = gradeService.getGradeByStudentId(Integer.valueOf(studentId));
        return JsonTools.toResult(0, "success", list.size(), list);
    }

    @PostMapping("/updateGrade")
    public Map<String, Object> updateGrade(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        Grade grade = analyzeJson(properties);
        if(grade.getId() == null){
            return JsonTools.toResult(1, "id不能为空", 0, null);
        }
        if(gradeService.updateGrade(grade))
            return JsonTools.toResult(0, "修改成功", 0, null);
        return JsonTools.toResult(1, "修改失败", 0, null);
    }

    @PostMapping("/addGrade")
    public Map<String, Object> addGrade(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        Grade grade = analyzeJson(properties);
        if(gradeService.addGrade(grade))
            return JsonTools.toResult(0, "添加成功", 0, null);
        return JsonTools.toResult(1, "添加失败", 0, null);
    }

    private Grade analyzeJson(Properties properties){
        final String json = properties.getProperty("json");
        JSONObject jsonObject = JSONObject.parseObject(json);
        return getGrade(jsonObject);
    }

    private Grade getGrade(JSONObject jsonObject){
        Grade grade = new Grade();
        final String id = jsonObject.getString(GlobalKey.ID);
        if(id != null && !id.isEmpty()){
            grade.setId(Integer.parseInt(id));
        }
        final String combinedLanguage = jsonObject.getString(GlobalKey.COMBINED_LANGUAGE);
        if(combinedLanguage != null && !combinedLanguage.isEmpty()){
            grade.setCombinedLanguage(Double.parseDouble(combinedLanguage));
        }
        final String combinedLanguagePlus = jsonObject.getString(GlobalKey.COMBINED_LANGUAGE_PLUS);
        if(combinedLanguagePlus != null && !combinedLanguagePlus.isEmpty()){
            grade.setCombinedLanguagePlus(Double.parseDouble(combinedLanguagePlus));
        }
        final String advancedMathematics = jsonObject.getString(GlobalKey.ADVANCED_MATHEMATICS);
        if(advancedMathematics != null && !advancedMathematics.isEmpty()){
            grade.setAdvancedMathematics(Double.parseDouble(advancedMathematics));
        }
        final String english = jsonObject.getString(GlobalKey.ENGLISH);
        if(english != null && !english.isEmpty()){
            grade.setEnglish(Double.parseDouble(english));
        }
        final String dataStructure = jsonObject.getString(GlobalKey.DATA_STRUCTURE);
        if(dataStructure != null && !dataStructure.isEmpty()){
            grade.setDataStructure(Double.parseDouble(dataStructure));
        }
        final String java = jsonObject.getString(GlobalKey.JAVA);
        if(java != null && !java.isEmpty()){
            grade.setJava(Double.parseDouble(java));
        }
        final String computerPrinciples = jsonObject.getString(GlobalKey.COMPUTER_PRINCIPLES);
        if(computerPrinciples != null && !computerPrinciples.isEmpty()){
            grade.setComputerPrinciples(Double.parseDouble(computerPrinciples));
        }
        final String computerNetwork = jsonObject.getString(GlobalKey.COMPUTER_NETWORK);
        if(computerNetwork != null && !computerNetwork.isEmpty()){
            grade.setComputerNetwork(Double.parseDouble(computerNetwork));
        }
        final String oracle = jsonObject.getString(GlobalKey.ORACLE);
        if(oracle != null && !oracle.isEmpty()){
            grade.setOracle(Double.parseDouble(oracle));
        }
        final String web = jsonObject.getString(GlobalKey.WEB);
        if(web != null && !web.isEmpty()){
            grade.setWeb(Double.parseDouble(web));
        }
        final String studentId = jsonObject.getString(GlobalKey.STUDENT_ID);
        if(studentId != null && !studentId.isEmpty()){
            grade.setStudentId(Integer.parseInt(studentId));
        }
        return grade;
    }

}
