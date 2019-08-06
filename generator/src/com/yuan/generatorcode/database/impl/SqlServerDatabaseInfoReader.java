package com.yuan.generatorcode.database.impl;

import com.yuan.generatorcode.bean.ColumnInfo;
import com.yuan.generatorcode.bean.JavaType;
import com.yuan.generatorcode.bean.TableInfo;
import com.yuan.generatorcode.config.DatabaseConfig;
import com.yuan.generatorcode.database.DatabaseInfoReader;

import java.util.List;

/**
 * SqlServer数据库信息读取类，暂未实现
 * @author YouYuan
 * @version 1.0
 * @Email xiyousuiyuan@163.com
 * @Date 2018/1/4 17:40
 */
public class SqlServerDatabaseInfoReader implements DatabaseInfoReader{
    @Override
    public List<ColumnInfo> getColumnsInfo(DatabaseConfig dbConfig) {
        return null;
    }

    @Override
    public List<TableInfo> getTablesInfo(DatabaseConfig dbConfig) {
        return null;
    }

    @Override
    public List<TableInfo> getTableInfo(DatabaseConfig dbConfig) {
        return null;
    }

    @Override
    public JavaType dbTypeCoverToJavaType(String dbType, String columnType) {
        return null;
    }

}
