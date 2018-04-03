package com.yxyc.auth.server.service;

import java.util.List;

/**
 * @author Yeoman
 * @description
 * @create 2018-03-28 14:16
 **/
public interface AuthClientService {
    // 根据客户名称和密钥生成Token
    String apply(String clientId, String secret) throws Exception;

    /**
     * 获取授权的客户端列表
     * @param serviceId
     * @param secret
     * @return
     */
    List<String> getAllowedClient(String serviceId, String secret);

    /**
     * 获取服务授权的客户端列表
     * @param serviceId
     * @return
     */
    List<String> getAllowedClient(String serviceId);

    void registryClient();

    void validate(String clientId, String secret) throws Exception;
}