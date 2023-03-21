package com.gpmall.user.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Description //TODO
 * @Date 2023/3/20 18:03
 * @Author hy
 **/
@SpringBootApplication
@MapperScan("com.gpmall.user.dal.persistence")
@ComponentScan(basePackages = {"com.gpmall.user","com.gpmall.commons"})
public class UserProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserProviderApplication.class, args);
    }
}
