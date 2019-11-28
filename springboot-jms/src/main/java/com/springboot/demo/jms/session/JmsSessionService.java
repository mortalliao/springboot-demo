package com.springboot.demo.jms.session;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Jim
 */
@Service
@Slf4j
public class JmsSessionService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = "customer:msg:new")
    public void handle(String msg) {
        log.info("Get msg:{}", msg);
        String reply = "Reply: " + msg;
        jmsTemplate.convertAndSend("customer:msg:reply", reply);
        if (msg.contains("error")) {
            simulateError();
        }
    }

    private void simulateError() {
        throw new RuntimeException("some data error.");
    }
}
