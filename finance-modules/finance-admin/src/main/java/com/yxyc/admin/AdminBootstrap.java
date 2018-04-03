package com.yxyc.admin;

import com.ace.cache.EnableAceCache;
import com.spring4all.swagger.EnableSwagger2Doc;
import com.yxyc.auth.client.EnableFinanceAuthClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
* @description 
* @author Yeoman
* @create 2018-03-30 15:53
**/
@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
@EnableFeignClients({"com.yxyc.auth.client.feign"})
@EnableScheduling
@EnableFinanceAuthClient
@EnableAceCache
@EnableTransactionManagement
@MapperScan("com.yxyc.admin.mapper")
@EnableSwagger2Doc
public class AdminBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(AdminBootstrap.class).web(true).run(args);    }
}
