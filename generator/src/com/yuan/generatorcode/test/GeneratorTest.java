package com.yuan.generatorcode.test;

import com.yuan.generatorcode.config.DatabaseConfig;
import com.yuan.generatorcode.config.GeneratorConfig;
import com.yuan.generatorcode.config.GlobalConfig;
import com.yuan.generatorcode.core.GeneratorCode;

/**
 * Explain:文件生成测试
 * Date:2017/12/13 13:58
 * Coder:YouYuan
 * Version:1.0
 */
public class GeneratorTest {
    public static void main(String[] args) {
        mysqlTest();
    }

    private static void mysqlTest() {
        GeneratorConfig generatorConfig = new GeneratorConfig();
        generatorConfig.setAuthor("dhz");
        generatorConfig.setPackageName("com.tbms.core");
        generatorConfig.setTemplateRoot("~/defaultTemplate/SSM");//使用~代表从classpath读取模板
        generatorConfig.setOutputPath("D:/Develop/AGCode");
        DatabaseConfig databaseConfig = new DatabaseConfig();
        String dbName = "employ";//数据库名
        databaseConfig.setTableName("token");
        databaseConfig.setDbUrl("jdbc:mysql://localhost:3306/" + dbName + "?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true");
        databaseConfig.setDbName(dbName);//设置数据库名
        databaseConfig.setUsername("root");
        databaseConfig.setPassword("123456");
        databaseConfig.setRemoveTables("log,resource,role,role_resource");
        //databaseConfig.setTablePrefix("t_");
        GlobalConfig globalConfig = new GlobalConfig();
//        globalConfig.setOpenFileManager(true);
//        globalConfig.setTemplateStatementStart("<%");
//        globalConfig.setTemplateStatementEnd("%>");
        GeneratorCode generatorCode = new GeneratorCode(databaseConfig, generatorConfig, globalConfig);//写法一，使用配置信息创建文件生成核心类
//        generatorCode.setDatabaseConfig(databaseConfig) //写法二，应用数据库设置
//                .setGeneratorConfig(generatorConfig) //应用文件生成信息配置
//                .setGlobalConfig(globalConfig); //应用全局配置
        generatorCode.batchGenerator();//执行批量生成
        //generatorCode.generator();//执行指定表生成
//        List<GeneratorInfo> buildData = generatorCode.getBuildData();//获取构建数据集
//        System.out.println(buildData);
    }
}
