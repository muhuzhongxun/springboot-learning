package com.xu.service;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    int n = 1 ;

    @Scheduled(cron= "0/10 * * * * 0-7") //什么时候执行
    public void hello(){
        System.out.println("hello~ScheduledService已执行了"+(n++)+"次");
    }

}
