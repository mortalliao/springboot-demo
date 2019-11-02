package com.springboot.demo.quickstart.config;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * @author liaoyujian
 */
public class MessageConfigurationTest {

    @Test
    public void testGetMessageBean() throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MessageConfiguration.class);
        assertEquals("message configuration", ctx.getBean("message"));
    }

    @Test
    public void testScanPackages() throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("org.spring.springboot");
        ctx.refresh();
        assertEquals("message configuration", ctx.getBean("message"));
    }
}