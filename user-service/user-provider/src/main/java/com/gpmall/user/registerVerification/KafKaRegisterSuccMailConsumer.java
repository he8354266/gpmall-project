package com.gpmall.user.registerVerification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description //TODO 邮件激活功能发送注册消息给kafka kafka消费信息发送给邮件
 * @Date 2023/3/21 9:59
 * @Author hy
 **/
@Component
@Slf4j
public class KafKaRegisterSuccMailConsumer {
    private static final String topic = "user-register-succ-topic";

    private static final String group_id = "mail-group-id";
}
