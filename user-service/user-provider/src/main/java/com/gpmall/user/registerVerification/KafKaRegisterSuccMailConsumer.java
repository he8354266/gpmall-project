package com.gpmall.user.registerVerification;

import com.gpmall.commons.tool.email.DefaultEmailSender;
import com.gpmall.commons.tool.email.MailData;
import com.gpmall.commons.tool.email.emailConfig.EmailConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    @Autowired
    private EmailConfig emailConfig;
    @Autowired
    private DefaultEmailSender defaultEmailSender;

    @KafkaListener(id = "", topics = topic, containerFactory = "userRegisterSuccKafkaListenerContainerFactory", groupId = group_id)
    public void receiveInfo(Map userVerifyMap, Acknowledgment acknowledgment) {
        try {
            log.info("收到一条注册消息" + userVerifyMap);
            sendMail(userVerifyMap);
            acknowledgment.acknowledge();//手动提交信息
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public void sendMail(Map userVerifyMap) {
        try {
            MailData mailData = new MailData();
            mailData.setToAddresss(Arrays.asList(String.valueOf(userVerifyMap.get("email"))));
            mailData.setSubject(emailConfig.getSubject());
            mailData.setContent("用户激活邮件");
            Map<String, Object> viewObj = new HashMap<>();
            viewObj.put("url", emailConfig.getUserMailActiveUrl() + "?username=" + userVerifyMap.get("username") + "&email" + userVerifyMap.get("key"));
            viewObj.put("title", emailConfig.getSubject());
            defaultEmailSender.sendMail(mailData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
