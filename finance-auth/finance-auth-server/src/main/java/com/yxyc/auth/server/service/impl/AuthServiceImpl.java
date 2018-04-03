package com.yxyc.auth.server.service.impl;

import com.yxyc.api.vo.user.UserInfo;
import com.yxyc.auth.common.util.jwt.JWTInfo;
import com.yxyc.auth.server.feign.IUserService;
import com.yxyc.auth.server.service.AuthService;
import com.yxyc.auth.server.util.user.JwtAuthenticationRequest;
import com.yxyc.auth.server.util.user.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
* @description 
* @author Yeoman
* @create 2018-03-28 16:02
**/
@Service
public class AuthServiceImpl implements AuthService {

    private JwtTokenUtil jwtTokenUtil;
    private IUserService userService;

    @Autowired
    public AuthServiceImpl(
            JwtTokenUtil jwtTokenUtil,
            IUserService userService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
    }

    @Override
    public String login(JwtAuthenticationRequest authenticationRequest) throws Exception {
        UserInfo info = userService.validate(authenticationRequest);
        String token = "";
        if (!StringUtils.isEmpty(info.getId())) {
            token = jwtTokenUtil.generateToken(new JWTInfo(info.getUsername(), info.getId() + "", info.getName()));
        }
        return token;
    }

    @Override
    public void validate(String token) throws Exception {
        jwtTokenUtil.getInfoFromToken(token);
    }

    @Override
    public Boolean invalid(String token) {
        // TODO: 2017/9/11 注销token
        return null;
    }

    @Override
    public String refresh(String oldToken) {
        // TODO: 2017/9/11 刷新token
        return null;
    }
}
