package com.xu.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//拓展speingmvc  dispatcherservlet
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/welcome.html").setViewName("welcome");
    }



    //自定义的国际化组件
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }


    //自定义拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //只拦截后缀为.html的地址，登录界面除外
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/*.html")
                .excludePathPatterns("/login.html");
    }
}
