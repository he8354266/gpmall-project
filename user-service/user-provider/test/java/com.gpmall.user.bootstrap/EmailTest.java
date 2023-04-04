package com.gpmall.user.bootstrap;

import com.gpmall.commons.tool.email.DefaultEmailSender;
import com.gpmall.commons.tool.email.MailData;
import com.gpmall.commons.tool.email.emailConfig.EmailConfig;
import com.gpmall.user.registerVerification.KafKaRegisterSuccProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.lang.annotation.RetentionPolicy;
import java.util.*;

/**
 * @Description //TODO
 * @Date 2023/4/3 14:07
 * @Author hy
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(properties = "classpath://application.yml")
public class EmailTest {
    @Autowired
    private DefaultEmailSender defaultEmailSender;
    @Autowired
    private EmailConfig emailConfig;
    @Resource
    private KafKaRegisterSuccProducer kafKaRegisterSuccProducer;

    @Test
    public void sendMail() throws Exception {
        Map map = new HashMap<>();
        map.put("username", "heyang");
        map.put("key", UUID.randomUUID().toString());
        map.put("email", "453159575@qq.com");
        kafKaRegisterSuccProducer.sendRegisterSuccInfo(map);


//        for (int i = 0; i <= 3; i++) {
//            MailData mailData = new MailData();
//            mailData.setToAddresss(Arrays.asList("453159575@qq.com"));
//            mailData.setContent("hello");
//            mailData.setSubject("文件地址");
//            Map<String, Object> viewObj = new HashMap<>();
//            viewObj.put("url", "http://www.xxxxx.ddcom/register");
//            viewObj.put("title", "激活邮件");
//            mailData.setDataMap(viewObj);
//            mailData.setFileName("activeRegisterInfoHtmlTemplate.html");
//            mailData.setAttachFileNames(new Vector<>(Arrays.asList("F:\\testmain.txt", "F:\\TEST.txt")));
//            defaultEmailSender.sendHtmlMailUseTemplate(mailData);
//            Thread.sleep(2000);
//            System.out.println("发送" + i + "邮件");
//        }
    }
}
