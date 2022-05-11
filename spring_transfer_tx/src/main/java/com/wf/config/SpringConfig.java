package com.wf.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration    //声明为Spring的核心配置类
@ComponentScan("com.wf")   //开始扫描包
@Import(DataSourceConfig.class)   //导入其他配置文件
@EnableTransactionManagement      //事务注解驱动
public class SpringConfig {


    @Bean
    public JdbcTemplate jdbcTemplate(@Autowired DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }

    @Bean
    public PlatformTransactionManager getplatformTransactionManager(@Autowired DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
        return dataSourceTransactionManager;
    }
}
