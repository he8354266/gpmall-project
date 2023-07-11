package com.gmall.kafka.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Description //生产者manager
 * @Date 2023/7/10 15:19
 * @Author hy
 **/
@Service
public class KafkaProducerManager {
    private static Logger logger = LoggerFactory.getLogger("adminLogger");

    @Autowired
    @Qualifier("kafkaTemplate")
    private KafkaTemplate kafkaTemplate;
    /**
     * producer 同步方式发送数据
     *
     * @param topic   topic名称
     * @param message producer发送的数据
     */
    public void sendMessageSync(String topic, String message) throws InterruptedException, ExecutionException, TimeoutException {
        kafkaTemplate.send(topic, message).get(10, TimeUnit.SECONDS);
    }

    /**
     * producer 异步方式发送数据
     *
     * @param topic   topic名称
     * @param message producer发送的数据
     */
    public void sendMessageAsync(String topic, String message) {
        kafkaTemplate.send(topic, message).addCallback(new ListenableFutureCallback() {
            @Override
            public void onFailure(Throwable throwable) {
                logger.error("kafka send failure !");
            }

            @Override
            public void onSuccess(Object o) {
//                logger.info("kafka send  success !");

            }
        });
    }
}
