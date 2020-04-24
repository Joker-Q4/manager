package com.sau.global;

import java.util.ArrayList;
import java.util.List;

public class GlobalKey {

    public static String PROJECT_ID = "id";                      //项目主键
    public static String PROJECT_NAME = "name";                  //项目名称
    public static String PROJECT_APPLICANT = "applicant";        //申请者
    public static String PROJECT_CONTENT = "content";            //内容
    public static String PROJECT_FUNDS = "funds";                //预计经费
    public static String PROJECT_T_STATE= "teacherState";          //状态
    public static String PROJECT_T_BACK = "teacherBack";     //退回原因
    public static String PROJECT_M_STATE= "managerState";          //状态
    public static String PROJECT_M_BACK = "managerBack";       //退回原因
    public static String PROJECT_CREATE_TIME = "createTime";     //创建时间
    public static String PROJECT_UPDATE_TIME = "updateTime";     //修改时间


    public static String ENTREPRENEUR_ACCOUNT = "entrepreneurAccount";          //创业者账号
    public static String ENTREPRENEUR_NAME = "entrepreneurName";          //创业者账号
    public static String ENTREPRENEUR_PASSWORD = "entrepreneurPassword";       //创业者密码
    public static String ENTREPRENEUR_SEX = "entrepreneurSex";                 //创业者性别
    public static String ENTREPRENEUR_PHONE= "entrepreneurPhone";              //创业者联系方式
    public static String ENTREPRENEUR_ADDRESS = "entrepreneurAddress";         //创业者地址
    public static String ENTREPRENEUR_RESUME = "entrepreneurResume";           //创业者个人简历
    public static String ENTREPRENEUR_STATE = "currentState";              //创业者绑定教师状态
    public static String ENTREPRENEUR_TEACHER_ACCOUNT = "teacherAccount";         //创业者绑定教师账号


    public static String TEACHER_ACCOUNT = "teacherAccount";         //教师账号
    public static String TEACHER_NAME = "teacherName";               //教师姓名
    public static String TEACHER_PASSWORD = "teacherPassword";       //教师密码
    public static String TEACHER_SEX = "teacherSex";                 //教师性别
    public static String TEACHER_PHONE= "teacherPhone";              //教师联系方式
    public static String TEACHER_ADDRESS = "teacherAddress";         //教师地址
    public static String TEACHER_RESUME = "teacherResume";           //教师个人简历



    public static String MANAGER_ACCOUNT = "managerAccount";         //管理员账号
    public static String MANAGER_NAME = "managerName";               //管理员姓名
    public static String MANAGER_PASSWORD = "managerPassword";       //管理员密码
    public static String MANAGER_SEX = "managerSex";                 //管理员性别
    public static String MANAGER_PHONE= "managerPhone";              //管理员联系方式
    public static String MANAGER_ADDRESS = "managerAddress";         //管理员地址
    public static String MANAGER_RESUME = "managerResume";           //管理员个人简历


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
