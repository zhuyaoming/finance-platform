package com.yxyc.auth.server.service.impl;

import com.yxyc.auth.server.bean.ClientInfo;
import com.yxyc.auth.server.entity.Client;
import com.yxyc.auth.server.mapper.ClientMapper;
import com.yxyc.auth.server.service.AuthClientService;
import com.yxyc.auth.server.util.client.ClientTokenUtil;
import com.yxyc.common.exception.auth.ClientInvalidException;
import com.yxyc.common.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yeoman
 * @description
 * @create 2018-03-28 14:19
 **/
@Service
public class DBAuthClientService implements AuthClientService {
    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private ClientTokenUtil clientTokenUtil;
    @Autowired
    private DiscoveryClient discovery;
    private ApplicationContext context;

    @Autowired
    public DBAuthClientService(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public String apply(String clientId, String secret) throws Exception {
        Client client = getClient(clientId, secret);
        return clientTokenUtil.generateToken(new ClientInfo(client.getCode(), client.getName(), client.getId().toString()));
    }

    private Client getClient(String clientId, String secret) {
        Client client = new Client();
        client.setCode(clientId);
        client = clientMapper.selectOne(client);
        if (client == null || !client.getSecret().equals(secret)) {
            throw new ClientInvalidException("Client not found or Client secret is error!");
        }
        return client;
    }

    @Override
    public void validate(String clientId, String secret) throws Exception {
        Client client = new Client();
        client.setCode(clientId);
        client = clientMapper.selectOne(client);
        if (client == null || !client.getSecret().equals(secret)) {
            throw new ClientInvalidException("Client not found or Client secret is error!");
        }
    }

    @Override
    public List<String> getAllowedClient(String clientId, String secret) {
        Client info = this.getClient(clientId, secret);
        List<String> clients = clientMapper.selectAllowedClient(info.getId() + "");
        if (clients == null) {
            new ArrayList<String>();
        }
        return clients;
    }

    @Override
    public List<String> getAllowedClient(String serviceId) {
        Client info = getClient(serviceId);
        List<String> clients = clientMapper.selectAllowedClient(info.getId() + "");
        if (clients == null) {
            new ArrayList<String>();
        }
        return clients;
    }

    private Client getClient(String clientId) {
        Client client = new Client();
        client.setCode(clientId);
        client = clientMapper.selectOne(client);
        return client;
    }

    @Override
    @Scheduled(cron = "0 0/1 * * * ?")
    public void registryClient() {
        // 自动注册节点
        discovery.getServices().forEach((name) -> {
            Client client = new Client();
            client.setName(name);
            client.setCode(name);
            Client dbClient = clientMapper.selectOne(client);
            if (dbClient == null) {
                client.setSecret(UUIDUtils.generateShortUuid());
                clientMapper.insert(client);
            }
        });
    }
}
