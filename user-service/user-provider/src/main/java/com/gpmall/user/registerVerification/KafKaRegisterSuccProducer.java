package com.gpmall.user.registerVerification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description //TODO
 * @Date 2023/3/21 10:31
 * @Author hy
 **/
@Component
@Slf4j
public class KafKaRegisterSuccProducer {
    @Autowired
//    @Qualifier("registerSuccInfoTemplate")
    private KafkaTemplate kafkaTemplate;

    private final static String topic = "user-register-succ-topic";

    public void sendRegisterSuccInfo(Map userVerifyMap) {
        try {
            kafkaTemplate.send(topic, userVerifyMap);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

    }
}
