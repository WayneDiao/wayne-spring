package com.wayne.bean.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: wayne
 * @Date: 2018/8/29
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean/beans-spel.xml");
        Address address = context.getBean("address",Address.class);
        System.out.println(address);

        Car car = context.getBean("car",Car.class);
        System.out.println(car);

        Person person = context.getBean("person",Person.class);
        System.out.println(person);
    }
}
