package com.sau.controller;

import com.alibaba.fastjson.JSONObject;
import com.sau.entity.TeachingSituation;
import com.sau.global.Global;
import com.sau.global.GlobalKey;
import com.sau.global.JsonTools;
import com.sau.service.SituationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@RestController
@RequestMapping("situation")
public class SituationController {

    @Resource
    SituationService situationService;

    @GetMapping("/getSituationByTeacherId")
    public Map<String, Object> getSituationByTeacherId(@RequestParam(defaultValue = "") String teacherId){
        if(teacherId.isEmpty()){
            return JsonTools.toResult(1, "参数有误", 0, null);
        }
        final List<TeachingSituation> list = situationService.getSituationByTeacherId(Integer.valueOf(teacherId));
        return JsonTools.toResult(0, "success", list.size(), list);
    }

    @PostMapping("/addSituation")
    public Map<String, Object> addSituation(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        TeachingSituation teachingSituation = analyzeJson(properties);
        if(situationService.addSituation(teachingSituation))
            return JsonTools.toResult(0, "添加成功", 0, null);
        return JsonTools.toResult(1, "添加失败", 0, null);
    }

    @PostMapping("/updateSituation")
    public Map<String, Object> updateSituation(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        TeachingSituation teachingSituation = analyzeJson(properties);
        if(teachingSituation.getId() == null){
            return JsonTools.toResult(1, "id不能为空", 0, null);
        }
        if(situationService.updateSituation(teachingSituation))
            return JsonTools.toResult(0, "修改成功", 0, null);
        return JsonTools.toResult(1, "修改失败", 0, null);
    }

    private TeachingSituation analyzeJson(Properties properties){
        final String json = properties.getProperty("json");
        JSONObject jsonObject = JSONObject.parseObject(json);
        return getSituation(jsonObject);
    }

    private TeachingSituation getSituation(JSONObject jsonObject){
        TeachingSituation teachingSituation = new TeachingSituation();
        final String id = jsonObject.getString(GlobalKey.ID);
        if(id != null && !id.isEmpty()){
            teachingSituation.setId(Integer.parseInt(id));
        }
        final String combinedLanguage = jsonObject.getString(GlobalKey.COMBINED_LANGUAGE);
        if(combinedLanguage != null && !combinedLanguage.isEmpty()){
            teachingSituation.setCombinedLanguage(combinedLanguage.equals("1"));
        }
        final String combinedLanguagePlus = jsonObject.getString(GlobalKey.COMBINED_LANGUAGE_PLUS);
        if(combinedLanguagePlus != null && !combinedLanguagePlus.isEmpty()){
            teachingSituation.setCombinedLanguagePlus(combinedLanguagePlus.equals("1"));
        }
        final String advancedMathematics = jsonObject.getString(GlobalKey.ADVANCED_MATHEMATICS);
        if(advancedMathematics != null && !advancedMathematics.isEmpty()){
            teachingSituation.setAdvancedMathematics(advancedMathematics.equals("1"));
        }
        final String english = jsonObject.getString(GlobalKey.ENGLISH);
        if(english != null && !english.isEmpty()){
            teachingSituation.setEnglish(english.equals("1"));
        }
        final String dataStructure = jsonObject.getString(GlobalKey.DATA_STRUCTURE);
        if(dataStructure != null && !dataStructure.isEmpty()){
            teachingSituation.setDataStructure(dataStructure.equals("1"));
        }
        final String java = jsonObject.getString(GlobalKey.JAVA);
        if(java != null && !java.isEmpty()){
            teachingSituation.setJava(java.equals("1"));
        }
        final String computerPrinciples = jsonObject.getString(GlobalKey.COMPUTER_PRINCIPLES);
        if(computerPrinciples != null && !computerPrinciples.isEmpty()){
            teachingSituation.setComputerPrinciples(computerPrinciples.equals("1"));
        }
        final String computerNetwork = jsonObject.getString(GlobalKey.COMPUTER_NETWORK);
        if(computerNetwork != null && !computerNetwork.isEmpty()){
            teachingSituation.setComputerNetwork(computerNetwork.equals("1"));
        }
        final String oracle = jsonObject.getString(GlobalKey.ORACLE);
        if(oracle != null && !oracle.isEmpty()){
            teachingSituation.setOracle(oracle.equals("1"));
        }
        final String web = jsonObject.getString(GlobalKey.WEB);
        if(web != null && !web.isEmpty()){
            teachingSituation.setWeb(web.equals("1"));
        }
        final String teacherId = jsonObject.getString(GlobalKey.TEACHER_ID);
        if(teacherId != null && !teacherId.isEmpty()){
            teachingSituation.setTeacherId(Integer.parseInt(teacherId));
        }
        return teachingSituation;
    }
}
