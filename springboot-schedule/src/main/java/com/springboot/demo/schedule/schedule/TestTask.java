package com.springboot.demo.schedule.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <pre>
 *
 * 1. 固定间隔任务
 * 2. 固定频率任务
 * 3. Cron表达式
 *
 *
 * </pre>
 */
@Component
public class TestTask {
    private final static long ONE_Minute = 60 * 1000;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

    /**
     * <pre>
     * 固定间隔任务
     *
     * 下一次的任务执行时间, 是从方法最后一次任务执行结束时间开始计算并以此规则开始周期性的执行任务
     *
     * 添加一个work()方法, 每隔10秒执行一次
     *
     * 例如：假设work()方法在第0秒开始执行, 方法执行了12秒, 那么下一次执行work()方法的时间是第22秒
     * </pre>
     */
    @Scheduled(fixedDelay = ONE_Minute)
    public void fixedDelayJob() {
        System.out.println(dateFormat.format(new Date()) + " >>fixedDelay执行....");
    }

    /**
     * <pre>
     * 固定频率任务
     *
     * 按照指定频率执行任务, 并以此规则开始周期性的执行调度
     *
     * 添加一个work()方法, 每10秒执行一次
     *
     * 注意：当方法的执行时间超过任务调度频率时, 调度器会在当前方法执行完成后立即执行下次任务
     *
     * 例如：假设work()方法在第0秒开始执行, 方法执行了12秒, 那么下一次执行work()方法的时间是第12秒
     * </pre>
     */
    @Scheduled(fixedRate = ONE_Minute)
    public void fixedRateJob() {
        System.out.println(dateFormat.format(new Date()) + " >>fixedRate执行....");
    }

    /**
     * <pre>
     * Cron表达式
     *
     * 每10秒执行一次定时任务
     * </pre>
     */
    @Scheduled(cron = "0/5 * * * * ? ")
    public void cronJob() {
        System.out.println(dateFormat.format(new Date()) + " >>cron执行....");
    }
}

