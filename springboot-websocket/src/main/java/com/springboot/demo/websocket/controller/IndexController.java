package com.springboot.demo.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Jim
 */
@Controller
public class IndexController {

    @GetMapping({"", "/", "/test"})
    public String index() {
        return "index";
    }
}
