package com.springboot.demo.schedule.schedule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * <pre>
 *     配置TaskScheduler线程池
 *
 *  源码
 *  org.springframework.scheduling.config.ScheduledTaskRegistrar
 *
 * 发现spring默认会创建一个单线程池。
 * 这样对于多任务调度可能会是致命的，当多个任务并发（或需要在同一时间）执行时，任务调度器就会出现时间漂移，任务执行时间将不确定。
 *
 * 自定义线程池
 * </pre>
 */
@Configuration
public class ScheduleConfig implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setScheduler(taskExecutor());
    }

    @Bean
    public Executor taskExecutor() {
        return Executors.newScheduledThreadPool(20);
    }
}
