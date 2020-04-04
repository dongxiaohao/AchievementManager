package com.lnavm.controller;

import com.alibaba.fastjson.JSONObject;
import com.lnavm.pojo.CxRecord;
import com.lnavm.pojo.CxbInfo;
import com.lnavm.service.WatchRecordService;
import com.lnavm.thirdutils.Page;
import org.apache.catalina.LifecycleState;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * 查看日志控制器
 */
@RequestMapping("/recode")
@Controller
public class WatchRecordController {
    @Autowired
    WatchRecordService watchRecordService;


    @ResponseBody
    @RequestMapping("/record")
    public String getRecord(@Param("kslx") String kslx, @Param("starttime")String starttime, @Param("endtime") String endtime,@Param("order") String order, @Param("yhsjh") String yhsjh , HttpServletRequest request, HttpServletResponse response){
        // 数据类型处理，转变为符合数据库中的存储类型


        JSONObject jsonObject = new JSONObject();
        Page page = new Page<>(request, response);
        List<CxRecord> list = watchRecordService.QueryRecoed(kslx,starttime,endtime,order,yhsjh,page);
        page.initialize();
        Integer count=watchRecordService.countRecord(kslx,starttime,endtime,yhsjh);
//        modelAndView.setViewName("recordofCX");
//        if(list==null) {
//            modelAndView.addObject("list",null);
//            modelAndView.addObject("count",0);
//            modelAndView.addObject("issuccess","false");
//            modelAndView.addObject("page",null);
//        }else {
//            modelAndView.addObject("list",list);
//            modelAndView.addObject("count",list.size());
//            modelAndView.addObject("issuccess","success");
//            modelAndView.addObject("page",page);
//        }
        jsonObject.put("recordList",list);
        jsonObject.put("page",page);
        jsonObject.put("count",count);
        return jsonObject.toString();
    }

    @RequestMapping("/statistic")
    @ResponseBody
    public String statOfRecord(@Param("starttime") String starttime, @Param("endtime") String endtime){

        JSONObject jsonObject = new JSONObject();
        HashMap<String,String> numOfRecord = watchRecordService.StatisticRecord(starttime, endtime);
        jsonObject.put("countOfRecord",numOfRecord);
        return jsonObject.toString();
    }
}
