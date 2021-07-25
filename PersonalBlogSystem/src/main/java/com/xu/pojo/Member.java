package com.xu.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//会员表
@Data
@NoArgsConstructor
public class Member {
    private Integer id;//会员编号
    private String name;//会员用户名
    private String password;//会员密码
    private String email;//会员邮箱
    private Integer gender;//会员性别：0:女  1：男
    private String phone;//电话号码
    private String address;//地址
    private String order;//订单
    private Integer status;//账号状态：0:禁用  1：启用
    private Integer role;//权限：0:普通用户 1：会员 2：超级会员 3：管理员
    private Date joiningtime;//会员加入时间 yyyy/mm/dd HH:mm
    private Date lasttime;//会员最后一次登录的时间

    public Member(Integer id, String name, String password, String email, Integer gender, String phone, String address, String order, Integer status, Integer role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.order = order;
        this.status = status;
        this.role = role;
        this.joiningtime = new Date();
        this.lasttime = new Date();
    }
}
