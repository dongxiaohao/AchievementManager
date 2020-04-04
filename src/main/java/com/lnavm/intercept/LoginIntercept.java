package com.lnavm.intercept;

import com.lnavm.Config.Constant;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginIntercept implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(request.getSession().getAttribute(Constant.LOGIN_ADMIN) != null) {
            return true;
        }
        else {
            HttpSession session = request.getSession();
            session.removeAttribute(Constant.LOGIN_ADMIN);
            session.removeAttribute(Constant.SJH);
            session.removeAttribute(Constant.YHM);
            //保存之前访问记录
            session.setAttribute(Constant.BEFORE_LOGIN_URL_TOKEN, request.getRequestURI());
            //登录失败重定向到登录界面
            response.sendRedirect(request.getContextPath() + Constant.LOGIN_URL);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
