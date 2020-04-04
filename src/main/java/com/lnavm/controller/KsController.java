package com.lnavm.controller;

import com.alibaba.fastjson.JSONObject;
import com.lnavm.Config.Examination;
import com.lnavm.Config.ExaminationToCode;
import com.lnavm.Config.SupportExamination;
import com.lnavm.entity.Grades;
import com.lnavm.service.GradeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/ks")
public class KsController {
    @Autowired
    SupportExamination supportExamination;
    @Autowired
    GradeService gradeService;
    @Autowired
    ExaminationToCode examinationToCode;

    @RequestMapping("/ksxx")
    @ResponseBody
    public String getKsxx(){
        System.out.println("得到考试信息");
        JSONObject jsonObject=new JSONObject();
       // List<Examination> list = supportExamination.getExaminations();
        jsonObject.put("ksxx",examinationToCode.getCodeMap());
//        System.out.println(examinationToCode.getCodeMap().size());
        return jsonObject.toString();
    }

    @RequestMapping("/watchgrade")
    @ResponseBody
    public String WatchGrade(@Param("yzbm") String yzbm, @Param("kslx") String kslx){
        JSONObject jsonObject=new JSONObject();
        if(yzbm == null || yzbm.length() ==0){
            jsonObject.put("success","false");
            jsonObject.put("result","验证编码为空，请重新确认！");
        }
        if(kslx==null || kslx.length()==0){
            jsonObject.put("success","false");
            jsonObject.put("result","出现错误，请重新尝试！");
        }
        // 将考试类型转换为考试代码
        if(examinationToCode.getCodeMap().containsKey(kslx)){
           kslx=examinationToCode.getCodeMap().get(kslx);
        }
        Grades grades=gradeService.getGrade(yzbm ,kslx);
        jsonObject.put("success","true");
        jsonObject.put("Scores",grades.getScoresMap());
        jsonObject.put("Others",grades.getOtherMap());
        return jsonObject.toString();
    }
}
