package com.xu.controller;

import com.xu.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    //告诉springboot这是异步任务
    @Async
    @RequestMapping("/hello")
    public String hello(){
        asyncService.hello();
        return "ok";
    }
}
