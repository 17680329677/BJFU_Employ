package com.yuan.generatorcode.database;

import com.yuan.generatorcode.constant.DbConst;
import com.yuan.generatorcode.database.impl.MySqlDatabaseInfoReader;
import com.yuan.generatorcode.database.impl.OracleDatabaseInfoReader;

/**
 * 数据库读取器工厂类
 * @author YouYuan
 * @version 1.0
 * @Date 2018/4/11 14:38
 */
public class DatabaseReaderFactory {

    /**
     * 获取DatabaseInfoReader工厂方法
     * @param dbType
     * @return DatabaseInfoReader
     */
    public static DatabaseInfoReader getDatabaseInfoReader(String dbType) {
        DatabaseInfoReader dbReader;
        if (DbConst.DB_TYPE_MYSQL.equalsIgnoreCase(dbType)) {
            dbReader = new MySqlDatabaseInfoReader();
        } else if (DbConst.DB_TYPE_ORACLE.equalsIgnoreCase(dbType)) {
            dbReader = new OracleDatabaseInfoReader();
        } else {
            throw new RuntimeException("对不起,不支持的数据库：" + dbType);
        }
        return dbReader;
    }
}
