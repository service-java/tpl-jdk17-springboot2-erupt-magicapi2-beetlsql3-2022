package com.example.demo;


import com.example.demo.util.GenCodeUtil;
import lombok.extern.java.Log;
import org.beetl.sql.core.SQLManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@Log
@SpringBootTest
class GenCodeTests {

    @Value("${spring.datasource.driver-class-name}")
    String driver;
    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String userName;
    @Value("${spring.datasource.password}")
    String password;

    String tplPath = "/src/test/resources/templates/";
//    String basePackageName = "com.example.demo";
    String basePackageName = "com.beetlsqlcodegen.demo";

    // 要生成的表格名
    List<String> tableNames = Arrays.asList(
            "user"
    );

    @Test
    void genCode() {
        SQLManager sqlManager = GenCodeUtil.getDataSource(driver, url, userName, password);
        GenCodeUtil.initGroupTemplate(tplPath);

        if (tableNames.size() > 0) {
            tableNames.stream().forEach(tableName -> {
                // 生成代码
                GenCodeUtil.genCode(sqlManager, basePackageName, tableName);
                // 生成数据库结构文档
                GenCodeUtil.genDoc(sqlManager, basePackageName, tableName);
            });
        }

    }

}
