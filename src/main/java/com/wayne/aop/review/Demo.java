package com.wayne.aop.review;

import org.springframework.stereotype.Component;

/**
 * @Author: wayne
 * @Date: 2018/9/11
 * @Description:
 */
@Component
public class Demo {

    public void say(String name,Integer id) {
        System.out.println("你好  :   " + name + ", 你是第 " + id + "学员");
    }
}
