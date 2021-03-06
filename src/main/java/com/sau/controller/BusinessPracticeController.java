package com.sau.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sau.entity.BusinessPractice;
import com.sau.entity.Page;
import com.sau.global.Global;
import com.sau.global.GlobalKey;
import com.sau.global.JsonTools;
import com.sau.service.BusinessPracticeService;
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
@RequestMapping("/businessPractice")
public class BusinessPracticeController {

    @Resource
    BusinessPracticeService businessPracticeService;

    @GetMapping("/getPracticeByStudentId")
    public Map<String, Object> getPracticeByStudentId(
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
            final List<BusinessPractice> list = businessPracticeService.getPracticeByStudentId(Integer.valueOf(studentId));
            PageInfo<BusinessPractice> pageInfo = new PageInfo<>(list);
            return JsonTools.toResult(0, "成功", pageInfo.getTotal(), pageInfo);
        }else {
            if(studentId.isEmpty()){
                return JsonTools.toResult(1, "参数有误", 0, null);
            }
            final List<BusinessPractice> list = businessPracticeService.getPracticeByStudentId(Integer.valueOf(studentId));
            final List<BusinessPractice> result = new ArrayList<>();
            for(BusinessPractice businessPractice: list){
                int[] temp = KMPUtils.kmpNext(key);
                if(KMPUtils.kmpSearch(businessPractice.getString(), key, temp) != -1){
                    //说明存在
                    result.add(businessPractice);
                }
            }
            PageInfo<BusinessPractice> pageInfo = new PageInfo<>(result);
            return JsonTools.toResult(0, "成功", pageInfo.getTotal(), pageInfo);
        }
    }

    @PostMapping("/updatePractice")
    public Map<String, Object> updatePractice(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        BusinessPractice businessPractice = analyzeJson(properties);
        if(businessPractice.getId() == null){
            return JsonTools.toResult(1, "id不能为空", 0, null);
        }
        if(businessPracticeService.updatePractice(businessPractice))
            return JsonTools.toResult(0, "修改成功", 0, null);
        return JsonTools.toResult(1, "修改失败", 0, null);
    }

    @PostMapping("/deletePractice")
    public Map<String, Object> deletePractice(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        String[] idArr = CommonController.delete(properties);
        if(businessPracticeService.deletePracticeById(Global.stringFormatInteger(idArr))){
            return JsonTools.toResult(0, "删除成功", 0, null);
        }
        return JsonTools.toResult(1, "删除失败", 0, null);
    }

    @PostMapping("/addPractice")
    public Map<String, Object> addPractice(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        BusinessPractice businessPractice = analyzeJson(properties);
        if(businessPracticeService.addPractice(businessPractice))
            return JsonTools.toResult(0, "添加成功", 0, null);
        return JsonTools.toResult(1, "添加失败", 0, null);
    }

    private BusinessPractice analyzeJson(Properties properties){
        final String json = properties.getProperty("json");
        JSONObject jsonObject = JSONObject.parseObject(json);
        return getBusinessPractice(jsonObject);
    }

    private BusinessPractice getBusinessPractice(JSONObject jsonObject){
        BusinessPractice businessPractice = new BusinessPractice();
        final String id = jsonObject.getString(GlobalKey.ID);
        if(id != null && !id.isEmpty()){
            businessPractice.setId(Integer.parseInt(id));
        }
        final String name = jsonObject.getString(GlobalKey.NAME);
        if(name != null && !name.isEmpty()){
            businessPractice.setName(name);
        }
        final String description = jsonObject.getString(GlobalKey.DESCRIPTION);
        if(description != null && !description.isEmpty()){
            businessPractice.setDescription(description);
        }
        final String studentId = jsonObject.getString(GlobalKey.STUDENT_ID);
        if(studentId != null && !studentId.isEmpty()){
            businessPractice.setStudentId(Integer.parseInt(studentId));
        }
        return businessPractice;
    }
}
