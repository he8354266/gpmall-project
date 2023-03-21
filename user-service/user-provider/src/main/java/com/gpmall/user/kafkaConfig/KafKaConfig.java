package com.gpmall.user.kafkaConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description //TODO
 * @Date 2023/3/21 9:32
 * @Author hy
 **/
@Configuration
public class KafKaConfig {
    @Autowired
    private KafkaProperties kafkaProperties;
//    @Bean
//    public KafKaRegisterSuccProducerFactory kafKaRegisterSuccProducerFactory;
}
