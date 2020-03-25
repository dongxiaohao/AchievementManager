package com.lnavm.controller;

import com.lnavm.entity.Resultentity;
import com.lnavm.pojo.CxbInfo;
import com.lnavm.pojo.YhrecordInfo;
import com.lnavm.service.UserService;
import com.lnavm.statusenum.Status;
import com.lnavm.thirdutils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/service")
    public ModelAndView QureyUser(String SfzhorSjh, HttpServletRequest request, HttpServletResponse response,ModelAndView modelAndView){
        //数据校验输入是否符合规则
        // if(SfzhorSjh.length()!=0 || SfzhorSjh.)

        //如果符合进行查询
        Page page = new Page<>(request, response);
        List<YhrecordInfo> list =userService.QueryUser(SfzhorSjh,page);
        //判断是否存在相应用户

        page.initialize();
        modelAndView.setViewName("recordofuser");
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

    @RequestMapping("/motify")
    public Resultentity<String> MotifyUser(String yhid,String sjh){
        Status status=userService.MatifyUserSJH(yhid,sjh);
        Resultentity resultentity = userService.getUserState(status);

        return resultentity;
    }

    /**
     * 禁止普通用户登录，需要改库
     * @param Userid
     * @return
     */
    @RequestMapping("/ban")
    public Resultentity<String> BanUser(String Userid){
        Status status=userService.updataUserBan(Userid,0);
        Resultentity resultentity=userService.getUserState(status);
        return resultentity;
    }
    /**
     * 禁止普通用户登录，需要改库
     * @param Userid
     * @return
     */
    @RequestMapping("/unban")
    public Resultentity<String> UnbanUser(String Userid){
        Status status=userService.updataUserBan(Userid,1);
        Resultentity resultentity=userService.getUserState(status);
        return resultentity;
    }


}
