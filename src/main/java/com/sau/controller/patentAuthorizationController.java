package com.sau.controller;

import com.alibaba.fastjson.JSONObject;
import com.sau.entity.PatentAuthorization;
import com.sau.global.Global;
import com.sau.global.GlobalKey;
import com.sau.global.JsonTools;
import com.sau.service.PatentAuthorizationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@RestController
@RequestMapping("/patentAuthorization")
public class patentAuthorizationController {

    @Resource
    PatentAuthorizationService service;

    @GetMapping("/getAuthorizationByStudentId")
    public Map<String, Object> getAuthorizationByStudentId(@RequestParam(defaultValue = "") String studentId){
        if(studentId.isEmpty()){
            return JsonTools.toResult(1, "参数有误", 0, null);
        }
        final List<PatentAuthorization> list = service.findAuthorizationByStudentId(Integer.valueOf(studentId));
        return JsonTools.toResult(0, "成功", list.size(), list);
    }

    @GetMapping("/getAuthorizationByTeacherId")
    public Map<String, Object> getAuthorizationByTeacherId(@RequestParam(defaultValue = "") String teacherId){
        if(teacherId.isEmpty()){
            return JsonTools.toResult(1, "参数有误", 0, null);
        }
        final List<PatentAuthorization> list = service.findAuthorizationByTeacherId(Integer.valueOf(teacherId));
        return JsonTools.toResult(0, "成功", list.size(), list);
    }

    @PostMapping("/updateAuthorization")
    public Map<String, Object> updateAuthorization(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        PatentAuthorization patentAuthorization = analyzeJson(properties);
        if(patentAuthorization.getId() == null){
            return JsonTools.toResult(1, "id不能为空", 0, null);
        }
        if(service.updateAuthorization(patentAuthorization))
            return JsonTools.toResult(0, "修改成功", 0, null);
        return JsonTools.toResult(1, "修改失败", 0, null);
    }

    @PostMapping("/deleteAuthorization")
    public Map<String, Object> deleteAuthorization(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        String[] idArr = CommonController.delete(properties);
        if(service.deleteAuthorizations(Global.stringFormatInteger(idArr))){
            return JsonTools.toResult(0, "删除成功", 0, null);
        }
        return JsonTools.toResult(1, "删除失败", 0, null);
    }

    @PostMapping("/addAuthorization")
    public Map<String, Object> addAuthorization(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        PatentAuthorization patentAuthorization = analyzeJson(properties);
        if(service.addAuthorization(patentAuthorization))
            return JsonTools.toResult(0, "添加成功", 0, null);
        return JsonTools.toResult(1, "添加失败", 0, null);
    }

    private PatentAuthorization analyzeJson(Properties properties){
        final String json = properties.getProperty("json");
        JSONObject jsonObject = JSONObject.parseObject(json);
        return getAuthorization(jsonObject);
    }

    private PatentAuthorization getAuthorization(JSONObject jsonObject){
        PatentAuthorization patentAuthorization = new PatentAuthorization();
        final String id = jsonObject.getString(GlobalKey.ID);
        if(id != null && !id.isEmpty()){
            patentAuthorization.setId(Integer.parseInt(id));
        }
        final String name = jsonObject.getString(GlobalKey.NAME);
        if(name != null && !name.isEmpty()){
            patentAuthorization.setName(name);
        }
        final String description = jsonObject.getString(GlobalKey.DESCRIPTION);
        if(description != null && !description.isEmpty()){
            patentAuthorization.setDescription(description);
        }
        final String fileId = jsonObject.getString(GlobalKey.FILE_ID);
        if(fileId != null && !fileId.isEmpty()){
            patentAuthorization.setFileId(Integer.parseInt(fileId));
        }
        final String studentId = jsonObject.getString(GlobalKey.STUDENT_ID);
        if(studentId != null && !studentId.isEmpty()){
            patentAuthorization.setStudentId(Integer.parseInt(studentId));
        }
        final String teacherId = jsonObject.getString(GlobalKey.TEACHER_ID);
        if(teacherId != null && !teacherId.isEmpty()){
            patentAuthorization.setTeacherId(Integer.parseInt(teacherId));
        }
        return patentAuthorization;
    }
}
