package com.yxyc.auth.server.feign;

import com.yxyc.api.vo.user.UserInfo;
import com.yxyc.auth.server.configuration.FeignConfiguration;
import com.yxyc.auth.server.util.user.JwtAuthenticationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 该接口使用Feign消费服务,feign 默认使用负载均衡
 *
 * @author wanghaobin
 * @create 2017-06-21 8:11
 */
@FeignClient(value = "fin-admin",configuration = FeignConfiguration.class)
public interface IUserService {
  @RequestMapping(value = "/api/user/validate", method = RequestMethod.POST)
  public UserInfo validate(@RequestBody JwtAuthenticationRequest authenticationRequest);
}
