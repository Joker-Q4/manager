package com.sau.controller;

import com.alibaba.fastjson.JSONObject;
import com.sau.entity.IndustryExperience;
import com.sau.global.Global;
import com.sau.global.GlobalKey;
import com.sau.global.JsonTools;
import com.sau.service.ExperienceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@RestController
@RequestMapping("/experience")
public class IndustryExperienceController {

    @Resource
    ExperienceService experienceService;

    @GetMapping("/getExperienceByTeacherId")
    public Map<String, Object> getExperienceByTeacherId(@RequestParam(defaultValue = "") String teacherId){
        if(teacherId.isEmpty()){
            return JsonTools.toResult(1, "参数有误", 0, null);
        }
        final List<IndustryExperience> list = experienceService.getExperienceByTeacherId(Integer.valueOf(teacherId));
        return JsonTools.toResult(0, "success", list.size(), list);
    }

    @PostMapping("/deleteExperiences")
    public Map<String, Object> deleteExperiences(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        String[] idArr = CommonController.delete(properties);
        if(experienceService.deleteExperienceById(Global.stringFormatInteger(idArr))){
            return JsonTools.toResult(0, "删除成功", 0, null);
        }
        return JsonTools.toResult(1, "删除失败", 0, null);
    }

    @PostMapping("/addExperience")
    public Map<String, Object> addExperience(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        IndustryExperience industryExperience = analyzeJson(properties);
        if(experienceService.addExperience(industryExperience))
            return JsonTools.toResult(0, "添加成功", 0, null);
        return JsonTools.toResult(1, "添加失败", 0, null);
    }

    @PostMapping("/updateExperience")
    public Map<String, Object> updateExperience(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        IndustryExperience industryExperience = analyzeJson(properties);
        if(industryExperience.getId() == null){
            return JsonTools.toResult(1, "id不能为空", 0, null);
        }
        if(experienceService.updateExperience(industryExperience))
            return JsonTools.toResult(0, "修改成功", 0, null);
        return JsonTools.toResult(1, "修改失败", 0, null);
    }

    private IndustryExperience analyzeJson(Properties properties){
        final String json = properties.getProperty("json");
        JSONObject jsonObject = JSONObject.parseObject(json);
        return getExperience(jsonObject);
    }

    private IndustryExperience getExperience(JSONObject jsonObject){
        IndustryExperience industryExperience = new IndustryExperience();
        final String id = jsonObject.getString(GlobalKey.ID);
        if(id != null && !id.isEmpty()){
            industryExperience.setId(Integer.parseInt(id));
        }
        final String title = jsonObject.getString(GlobalKey.TITLE);
        if(title != null && !title.isEmpty()){
            industryExperience.setTitle(title);
        }
        final String description = jsonObject.getString(GlobalKey.DESCRIPTION);
        if(description != null && !description.isEmpty()){
            industryExperience.setDescription(description);
        }
        final String time = jsonObject.getString(GlobalKey.TIME);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        try {
            Date date = simpleDateFormat.parse(time);
            industryExperience.setTime(date);
        } catch (ParseException e) {
            industryExperience.setTime(null);
            e.printStackTrace();
        }
        final String location = jsonObject.getString(GlobalKey.LOCATION);
        if(location != null && !location.isEmpty()){
            industryExperience.setLocation(location);
        }
        final String teacherId = jsonObject.getString(GlobalKey.TEACHER_ID);
        if(teacherId != null && !teacherId.isEmpty()){
            industryExperience.setTeacherId(Integer.parseInt(teacherId));
        }
        return industryExperience;
    }
}
