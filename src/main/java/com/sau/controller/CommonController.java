package com.sau.controller;

import com.alibaba.fastjson.JSONObject;
import com.sau.entity.FileBinding;
import com.sau.global.GlobalKey;
import com.sau.utils.CommonUtil;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class CommonController {

    public static String[] delete(Properties properties){
        final String json = properties.getProperty("json");
        JSONObject jsonObject = JSONObject.parseObject(json);
        String ids = jsonObject.getString(GlobalKey.IDS).replace("[", "").replace("]", "");
        return ids.split(",");
    }

    private static Object saveFile(MultipartFile file){
        if (file.isEmpty()) {
            return false;
        }
        String fileName = file.getOriginalFilename();
        int size = (int) file.getSize();
        System.out.println(fileName + "-->" + size);

        String absolutePath = "/"+fileName;
        File dest = new File(CommonUtil.PATH + absolutePath);
        if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
            if(dest.getParentFile().mkdir())
                return Boolean.FALSE;
        }
        try {
            file.transferTo(dest); //保存文件
            return new FileBinding(fileName, absolutePath);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }

    static FileBinding getFile(MultipartFile file){
        if(file != null){
            Object result = CommonController.saveFile(file);
            if(result instanceof Boolean)
                return null;
            else
                return (FileBinding) result;
        }else
            return null;
    }
}
