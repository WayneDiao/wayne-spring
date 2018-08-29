package com.wayne.bean.cycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: wayne
 * @Date: 2018/8/29
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans-cycle.xml");
        Car car = context.getBean("car",Car.class);
        System.out.println(car);

        /*关闭容器*/
        ((ClassPathXmlApplicationContext) context).close();
    }
}
