package com.springboot.demo.email.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Jim
 */
@Component
@Data
public class EmailConfig {

    /**
     * 发件邮箱
     */
    @Value("${spring.mail.username}")
    private String emailFrom;

}
