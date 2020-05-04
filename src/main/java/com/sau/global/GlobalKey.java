package com.sau.global;

import java.util.ArrayList;
import java.util.List;

public class GlobalKey {


    public static String IDS = "ids";           //多个主键的数组

    public static String ID = "id";                        //主键
    public static String NAME = "name";                    //姓名
    public static String TITLE = "title";                  //姓名
    public static String SEX = "sex";                      //性别
    public static String PHONE = "phone";                  //联系方式
    public static String ADDRESS = "address";              //家庭住址
    public static String DESCRIPTION = "description";      //详细描述
    public static String LOCATION = "location";            //实践地址
    public static String TIME = "time";                    //活动时间
    public static String CREATE_TIME = "create_time";      //创建时间
    public static String ACADEMIC_DEGREE = "academicDegree";      //学位

    public static String COMBINED_LANGUAGE = "combinedLanguage";            //C语言
    public static String COMBINED_LANGUAGE_PLUS = "combinedLanguagePlus";   //C++
    public static String ADVANCED_MATHEMATICS = "advancedMathematics";      //高等数学
    public static String ENGLISH = "english";                               //英语
    public static String DATA_STRUCTURE = "dataStructure";                  //数据结构
    public static String JAVA = "java";                                     //Java
    public static String COMPUTER_PRINCIPLES = "computerPrinciples";        //计算机原理
    public static String COMPUTER_NETWORK = "computerNetwork";              //计算机网络
    public static String ORACLE = "oracle";                                 //oracle
    public static String WEB = "web";                                       //web
    public static String STUDENT_ID = "studentId";                          //当前学生
    public static String TEACHER_ID = "teacherId";                          //当前教师
    public static String FILE_ID = "fileId";                                //当前文件

    public static List<String> getGradeString(){
        List<String> list = new ArrayList<>();
        list.add(COMBINED_LANGUAGE);
        list.add(COMBINED_LANGUAGE_PLUS);
        list.add(ADVANCED_MATHEMATICS);
        list.add(ENGLISH);
        list.add(DATA_STRUCTURE);
        list.add(JAVA);
        list.add(COMPUTER_PRINCIPLES);
        list.add(COMPUTER_NETWORK);
        list.add(ORACLE);
        list.add(WEB);
        return list;
    }

}
