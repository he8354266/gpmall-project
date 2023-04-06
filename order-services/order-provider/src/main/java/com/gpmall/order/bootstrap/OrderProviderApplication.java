package com.gpmall.order.bootstrap;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description //TODO
 * @Date 2023/4/6 9:42
 * @Author hy
 **/
@ComponentScan(basePackages = {"com.gpmall.order", "com.gpmall.commons.mq"})
@MapperScan(basePackages = "com.gpmall.order.dal")
@SpringBootApplication
public class OrderProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderProviderApplication.class, args);
    }
}
