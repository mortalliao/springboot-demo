package com.springboot.demo.jms.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jim
 */
@RestController
@RequestMapping("/api/customer")
public class JmsSessionController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private JmsSessionService jmsSessionService;

    @PostMapping("/message/listen")
    public String create(@RequestParam String msg) {
        jmsTemplate.convertAndSend("customer:msg:new", msg);
        return "success";
    }

    @PostMapping("/message/direct")
    public String handle(@RequestParam String msg) {
        jmsSessionService.handle(msg);
        return "success";
    }

    @PostMapping("/message2/listen")
    public String create2(@RequestParam String msg) {
        jmsTemplate.convertAndSend("customer:msg2:new", msg);
        return "success";
    }

    @PostMapping("/message2/direct")
    public String handle2(@RequestParam String msg) {
        jmsSessionService.handleInCode(msg);
        return "success";
    }

    @GetMapping("message")
    public String read() {
        jmsTemplate.setReceiveTimeout(2000);
        Object obj = jmsTemplate.receiveAndConvert("customer:msg:reply");
        return String.valueOf(obj);
    }
}
