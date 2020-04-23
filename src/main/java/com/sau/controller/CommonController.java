package com.sau.controller;

import com.alibaba.fastjson.JSONObject;
import com.sau.global.GlobalKey;

import java.util.Properties;

public class CommonController {

    public static String[] delete(Properties properties){
        final String json = properties.getProperty("json");
        JSONObject jsonObject = JSONObject.parseObject(json);
        String ids = jsonObject.getString(GlobalKey.IDS).replace("[", "").replace("]", "");
        return ids.split(",");
    }
}
