package com.yxyc.auth.server.controller;

import com.yxyc.auth.server.biz.ClientBiz;
import com.yxyc.auth.server.entity.Client;
import com.yxyc.auth.server.entity.ClientService;
import com.yxyc.common.msg.ObjectRestResponse;
import com.yxyc.common.rest.BaseController;
import org.springframework.web.bind.annotation.*;

/**
* @description 
* @author Yeoman
* @create 2018-03-28 16:32
**/
@RestController
@RequestMapping("service")
public class ServiceController extends BaseController<ClientBiz,Client> {

    @RequestMapping(value = "/{id}/client", method = RequestMethod.PUT)
    @ResponseBody
    public ObjectRestResponse modifyUsers(@PathVariable int id, String clients){
        baseBiz.modifyClientServices(id, clients);
        return new ObjectRestResponse().rel(true);
    }

    @RequestMapping(value = "/{id}/client", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse<ClientService> getUsers(@PathVariable int id){
        return new ObjectRestResponse<ClientService>().rel(true).data(baseBiz.getClientServices(id));
    }
}
