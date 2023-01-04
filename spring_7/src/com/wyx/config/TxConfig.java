package com.wyx.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

//完全注解声明式事务管理
//完全注解开发模式最好不要和xml文件混在一起，容易navigate到奇怪的地方
@Configuration
@ComponentScan(basePackages = "com.wyx")
@EnableTransactionManagement //开启事务
public class TxConfig {
    //在ioc容器中创建数据库连接池对象
    @Bean
    public DruidDataSource getDruidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/test");
        dataSource.setUsername("root");
        dataSource.setPassword("wyxc2h4664dszwy");
        return dataSource;
    }

    //创建JdbcTemplate对象
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //根据参数类型去ioc容器中找到对应的dataSource，并注入dataSource
        jdbcTemplate.setDataSource(dataSource);
        //以下写法也可以，但是会额外创建对象，相当于getDruidDataSource方法会执行两次
//        jdbcTemplate.setDataSource(getDruidDataSource());
        return jdbcTemplate;
    }

    //创建事务管理器对象
    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}
