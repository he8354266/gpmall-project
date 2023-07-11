package com.gpmall.pay.bootstrap;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description //TODO
 * @Date 2023/7/4 10:05
 * @Author hy
 **/
@SpringBootApplication
@ComponentScan(basePackages = {"com.gpmall.pay"})
@MapperScan(basePackages = {"com.gpmall.pay.dal"})
public class PayProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(PayProviderApplication.class, args);
    }
}
