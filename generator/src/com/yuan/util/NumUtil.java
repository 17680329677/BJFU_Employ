package com.yuan.util;

/**
 * 数字工具类
 * @author YouYuan
 * @version 1.0
 * @Email xiyousuiyuan@163.com
 * @Date 2018/2/2 16:04
 */
public class NumUtil {
    private static final int DEFAULT_COVER_INT_VAL = -1;

    public static int toInt(Object o) {
        return toInt(o, DEFAULT_COVER_INT_VAL);
    }

    /**
     * 对象转换成int，若转换失败返回给定的默认值
     * @param o 要转int的对象
     * @param defaultCoverIntVal 默认值
     * @return
     */
    public static int toInt(Object o, int defaultCoverIntVal) {
        if (o == null) {
            return defaultCoverIntVal;
        }
        try {
            return Integer.parseInt(o.toString().trim());
        } catch (Exception e) {
            return defaultCoverIntVal;
        }
    }
}
