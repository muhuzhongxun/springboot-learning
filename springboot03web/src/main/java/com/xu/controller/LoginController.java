package com.xu.controller;

import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

public class LoginController {

    @RequestMapping("/user/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model, HttpSession session) {

        if(StringUtils.hasLength(username) && "123".equals(password)){
            session.setAttribute("loginUser",username);
            return "redirect:/index.html";
        }else{
            model.addAttribute("msg","账号或密码错误！");
            return "login.html";
        }
    }

}
