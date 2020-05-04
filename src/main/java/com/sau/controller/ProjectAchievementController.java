package com.sau.controller;

import com.alibaba.fastjson.JSONObject;
import com.sau.entity.ProjectAchievement;
import com.sau.global.Global;
import com.sau.global.GlobalKey;
import com.sau.global.JsonTools;
import com.sau.service.ProjectAchievementService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@RestController
@RequestMapping("/achievement")
public class ProjectAchievementController {

    @Resource
    ProjectAchievementService service;

    @GetMapping("/getAchievementByStudentId")
    public Map<String, Object> getAchievementByStudentId(@RequestParam(defaultValue = "") String studentId){
        if(studentId.isEmpty()){
            return JsonTools.toResult(1, "参数有误", 0, null);
        }
        final List<ProjectAchievement> list = service.findAchievementByStudentId(Integer.valueOf(studentId));
        return JsonTools.toResult(0, "成功", list.size(), list);
    }

    @GetMapping("/getAchievementByTeacherId")
    public Map<String, Object> getAchievementByTeacherId(@RequestParam(defaultValue = "") String teacherId){
        if(teacherId.isEmpty()){
            return JsonTools.toResult(1, "参数有误", 0, null);
        }
        final List<ProjectAchievement> list = service.findAchievementByTeacherId(Integer.valueOf(teacherId));
        return JsonTools.toResult(0, "成功", list.size(), list);
    }

    @PostMapping("/updateAchievement")
    public Map<String, Object> updateAchievement(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        ProjectAchievement projectAchievement = analyzeJson(properties);
        if(projectAchievement.getId() == null){
            return JsonTools.toResult(1, "id不能为空", 0, null);
        }
        if(service.updateAchievement(projectAchievement))
            return JsonTools.toResult(0, "修改成功", 0, null);
        return JsonTools.toResult(1, "修改失败", 0, null);
    }

    @PostMapping("/deleteAchievement")
    public Map<String, Object> deleteAchievement(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        String[] idArr = CommonController.delete(properties);
        if(service.deleteAchievements(Global.stringFormatInteger(idArr))){
            return JsonTools.toResult(0, "删除成功", 0, null);
        }
        return JsonTools.toResult(1, "删除失败", 0, null);
    }

    @PostMapping("/addAchievement")
    public Map<String, Object> addAchievement(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        ProjectAchievement projectAchievement = analyzeJson(properties);
        if(service.addAchievement(projectAchievement))
            return JsonTools.toResult(0, "添加成功", 0, null);
        return JsonTools.toResult(1, "添加失败", 0, null);
    }

    private ProjectAchievement analyzeJson(Properties properties){
        final String json = properties.getProperty("json");
        JSONObject jsonObject = JSONObject.parseObject(json);
        return getAchievement(jsonObject);
    }

    private ProjectAchievement getAchievement(JSONObject jsonObject){
        ProjectAchievement projectAchievement = new ProjectAchievement();
        final String id = jsonObject.getString(GlobalKey.ID);
        if(id != null && !id.isEmpty()){
            projectAchievement.setId(Integer.parseInt(id));
        }
        final String name = jsonObject.getString(GlobalKey.NAME);
        if(name != null && !name.isEmpty()){
            projectAchievement.setName(name);
        }
        final String description = jsonObject.getString(GlobalKey.DESCRIPTION);
        if(description != null && !description.isEmpty()){
            projectAchievement.setDescription(description);
        }
        final String fileId = jsonObject.getString(GlobalKey.FILE_ID);
        if(fileId != null && !fileId.isEmpty()){
            projectAchievement.setFileId(Integer.parseInt(fileId));
        }
        final String studentId = jsonObject.getString(GlobalKey.STUDENT_ID);
        if(studentId != null && !studentId.isEmpty()){
            projectAchievement.setStudentId(Integer.parseInt(studentId));
        }
        final String teacherId = jsonObject.getString(GlobalKey.TEACHER_ID);
        if(teacherId != null && !teacherId.isEmpty()){
            projectAchievement.setTeacherId(Integer.parseInt(teacherId));
        }
        return projectAchievement;
    }
}
