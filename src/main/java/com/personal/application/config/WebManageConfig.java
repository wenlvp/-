package com.personal.application.config;

import com.personal.application.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebManageConfig implements WebMvcConfigurer {
    /*

     * 注册拦截器*/

    @Override

    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginInterceptor());

    }
}
