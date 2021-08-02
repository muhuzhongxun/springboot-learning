package com.xu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

//开启异步注解
@EnableAsync
@SpringBootApplication
public class Sprintboot09TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sprintboot09TestApplication.class, args);
    }

}
