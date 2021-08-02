package com.xu.controller;

import com.xu.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @ApiOperation("User控制类")
    //只要我们接口中，返回值中存在这个类，它就会被扫描到Swagger中
    @GetMapping("/user")
    public User user(){
        return new User();
    }

/*
     //这个swagger会打不开，不知道啥原因
    @ApiOperation("User测试类")
    @PostMapping("/postt")
    public User postt(@ApiParam("用户") User user){
        return user;
    }*/

}
