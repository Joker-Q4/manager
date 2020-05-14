package com.sau.controller;

import com.alibaba.fastjson.JSONObject;
import com.sau.entity.Grade;
import com.sau.entity.Prize;
import com.sau.global.Global;
import com.sau.global.GlobalKey;
import com.sau.global.JsonTools;
import com.sau.service.PrizeService;
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
@RequestMapping("/prize")
public class PrizeController {

    @Resource
    PrizeService prizeService;

    @GetMapping("/getPrizeByStudentId")
    public Map<String, Object> getPrizeByStudentId(
            @RequestParam(defaultValue = "") String studentId,
            @RequestParam(defaultValue = "") String key
    ){
        if(key.isEmpty()){
            if(studentId.isEmpty()){
                return JsonTools.toResult(1, "参数有误", 0, null);
            }
            final List<Prize> list = prizeService.getPrizeByStudentId(Integer.valueOf(studentId));
            return JsonTools.toResult(0, "success", list.size(), list);
        }else {
            if(studentId.isEmpty()){
                return JsonTools.toResult(1, "参数有误", 0, null);
            }
            final List<Prize> list = prizeService.getPrizeByStudentId(Integer.valueOf(studentId));
            final List<Prize> result = new ArrayList<>();
            for(Prize prize: list){
                int[] temp = KMPUtils.kmpNext(key);
                if(KMPUtils.kmpSearch(prize.getString(), key, temp) != -1){
                    //说明存在
                    result.add(prize);
                }
            }
            return JsonTools.toResult(0, "成功", result.size(), result);
        }
    }

    @PostMapping("/updatePrize")
    public Map<String, Object> updatePrize(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        Prize prize = analyzeJson(properties);
        if(prize.getId() == null){
            return JsonTools.toResult(1, "id不能为空", 0, null);
        }
        if(prizeService.updatePrize(prize))
            return JsonTools.toResult(0, "修改成功", 0, null);
        return JsonTools.toResult(1, "修改失败", 0, null);
    }

    @PostMapping("/deletePrize")
    public Map<String, Object> deletePrize(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        String[] idArr = CommonController.delete(properties);
        if(prizeService.deletePrizes(Global.stringFormatInteger(idArr))){
            return JsonTools.toResult(0, "删除成功", 0, null);
        }
        return JsonTools.toResult(1, "删除失败", 0, null);
    }

    @PostMapping("/addPrize")
    public Map<String, Object> addPrize(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        Prize prize = analyzeJson(properties);
        if(prizeService.addPrize(prize))
            return JsonTools.toResult(0, "添加成功", 0, null);
        return JsonTools.toResult(1, "添加失败", 0, null);
    }

    private Prize analyzeJson(Properties properties){
        final String json = properties.getProperty("json");
        JSONObject jsonObject = JSONObject.parseObject(json);
        return getPrize(jsonObject);
    }

    private Prize getPrize(JSONObject jsonObject){
        Prize prize = new Prize();
        final String id = jsonObject.getString(GlobalKey.ID);
        if(id != null && !id.isEmpty()){
            prize.setId(Integer.parseInt(id));
        }
        final String name = jsonObject.getString(GlobalKey.NAME);
        if(name != null && !name.isEmpty()){
            prize.setName(name);
        }
        final String description = jsonObject.getString(GlobalKey.DESCRIPTION);
        if(description != null && !description.isEmpty()){
            prize.setDescription(description);
        }
        final String studentId = jsonObject.getString(GlobalKey.STUDENT_ID);
        if(studentId != null && !studentId.isEmpty()){
            prize.setStudentId(Integer.parseInt(studentId));
        }
        return prize;
    }
}
