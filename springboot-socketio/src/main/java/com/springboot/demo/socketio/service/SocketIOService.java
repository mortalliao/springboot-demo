package com.springboot.demo.socketio.service;

import com.springboot.demo.socketio.domain.PushMessage;

/**
 * @author Jim
 */
public interface SocketIOService {

    /**
     * 推送的事件
     */
    public static final String PUSH_EVENT = "push_event";

    /**
     * 启动服务
     *
     * @throws Exception e
     */
    void start() throws Exception;

    /**
     * 停止服务
     */
    void stop();

    /**
     * 推送信息
     *
     * @param pushMessage pushMessage
     */
    void pushMessageToUser(PushMessage pushMessage);
}
