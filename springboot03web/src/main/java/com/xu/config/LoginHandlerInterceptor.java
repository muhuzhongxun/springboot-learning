package com.xu.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录成功之后，应该有用户的session
        Object loginUser = request.getAttribute("loginUser");
        if(loginUser == null){
            request.setAttribute("msg","cooick已过期，请重新登录！");
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;
        }else{
            return true;
        }
    }


}
