package com.sau.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sau.entity.Page;
import com.sau.entity.PatentAuthorization;
import com.sau.global.Global;
import com.sau.global.JsonTools;
import com.sau.service.PatentAuthorizationService;
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
@RequestMapping("/patentAuthorization")
public class PatentAuthorizationController {

    @Resource
    PatentAuthorizationService service;

    @GetMapping("/getAuthorizationByStudentId")
    public Map<String, Object> getAuthorizationByStudentId(
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
            final List<PatentAuthorization> list = service.findAuthorizationByStudentId(Integer.valueOf(studentId));
            PageInfo<PatentAuthorization> pageInfo = new PageInfo<>(list);
            return JsonTools.toResult(0, "成功", pageInfo.getTotal(), pageInfo);
        }else{
            if(studentId.isEmpty()){
                return JsonTools.toResult(1, "参数有误", 0, null);
            }
            final List<PatentAuthorization> list = service.findAuthorizationByStudentId(Integer.valueOf(studentId));
            final List<PatentAuthorization> result = new ArrayList<>();
            for(PatentAuthorization patentAuthorization: list){
                int[] temp = KMPUtils.kmpNext(key);
                if(KMPUtils.kmpSearch(patentAuthorization.getString(), key, temp) != -1){
                    //说明存在
                    result.add(patentAuthorization);
                }
            }
            PageInfo<PatentAuthorization> pageInfo = new PageInfo<>(result);
            return JsonTools.toResult(0, "成功", pageInfo.getTotal(), pageInfo);
        }
    }

    @GetMapping("/getAuthorizationByTeacherId")
    public Map<String, Object> getAuthorizationByTeacherId(
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
            final List<PatentAuthorization> list = service.findAuthorizationByTeacherId(Integer.valueOf(teacherId));
            PageInfo<PatentAuthorization> pageInfo = new PageInfo<>(list);
            return JsonTools.toResult(0, "成功", pageInfo.getTotal(), pageInfo);
        }else{
            if(teacherId.isEmpty()){
                return JsonTools.toResult(1, "参数有误", 0, null);
            }
            final List<PatentAuthorization> list = service.findAuthorizationByTeacherId(Integer.valueOf(teacherId));
            final List<PatentAuthorization> result = new ArrayList<>();
            for(PatentAuthorization patentAuthorization: list){
                int[] temp = KMPUtils.kmpNext(key);
                if(KMPUtils.kmpSearch(patentAuthorization.getString(), key, temp) != -1){
                    //说明存在
                    result.add(patentAuthorization);
                }
            }
            PageInfo<PatentAuthorization> pageInfo = new PageInfo<>(result);
            return JsonTools.toResult(0, "成功", pageInfo.getTotal(), pageInfo);
        }
    }

    @PostMapping("/updateAuthorization")
    public Map<String, Object> updateAuthorization(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        PatentAuthorization patentAuthorization = (PatentAuthorization) CommonController.analyzeJson(properties, new PatentAuthorization());
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
        PatentAuthorization patentAuthorization = (PatentAuthorization) CommonController.analyzeJson(properties, new PatentAuthorization());
        if(service.addAuthorization(patentAuthorization))
            return JsonTools.toResult(0, "添加成功", 0, null);
        return JsonTools.toResult(1, "添加失败", 0, null);
    }
}
