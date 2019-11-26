package com.springboot.demo.retry.service;

import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @author Jim
 * <p>
 * 对于非幂等的请求（比如新增，更新操作），千万不要使用重试，对数据一致性会造成很大影响。
 */
@Service
public class RetryService {

    /**
     * <pre>
     * @Retryable注解 被注解的方法发生异常时会重试
     *
     * value: 指定发生的异常进行重试
     * include: 和value一样，默认空，当exclude也为空时，所有异常都重试
     * exclude: 指定异常不重试，默认空，当include也为空时，所有异常都重试
     * maxAttempts: 重试次数，默认3
     * backoff: 重试补偿机制，默认没有
     *
     *
     * @Backoff注解
     * delay:指定延迟后重试
     * multiplier:指定延迟的倍数，
     * 比如delay=5000L, multiplier=2时，第一次重试为5秒后，第二次为10秒，第三次为20秒
     * </pre>
     */
    @Retryable(value = RemoteAccessException.class, maxAttempts = 5, backoff = @Backoff(delay = 5000L, multiplier = 0.0))
    public void retryTest() {
        System.out.println("start retry...");
        throw new RemoteAccessException("RemoteAccessException....");
    }

    /**
     * <pre>
     * @Recover
     * 当重试到达指定次数时，被注解的方法将被回调，可以在该方法中进行日志处理。需要注意的是发生的异常和入参类型一致时才会回调
     *
     * </pre>
     */
    @Recover
    public void recover(RemoteAccessException e) {
        System.out.println(e.getMessage());
        System.out.println("recover....");
    }

}
