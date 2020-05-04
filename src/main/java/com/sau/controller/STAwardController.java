package com.sau.controller;

import com.alibaba.fastjson.JSONObject;
import com.sau.entity.ScienceTechnologyAchievementAward;
import com.sau.global.Global;
import com.sau.global.GlobalKey;
import com.sau.global.JsonTools;
import com.sau.service.STAwardService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@RestController
@RequestMapping("/stAward")
public class STAwardController {
    
    @Resource
    STAwardService stAwardService;

    @GetMapping("/getSTAwardByStudentId")
    public Map<String, Object> getSTAwardByStudentId(@RequestParam(defaultValue = "") String studentId){
        if(studentId.isEmpty()){
            return JsonTools.toResult(1, "参数有误", 0, null);
        }
        final List<ScienceTechnologyAchievementAward> list = stAwardService.findSTAwardByStudentId(Integer.valueOf(studentId));
        return JsonTools.toResult(0, "成功", list.size(), list);
    }

    @GetMapping("/getSTAwardByTeacherId")
    public Map<String, Object> getSTAwardByTeacherId(@RequestParam(defaultValue = "") String teacherId){
        if(teacherId.isEmpty()){
            return JsonTools.toResult(1, "参数有误", 0, null);
        }
        final List<ScienceTechnologyAchievementAward> list = stAwardService.findSTAwardByTeacherId(Integer.valueOf(teacherId));
        return JsonTools.toResult(0, "成功", list.size(), list);
    }

    @PostMapping("/updateSTAward")
    public Map<String, Object> updateSTAward(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        ScienceTechnologyAchievementAward scienceTechnologyAchievementAward = analyzeJson(properties);
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
        ScienceTechnologyAchievementAward scienceTechnologyAchievementAward = analyzeJson(properties);
        if(stAwardService.addSTAward(scienceTechnologyAchievementAward))
            return JsonTools.toResult(0, "添加成功", 0, null);
        return JsonTools.toResult(1, "添加失败", 0, null);
    }

    private ScienceTechnologyAchievementAward analyzeJson(Properties properties){
        final String json = properties.getProperty("json");
        JSONObject jsonObject = JSONObject.parseObject(json);
        return getSTAward(jsonObject);
    }

    private ScienceTechnologyAchievementAward getSTAward(JSONObject jsonObject){
        ScienceTechnologyAchievementAward scienceTechnologyAchievementAward = new ScienceTechnologyAchievementAward();
        final String id = jsonObject.getString(GlobalKey.ID);
        if(id != null && !id.isEmpty()){
            scienceTechnologyAchievementAward.setId(Integer.parseInt(id));
        }
        final String name = jsonObject.getString(GlobalKey.NAME);
        if(name != null && !name.isEmpty()){
            scienceTechnologyAchievementAward.setName(name);
        }
        final String description = jsonObject.getString(GlobalKey.DESCRIPTION);
        if(description != null && !description.isEmpty()){
            scienceTechnologyAchievementAward.setDescription(description);
        }
        final String fileId = jsonObject.getString(GlobalKey.FILE_ID);
        if(fileId != null && !fileId.isEmpty()){
            scienceTechnologyAchievementAward.setFileId(Integer.parseInt(fileId));
        }
        final String studentId = jsonObject.getString(GlobalKey.STUDENT_ID);
        if(studentId != null && !studentId.isEmpty()){
            scienceTechnologyAchievementAward.setStudentId(Integer.parseInt(studentId));
        }
        final String teacherId = jsonObject.getString(GlobalKey.TEACHER_ID);
        if(teacherId != null && !teacherId.isEmpty()){
            scienceTechnologyAchievementAward.setTeacherId(Integer.parseInt(teacherId));
        }
        return scienceTechnologyAchievementAward;
    }
}
