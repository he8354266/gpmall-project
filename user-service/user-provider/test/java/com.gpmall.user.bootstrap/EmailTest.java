package com.gpmall.user.bootstrap;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.annotation.RetentionPolicy;

/**
 * @Description //TODO
 * @Date 2023/4/3 14:07
 * @Author hy
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(properties = "classpath://application.yml")
public class EmailTest {
}
