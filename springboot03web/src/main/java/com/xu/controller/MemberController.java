package com.xu.controller;

import com.xu.mapper.MemberDao;
import com.xu.mapper.RoleDao;
import com.xu.pojo.Member;
import com.xu.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class MemberController {

    @Autowired
    MemberDao memberDao;

    @Autowired
    RoleDao roleDao;

    @RequestMapping("/memberlist")
    public String memberlist(Model model){
        System.out.println("MemberController==>member-list");
        Collection<Member> members = memberDao.getMembers();
        model.addAttribute("members",members);
        return "member-list.html";
    }

    // GET请求：点击添加用户信息时，弹窗并列出所有权限信息
    @GetMapping("/memberadd")
    public String rolelist(Model model){
        System.out.println("MemberController==>member-add");
        //获得所有权限的信息
        Collection<Role> roles = roleDao.getRole();
        model.addAttribute("roles",roles);
        return "member-add.html";
    }


}
