package com.yxyc.common.exception.auth;

import com.yxyc.common.constant.CommonConstants;
import com.yxyc.common.exception.BaseException;

/**
* @description 
* @author Yeoman
* @create 2018-03-28 14:49
**/
public class ClientInvalidException extends BaseException {
    public ClientInvalidException(String message) {
        super(message, CommonConstants.EX_CLIENT_INVALID_CODE);
    }
}

