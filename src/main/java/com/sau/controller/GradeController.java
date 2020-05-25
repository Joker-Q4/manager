package com.sau.controller;

import com.alibaba.fastjson.JSONObject;
import com.sau.entity.Grade;
import com.sau.entity.GradeAssessment;
import com.sau.global.Global;
import com.sau.global.GlobalKey;
import com.sau.global.JsonTools;
import com.sau.kmeans.Cluster;
import com.sau.kmeans.KMeansRun;
import com.sau.service.GradeService;
import com.sau.utils.KMPUtils;
import com.sau.utils.MyCompare;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.*;

@RestController
@RequestMapping("/grade")
public class GradeController {

    @Resource
    GradeService gradeService;

    @GetMapping("/getGradeByStudentId")
    public Map<String, Object> getGradeByStudentId(
            @RequestParam(defaultValue = "") String studentId,
            @RequestParam(defaultValue = "") String key
    ) {
        if (key.isEmpty()) {
            if (studentId.isEmpty()) {
                return JsonTools.toResult(1, "参数有误", 0, null);
            }
            final List<Grade> list = gradeService.getGradeByStudentId(Integer.valueOf(studentId));
            return JsonTools.toResult(0, "success", list.size(), list);
        } else {
            if (studentId.isEmpty()) {
                return JsonTools.toResult(1, "参数有误", 0, null);
            }
            final List<Grade> list = gradeService.getGradeByStudentId(Integer.valueOf(studentId));
            final List<Grade> result = new ArrayList<>();
            for (Grade grade : list) {
                int[] temp = KMPUtils.kmpNext(key);
                if (KMPUtils.kmpSearch(grade.getString(), key, temp) != -1) {
                    //说明存在
                    result.add(grade);
                }
            }
            return JsonTools.toResult(0, "成功", result.size(), result);
        }
    }

    @GetMapping("/getGradeAssessmentByStudentId")
    public Map<String, Object> getGradeAssessmentByStudentId(
            @RequestParam(defaultValue = "") String studentId,
            @RequestParam(defaultValue = "") String key
    ) {
        if (key.isEmpty()) {
            if (studentId.isEmpty()) {
                return JsonTools.toResult(1, "参数有误", 0, null);
            }
           /* final List<Grade> list = gradeService.getGradeByStudentId(Integer.valueOf(studentId));
            return JsonTools.toResult(0, "success", list.size(), list);*/
            List<GradeAssessment> gradeAssessmentList = new ArrayList<>();
            GradeAssessment gradeAssessment = getGradeVO(gradeService.getGradeByStudentId(Integer.valueOf(studentId)).get(0));
            gradeAssessmentList.add(gradeAssessment);
            return JsonTools.toResult(0, "成功", 1, gradeAssessmentList);
        } else {
            if (studentId.isEmpty()) {
                return JsonTools.toResult(1, "参数有误", 0, null);
            }
            List<GradeAssessment> gradeAssessmentList = new ArrayList<>();
            GradeAssessment gradeAssessment = getGradeVO(gradeService.getGradeByStudentId(Integer.valueOf(studentId)).get(0));
            gradeAssessmentList.add(gradeAssessment);
            return JsonTools.toResult(0, "成功", 1, gradeAssessmentList);
        }
    }

    @PostMapping("/updateGrade")
    public Map<String, Object> updateGrade(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        Grade grade = analyzeJson(properties);
        if (grade.getId() == null) {
            return JsonTools.toResult(1, "id不能为空", 0, null);
        }
        if (gradeService.updateGrade(grade))
            return JsonTools.toResult(0, "修改成功", 0, null);
        return JsonTools.toResult(1, "修改失败", 0, null);
    }

    @PostMapping("/addGrade")
    public Map<String, Object> addGrade(
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        final Properties properties = Global.getRequest(request);
        Grade grade = analyzeJson(properties);
        if (gradeService.addGrade(grade))
            return JsonTools.toResult(0, "添加成功", 0, null);
        return JsonTools.toResult(1, "添加失败", 0, null);
    }

    private static void randomGrade() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Grade grade = new Grade();
            grade.setCombinedLanguage(getRandom(random));
            grade.setCombinedLanguagePlus(getRandom(random));
            grade.setAdvancedMathematics(getRandom(random));
            grade.setEnglish(getRandom(random));
            grade.setDataStructure(getRandom(random));
            grade.setJava(getRandom(random));
            grade.setComputerPrinciples(getRandom(random));
            grade.setComputerNetwork(getRandom(random));
            grade.setOracle(getRandom(random));
            grade.setWeb(getRandom(random));
            grade.setStudentId(3);
            System.out.println(grade.getString());
        }
    }

    private static double getRandom(Random random){
        return random.nextInt(10000)*1.0/100;
    }

    public static void main(String[] args) {
        randomGrade();
    }

    private Grade analyzeJson(Properties properties) {
        final String json = properties.getProperty("json");
        JSONObject jsonObject = JSONObject.parseObject(json);
        return getGrade(jsonObject);
    }

    private Grade getGrade(JSONObject jsonObject) {
        Grade grade = new Grade();
        final String id = jsonObject.getString(GlobalKey.ID);
        if (id != null && !id.isEmpty()) {
            grade.setId(Integer.parseInt(id));
        }
        final String combinedLanguage = jsonObject.getString(GlobalKey.COMBINED_LANGUAGE);
        if (combinedLanguage != null && !combinedLanguage.isEmpty()) {
            grade.setCombinedLanguage(Double.parseDouble(combinedLanguage));
        }
        final String combinedLanguagePlus = jsonObject.getString(GlobalKey.COMBINED_LANGUAGE_PLUS);
        if (combinedLanguagePlus != null && !combinedLanguagePlus.isEmpty()) {
            grade.setCombinedLanguagePlus(Double.parseDouble(combinedLanguagePlus));
        }
        final String advancedMathematics = jsonObject.getString(GlobalKey.ADVANCED_MATHEMATICS);
        if (advancedMathematics != null && !advancedMathematics.isEmpty()) {
            grade.setAdvancedMathematics(Double.parseDouble(advancedMathematics));
        }
        final String english = jsonObject.getString(GlobalKey.ENGLISH);
        if (english != null && !english.isEmpty()) {
            grade.setEnglish(Double.parseDouble(english));
        }
        final String dataStructure = jsonObject.getString(GlobalKey.DATA_STRUCTURE);
        if (dataStructure != null && !dataStructure.isEmpty()) {
            grade.setDataStructure(Double.parseDouble(dataStructure));
        }
        final String java = jsonObject.getString(GlobalKey.JAVA);
        if (java != null && !java.isEmpty()) {
            grade.setJava(Double.parseDouble(java));
        }
        final String computerPrinciples = jsonObject.getString(GlobalKey.COMPUTER_PRINCIPLES);
        if (computerPrinciples != null && !computerPrinciples.isEmpty()) {
            grade.setComputerPrinciples(Double.parseDouble(computerPrinciples));
        }
        final String computerNetwork = jsonObject.getString(GlobalKey.COMPUTER_NETWORK);
        if (computerNetwork != null && !computerNetwork.isEmpty()) {
            grade.setComputerNetwork(Double.parseDouble(computerNetwork));
        }
        final String oracle = jsonObject.getString(GlobalKey.ORACLE);
        if (oracle != null && !oracle.isEmpty()) {
            grade.setOracle(Double.parseDouble(oracle));
        }
        final String web = jsonObject.getString(GlobalKey.WEB);
        if (web != null && !web.isEmpty()) {
            grade.setWeb(Double.parseDouble(web));
        }
        final String studentId = jsonObject.getString(GlobalKey.STUDENT_ID);
        if (studentId != null && !studentId.isEmpty()) {
            grade.setStudentId(Integer.parseInt(studentId));
        }
        return grade;
    }

    private GradeAssessment getGradeVO(Grade grade){
        GradeAssessment gradeAssessment = new GradeAssessment();
        gradeAssessment.setCombinedLanguage(getString(grade.getCombinedLanguage(), gradeService.getCombinedLanguage()));
        gradeAssessment.setCombinedLanguagePlus(getString(grade.getCombinedLanguagePlus(), gradeService.getCombinedLanguagePlus()));
        gradeAssessment.setAdvancedMathematics(getString(grade.getAdvancedMathematics(), gradeService.getAdvancedMathematics()));
        gradeAssessment.setEnglish(getString(grade.getEnglish(), gradeService.getEnglish()));
        gradeAssessment.setDataStructure(getString(grade.getDataStructure(), gradeService.getDataStructure()));
        gradeAssessment.setJava(getString(grade.getJava(), gradeService.getJava()));
        gradeAssessment.setComputerPrinciples(getString(grade.getComputerPrinciples(), gradeService.getComputerPrinciples()));
        gradeAssessment.setComputerNetwork(getString(grade.getComputerNetwork(), gradeService.getComputerNetwork()));
        gradeAssessment.setOracle(getString(grade.getOracle(), gradeService.getOracle()));
        gradeAssessment.setWeb(getString(grade.getWeb(), gradeService.getWeb()));
        return gradeAssessment;
    }

    private String getString(double grade, List<Double> list){
        ArrayList<double[]> dataSet = new ArrayList<>();
        for(Double d:list){
            dataSet.add(new double[]{d});
        }
        KMeansRun kRun =new KMeansRun(4, dataSet);
        Cluster[] clusters = kRun.run().toArray(new Cluster[0]);
        Arrays.sort(clusters, new MyCompare()) ; // 进行排序操作
        //不及格
        //及格
        //中等
        //良好
        //优秀
        if(grade < clusters[0].getCenter().getlocalArray()[0]){
            return "不及格";
        }else if(grade >= clusters[0].getCenter().getlocalArray()[0] && grade < clusters[1].getCenter().getlocalArray()[0]){
            return "及格";
        }else if(grade >= clusters[1].getCenter().getlocalArray()[0] && grade < clusters[2].getCenter().getlocalArray()[0]){
            return "中等";
        }else if(grade >= clusters[2].getCenter().getlocalArray()[0] && grade < clusters[3].getCenter().getlocalArray()[0]){
            return "良好";
        }else {
            return "优秀";
        }
    }
}
