package com.springboot.demo.quickstart.controller;

import com.springboot.demo.quickstart.controller.HelloWorldController;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * Spring Boot HelloWorldController 测试 - {@link HelloWorldController}
 * <p>
 * Created by bysocket on 16/4/26.
 */
public class HelloWorldControllerTest {

    @Test
    public void testSayHello() {
        assertEquals("Hello,World!", new HelloWorldController().sayHello());
    }
}
