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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
public class MemberController {

    @Autowired
    MemberDao memberDao;

    @Autowired
    RoleDao roleDao;

    // 列出所有用户信息
    @RequestMapping("/memberlist")
    public String memberlist(Model model){
        System.out.println("MemberController==>member-list");
        Collection<Member> members = memberDao.getMembers();
        model.addAttribute("members",members);
        return "member/member-list.html";
    }

    // GET请求：点击添加用户信息时，弹窗并列出所有权限信息
    @GetMapping("/memberadd")
    public String rolelist(Model model){
        System.out.println("MemberController==>member-add");
        //获得所有权限的信息
        Collection<Role> roles = roleDao.getRole();
        model.addAttribute("roles",roles);
        return "member/member-add.html";
    }

    // Get请求：根据id返回该会员消息！并列出所有权限信息
    @GetMapping("/memberedit")
    public String getTheMember(@RequestParam("id") Integer id,Model model){
        System.out.println("MemberRestController==>member-edit");
        //查询会员信息
        Member member = memberDao.getMemberById(id);
        model.addAttribute("member",member);
        //及其订单
        //获得所有权限的信息
        Collection<Role> roles = roleDao.getRole();
        model.addAttribute("roles",roles);

        System.out.println("正尝试跳转到 member/member-edit.html");
        //跳转到编辑会员信息页面
        return "member/member-edit.html";
    }

    @GetMapping("/memberpassword")
    public String modifypass(@RequestParam("id") Integer id,Model model){
        System.out.println("MemberRestController==>member-password");
        //查询会员信息
        Member member = memberDao.getMemberById(id);
        model.addAttribute("member",member);
        //跳转到重置密码页面
        return "member/member-password.html";
    }



}
