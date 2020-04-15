package com.lnavm.Aspects;

import com.lnavm.Config.Constant;
import com.lnavm.annotations.GLYLogAnnotation;
import com.lnavm.pojo.GlyrzInfo;
import com.lnavm.pojo.GlyxxInfo;
import com.lnavm.service.LogService;
import com.lnavm.utils.DateConverter;
import com.lnavm.utils.IpAdrressUtil;
import com.mks.api.Session;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

@Aspect
@Component
public class GLYLogAspect {

    @Autowired
    private LogService logService;

    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation(com.lnavm.annotations.GLYLogAnnotation)")
    public void logPointCut() {
    }

    //切面 配置通知
    @AfterReturning("logPointCut()")
    public void saveGLYLog(JoinPoint joinPoint){
        System.out.println("管理员日志切面...");

        GlyrzInfo glyrzInfo =new GlyrzInfo();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        Method method = signature.getMethod();
        GLYLogAnnotation logAnnotation =method.getAnnotation(GLYLogAnnotation.class);
        if(logAnnotation != null){
            String value =logAnnotation.value();
            glyrzInfo.setOperate(value);
        }

        //获取用户ip地址
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();

        //得到登录的管理员信息
        GlyxxInfo glyxxInfo=(GlyxxInfo) session.getAttribute(Constant.LOGIN_ADMIN);
        if(glyxxInfo == null)
            glyxxInfo = (GlyxxInfo) session.getAttribute(Constant.LAST_LOGIN_ADMIN);

        if(glyxxInfo != null || glyxxInfo.getBm() != null)
            glyrzInfo.setBm(glyxxInfo.getBm());
        glyrzInfo.setCxkslx(null);
        glyrzInfo.setCzjg(null);
        glyrzInfo.setCxsfzh(null);
        glyrzInfo.setCzsj(DateConverter.getCurrentFormatDate());
        if(glyxxInfo != null || glyxxInfo.getGlyid() != null)
        glyrzInfo.setDlzh(glyxxInfo.getGlyid().toString());
        //glyrzInfo.setGlyrzid(.);
        glyrzInfo.setIpdz(IpAdrressUtil.getIpAddr(request));
        glyrzInfo.setQqff(null);
        if(glyxxInfo != null || glyxxInfo.getGlyzh() != null)
        glyrzInfo.setXm(glyxxInfo.getGlyzh());

        logService.save(glyrzInfo);
    }
}
