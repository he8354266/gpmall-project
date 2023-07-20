package com.gmall.kafka.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @Description //TODO
 * @Date 2023/7/18 10:18
 * @Author hy
 **/
@Configuration
@EnableAsync
public class ThreadConfig implements AsyncConfigurer {
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //最大线程数
        executor.setMaxPoolSize(20);
        //核心线程池大小
        executor.setCorePoolSize(10);
        //队列容量
        executor.setQueueCapacity(200);
        //活跃时间
        executor.setKeepAliveSeconds(60);
        //线程池名称前缀
        executor.setThreadNamePrefix("taskExecutor-");
        //初始化线程
        executor.initialize();
        return executor;
    }
}
