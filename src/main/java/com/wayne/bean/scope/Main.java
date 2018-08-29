package com.wayne.bean.scope;

import com.wayne.bean.autowire.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: wayne
 * @Date: 2018/8/28
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans-scope.xml");
        Car car = context.getBean("car", Car.class);
        Car car1 = context.getBean("car", Car.class);
        System.out.println(car == car1);
    }
}
