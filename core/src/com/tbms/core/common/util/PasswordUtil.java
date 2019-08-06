package com.tbms.core.common.util;

import org.apache.shiro.crypto.hash.SimpleHash;

public class PasswordUtil {
    public static String hashPwd(String password,String salt){
        return new SimpleHash("MD5",password,salt,3).toHex();
    }
}
