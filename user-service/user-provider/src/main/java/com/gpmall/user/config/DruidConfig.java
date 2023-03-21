package com.gpmall.user.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.beans.ConstructorProperties;

/**
 * @Description //TODO
 * @Date 2023/3/20 18:05
 * @Author hy
 **/
public class DruidConfig {
    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource druid() {
       return new DruidDataSource();
    }
}
