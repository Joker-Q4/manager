package com.sau.controller;

import com.alibaba.fastjson.JSONObject;
import com.sau.entity.CommonEntity;
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

    static CommonEntity analyzeJson(Properties properties, Object object){
        final String json = properties.getProperty("json");
        JSONObject jsonObject = JSONObject.parseObject(json);
        return CommonController.getEntity(jsonObject, object);
    }

    private static CommonEntity getEntity(JSONObject jsonObject, Object object){
        if(object instanceof CommonEntity){
            CommonEntity commonEntity = (CommonEntity) object;
            final String id = jsonObject.getString(GlobalKey.ID);
            if(id != null && !id.isEmpty()){
                commonEntity.setId(Integer.parseInt(id));
            }
            final String name = jsonObject.getString(GlobalKey.NAME);
            if(name != null && !name.isEmpty()){
                commonEntity.setName(name);
            }
            final String title = jsonObject.getString(GlobalKey.TITLE);
            if(title != null && !title.isEmpty()){
                commonEntity.setTitle(title);
            }
            final String description = jsonObject.getString(GlobalKey.DESCRIPTION);
            if(description != null && !description.isEmpty()){
                commonEntity.setDescription(description);
            }
            final String fileId = jsonObject.getString(GlobalKey.FILE_ID);
            if(fileId != null && !fileId.isEmpty()){
                commonEntity.setFileId(Integer.parseInt(fileId));
            }
            final String studentId = jsonObject.getString(GlobalKey.STUDENT_ID);
            if(studentId != null && !studentId.isEmpty()){
                commonEntity.setStudentId(Integer.parseInt(studentId));
            }
            final String teacherId = jsonObject.getString(GlobalKey.TEACHER_ID);
            if(teacherId != null && !teacherId.isEmpty()){
                commonEntity.setTeacherId(Integer.parseInt(teacherId));
            }
            return commonEntity;
        }else {
            return null;
        }
    }
}
