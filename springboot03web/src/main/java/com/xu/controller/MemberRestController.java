package com.xu.controller;

import com.xu.mapper.MemberDao;
import com.xu.pojo.Member;
import com.xu.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class MemberRestController {

    @Autowired
    MemberDao memberDao;

    // POST请求：添加会员信息，并返回消息！
    @PostMapping("/memberadd")
    public String memberadd(Member member){
        System.out.println("MemberController==>member-add2");
        //添加会员信息
        System.out.println(member);
        memberDao.save(member);
        //添加成功后重定位刷新会员列表
        if(true){
            return "添加成功！";
        }else{
            return "添加失败,请稍后重试。";
        }
    }


    // POST请求：添加会员信息，并返回消息！
    @PostMapping("/memberupdata")
    public String memberupdata(
            @RequestParam("id") Integer id,
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("role") Integer role,
            @RequestParam("phone") String phone){
        System.out.println("MemberResstController==>member-updata");
        //添加会员信息
        Member member = memberDao.getMemberById(id);
        member.setName(name);
        member.setEmail(email);
        member.setRole(role);
        member.setPhone(phone);

        System.out.println(member);
        memberDao.save(member);
        //添加成功后重定位刷新会员列表
        if(true){
            return "修改成功！";
        }else{
            return "修改失败,请稍后重试。";
        }
    }
}
