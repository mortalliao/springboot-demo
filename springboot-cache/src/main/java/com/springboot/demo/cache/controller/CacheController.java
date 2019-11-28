package com.springboot.demo.cache.controller;

import com.springboot.demo.cache.domain.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jim
 */
@RestController()
public class CacheController {

    @GetMapping("/hello")
    public String hello() {
        return "world";
    }

    @Cacheable(value = "emp", key = "targetClass + methodName +#id")
    @GetMapping("/{id:\\d+}")
    public User getUser(@PathVariable("id") Long id) {
        System.out.println("hint the cache");
        return new User(1L, "Jim", "pwd");
    }

//    @CacheEvict
//    @CachePut
}
