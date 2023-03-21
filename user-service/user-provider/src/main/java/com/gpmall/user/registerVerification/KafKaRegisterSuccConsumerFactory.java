package com.gpmall.user.registerVerification;

import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.Map;

/**
 * @Description //邮件发送消息消费
 * @Date 2023/3/21 9:57
 * @Author hy
 **/
public class KafKaRegisterSuccConsumerFactory extends DefaultKafkaConsumerFactory {
    public KafKaRegisterSuccConsumerFactory(Map confings) {
        super(confings);
    }
}
