package com.gmall.kafka.services;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

/**
 * @Description //TODO
 * @Date 2023/7/10 15:36
 * @Author hy
 **/
@Component
public class KafkaComsumerManager {
    private static Logger logger = LoggerFactory.getLogger("adminLogger");
    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 指定topic
     * 指定消费分区parttition
     *
     * @param records
     */
//    @KafkaListener(topicPartitions = {
//            @TopicPartition(topic = "${kafkaserver.topic}",  partitions = "${kafkaserver.parttition}" )},
//            containerFactory = "kafkaListenerContainerFactory" )
//    public void onMessage(List<ConsumerRecord> records) {
//        logger.info("**********************************接收数量{}**************************************",records.size());
//        for(ConsumerRecord record :records ){
//            Optional<Object> kafkaMassage = Optional.ofNullable(record.value());
//            if(kafkaMassage.isPresent()){
//                try {
//                    Long current = System.currentTimeMillis();
//                    logger.info("**********************************kafka接收信息打印开始**************************************");
//                    logger.info("kafka接收信息："+'\t'+record.toString());
//                    logger.info("kafka数据："+'\t'+record.value());
//                    logger.info("分区："+ record.partition());
//                    logger.info("偏移量：" + record.offset());
//                    logger.info("报文时间：" + formatter.format(record.timestamp()));
//                    logger.info("系统时间：" + formatter.format(current));
//                    logger.info("**********************************kafka信息打印结束**************************************");
//                    JSONObject value = JSONObject.parseObject(record.value().toString());
//
//                } catch (Exception e) {
//                    // TODO: handle exception
//                    logger.error("********kafka接收数据出错:{}********",e.getMessage());
//                }
//            }
//
//
//        }
//
//    }
    @KafkaListener(topics = "${kafkaserver.topic}")
    @Async
    public void onMessage(ConsumerRecord<String, String> record) {
        Long current = System.currentTimeMillis();
        logger.info("**********************************kafka接收信息打印开始**************************************");
        logger.info("kafka接收信息：" + '\t' + record.toString());
        logger.info("kafka数据：" + '\t' + record.value());
        logger.info("分区：" + record.partition());
        logger.info("线程：" + Thread.currentThread().getName());
        logger.info("偏移量：" + record.offset());
        logger.info("报文时间：" + formatter.format(record.timestamp()));
        logger.info("系统时间：" + formatter.format(current));
        logger.info("**********************************kafka信息打印结束**************************************");
    }

}
