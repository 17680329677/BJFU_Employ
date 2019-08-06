package com.yuan.generatorcode.database.impl;

import com.yuan.generatorcode.bean.ColumnInfo;
import com.yuan.generatorcode.bean.JavaType;
import com.yuan.generatorcode.bean.TableInfo;
import com.yuan.generatorcode.config.DatabaseConfig;
import com.yuan.generatorcode.constant.JavaTypeConst;
import com.yuan.generatorcode.database.DatabaseInfoReader;
import com.yuan.generatorcode.util.JdbcUtil;
import com.yuan.util.NumUtil;
import com.yuan.util.StringUtil;
import com.yuan.util.WordUtil;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Oracle数据库信息读取类
 * @author YouYuan
 * @version 1.0
 * @Email xiyousuiyuan@163.com
 * @Date 2018/4/12 14:26
 */
public class OracleDatabaseInfoReader implements DatabaseInfoReader{

    /**SQL:查询数据表列信息*/
    private static final String SQL_QUERY_COLUMN_INFO = "SELECT A.COLUMN_NAME, A.DATA_TYPE, A.DATA_LENGTH, A.NULLABLE, a.DATA_DEFAULT, (CASE WHEN A.DATA_TYPE = 'NUMBER' THEN (CASE WHEN A.DATA_PRECISION IS NULL THEN A.DATA_TYPE WHEN NVL(A.DATA_SCALE, 0) > 0 THEN A.DATA_TYPE || '(' || A.DATA_PRECISION || ',' || A.DATA_SCALE || ')'ELSE A.DATA_TYPE || '(' || A.DATA_PRECISION || ')'END) ELSE A.DATA_TYPE END) COLUMN_TYPE, B.COMMENTS COLUMN_COMMENT, DECODE(C.POSITION, '1', 'PRI') COLUMN_KEY FROM USER_TAB_COLUMNS A INNER JOIN USER_COL_COMMENTS B ON A.TABLE_NAME = B.TABLE_NAME AND A.COLUMN_NAME = B.COLUMN_NAME LEFT JOIN USER_CONSTRAINTS D ON D.TABLE_NAME = A.TABLE_NAME AND D.CONSTRAINT_TYPE = 'P'LEFT JOIN USER_CONS_COLUMNS C ON C.CONSTRAINT_NAME = D.CONSTRAINT_NAME AND C.COLUMN_NAME = A.COLUMN_NAME WHERE A.TABLE_NAME = ?";
    /**SQL:查询数据表信息*/
    private static final String SQL_QUERY_TABLE_INFO = "SELECT t.TABLE_NAME,c.COMMENTS AS TABLE_COMMENT FROM USER_TABLES t left join USER_TAB_COMMENTS c on t.TABLE_NAME = c.TABLE_NAME WHERE 1=1";

    @Override
    public List<ColumnInfo> getColumnsInfo(DatabaseConfig dbConfig) {
        String tableName = dbConfig.getTableName();
        Connection connection = dbConfig.getConnection();
        List<Map> mapList = JdbcUtil.executeSql(connection, SQL_QUERY_COLUMN_INFO, tableName);
        List<ColumnInfo> list = new ArrayList<ColumnInfo>();
        for (Map map : mapList) {
            ColumnInfo columnInfo = new ColumnInfo();
            String column = StringUtil.trim(map.get("COLUMN_NAME"));//数据库字段名
            String columnKey = StringUtil.trim(map.get("COLUMN_KEY"));
            String isNull = StringUtil.trim(map.get("NULLABLE"));
            String dataType = StringUtil.trim(map.get("DATA_TYPE"));
            String columnType = StringUtil.trim(map.get("COLUMN_TYPE"));
            String columnDefault = (String) map.get("DATA_DEFAULT");
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
            if ("N".equalsIgnoreCase(isNull)) {
                columnInfo.setNull(false);
            }
            columnInfo.setColumnLen(WordUtil.extractColumnLen(columnType));
            list.add(columnInfo);
        }
        return list;
    }

    @Override
    public List<TableInfo> getTablesInfo(DatabaseConfig dbConfig) {
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
        List<Map> mapList = JdbcUtil.executeSql(connection, sql.toString());
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
        String tableName = StringUtil.trim(dbConfig.getTableName());
        StringBuilder sql = new StringBuilder(SQL_QUERY_TABLE_INFO);
        /**
         * 生成查询指定表的sql
         */
        String[] split = tableName.split(",");
        if (split.length > 0 && split[0].length() > 0) {
            sql.append(" AND t.TABLE_NAME IN(");
            for (int i = 0; i < split.length; i++) {
                if (i != 0) {
                    sql.append(",");
                }
                sql.append("'" + StringUtil.trim(split[i]) + "'");
            }
            sql.append(")");
        }
        Connection connection = dbConfig.getConnection();
        List<Map> mapList = JdbcUtil.executeSql(connection, sql.toString());
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

    private static final Pattern columnLenPattern = Pattern.compile("\\(.+\\)");

    @Override
    public JavaType dbTypeCoverToJavaType(String dbType, String columnType) {
        dbType = StringUtil.trim(dbType);
        if (StringUtil.whereStrInIgnoreCase(dbType, "CHAR", "VARCHAR2", "LONG")) {
            return JavaTypeConst.STRING;
        } else if (StringUtil.whereStrInIgnoreCase(dbType, "NUMBER")) {
            int[] lens = getColumnLens(columnType);
            if (lens[1] != 0) {
                // 带小数位则类型为BigDecimal
                return JavaTypeConst.BIGDECIMAL;
            } else {
                // 无小数位默认为Long
                return JavaTypeConst.LONG;
            }
        } else if (StringUtil.whereStrInIgnoreCase(dbType, "DATE")) {
            return JavaTypeConst.DATE;
        } else {
            return JavaTypeConst.OBJECT;
        }
    }

    private int[] getColumnLens(String columnType) {
        Matcher matcher = columnLenPattern.matcher(columnType);
        int[] lens = new int[2];
        if (matcher.find()) {
            String group = matcher.group();
            group = group.substring(1, group.length() - 1);
            String[] split = group.split(",");
            for (int i = 0; i < split.length; i++) {
                int n = NumUtil.toInt(split[0], 0);
                lens[i] = n;
                if (i >= 1) {
                    break;
                }
            }
        }
        return lens;
    }
}
