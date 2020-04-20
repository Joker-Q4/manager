package com.sau.entity;

/**
 * 学生各科成绩
 */
public class Grade {

    private Integer id;
    private Double combinedLanguage;       //C语言
    private Double combinedLanguagePlus;   //C++
    private Double advancedMathematics;    //高等数学
    private Double english;                //英语
    private Double dataStructure;          //数据结构
    private Double java;                   //Java
    private Double computerPrinciples;     //计算机原理
    private Double computerNetwork;        //计算机网络
    private Double oracle;                 //Oracle数据库
    private Double web;                    //web应用程序设计
    private Integer studentId;             //所属学生
    private Student student;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCombinedLanguage() {
        return combinedLanguage;
    }

    public void setCombinedLanguage(Double combinedLanguage) {
        this.combinedLanguage = combinedLanguage;
    }

    public Double getCombinedLanguagePlus() {
        return combinedLanguagePlus;
    }

    public void setCombinedLanguagePlus(Double combinedLanguagePlus) {
        this.combinedLanguagePlus = combinedLanguagePlus;
    }

    public Double getAdvancedMathematics() {
        return advancedMathematics;
    }

    public void setAdvancedMathematics(Double advancedMathematics) {
        this.advancedMathematics = advancedMathematics;
    }

    public Double getEnglish() {
        return english;
    }

    public void setEnglish(Double english) {
        this.english = english;
    }

    public Double getDataStructure() {
        return dataStructure;
    }

    public void setDataStructure(Double dataStructure) {
        this.dataStructure = dataStructure;
    }

    public Double getJava() {
        return java;
    }

    public void setJava(Double java) {
        this.java = java;
    }

    public Double getComputerPrinciples() {
        return computerPrinciples;
    }

    public void setComputerPrinciples(Double computerPrinciples) {
        this.computerPrinciples = computerPrinciples;
    }

    public Double getComputerNetwork() {
        return computerNetwork;
    }

    public void setComputerNetwork(Double computerNetwork) {
        this.computerNetwork = computerNetwork;
    }

    public Double getOracle() {
        return oracle;
    }

    public void setOracle(Double oracle) {
        this.oracle = oracle;
    }

    public Double getWeb() {
        return web;
    }

    public void setWeb(Double web) {
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
}
