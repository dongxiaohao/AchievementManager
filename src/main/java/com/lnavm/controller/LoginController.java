package com.lnavm.controller;

import com.alibaba.fastjson.JSONObject;
import com.lnavm.Config.Constant;
import com.lnavm.annotations.GLYLogAnnotation;
import com.lnavm.entity.Resultentity;
import com.lnavm.pojo.GlyxxInfo;
import com.lnavm.service.adminService;
import com.lnavm.statusenum.Status;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    adminService adminService;

    @GLYLogAnnotation(value = "管理员登录")
    @ResponseBody
    @RequestMapping("/login")
    public String Loginin(@Param("username") String username,@Param("pawassord") String pawassord, HttpSession session, HttpServletRequest request ){
        System.out.println("用户登录..." );
        JSONObject jsonObject=new JSONObject();
        //清除之前的session,避免状态的混乱
        session.removeAttribute(Constant.LOGIN_ADMIN);
        session.removeAttribute(Constant.YHM);
        Status status=adminService.loginin(username,pawassord);
        //如果登陆成功
        GlyxxInfo glyxxInfo=null;
        if(status == Status.OK){
            glyxxInfo=adminService.getGlyxxInfo(username);
            if(glyxxInfo != null ){
                session.setAttribute(Constant.LOGIN_ADMIN,glyxxInfo);
                session.setAttribute(Constant.YHM,username);
            }

        }
        if(glyxxInfo == null){
            session.setAttribute(Constant.YHM,username);
        }
        Resultentity<String> resultentity=adminService.getAdminState(status);
        if(resultentity.getResult() == Resultentity.SUCCESS) {
            resultentity.setData(request.getContextPath()+"/index.html");
            jsonObject.put("next",request.getContextPath()+"/index.html");
        }
        jsonObject.put("success",resultentity.getResult());
        jsonObject.put("massege",resultentity.getMessage());
//        return resultentity;

        return jsonObject.toString();
    }
}
