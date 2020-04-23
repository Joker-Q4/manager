package com.sau.controller;

import com.alibaba.fastjson.JSONObject;
import com.sau.entity.Student;
import com.sau.global.Global;
import com.sau.global.GlobalKey;
import com.sau.global.JsonTools;
import com.sau.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    StudentService studentService;

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @GetMapping("/queryAllStudents")
    public Map<String, Object> queryAllStudents(@RequestParam(defaultValue = "") String studentId){
        if(studentId.isEmpty()){
            final List<Student> students = studentService.getAllStudents();
            return JsonTools.toResult(0, "success", students.size(), students);
        }
        Student student = studentService.getStudentById(Integer.valueOf(studentId));
        if(student != null)
            return JsonTools.toResult(0, "success", 1, student);
        else
            return JsonTools.toResult(0, "success", 0, null);
    }

    @PostMapping("/deleteStudents")
    public Map<String, Object> deleteStudents(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        String[] idArr = CommonController.delete(properties);
        if(studentService.deleteStudents(Global.stringFormatInteger(idArr))){
            return JsonTools.toResult(0, "删除成功", 0, null);
        }
        return JsonTools.toResult(1, "删除失败", 0, null);
    }

    @GetMapping("/deleteStudent")
    public Map<String, Object> deleteStudent(@RequestParam(defaultValue = "") String studentId){
        if(studentId.isEmpty()){
            return JsonTools.toResult(0, "studentId不能为空", 0, null);
        }
        if(studentService.deleteStudent(Integer.valueOf(studentId)))
            return JsonTools.toResult(0, "success", 0, null);
        else
            return JsonTools.toResult(1, "fail", 0, null);
    }

    @PostMapping("/updateStudent")
    public Map<String, Object> updateStudent(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        Student student = analyzeJson(properties);
        if(student.getId() == null){
            return JsonTools.toResult(1, "id不能为空", 0, null);
        }
        if(studentService.updateStudent(student))
            return JsonTools.toResult(0, "修改成功", 0, null);
        return JsonTools.toResult(1, "修改失败", 0, null);
    }

    @PostMapping("/addStudent")
    public Map<String, Object> addStudent(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        Student student = analyzeJson(properties);
        if(studentService.addStudent(student))
            return JsonTools.toResult(0, "添加成功", 0, null);
        return JsonTools.toResult(1, "添加失败", 0, null);
    }

    private Student analyzeJson(Properties properties){
        final String json = properties.getProperty("json");
        JSONObject jsonObject = JSONObject.parseObject(json);
        return getStudent(jsonObject);
    }

    private Student getStudent(JSONObject jsonObject){
        Student student = new Student();
        final String id = jsonObject.getString(GlobalKey.ID);
        if(id != null && !id.isEmpty()){
            student.setId(Integer.parseInt(id));
        }
        final String name = jsonObject.getString(GlobalKey.NAME);
        if(name != null && !name.isEmpty()){
            student.setName(name);
        }
        final String sex = jsonObject.getString(GlobalKey.SEX);
        if(sex != null && !sex.isEmpty()){
            student.setSex(sex);
        }
        final String phoneNumber = jsonObject.getString(GlobalKey.PHONE);
        if(phoneNumber != null && !phoneNumber.isEmpty()){
            student.setPhoneNumber(phoneNumber);
        }
        final String address = jsonObject.getString(GlobalKey.ADDRESS);
        if(address != null && !address.isEmpty()){
            student.setAddress(address);
        }
        return student;
    }
}
