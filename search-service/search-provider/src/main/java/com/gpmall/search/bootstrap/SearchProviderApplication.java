package com.gpmall.search.bootstrap;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @Description //TODO
 * @Date 2023/6/21 16:30
 * @Author hy
 **/
@SpringBootApplication
@ComponentScan(basePackages = "com.gpmall.search")
@MapperScan(basePackages = "com.gpmall.search.dal")
@EnableElasticsearchRepositories(basePackages = "com.gpmall.search.repository")
public class SearchProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SearchProviderApplication.class, args);
    }
}
