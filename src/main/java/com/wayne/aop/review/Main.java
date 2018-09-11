package com.wayne.aop.review;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: wayne
 * @Date: 2018/9/11
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:aop/application-review.xml");
        Demo demo = context.getBean(Demo.class);
        demo.say("wayne",12);
    }
}
