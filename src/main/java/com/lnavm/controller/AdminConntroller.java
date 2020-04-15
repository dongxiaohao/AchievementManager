package com.lnavm.controller;

import com.alibaba.fastjson.JSONObject;
import com.lnavm.Config.Constant;
import com.lnavm.annotations.GLYLogAnnotation;
import com.lnavm.entity.Resultentity;
import com.lnavm.pojo.GlyrzInfo;
import com.lnavm.pojo.GlyxxInfo;
import com.lnavm.pojo.YhxxInfo;
import com.lnavm.service.adminService;
import com.lnavm.statusenum.Status;
import com.lnavm.thirdutils.Page;
import org.apache.ibatis.annotations.Param;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @GLYLogAnnotation(value = "查看管理员")
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

    @GLYLogAnnotation(value = "添加管理员")
    @RequestMapping("/addadmin")
    @ResponseBody
    public Resultentity<String> AddAdmin(String username,String password){
        Status status=adminService.addadmin(username,password);
        Resultentity<String> resultentity=adminService.getAdminState(status);
        return resultentity;
    }

    @GLYLogAnnotation(value = "修改管理员信息")
    @RequestMapping("/motifyadmin")
    @ResponseBody
    public Resultentity<String> MotifyAdmin(@Param("glyid") String glyid,@Param("username") String username,@Param("password")String password){
        Status status =adminService.MotifyAdmin(glyid,username,password);
        Resultentity<String> resultentity=adminService.getAdminState(status);
        return resultentity;
    }

    /**
     * 禁止管理员登录，现用部门号代替
     * 部门号为1表示可以登录，为0表示禁止登录
     * @param glyid
     * @return
     */
    @GLYLogAnnotation(value = "禁止管理员登录")
    @RequestMapping("/ban")
    @ResponseBody
    public Resultentity<String> BanAdmin(@Param("glyid") String glyid,HttpSession session)
    {
        GlyxxInfo glyxxInfo =(GlyxxInfo) session.getAttribute(Constant.LOGIN_ADMIN);
        Status status=null;
//        System.out.println(glyxxInfo.getGlyid()+" "+glyid);
        if(glyxxInfo.getGlyid().equals(glyid)){
            status=Status.SAME_ADMIN;
        }
        if(status == null || adminService.countValidAdmin(1) <= 1){
            status =Status.VALID_ADMIN_SMALL;
        }
        if(status == null) {
            status=adminService.adminZT(glyid,0);
        }

        Resultentity<String> resultentity=adminService.getAdminState(status);
        return resultentity;
    }
    @RequestMapping("/unban")
    @ResponseBody
    public  Resultentity<String> UnBanAdmin(@Param("glyid") String glyid){

        Status status=adminService.adminZT(glyid,1);
        Resultentity<String> resultentity=adminService.getAdminState(status);
        return resultentity;
    }

    @GLYLogAnnotation(value = "注销登录")
    @RequestMapping("/signOut")
    @ResponseBody
    public String signOut(HttpSession session) {
        JSONObject jsonObject=new JSONObject();
        GlyxxInfo glyxxInfo=(GlyxxInfo)session.getAttribute(Constant.LOGIN_ADMIN);
        session.removeAttribute(Constant.LOGIN_ADMIN);
        session.removeAttribute(Constant.YHM);
        session.setAttribute(Constant.LAST_LOGIN_ADMIN,glyxxInfo);
       jsonObject.put("logoutStatus","success");
        return jsonObject.toString();
    }


    @RequestMapping(value = "/isSignin")
    @ResponseBody
    public String isSignin(HttpServletRequest request) {
        JSONObject jsonObject=new JSONObject();
        if(request.getSession().getAttribute(Constant.LOGIN_ADMIN)==null){
            jsonObject.put("signinStatus", "failed");
        }else {
            jsonObject.put("signInName",request.getSession().getAttribute(Constant.YHM));
            jsonObject.put("signinStatus", "success");
        }

        return jsonObject.toString();
    }
}
