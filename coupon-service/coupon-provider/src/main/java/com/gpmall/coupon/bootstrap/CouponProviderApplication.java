package com.gpmall.coupon.bootstrap;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description //TODO
 * @Date 2023/7/3 10:46
 * @Author hy
 **/
@SpringBootApplication
@ComponentScan(basePackages = {"com.gpmall.coupon"})
@MapperScan("com.gpmall.coupon.dal")
public class CouponProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(CouponProviderApplication.class, args);
    }
}
