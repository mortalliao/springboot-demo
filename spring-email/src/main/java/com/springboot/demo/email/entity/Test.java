package com.springboot.demo.email.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 测试表
 *
 * @author Jim
 */
@Data
@Accessors(chain = true)
public class Test {

    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    private String name;

    /**
     * 地址
     */
    private String address;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 生日
     */
    private Date birthdayDt;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 分数
     */
    private Double score;

    public static final String NAME = "name";
    public static final String ADDRESS = "address";
    public static final String SEX = "sex";
    public static final String BIRTHDAY_DT = "birthday_dt";
    public static final String MOBILE = "mobile";
    public static final String SCORE = "score";

}
