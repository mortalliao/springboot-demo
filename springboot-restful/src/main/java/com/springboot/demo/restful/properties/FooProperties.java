package com.springboot.demo.restful.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Jim
 */
@Data
@Component // 注册为组件
@PropertySource(value = "test.properties") //指定自定义的资源目录
@ConfigurationProperties(prefix = "com.didispace")
public class FooProperties {

    private String foo;

}