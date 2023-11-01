package com.gmall.kafka.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Description //TODO
 * @Date 2023/7/10 17:16
 * @Author hy
 **/
@SpringBootApplication
@ComponentScan(basePackages ={"com.gmall.kafka.*"})
@EnableScheduling
public class KafkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }
}
