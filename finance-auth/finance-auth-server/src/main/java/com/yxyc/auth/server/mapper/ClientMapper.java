package com.yxyc.auth.server.mapper;

import com.yxyc.auth.server.entity.Client;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Yeoman
 * @description
 * @create 2018-03-28 14:28
 **/
public interface ClientMapper extends Mapper<Client> {

    List<String> selectAllowedClient(String serviceId);

    List<Client> selectAuthorityServiceInfo(int clientId);
}