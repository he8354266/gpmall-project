package com.gpmall.shopping.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description //TODO
 * @Date 2023/1/31 11:32
 * @Author hy
 **/
@SpringBootApplication
@ComponentScan(basePackages = {"com.gpmall.shopping"})
public class GpmallShoppingApplication {
    public static void main(String[] args) {
        SpringApplication.run(GpmallShoppingApplication.class, args);
    }
}
