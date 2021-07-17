package com.xu.controller;

import com.xu.mapper.MemberDao;
import com.xu.pojo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberRestController {

    @Autowired
    MemberDao memberDao;

    // POST请求：添加会员信息
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

}
