package com.wayne.bean.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: wayne
 * @Date: 2018/8/29
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean/beans-factory.xml");
        Car car1 = context.getBean("car1",Car.class);
        System.out.println(car1);

        Car car2 = context.getBean("car2",Car.class);
        System.out.println(car2);

    }
}
