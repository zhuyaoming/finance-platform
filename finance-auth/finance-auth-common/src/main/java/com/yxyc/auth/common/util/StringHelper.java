package com.yxyc.auth.common.util;

/**
 * @author Yeoman
 * @description
 * @create 2018-03-28 13:54
 **/
public class StringHelper {
    public static String getObjectValue(Object obj) {
        return obj == null ? "" : obj.toString();
    }
}
