package com.lnavm.controller;

import com.alibaba.fastjson.JSONObject;
import com.lnavm.Config.Examination;
import com.lnavm.Config.SupportExamination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ks")
public class KsController {
    @Autowired
    SupportExamination supportExamination;

    @RequestMapping("/ksxx")
    public String getKsxx(){
        JSONObject jsonObject=new JSONObject();
        List<Examination> list = supportExamination.getExaminations();
        jsonObject.put("ksxx",list);
        return jsonObject.toString();
    }
}
