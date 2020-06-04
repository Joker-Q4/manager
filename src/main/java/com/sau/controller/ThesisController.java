package com.sau.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sau.entity.Page;
import com.sau.entity.Thesis;
import com.sau.global.Global;
import com.sau.global.JsonTools;
import com.sau.service.ThesisService;
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
@RequestMapping("/thesis")
public class ThesisController {

    @Resource
    ThesisService thesisService;

    @GetMapping("/getThesisByStudentId")
    public Map<String, Object> getThesisByStudentId(
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
            final List<Thesis> list = thesisService.getThesisByStudentId(Integer.valueOf(studentId));
            PageInfo<Thesis> pageInfo = new PageInfo<>(list);
            return JsonTools.toResult(0, "成功", pageInfo.getTotal(), pageInfo);
        }else {
            if(studentId.isEmpty()){
                return JsonTools.toResult(1, "参数有误", 0, null);
            }
            final List<Thesis> list = thesisService.getThesisByStudentId(Integer.valueOf(studentId));
            final List<Thesis> result = new ArrayList<>();
            for(Thesis thesis: list){
                int[] temp = KMPUtils.kmpNext(key);
                if(KMPUtils.kmpSearch(thesis.getString(), key, temp) != -1){
                    //说明存在
                    result.add(thesis);
                }
            }
            PageInfo<Thesis> pageInfo = new PageInfo<>(result);
            return JsonTools.toResult(0, "成功", pageInfo.getTotal(), pageInfo);
        }
    }

    @GetMapping("/getThesisByTeacherId")
    public Map<String, Object> getThesisByTeacherId(
            @RequestParam(defaultValue = "") String teacherId,
            @RequestParam(defaultValue = "") String key,
            @RequestParam(defaultValue = Page.PAGE_INDEX) String page,
            @RequestParam(defaultValue = Page.PAGE_SIZE) String limit
    ){
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        if(key.isEmpty()) {
            if (teacherId.isEmpty()) {
                return JsonTools.toResult(1, "参数有误", 0, null);
            }
            final List<Thesis> list = thesisService.getThesisByTeacherId(Integer.valueOf(teacherId));
            PageInfo<Thesis> pageInfo = new PageInfo<>(list);
            return JsonTools.toResult(0, "成功", pageInfo.getTotal(), pageInfo);
        }else {
            if (teacherId.isEmpty()) {
                return JsonTools.toResult(1, "参数有误", 0, null);
            }
            final List<Thesis> list = thesisService.getThesisByTeacherId(Integer.valueOf(teacherId));
            final List<Thesis> result = new ArrayList<>();
            for(Thesis thesis: list){
                int[] temp = KMPUtils.kmpNext(key);
                if(KMPUtils.kmpSearch(thesis.getString(), key, temp) != -1){
                    //说明存在
                    result.add(thesis);
                }
            }
            PageInfo<Thesis> pageInfo = new PageInfo<>(result);
            return JsonTools.toResult(0, "成功", pageInfo.getTotal(), pageInfo);
        }
    }

    @PostMapping("/updateThesis")
    public Map<String, Object> updateThesis(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        Thesis thesis = (Thesis) CommonController.analyzeJson(properties, new Thesis());
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
        Thesis thesis = (Thesis) CommonController.analyzeJson(properties, new Thesis());
        if(thesisService.addThesis(thesis))
            return JsonTools.toResult(0, "添加成功", 0, null);
        return JsonTools.toResult(1, "添加失败", 0, null);
    }
}
