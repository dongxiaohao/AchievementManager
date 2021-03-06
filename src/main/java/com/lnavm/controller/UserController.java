package com.lnavm.controller;

import com.alibaba.fastjson.JSONObject;
import com.lnavm.annotations.GLYLogAnnotation;
import com.lnavm.entity.Resultentity;
import com.lnavm.pojo.YhrecordInfo;
import com.lnavm.service.UserService;
import com.lnavm.statusenum.Status;
import com.lnavm.thirdutils.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    UserService userService;

//    private final HttpServletRequest request;
//
//    private final JSONObject jsonObject;
//
//
//    @Autowired
//    public UserController(HttpServletRequest request, JSONObject jsonObject) {
//        this.request = request;
//        this.jsonObject = jsonObject;
//    }
  //  private final JSONObject jsonObject;

      //@Autowired
//    public UserController(JSONObject jsonObject) {
//        this.jsonObject = jsonObject;
//    }

    @GLYLogAnnotation(value = "查看用户")
    @RequestMapping("/service")
    @ResponseBody
    public String QureyUser(String SfzhorSjh, HttpServletRequest request, HttpServletResponse response){
        //数据校验输入是否符合规则
        boolean right=false;
        JSONObject jsonObject = new JSONObject();
         if(SfzhorSjh==null || SfzhorSjh.length()==0 || SfzhorSjh.length()==11 || SfzhorSjh.length()==15||SfzhorSjh.length()==18)
                right=true;
        //如果符合进行查询
        List<YhrecordInfo> list=new ArrayList<>();
        Page page = new Page<>(request, response);
        Integer count=0;
        if(right) {
            list = userService.QueryUser(SfzhorSjh, page);
            //判断是否存在相应用户
            page.initialize();
            count=userService.CountUserCon(SfzhorSjh);
        }
//        modelAndView.setViewName("recordofuser");
        jsonObject.put("recordList", list);
        jsonObject.put("page", page);
        jsonObject.put("count",count);
     //   jsonObject.put("success","success");

        return jsonObject.toString();
//        return modelAndView;
//        return null;
    }

    @GLYLogAnnotation(value = "修改用户手机号")
    @RequestMapping("/motify")
    @ResponseBody
    public Resultentity<String> MotifyUser(String yhid,String sjh){
        Status status=userService.MatifyUserSJH(yhid,sjh);
        Resultentity resultentity = userService.getUserState(status);

        return resultentity;
    }

    /**
     * 禁止普通用户登录，需要改库
     * @param userid
     * @return
     */
    @GLYLogAnnotation(value = "禁止用户登录")
    @RequestMapping("/ban")
    @ResponseBody
    public Resultentity<String> BanUser(@Param("uSuser" +
            "serid") String userid){
        Status status=userService.updataUserBan(userid,0);
        Resultentity resultentity=userService.getUserState(status);
        return resultentity;
    }
    /**
     * 禁止普通用户登录，需要改库
     * @param userid
     * @return
     */
    @GLYLogAnnotation(value = "允许用户登录")
    @RequestMapping("/unban")
    @ResponseBody
    public Resultentity<String> UnbanUser(@Param("userid") String userid){
        Status status=userService.updataUserBan(userid,1);
        Resultentity resultentity=userService.getUserState(status);
        return resultentity;
    }


}
