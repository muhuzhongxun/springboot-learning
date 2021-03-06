package com.xu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model, HttpSession session) {
        System.out.println("LoginController==>user/login！");
        //默认牧户仲寻可随便进入
        if("牧户仲寻".equals(username) && "123".equals(password)){
            System.out.println("登录成功！");
            session.removeAttribute("loginUser");
            session.setAttribute("loginUser",username);
            return "redirect:/index.html";
        }else{

            System.out.println("登录失败！");
            model.addAttribute("msg","账号或密码错误！");
            return "login.html";
        }
    }

}

