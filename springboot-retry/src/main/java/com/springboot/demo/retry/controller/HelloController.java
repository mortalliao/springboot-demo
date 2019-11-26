package com.springboot.demo.retry.controller;

import com.springboot.demo.retry.service.RetryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jim
 */
@RestController
public class HelloController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RetryService retryService;

    @GetMapping("/retry")
    public String retry() {
        retryService.retryTest();
        return "成功";
    }
}
