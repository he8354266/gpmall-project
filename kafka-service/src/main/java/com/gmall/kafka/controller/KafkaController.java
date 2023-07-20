package com.gmall.kafka.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gmall.kafka.services.KafkaProducerManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * @Description //TODO
 * @Date 2023/7/10 17:21
 * @Author hy
 **/
@RestController
@RequestMapping("/kafka")
public class KafkaController {
    private static final Logger logger = LoggerFactory.getLogger("adminLogger");
    private static final String producersuccess = " 生产数据到kafka成功！";
    @Value("${kafkaserver.topic}")
    private String topic;
    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;
    @Resource
    private KafkaProducerManager kafkaProducerManager;

    @PostMapping("/producerData")
    public JSONObject producerData(@RequestBody Object object) throws ExecutionException, InterruptedException, TimeoutException {
        kafkaProducerManager.sendMessageSync("topic1", JSONObject.toJSONString(object));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", producersuccess);
        logger.info(producersuccess);
        return jsonObject;
    }
}
