package com.yxyc.auth.server.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
* @description 
* @author Yeoman
* @create 2018-03-28 14:09
**/
@Configuration
public class ClientConfiguration {
    // 应用名称
    @Value("${client.id}")
    private String clientId;
    // 应用密钥
    @Value("${client.secret}")
    private String clientSecret;
    // 应用Token-header
    @Value("${client.token-header}")
    private String clientTokenHeader;

    public String getClientTokenHeader() {
        return clientTokenHeader;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getClientId() {
        return clientId;
    }


}
