package com.sau.controller;

import com.alibaba.fastjson.JSONObject;
import com.sau.entity.Grade;
import com.sau.entity.Prize;
import com.sau.global.Global;
import com.sau.global.GlobalKey;
import com.sau.global.JsonTools;
import com.sau.service.PrizeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@RestController
public class PrizeController {

    @Resource
    PrizeService prizeService;

    @GetMapping("/getPrizeByStudentId")
    public Map<String, Object> getPrizeByStudentId(@RequestParam(defaultValue = "") String studentId){
        if(studentId.isEmpty()){
            return JsonTools.toResult(1, "参数有误", 0, null);
        }
        final List<Prize> list = prizeService.getPrizeByStudentId(Integer.valueOf(studentId));
        return JsonTools.toResult(0, "success", list.size(), list);
    }

    @PostMapping("/updateGrade")
    public Map<String, Object> updateGrade(
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
        if(id != null && !id.isEmpty()){
            prize.setName(name);
        }
        final String description = jsonObject.getString(GlobalKey.DESCRIPTION);
        if(id != null && !id.isEmpty()){
            prize.setDescription(description);
        }
        return prize;
    }
}
