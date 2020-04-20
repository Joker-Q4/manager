package com.sau.entity;

/**
 * 教师授课情况
 */
public class TeachingSituation {

    private Integer id;
    private Boolean combinedLanguage;       //C语言
    private Boolean combinedLanguagePlus;   //C++
    private Boolean advancedMathematics;    //高等数学
    private Boolean english;                //英语
    private Boolean dataStructure;          //数据结构
    private Boolean java;                   //Java
    private Boolean computerPrinciples;     //计算机原理
    private Boolean computerNetwork;        //计算机网络
    private Boolean oracle;                 //Oracle数据库
    private Boolean web;                    //web应用程序设计
    private Integer teacherId;              //所属教师
    private Teacher teacher;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getCombinedLanguage() {
        return combinedLanguage;
    }

    public void setCombinedLanguage(Boolean combinedLanguage) {
        this.combinedLanguage = combinedLanguage;
    }

    public Boolean getCombinedLanguagePlus() {
        return combinedLanguagePlus;
    }

    public void setCombinedLanguagePlus(Boolean combinedLanguagePlus) {
        this.combinedLanguagePlus = combinedLanguagePlus;
    }

    public Boolean getAdvancedMathematics() {
        return advancedMathematics;
    }

    public void setAdvancedMathematics(Boolean advancedMathematics) {
        this.advancedMathematics = advancedMathematics;
    }

    public Boolean getEnglish() {
        return english;
    }

    public void setEnglish(Boolean english) {
        this.english = english;
    }

    public Boolean getDataStructure() {
        return dataStructure;
    }

    public void setDataStructure(Boolean dataStructure) {
        this.dataStructure = dataStructure;
    }

    public Boolean getJava() {
        return java;
    }

    public void setJava(Boolean java) {
        this.java = java;
    }

    public Boolean getComputerPrinciples() {
        return computerPrinciples;
    }

    public void setComputerPrinciples(Boolean computerPrinciples) {
        this.computerPrinciples = computerPrinciples;
    }

    public Boolean getComputerNetwork() {
        return computerNetwork;
    }

    public void setComputerNetwork(Boolean computerNetwork) {
        this.computerNetwork = computerNetwork;
    }

    public Boolean getOracle() {
        return oracle;
    }

    public void setOracle(Boolean oracle) {
        this.oracle = oracle;
    }

    public Boolean getWeb() {
        return web;
    }

    public void setWeb(Boolean web) {
        this.web = web;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "TeachingSituation{" +
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
                ", teacherId=" + teacherId +
                ", teacher=" + teacher +
                '}';
    }
}
