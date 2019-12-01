package com.springboot.demo.jms.session;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author Jim
 */
@Service
@Slf4j
public class JmsSessionService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    PlatformTransactionManager transactionManager;

    @JmsListener(destination = "customer:msg:new", containerFactory = "msgFactory")
    public void handle(String msg) {
        log.info("Get msg:{}", msg);
        String reply = "Reply: " + msg;
        jmsTemplate.convertAndSend("customer:msg:reply", reply);
        if (msg.contains("error")) {
            simulateError();
        }
    }

    @JmsListener(destination = "customer:msg2:new", containerFactory = "msgFactory")
    public void handleInCode(String msg){
        log.info("Get msg2:{}", msg);
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus transactionStatus = transactionManager.getTransaction(def);
        try{
            String reply = "Reply2: " + msg;
            jmsTemplate.convertAndSend("customer:msg:reply", reply);
            if (msg.contains("error")) {
                transactionManager.rollback(transactionStatus);
            } else{
                transactionManager.commit(transactionStatus);
            }
        } catch (Exception e){
            transactionManager.rollback(transactionStatus);
            throw e;
        }
    }

    private void simulateError() {
        throw new RuntimeException("some data error.");
    }
}
