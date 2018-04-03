package com.yxyc.auth.common.util.jwt;

/**
 * @author Yeoman
 * @description
 * @create 2018-03-28 13:57
 **/
public interface IJWTInfo {
    /**
     * 获取用户名
     *
     * @return
     */
    String getUniqueName();

    /**
     * 获取用户ID
     *
     * @return
     */
    String getId();

    /**
     * 获取名称
     *
     * @return
     */
    String getName();
}
