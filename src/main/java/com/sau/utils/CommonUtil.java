package com.sau.utils;

import java.util.UUID;

/**
 * 工具类的封装uuid
 */
public class CommonUtil {

    public static String PATH = "C:/test";

    /**
     * 生成 uuid， 即用来标识一笔单，也用做 nonce_str
     * @return String
     */
    public static String generateUUID(){
        return UUID.randomUUID().toString().replaceAll("-","").substring(0,32);
    }
}
