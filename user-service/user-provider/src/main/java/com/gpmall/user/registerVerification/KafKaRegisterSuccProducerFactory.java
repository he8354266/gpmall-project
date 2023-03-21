package com.gpmall.user.registerVerification;

import org.springframework.kafka.core.DefaultKafkaProducerFactory;

import java.util.Map;

/**
 * @Description //TODO
 * @Date 2023/3/21 10:29
 * @Author hy
 **/
public class KafKaRegisterSuccProducerFactory extends DefaultKafkaProducerFactory {
    public KafKaRegisterSuccProducerFactory(Map confings) {
        super(confings);
    }
}
