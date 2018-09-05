package com.wayne.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: wayne
 * @Date: 2018/9/5
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        /*创建spring的IOC容器*/
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:aop/application.xml");
        /*获取bean实例*/
        CalcService service = context.getBean(CalcService.class);
        /*使用bean实例*/
        int result = service.add(3, 6);
        System.out.println("result: " + result);

        result = service.div(6, 1);
        System.out.println("result: " + result);

    }
}
