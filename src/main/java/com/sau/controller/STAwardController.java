package com.sau.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sau.entity.Page;
import com.sau.entity.ScienceTechnologyAchievementAward;
import com.sau.global.Global;
import com.sau.global.JsonTools;
import com.sau.service.STAwardService;
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
@RequestMapping("/stAward")
public class STAwardController {
    
    @Resource
    STAwardService stAwardService;

    @GetMapping("/getSTAwardByStudentId")
    public Map<String, Object> getSTAwardByStudentId(
            @RequestParam(defaultValue = "") String studentId,
            @RequestParam(defaultValue = "") String key,
            @RequestParam(defaultValue = Page.PAGE_INDEX) String page,
            @RequestParam(defaultValue = Page.PAGE_SIZE) String limit
    ){
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        if(key.isEmpty()){
            if(studentId.isEmpty()){
                return JsonTools.toResult(1, "参数有误", 0, null);
            }
            final List<ScienceTechnologyAchievementAward> list = stAwardService.findSTAwardByStudentId(Integer.valueOf(studentId));
            PageInfo<ScienceTechnologyAchievementAward> pageInfo = new PageInfo<>(list);
            return JsonTools.toResult(0, "成功", pageInfo.getTotal(), pageInfo);
        }else {
            if(studentId.isEmpty()){
                return JsonTools.toResult(1, "参数有误", 0, null);
            }
            final List<ScienceTechnologyAchievementAward> list = stAwardService.findSTAwardByStudentId(Integer.valueOf(studentId));
            final List<ScienceTechnologyAchievementAward> result = new ArrayList<>();
            for(ScienceTechnologyAchievementAward scienceTechnologyAchievementAward: list){
                int[] temp = KMPUtils.kmpNext(key);
                if(KMPUtils.kmpSearch(scienceTechnologyAchievementAward.getString(), key, temp) != -1){
                    //说明存在
                    result.add(scienceTechnologyAchievementAward);
                }
            }
            PageInfo<ScienceTechnologyAchievementAward> pageInfo = new PageInfo<>(result);
            return JsonTools.toResult(0, "成功", pageInfo.getTotal(), pageInfo);
        }
    }

    @GetMapping("/getSTAwardByTeacherId")
    public Map<String, Object> getSTAwardByTeacherId(
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
            final List<ScienceTechnologyAchievementAward> list = stAwardService.findSTAwardByTeacherId(Integer.valueOf(teacherId));
            PageInfo<ScienceTechnologyAchievementAward> pageInfo = new PageInfo<>(list);
            return JsonTools.toResult(0, "成功", pageInfo.getTotal(), pageInfo);
        }else {
            if(teacherId.isEmpty()){
                return JsonTools.toResult(1, "参数有误", 0, null);
            }
            final List<ScienceTechnologyAchievementAward> list = stAwardService.findSTAwardByTeacherId(Integer.valueOf(teacherId));
            final List<ScienceTechnologyAchievementAward> result = new ArrayList<>();
            for(ScienceTechnologyAchievementAward scienceTechnologyAchievementAward: list){
                int[] temp = KMPUtils.kmpNext(key);
                if(KMPUtils.kmpSearch(scienceTechnologyAchievementAward.getString(), key, temp) != -1){
                    //说明存在
                    result.add(scienceTechnologyAchievementAward);
                }
            }
            PageInfo<ScienceTechnologyAchievementAward> pageInfo = new PageInfo<>(result);
            return JsonTools.toResult(0, "成功", pageInfo.getTotal(), pageInfo);
        }
    }

    @PostMapping("/updateSTAward")
    public Map<String, Object> updateSTAward(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        ScienceTechnologyAchievementAward scienceTechnologyAchievementAward = (ScienceTechnologyAchievementAward) CommonController.analyzeJson(properties, new ScienceTechnologyAchievementAward());
        if(scienceTechnologyAchievementAward.getId() == null){
            return JsonTools.toResult(1, "id不能为空", 0, null);
        }
        if(stAwardService.updateSTAward(scienceTechnologyAchievementAward))
            return JsonTools.toResult(0, "修改成功", 0, null);
        return JsonTools.toResult(1, "修改失败", 0, null);
    }

    @PostMapping("/deleteSTAward")
    public Map<String, Object> deleteSTAward(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        String[] idArr = CommonController.delete(properties);
        if(stAwardService.deleteSTAwards(Global.stringFormatInteger(idArr))){
            return JsonTools.toResult(0, "删除成功", 0, null);
        }
        return JsonTools.toResult(1, "删除失败", 0, null);
    }

    @PostMapping("/addSTAward")
    public Map<String, Object> addSTAward(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        ScienceTechnologyAchievementAward scienceTechnologyAchievementAward = (ScienceTechnologyAchievementAward) CommonController.analyzeJson(properties, new ScienceTechnologyAchievementAward());
        if(stAwardService.addSTAward(scienceTechnologyAchievementAward))
            return JsonTools.toResult(0, "添加成功", 0, null);
        return JsonTools.toResult(1, "添加失败", 0, null);
    }
}
