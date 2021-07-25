package com.xu.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){

        return new DruidDataSource();
    }


    //后台监控: web.xml,ServletRegistrationBean

    //因为SpringBoot 内置了Serlvet容器，所有没有web.xml，替代的方法：ServletRegistrationBean
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> statViewServletServletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        //后台需要有人登录，账号密码配置
        HashMap<String, String> initParameter = new HashMap<>();
        //增加配置,登录的key是固定的”loginUsername“、”loginPassword“
        initParameter.put("loginUsername","muhuzhongxun");
        initParameter.put("loginPassword","123456");

        //允许谁可以访问  空为允许所有人
        initParameter.put("allow","");

//        //禁止谁能访问
//        initParameter.put("xu","192.168.1.1");


        statViewServletServletRegistrationBean.setInitParameters(initParameter);//设置初始化参数
        return statViewServletServletRegistrationBean;
    }

    //filter 过滤器
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        //可以过滤那些请求呢？
        Map<String,String> initParameters = new HashMap<>();

        //这些东西不进行统计
        initParameters.put("exclusions","*.js,*.css,/druid/*");

        bean.setInitParameters(initParameters);
        return bean;
    }


}

