package com.springboot.demo.cache.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Jim
 */
@Data
@AllArgsConstructor
public class User {

    private Long id;
    private String username;
    private String password;
}
