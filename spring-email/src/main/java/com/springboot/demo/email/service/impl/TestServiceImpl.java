package com.springboot.demo.email.service.impl;

import com.springboot.demo.email.service.MailService;
import com.springboot.demo.email.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 测试表 服务实现类
 *
 * @author Jim
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    MailService mailService;

    @Override
    public void sendSimpleMail() throws Exception {
        mailService.sendSimpleMail("2533011924@qq.com", "测试Subject", "测试Content");
    }

}
