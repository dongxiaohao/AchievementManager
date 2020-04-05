package com.lnavm.controller;

import com.alibaba.fastjson.JSONObject;
import com.lnavm.Config.Constant;
import com.lnavm.entity.Resultentity;
import com.lnavm.pojo.GlyrzInfo;
import com.lnavm.pojo.GlyxxInfo;
import com.lnavm.service.adminService;
import com.lnavm.statusenum.Status;
import com.lnavm.thirdutils.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminConntroller {

    @Autowired
    adminService adminService;
    /**
     * 由于管理员数量不多，因此不需要添加查询条件
     * @return
     */
    @RequestMapping("/watchadmin")
    @ResponseBody
    public String listadmin(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView){
        JSONObject jsonObject=new JSONObject();
        Page<GlyxxInfo> page=new Page<>(request,response);
        List<GlyxxInfo> list=adminService.listAll(page);
        page.initialize();
        modelAndView.setViewName("recordofadmin");
        //如果list为空表示出现异常
//        if(list==null) {
//            modelAndView.addObject("list",null);
//            modelAndView.addObject("success","false");
//            modelAndView.addObject("count",0);
//            modelAndView.addObject("page",null);
//        }else {
//            modelAndView.addObject("list",list);
//            modelAndView.addObject("success","success");
//            modelAndView.addObject("count",list.size());
//            modelAndView.addObject("page",page);
//        }
//        return modelAndView;
        jsonObject.put("recordList",list);
        jsonObject.put("page",page);
        return jsonObject.toString();
    }

    @RequestMapping("/addadmin")
    @ResponseBody
    public Resultentity<String> AddAdmin(String username,String password){
        Status status=adminService.addadmin(username,password);
        Resultentity<String> resultentity=adminService.getAdminState(status);
        return resultentity;
    }

    @RequestMapping("/motifyadmin")
    @ResponseBody
    public Resultentity<String> MotifyAdmin(String username,String password){
        //todo
        return  null;
    }

    @RequestMapping("/ban")
    @ResponseBody
    public Resultentity<String> BanAdmin()
    {
        //todo
        return null;
    }
    @RequestMapping("/unban")
    @ResponseBody
    public  Resultentity<String> UnBanAdmin(){

        //todo
        return null;
    }

    @RequestMapping("/signOut")
    @ResponseBody
    public String signOut(HttpSession session) {
        session.removeAttribute(Constant.LOGIN_ADMIN);
        session.removeAttribute(Constant.YHM);
        return "longin";
    }

}
