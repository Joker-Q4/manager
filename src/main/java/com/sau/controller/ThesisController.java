package com.sau.controller;

import com.alibaba.fastjson.JSONObject;
import com.sau.entity.Thesis;
import com.sau.global.Global;
import com.sau.global.GlobalKey;
import com.sau.global.JsonTools;
import com.sau.service.ThesisService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@RestController
@RequestMapping("/thesis")
public class ThesisController {

    @Resource
    ThesisService thesisService;

    @GetMapping("/getThesisByStudentId")
    public Map<String, Object> getThesisByStudentId(@RequestParam(defaultValue = "") String studentId){
        if(studentId.isEmpty()){
            return JsonTools.toResult(1, "参数有误", 0, null);
        }
        final List<Thesis> list = thesisService.getThesisByStudentId(Integer.valueOf(studentId));
        return JsonTools.toResult(0, "success", list.size(), list);
    }

    @PostMapping("/updateThesis")
    public Map<String, Object> updateThesis(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        Thesis thesis = analyzeJson(properties);
        if(thesis.getId() == null){
            return JsonTools.toResult(1, "id不能为空", 0, null);
        }
        if(thesisService.updateThesis(thesis))
            return JsonTools.toResult(0, "修改成功", 0, null);
        return JsonTools.toResult(1, "修改失败", 0, null);
    }

    @PostMapping("/deleteThesis")
    public Map<String, Object> deleteThesis(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        String[] idArr = CommonController.delete(properties);
        if(thesisService.deleteThesis(Global.stringFormatInteger(idArr))){
            return JsonTools.toResult(0, "删除成功", 0, null);
        }
        return JsonTools.toResult(1, "删除失败", 0, null);
    }

    @PostMapping("/addThesis")
    public Map<String, Object> addThesis(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        Thesis thesis = analyzeJson(properties);
        if(thesisService.addThesis(thesis))
            return JsonTools.toResult(0, "添加成功", 0, null);
        return JsonTools.toResult(1, "添加失败", 0, null);
    }

    private Thesis analyzeJson(Properties properties){
        final String json = properties.getProperty("json");
        JSONObject jsonObject = JSONObject.parseObject(json);
        return getThesis(jsonObject);
    }

    private Thesis getThesis(JSONObject jsonObject){
        Thesis thesis = new Thesis();
        final String id = jsonObject.getString(GlobalKey.ID);
        if(id != null && !id.isEmpty()){
            thesis.setId(Integer.parseInt(id));
        }
        final String title = jsonObject.getString(GlobalKey.TITLE);
        if(title != null && !title.isEmpty()){
            thesis.setTitle(title);
        }
        final String description = jsonObject.getString(GlobalKey.DESCRIPTION);
        if(description != null && !description.isEmpty()){
            thesis.setDescription(description);
        }
        final String studentId = jsonObject.getString(GlobalKey.STUDENT_ID);
        if(studentId != null && !studentId.isEmpty()){
            thesis.setStudentId(Integer.parseInt(studentId));
        }
        return thesis;
    }
}
