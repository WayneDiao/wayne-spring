package com.wayne.bean.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: wayne
 * @Date: 2018/8/28
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans-autowire.xml");
        Demo demo = context.getBean("demo",Demo.class);
        System.out.println(demo);
    }
}
