package com.springboot.demo.restful.web;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jim
 */
@Api(tags = {"1-教师管理", "3-教学管理"})
@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {

    // ...

}
