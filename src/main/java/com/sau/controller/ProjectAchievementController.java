package com.sau.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sau.entity.Page;
import com.sau.entity.ProjectAchievement;
import com.sau.global.Global;
import com.sau.global.JsonTools;
import com.sau.service.ProjectAchievementService;
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
@RequestMapping("/achievement")
public class ProjectAchievementController {

    @Resource
    ProjectAchievementService service;

    @GetMapping("/getAchievementByStudentId")
    public Map<String, Object> getAchievementByStudentId(
            @RequestParam(defaultValue = "") String studentId,
            @RequestParam(defaultValue = "") String key,
            @RequestParam(defaultValue = Page.PAGE_INDEX) String page,
            @RequestParam(defaultValue = Page.PAGE_SIZE) String limit
    ) {
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        if(key.isEmpty()){
            if(studentId.isEmpty()){
                return JsonTools.toResult(1, "参数有误", 0, null);
            }
            final List<ProjectAchievement> list = service.findAchievementByStudentId(Integer.valueOf(studentId));
            PageInfo<ProjectAchievement> pageInfo = new PageInfo<>(list);
            return JsonTools.toResult(0, "成功", pageInfo.getTotal(), pageInfo);
        }else{
            if(studentId.isEmpty()){
                return JsonTools.toResult(1, "参数有误", 0, null);
            }
            final List<ProjectAchievement> list = service.findAchievementByStudentId(Integer.valueOf(studentId));
            final List<ProjectAchievement> result = new ArrayList<>();
            for(ProjectAchievement projectAchievement: list){
                int[] temp = KMPUtils.kmpNext(key);
                if(KMPUtils.kmpSearch(projectAchievement.getString(), key, temp) != -1){
                    //说明存在
                    result.add(projectAchievement);
                }
            }
            PageInfo<ProjectAchievement> pageInfo = new PageInfo<>(result);
            return JsonTools.toResult(0, "成功", pageInfo.getTotal(), pageInfo);
        }
    }

    @GetMapping("/getAchievementByTeacherId")
    public Map<String, Object> getAchievementByTeacherId(
            @RequestParam(defaultValue = "") String teacherId,
            @RequestParam(defaultValue = "") String key,
            @RequestParam(defaultValue = Page.PAGE_INDEX) String page,
            @RequestParam(defaultValue = Page.PAGE_SIZE) String limit
    ){
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        if(key.isEmpty()){
            if(teacherId.isEmpty()){
                return JsonTools.toResult(1, "参数有误", 0, null);
            }
            final List<ProjectAchievement> list = service.findAchievementByTeacherId(Integer.valueOf(teacherId));
            PageInfo<ProjectAchievement> pageInfo = new PageInfo<>(list);
            return JsonTools.toResult(0, "成功", pageInfo.getTotal(), pageInfo);
        }else{
            if(teacherId.isEmpty()){
                return JsonTools.toResult(1, "参数有误", 0, null);
            }
            final List<ProjectAchievement> list = service.findAchievementByTeacherId(Integer.valueOf(teacherId));
            final List<ProjectAchievement> result = new ArrayList<>();
            for(ProjectAchievement projectAchievement: list){
                int[] temp = KMPUtils.kmpNext(key);
                if(KMPUtils.kmpSearch(projectAchievement.getString(), key, temp) != -1){
                    //说明存在
                    result.add(projectAchievement);
                }
            }
            PageInfo<ProjectAchievement> pageInfo = new PageInfo<>(result);
            return JsonTools.toResult(0, "成功", pageInfo.getTotal(), pageInfo);
        }
    }

    @PostMapping("/updateAchievement")
    public Map<String, Object> updateAchievement(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        ProjectAchievement projectAchievement = (ProjectAchievement) CommonController.analyzeJson(properties, new ProjectAchievement());
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
        ProjectAchievement projectAchievement = (ProjectAchievement) CommonController.analyzeJson(properties, new ProjectAchievement());
        if(service.addAchievement(projectAchievement))
            return JsonTools.toResult(0, "添加成功", 0, null);
        return JsonTools.toResult(1, "添加失败", 0, null);
    }
}
