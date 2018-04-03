package com.yxyc.gate;


import com.yxyc.auth.client.EnableFinanceAuthClient;
import com.yxyc.gate.ratelimit.EnableAceGateRateLimit;
import com.yxyc.gate.ratelimit.config.IUserPrincipal;
import com.yxyc.gate.config.UserPrincipal;
import com.yxyc.gate.utils.DBLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Ace on 2017/6/2.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients({"com.yxyc.auth.client.feign","com.yxyc.gate.feign"})
@EnableZuulProxy
@EnableScheduling
@EnableFinanceAuthClient
@EnableAceGateRateLimit
public class GateBootstrap {
    public static void main(String[] args) {
        DBLog.getInstance().start();
        SpringApplication.run(GateBootstrap.class, args);
    }

    @Bean
    @Primary
    IUserPrincipal userPrincipal(){
        return new UserPrincipal();
    }
}
