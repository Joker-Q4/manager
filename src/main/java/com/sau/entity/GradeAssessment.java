package com.sau.entity;

/**
 * 学生各科成绩
 */
public class GradeAssessment {

    private Integer id;
    private String combinedLanguage;       //C语言
    private String combinedLanguagePlus;   //C++
    private String advancedMathematics;    //高等数学
    private String english;                //英语
    private String dataStructure;          //数据结构
    private String java;                   //Java
    private String computerPrinciples;     //计算机原理
    private String computerNetwork;        //计算机网络
    private String oracle;                 //Oracle数据库
    private String web;                    //web应用程序设计
    private Integer studentId;             //所属学生
    private Student student;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCombinedLanguage() {
        return combinedLanguage;
    }

    public void setCombinedLanguage(String combinedLanguage) {
        this.combinedLanguage = combinedLanguage;
    }

    public String getCombinedLanguagePlus() {
        return combinedLanguagePlus;
    }

    public void setCombinedLanguagePlus(String combinedLanguagePlus) {
        this.combinedLanguagePlus = combinedLanguagePlus;
    }

    public String getAdvancedMathematics() {
        return advancedMathematics;
    }

    public void setAdvancedMathematics(String advancedMathematics) {
        this.advancedMathematics = advancedMathematics;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getDataStructure() {
        return dataStructure;
    }

    public void setDataStructure(String dataStructure) {
        this.dataStructure = dataStructure;
    }

    public String getJava() {
        return java;
    }

    public void setJava(String java) {
        this.java = java;
    }

    public String getComputerPrinciples() {
        return computerPrinciples;
    }

    public void setComputerPrinciples(String computerPrinciples) {
        this.computerPrinciples = computerPrinciples;
    }

    public String getComputerNetwork() {
        return computerNetwork;
    }

    public void setComputerNetwork(String computerNetwork) {
        this.computerNetwork = computerNetwork;
    }

    public String getOracle() {
        return oracle;
    }

    public void setOracle(String oracle) {
        this.oracle = oracle;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", combinedLanguage=" + combinedLanguage +
                ", combinedLanguagePlus=" + combinedLanguagePlus +
                ", advancedMathematics=" + advancedMathematics +
                ", english=" + english +
                ", dataStructure=" + dataStructure +
                ", java=" + java +
                ", computerPrinciples=" + computerPrinciples +
                ", computerNetwork=" + computerNetwork +
                ", oracle=" + oracle +
                ", web=" + web +
                ", studentId=" + studentId +
                ", student=" + student +
                '}';
    }

    public String getString(){
        return id + " " +
                combinedLanguage + " " +
                combinedLanguagePlus + " " +
                advancedMathematics + " " +
                english + " " +
                dataStructure + " " +
                java + " " +
                computerPrinciples + " " +
                computerNetwork + " " +
                oracle + " " +
                web + " " +
                studentId + " " +
                student;
    }
}
