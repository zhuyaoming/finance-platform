package com.yxyc.common.exception.auth;

import com.yxyc.common.constant.CommonConstants;
import com.yxyc.common.exception.BaseException;

/**
 * @author Yeoman
 * @description
 * @create 2018-03-28 15:17
 **/
public class ClientForbiddenException extends BaseException {
    public ClientForbiddenException(String message) {
        super(message, CommonConstants.EX_CLIENT_FORBIDDEN_CODE);
    }

}

