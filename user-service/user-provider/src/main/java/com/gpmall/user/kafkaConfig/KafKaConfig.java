package com.gpmall.user.kafkaConfig;

import com.gpmall.user.registerVerification.KafKaRegisterSuccProducerFactory;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @Description //TODO
 * @Date 2023/3/21 9:32
 * @Author hy
 **/
@Configuration
public class KafKaConfig {
    @Autowired
    private KafkaProperties kafkaProperties;

    @Bean
    public KafKaRegisterSuccProducerFactory kafKaRegisterSuccProducerFactory() {
        Map<String, Object> producerProperties = kafkaProperties.buildProducerProperties();
        producerProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        return null;
    }
}
