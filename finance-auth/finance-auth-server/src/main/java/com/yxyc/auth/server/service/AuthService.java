package com.yxyc.auth.server.service;

import com.yxyc.auth.server.util.user.JwtAuthenticationRequest;

/**
 * @author Yeoman
 * @description
 * @create 2018-03-28 16:01
 **/
public interface AuthService {
    String login(JwtAuthenticationRequest authenticationRequest) throws Exception;
    String refresh(String oldToken);
    void validate(String token) throws Exception;
    Boolean invalid(String token);
}
