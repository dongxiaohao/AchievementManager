package com.lnavm.controller;

import com.alibaba.fastjson.JSONObject;
import com.lnavm.utils.IpAdrressUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Properties;

@Controller
public class IndexController {
    @RequestMapping("/indexxx")
    @ResponseBody
    public String Getfqqxx(){
        //todo
        JSONObject jsonObject =new JSONObject();
        //得到本机ip地址 和 Mac地址
        try {
            InetAddress address = InetAddress.getLocalHost();
            NetworkInterface ni = NetworkInterface.getByInetAddress(address);
            //ni.getInetAddresses().nextElement().getAddress();
            byte[] mac = ni.getHardwareAddress();
            String sIP = address.getHostAddress();
            String sMAC = "";
            Formatter formatter = new Formatter();
            for (int i = 0; i < mac.length; i++) {
                sMAC = formatter.format(Locale.getDefault(), "%02X%s", mac[i],
                        (i < mac.length - 1) ? "-" : "").toString();
            }
            jsonObject.put("thisip",sIP); //本机ip
            jsonObject.put("thisMac",sMAC); //本机MAC
            System.out.println("IP：" + sIP);
            System.out.println("MAC：" + sMAC);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //
        //获取访问者ip地址
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        System.out.println("访问ip："+IpAdrressUtil.getIpAddr(request));
        jsonObject.put("fanfwenip",IpAdrressUtil.getIpAddr(request));  //访问ip
        //得到系统基本信息
        Properties props = System.getProperties();
        jsonObject.put("javaversion",props.getProperty("java.version"));  //Java的运行环境版本
        jsonObject.put("javavendor",props.getProperty("java.vendor"));//Java的运行环境供应商
        jsonObject.put("javahome",props.getProperty("java.home"));//Java的安装路径
        jsonObject.put("javavmversion",props.getProperty("java.vm.specification.version"));//Java的虚拟机规范版本
        jsonObject.put("osname",props.getProperty("os.name"));//操作系统的名称
        jsonObject.put("osarch",props.getProperty("os.arch"));//操作系统的构架
        jsonObject.put("osversion",props.getProperty("os.version"));//操作系统的版本

        System.out.println("Java的运行环境版本：" + props.getProperty("java.version"));
        System.out.println("Java的运行环境供应商：" + props.getProperty("java.vendor"));
        System.out.println("Java供应商的URL：" + props.getProperty("java.vendor.url"));
        System.out.println("Java的安装路径：" + props.getProperty("java.home"));
        System.out.println("Java的虚拟机规范版本：" + props.getProperty("java.vm.specification.version"));
        System.out.println("Java的虚拟机规范供应商：" + props.getProperty("java.vm.specification.vendor"));
        System.out.println("Java的虚拟机规范名称：" + props.getProperty("java.vm.specification.name"));
        System.out.println("Java的虚拟机实现版本：" + props.getProperty("java.vm.version"));
        System.out.println("Java的虚拟机实现供应商：" + props.getProperty("java.vm.vendor"));
        System.out.println("Java的虚拟机实现名称：" + props.getProperty("java.vm.name"));
        System.out.println("Java运行时环境规范版本：" + props.getProperty("java.specification.version"));
        System.out.println("Java运行时环境规范供应商：" + props.getProperty("java.specification.vender"));
        System.out.println("Java运行时环境规范名称：" + props.getProperty("java.specification.name"));
        System.out.println("Java的类格式版本号：" + props.getProperty("java.class.version"));
        System.out.println("Java的类路径：" + props.getProperty("java.class.path"));
        System.out.println("加载库时搜索的路径列表：" + props.getProperty("java.library.path"));
        System.out.println("默认的临时文件路径：" + props.getProperty("java.io.tmpdir"));
        System.out.println("一个或多个扩展目录的路径：" + props.getProperty("java.ext.dirs"));
        System.out.println("操作系统的名称：" + props.getProperty("os.name"));
        System.out.println("操作系统的构架：" + props.getProperty("os.arch"));
        System.out.println("操作系统的版本：" + props.getProperty("os.version"));
        return jsonObject.toString();
    }
}
