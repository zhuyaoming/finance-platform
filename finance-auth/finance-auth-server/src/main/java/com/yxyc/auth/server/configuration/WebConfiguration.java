package com.yxyc.auth.server.configuration;

import com.yxyc.auth.server.interceptor.ServiceAuthRestInterceptor;
import com.yxyc.auth.server.interceptor.UserAuthRestInterceptor;
import com.yxyc.common.handler.GlobalExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
* @description 
* @author Yeoman
* @create 2018-03-28 15:55
**/
@Configuration("admimWebConfig")
@Primary
public class WebConfiguration implements WebMvcConfigurer {
    @Bean
    GlobalExceptionHandler getGlobalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则 /service/** 使用下面2个拦截器
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(getServiceAuthRestInterceptor()).addPathPatterns("/service/**");
        registry.addInterceptor(getUserAuthRestInterceptor()).addPathPatterns("/service/**");
    }

    @Bean
    ServiceAuthRestInterceptor getServiceAuthRestInterceptor() {
        return new ServiceAuthRestInterceptor();
    }

    @Bean
    UserAuthRestInterceptor getUserAuthRestInterceptor() {
        return new UserAuthRestInterceptor();
    }

}
