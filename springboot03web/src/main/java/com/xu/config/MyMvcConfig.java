package com.xu.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

//拓展speingmvc  dispatcherservlet
@Configuration
@EnableWebMvc
public class MyMvcConfig implements WebMvcConfigurer {

}
