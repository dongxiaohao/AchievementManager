package com.lnavm.controller;

import com.lnavm.pojo.CxbInfo;
import com.lnavm.service.WatchRecordService;
import com.lnavm.thirdutils.Page;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    @RequestMapping("/")
    public ModelAndView getRecord(String kslx, String starttime, String endtime, String order,String yhsjh ,HttpServletRequest request, HttpServletResponse response,ModelAndView modelAndView){
        // 数据类型处理，转变为符合数据库中的存储类型

        Page page = new Page<>(request, response);
        List<CxbInfo> list = watchRecordService.QueryRecoed(kslx,starttime,endtime,order,yhsjh,page);
        page.initialize();
        modelAndView.setViewName("recordofCX");
        if(list==null) {
            modelAndView.addObject("list",null);
            modelAndView.addObject("count",0);
            modelAndView.addObject("issuccess","false");
            modelAndView.addObject("page",null);
        }else {
            modelAndView.addObject("list",list);
            modelAndView.addObject("count",list.size());
            modelAndView.addObject("issuccess","success");
            modelAndView.addObject("page",page);
        }
        return modelAndView;
    }

}
