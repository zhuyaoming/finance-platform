package com.yxyc.auth.server.util.client;

import com.yxyc.auth.common.util.jwt.IJWTInfo;
import com.yxyc.auth.common.util.jwt.JWTHelper;
import com.yxyc.auth.server.configuration.KeyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Yeoman
 * @description
 * @create 2018-03-28 14:22
 **/
@Configuration
public class ClientTokenUtil {
    @Value("${client.expire}")
    private int expire;
    @Autowired
    private KeyConfiguration keyConfiguration;

    public String generateToken(IJWTInfo jwtInfo) throws Exception {
        return JWTHelper.generateToken(jwtInfo, keyConfiguration.getServicePriKey(), expire);
    }

    public IJWTInfo getInfoFromToken(String token) throws Exception {
        return JWTHelper.getInfoFromToken(token, keyConfiguration.getServicePubKey());
    }
}
