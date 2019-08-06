package com.yuan.generatorcode.database.impl;

import com.yuan.generatorcode.bean.ColumnInfo;
import com.yuan.generatorcode.bean.JavaType;
import com.yuan.generatorcode.bean.TableInfo;
import com.yuan.generatorcode.config.DatabaseConfig;
import com.yuan.generatorcode.constant.JavaTypeConst;
import com.yuan.generatorcode.database.DatabaseInfoReader;
import com.yuan.generatorcode.util.JdbcUtil;
import com.yuan.util.StringUtil;
import com.yuan.util.WordUtil;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Explain:     [MySql数据库信息读取实现类]
 * Date:        [2017/12/7 10:04]
 * Coder:       [YouYuan]
 * Version:     [1.0]
 */
public class MySqlDatabaseInfoReader implements DatabaseInfoReader {

    /**SQL:查询数据表列信息*/
    private static final String SQL_QUERY_COLUMN_INFO = "SELECT COLUMN_NAME, COLUMN_KEY, IS_NULLABLE, DATA_TYPE, COLUMN_TYPE, COLUMN_DEFAULT, COLUMN_COMMENT " +
            "FROM INFORMATION_SCHEMA.COLUMNS WHERE table_name=? AND table_schema=?";
    /**SQL:查询数据表信息*/
    private static final String SQL_QUERY_TABLE_INFO = "SELECT TABLE_NAME,TABLE_COMMENT FROM information_schema.TABLES t WHERE table_schema=? AND table_type='base table'";

    @Override
    public List<ColumnInfo> getColumnsInfo(DatabaseConfig dbConfig) {
        String dbName = dbConfig.getDbName();
        String tableName = dbConfig.getTableName();
        Connection connection = dbConfig.getConnection();
        List<Map> mapList = JdbcUtil.executeSql(connection, SQL_QUERY_COLUMN_INFO, tableName, dbName);
        List<ColumnInfo> list = new ArrayList<ColumnInfo>();
        for (Map map : mapList) {
            ColumnInfo columnInfo = new ColumnInfo();
            String column = StringUtil.trim(map.get("COLUMN_NAME"));//数据库字段名
            String columnKey = StringUtil.trim(map.get("COLUMN_KEY"));
            String isNull = StringUtil.trim(map.get("IS_NULLABLE"));
            String dataType = StringUtil.trim(map.get("DATA_TYPE"));
            String columnType = StringUtil.trim(map.get("COLUMN_TYPE"));
            String columnDefault = (String) map.get("COLUMN_DEFAULT");
            String columnComment = StringUtil.trim(map.get("COLUMN_COMMENT"));
            columnInfo.setColumn(column);
            columnInfo.setDataType(dataType);
            columnInfo.setColumnType(columnType);
            columnInfo.setColumnDefault(columnDefault);
            columnInfo.setColumnComment(columnComment);
            if (columnKey.contains("PRI")) {
                columnInfo.setPrimaryKey(true);
                columnInfo.setUnique(true);
            }
            if (columnKey.contains("UNI")) {
                columnInfo.setUnique(true);
            }
            if ("NO".equalsIgnoreCase(isNull)) {
                columnInfo.setNull(false);
            }
            columnInfo.setColumnLen(WordUtil.extractColumnLen(columnType));
            list.add(columnInfo);
        }
        return list;
    }

    @Override
    public List<TableInfo> getTablesInfo(DatabaseConfig dbConfig) {
        String dbName = dbConfig.getDbName();
        StringBuilder sql = new StringBuilder(SQL_QUERY_TABLE_INFO);
        /**
         * 生成排除设定表的sql
         */
        String removeTables = StringUtil.trim(dbConfig.getRemoveTables());
        String[] split = removeTables.split(",");
        if (split.length > 0 && split[0].length() > 0) {
            sql.append(" AND t.TABLE_NAME NOT IN(");
            for (int i = 0; i < split.length; i++) {
                if (i != 0) {
                    sql.append(",");
                }
                sql.append("'" + StringUtil.trim(split[i]) + "'");
            }
            sql.append(")");
        }
        Connection connection = dbConfig.getConnection();
        List<Map> mapList = JdbcUtil.executeSql(connection, sql.toString(), dbName);
        List<TableInfo> list = new ArrayList<TableInfo>();
        for (Map map : mapList) {
            String table = StringUtil.trim(map.get("TABLE_NAME"));
            String tableComment = StringUtil.trim(map.get("TABLE_COMMENT"));
            TableInfo tableInfo = new TableInfo();
            tableInfo.setTable(table);
            tableInfo.setTableComment(tableComment);
            list.add(tableInfo);
        }
        return list;
    }

    @Override
    public List<TableInfo> getTableInfo(DatabaseConfig dbConfig) {
        String dbName = dbConfig.getDbName();
        String tableName = StringUtil.trim(dbConfig.getTableName());
        StringBuilder sql = new StringBuilder(SQL_QUERY_TABLE_INFO);
        /**
         * 生成查询指定表的sql
         */
        String[] split = tableName.split(",");
        if (split.length > 0 && split[0].length() > 0) {
            sql.append(" AND TABLE_NAME IN(");
            for (int i = 0; i < split.length; i++) {
                if (i != 0) {
                    sql.append(",");
                }
                sql.append("'" + StringUtil.trim(split[i]) + "'");
            }
            sql.append(")");
        }
        Connection connection = dbConfig.getConnection();
        List<Map> mapList = JdbcUtil.executeSql(connection, sql.toString(), dbName);
        List<TableInfo> list = new ArrayList<TableInfo>();
        for (Map map : mapList) {
            String table = StringUtil.trim(map.get("TABLE_NAME"));
            String tableComment = StringUtil.trim(map.get("TABLE_COMMENT"));
            TableInfo tableInfo = new TableInfo();
            tableInfo.setTable(table);
            tableInfo.setTableComment(tableComment);
            list.add(tableInfo);
        }
        return list;
    }

    @Override
    public JavaType dbTypeCoverToJavaType(String dbType, String columnType) {
        dbType = StringUtil.trim(dbType);
        if (StringUtil.whereStrInIgnoreCase(dbType, "int", "integer","tinyint","smallint","mediumint")) {
            return JavaTypeConst.INT;
        } else if (StringUtil.whereStrInIgnoreCase(dbType, "bigint")) {
            return JavaTypeConst.LONG;
        } else if (StringUtil.whereStrInIgnoreCase(dbType, "varchar", "text", "longtext", "char")) {
            return JavaTypeConst.STRING;
        } else if (StringUtil.whereStrInIgnoreCase(dbType, "decimal", "float", "numeric", "double")) {
            return JavaTypeConst.DOUBLE;
        } else if (StringUtil.whereStrInIgnoreCase(dbType, "datetime", "timestamp", "date", "time")) {
            return JavaTypeConst.DATE;
        } else if (StringUtil.whereStrInIgnoreCase(dbType, "boolean", "bit")) {
            return JavaTypeConst.BOOLEAN;
        } else {
            return JavaTypeConst.OBJECT;
        }
    }
}
