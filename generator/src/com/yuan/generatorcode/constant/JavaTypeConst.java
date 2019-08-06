package com.yuan.generatorcode.constant;

import com.yuan.generatorcode.bean.JavaType;

/**
 * JavaType常量，避免每次转换dbType到javaType都要new一个新对象
 * @author YouYuan
 * @version 1.0
 * @Email xiyousuiyuan@163.com
 * @Date 2018/1/4 17:59
 */
public class JavaTypeConst {
    public static final JavaType INT = new JavaType("Integer", "int", "java.lang.Integer");
    public static final JavaType LONG = new JavaType("Long", "long", "java.lang.Long");
    public static final JavaType STRING = new JavaType("String", "String", "java.lang.String");
    public static final JavaType DOUBLE = new JavaType("Double", "double", "java.lang.Double");
    public static final JavaType DATE = new JavaType("Date", "Date", "java.util.Date");
    public static final JavaType BOOLEAN = new JavaType("Boolean", "boolean", "java.lang.Boolean");
    public static final JavaType BIGDECIMAL = new JavaType("BigDecimal", "BigDecimal", "java.math.BigDecimal");
    public static final JavaType OBJECT = new JavaType("Object", "Object", "java.lang.Object");
}
